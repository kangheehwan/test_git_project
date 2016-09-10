package work.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import work.model.dto.Board;
import work.model.dto.Caring;
import work.model.dto.Manager;
import work.model.dto.Owner;
import work.model.service.BoardService;
import work.model.service.CaringService;
import work.model.service.ManagerService;
import work.model.service.OwnerService;

/**
 * Servlet implementation class FrontController ##
 * <url-pattern>/Controller</url-pattern>
 */
@WebServlet("/Controller")
public class FrontController extends HttpServlet {
	/** 업데이트
	/** 맡기미회원관리 Service 객체 생성 */
	private OwnerService ownerService = new OwnerService();

	/** 돌보미회원관리 Service 객체 생성 */
	private ManagerService managerService = new ManagerService();

	/** 돌보미회원관리 Service 객체 생성 */
	private BoardService boardService = new BoardService();

	/** 강아지등록매칭 Service 객체 생성 */
	private CaringService caringService = new CaringService();

	/** 맡기미로그인 요청 서비스 메서드 */
	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 요청데이터 추출: view login.jsp
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");

		// 요청데이터 검증: 필수 입력항목
		if (userId == null || userId.trim().length() == 0 || userPw == null || userPw.trim().length() == 0) {
			// 미입력시 오류 페이지 이동 처리
			request.setAttribute("message", "로그인정보를 입력하시기 바랍니다.");
			// 오류페이지로 포워드 이동
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
		}
		// Model 요청 의뢰
		HashMap<String, String> loginMap = ownerService.login(userId, userPw);

		// 요청결과 받아서 응답위한 설정
		if (loginMap != null) {
			// 응답페이지 이동 :성공
			request.setAttribute("loginMap", loginMap);

			// HttpSession : 로그인 ~ 로그아웃(타임아웃) 할때까지 상태정보설정 (유지)
			HttpSession session = request.getSession(true);// 기본 true
			session.setAttribute("userId", userId);
			session.setAttribute("name", loginMap.get("name"));
			session.setAttribute("grade", loginMap.get("grade"));

			request.getRequestDispatcher("loginEnd.jsp").forward(request, response);
		} else {
			StringBuilder error = new StringBuilder();
			error.append("아이디 또는 비밀번호를 다시 확인하세요.");
			error.append("\n");
			error.append("혹은 등록되지 않았습니다.");
			request.setAttribute("message", error.toString());
			request.getRequestDispatcher("error/error.jsp").forward(request, response);

		}
		// 응답페이지 이동 :실패

	}

	// 맡기미 로그아웃하기
	protected void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 기존 로그인
		HttpSession session = request.getSession(false);

		if (session.getAttribute("userId") != null && session != null) {

			session.removeAttribute("userId");
			session.removeAttribute("name");
			session.removeAttribute("grade");

			session.invalidate();
			response.sendRedirect("index.jsp");

			// nextView.redirect(request, response);
		} else {
			request.setAttribute("message", "로그인후 서비스를 입력하시기 바랍니다.");
			// 오류페이지로 포워드 이동
			request.getRequestDispatcher("index.jsp").forward(request, response);

		}

	}

	/** 맡기미회원가입 요청 서비스 메서드 */
	protected void enroll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");

		String mobile1 = request.getParameter("firstPhoneNumber");
		String mobile2 = request.getParameter("middlePhoneNumber");
		String mobile3 = request.getParameter("lastPhoneNumber");
		String mobile = mobile1 + "-" + mobile2 + "-" + mobile3;

		String address = request.getParameter("address");
		System.out.println(userId + userPw + name + mobile + address);

		if (name == null || name.trim().length() == 0 || userId == null || userId.trim().length() == 0 || userPw == null
				|| userPw.trim().length() == 0 || mobile == null || mobile.trim().length() == 0 || address == null
				|| address.trim().length() == 0) {
			// 미입력시 오류 페이지 이동 처리
			request.setAttribute("message", "맡기미회원가입 필수항목을 넣어주세요.");
			// 오류페이지로 포워드 이동
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
			return;
		} else {
			Owner member = new Owner(userId, name, userPw, mobile, address);

			ownerService.enroll(member);
			RequestDispatcher nextView = request.getRequestDispatcher("loginCheck.jsp");
			nextView.forward(request, response);
		}

	}

	// 아이디중복검사

	protected void checkId(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userId = request.getParameter("userId");

		try {
			int re = ownerService.checkedId(userId);
			System.out.println(userId);
			String data = "";
			if (re != 1) {
				data = "사용가능한 아이디입니다.";
				request.setAttribute("checkData", data);
				request.getRequestDispatcher("ownerEnroll.jsp").forward(request, response);
			} else if (re == 1) {
				data = "중복된 아이디입니다.";
				request.setAttribute("checkData", data);
				request.getRequestDispatcher("ownerEnroll.jsp").forward(request, response);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/** 맡기미회원정보 수정 요청 서비스 메서드 */
	protected void updateMyInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		String name = request.getParameter("name");
		String userId = (String) session.getAttribute("userId");
		String userPw = request.getParameter("userPw");
		String mobile = request.getParameter("mobile");
		String address = request.getParameter("address");

		if (userId == null) {
			request.setAttribute("message", "로그인 후 접속해주세요:(");
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
		}

		if (name.trim().length() == 0 || userId.trim().length() == 0 || userPw.trim().length() == 0
				|| mobile.trim().length() == 0 || address.trim().length() == 0) {
			// 미입력시 오류 페이지 이동 처리
			request.setAttribute("message", "정확한 정보를 입력해주세요:(");
			// 오류페이지로 포워드 이동
			request.getRequestDispatcher("error/error.jsp").forward(request, response);

		} else {
			Owner member = new Owner(userId, name, userPw, mobile, address);

			int checkUpdate = ownerService.updateMember(member);
			System.out.println(checkUpdate);
			if (checkUpdate != 0) {
				request.setAttribute("message", "정보가 올바르게 변경되었습니다:)");
				// 정상페이지로 포워드 이동
				request.getRequestDispatcher("success/successLoginEnd.jsp").forward(request, response);
				/*
				 * RequestDispatcher nextView =
				 * request.getRequestDispatcher("loginEnd.jsp");
				 * nextView.forward(request, response);
				 */

			}
			request.setAttribute("message", "변경된 정보가 올바르지않습니다:(");
			// 오류페이지로 포워드 이동
			request.getRequestDispatcher("error/errorLogin.jsp").forward(request, response);
		}

	}

	// 맡기미회원 상세조회
	protected void findMemberBylogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false); // session 유지
		String userId = (String) session.getAttribute("userId");
		System.out.println(session.getAttribute("userId"));
		if (userId == null) {
			request.setAttribute("message", "로그인 후 접속해주세요:(");
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
		}
		// 요청데이터 검증: 필수 입력항목
		if (userId.trim().length() == 0) {
			// 미입력시 오류 페이지 이동 처리
			request.setAttribute("message", "아이디를 다시입력해주세요");
			// 오류페이지로 포워드 이동
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
		}

		Owner member = ownerService.findMember(userId);
		System.out.println(member);

		// 요청결과 받아서 응답위한 설정
		if (member != null) {
			request.setAttribute("member", member);

			request.getRequestDispatcher("checkMyInfo.jsp").forward(request, response);
		} else {
			StringBuilder error = new StringBuilder();
			error.append("등록되지 않은 맡기미회원정보 확인부탁드립니다");
			request.setAttribute("message", error.toString());
			request.getRequestDispatcher("error/errorLogin.jsp").forward(request, response);

		}
		// 응답페이지 이동 :실패

	}

	/** 맡기미회원아이디찾기 서비스 메서드 */
	protected void ownerFindId(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 요청데이터 추출: view findIdPw.jsp
		String name = request.getParameter("name");
		String mobile = request.getParameter("mobile");
		System.out.println(name);
		System.out.println(mobile);

		// 요청데이터 검증: 필수 입력항목
		if (name.trim().length() == 0 || mobile.trim().length() == 0) {
			// 미입력시 오류 페이지 이동 처리
			request.setAttribute("message", "자신의 이름과 핸드폰번호를 다시 확인바랍니다:(");
			// 오류페이지로 포워드 이동
			RequestDispatcher nextView = request.getRequestDispatcher("error/error.jsp");
			nextView.forward(request, response);
		}
		// Model 요청 의뢰
		String findId = ownerService.findId(name, mobile);
		System.out.println("\n## findId: " + findId);

		// 요청결과 받아서 응답위한 설정
		if (findId != null) {
			request.setAttribute("findId", findId);
			request.setAttribute("message", "당신의 아이디는 " + findId + "입니다:)");
			// 정상페이지로 포워드 이동
			request.getRequestDispatcher("success/success.jsp").forward(request, response);

			// request.getRequestDispatcher("findId.jsp").forward(request,
			// response);
		} else {
			// StringBuilder error = new StringBuilder();
			request.setAttribute("message", "맡기미회원이 아니시거나 잘못된 정보를 입력하였습니다:(");
			request.getRequestDispatcher("error/error.jsp").forward(request, response);

		}
		// 응답페이지 이동 :실패

	}

	/** 맡기미회원아이디찾기 서비스 메서드 */
	protected void managerFindId(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 요청데이터 추출: view findIdPw.jsp
		String name = request.getParameter("name");
		String mobile = request.getParameter("mobile");
		System.out.println(name);
		System.out.println(mobile);

		// 요청데이터 검증: 필수 입력항목
		if (name.trim().length() == 0 || mobile.trim().length() == 0) {
			// 미입력시 오류 페이지 이동 처리
			request.setAttribute("message", "자신의 이름과 핸드폰번호를 다시 확인바랍니다:(");
			// 오류페이지로 포워드 이동
			RequestDispatcher nextView = request.getRequestDispatcher("error/error.jsp");
			nextView.forward(request, response);
		}
		// Model 요청 의뢰
		String cNumber = managerService.findcNumber(name, mobile);
		System.out.println("\n## cNumber: " + cNumber);

		// 요청결과 받아서 응답위한 설정
		if (cNumber != null) {
			request.setAttribute("cNumber", cNumber);
			request.setAttribute("message", "당신의 자격번호는 :)" + cNumber + "입니다.");
			// 정상페이지로 포워드 이동
			request.getRequestDispatcher("success/success.jsp").forward(request, response);

			// request.getRequestDispatcher("findId.jsp").forward(request,
			// response);
		} else {
			// StringBuilder error = new StringBuilder();
			request.setAttribute("message", "돌보미회원이 아니시거나 잘못된 정보를 입력하였습니다:(");
			request.getRequestDispatcher("error/error.jsp").forward(request, response);

		}
		// 응답페이지 이동 :실패

	}

	/** 맡기미회원비밀번호찾기 서비스 메서드 */

	protected void ownerFindPw(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 요청데이터 추출: view findIdPw.jsp
		String userId = request.getParameter("userId");
		String mobile = request.getParameter("mobile");
		System.out.println(userId);
		System.out.println(mobile);

		// 요청데이터 검증: 필수 입력항목
		if (userId.trim().length() == 0 || mobile.trim().length() == 0) {
			// 미입력시 오류 페이지 이동 처리
			request.setAttribute("message", "자신의 이름과 핸드폰번호를 다시 확인바랍니다:(");
			// 오류페이지로 포워드 이동
			RequestDispatcher nextView = request.getRequestDispatcher("error/error.jsp");
			nextView.forward(request, response);
		}
		// Model 요청 의뢰
		String findPw = ownerService.findPw(userId, mobile);
		System.out.println("\n## findPw: " + findPw);

		// 요청결과 받아서 응답위한 설정
		if (findPw != null) {
			request.setAttribute("findPw", findPw);
			request.setAttribute("message", "당신의 비밀번호는 " + findPw + "입니다:)");
			// 정상페이지로 포워드 이동
			request.getRequestDispatcher("success/success.jsp").forward(request, response);

			// request.getRequestDispatcher("findId.jsp").forward(request,
			// response);
		} else {
			// StringBuilder error = new StringBuilder();
			request.setAttribute("message", "맡기미회원이 아니시거나 잘못된 정보를 입력하였습니다:(");
			request.getRequestDispatcher("error/error.jsp").forward(request, response);

		}

	}

	/** 돌보미로그인 요청 서비스 메서드 */
	protected void loginManager(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cNumber = request.getParameter("cNumber");
		String userPw = request.getParameter("userPw");
		System.out.println(cNumber);
		System.out.println(userPw);

		// 요청데이터 검증: 필수 입력항목
		if (cNumber == null || cNumber.trim().length() == 0 || userPw == null || userPw.trim().length() == 0) {
			// 미입력시 오류 페이지 이동 처리
			request.setAttribute("message", "로그인정보를 입력하시기 바랍니다.");
			// 오류페이지로 포워드 이동
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
		}
		// Model 요청 의뢰
		HashMap<String, String> loginMap = managerService.login(cNumber, userPw);

		// 요청결과 받아서 응답위한 설정
		if (loginMap != null) {
			// 응답페이지 이동 :성공
			request.setAttribute("loginMap", loginMap);

			// HttpSession : 로그인 ~ 로그아웃(타임아웃) 할때까지 상태정보설정 (유지)
			HttpSession session = request.getSession(true);// 기본 true
			session.setAttribute("cNumber", cNumber);
			session.setAttribute("name", loginMap.get("name"));
			session.setAttribute("grade", loginMap.get("grade"));

			System.out.println(loginMap.get("name"));

			request.getRequestDispatcher("loginEndManager.jsp").forward(request, response);
		} else {
			// StringBuilder error = new StringBuilder();
			request.setAttribute("message", "로그인 정보를 다시한번 확인해주세요 :(");
			request.getRequestDispatcher("error/error.jsp").forward(request, response);

		}

	}

	// 로그아웃하기
	protected void logoutManager(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 로그인 사용자인지 덤중
		// 기존 로그인
		HttpSession session = request.getSession(false);

		if (session.getAttribute("cNumber") != null && session != null) {

			session.removeAttribute("cNumber");
			session.removeAttribute("name");
			session.removeAttribute("grade");

			session.invalidate();
			response.sendRedirect("index.jsp");

			// nextView.redirect(request, response);
		} else {
			request.setAttribute("message", "로그인후 서비스를 입력하시기 바랍니다.");
			// 오류페이지로 포워드 이동
			request.getRequestDispatcher("login.jsp").forward(request, response);

		}

	}

	/** 돌보미회원가입 요청 서비스 메서드 */
	protected void enrollManager(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cNumber = request.getParameter("cNumber");
		String name = request.getParameter("name");
		String userPw = request.getParameter("userPw");
		String mobile1 = request.getParameter("firstPhoneNumber");
		String mobile2 = request.getParameter("middlePhoneNumber");
		String mobile3 = request.getParameter("lastPhoneNumber");
		String mobile = mobile1 + "-" + mobile2 + "-" + mobile3;

		String posssibleArea = request.getParameter("posssibleArea");
		String enviroment = request.getParameter("enviroment");

		String carrier = request.getParameter("carrier");

		System.out.println(cNumber + name + userPw + mobile + posssibleArea + enviroment + carrier);

		if (name.trim().length() == 0 || cNumber.trim().length() == 0 || userPw.trim().length() == 0
				|| mobile.trim().length() == 0 || posssibleArea.trim().length() == 0 || enviroment.trim().length() == 0
				|| carrier.trim().length() == 0) {
			// 미입력시 오류 페이지 이동 처리
			request.setAttribute("message", "맡기미회원가입 필수항목을 넣어주세요.");
			// 오류페이지로 포워드 이동
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
		} else {
			Manager member = new Manager(cNumber, name, userPw, mobile, posssibleArea, enviroment, carrier);

			managerService.enrollManager(member);
			RequestDispatcher nextView = request.getRequestDispatcher("loginCheck.jsp");
			nextView.forward(request, response);
		}

	}

	/** 돌보미회원비밀번호찾기 서비스 메서드 */

	protected void managerFindPw(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 요청데이터 추출: view findIdPw.jsp
		String cNumber = request.getParameter("cNumber");
		String mobile = request.getParameter("mobile");
		System.out.println(cNumber);
		System.out.println(mobile);

		// 요청데이터 검증: 필수 입력항목
		if (cNumber.trim().length() == 0 || mobile.trim().length() == 0) {
			// 미입력시 오류 페이지 이동 처리
			request.setAttribute("message", "자신의 자격번호와 핸드폰번호를 다시 확인바랍니다:(");
			// 오류페이지로 포워드 이동
			RequestDispatcher nextView = request.getRequestDispatcher("error/error.jsp");
			nextView.forward(request, response);
		}
		// Model 요청 의뢰
		String findPw = managerService.findPw(cNumber, mobile);
		System.out.println("\n## findPw: " + findPw);

		// 요청결과 받아서 응답위한 설정
		if (findPw != null) {
			request.setAttribute("findPw", findPw);
			request.setAttribute("message", "당신의 비밀번호는 " + findPw + "입니다:)");
			// 정상페이지로 포워드 이동
			request.getRequestDispatcher("success/success.jsp").forward(request, response);

			// request.getRequestDispatcher("findId.jsp").forward(request,
			// response);
		} else {
			// StringBuilder error = new StringBuilder();
			request.setAttribute("message", "맡기미회원이 아니시거나 잘못된 정보를 입력하였습니다:(");
			request.getRequestDispatcher("error/error.jsp").forward(request, response);

		}

	}

	// 돌보미회원 상세조회
	protected void findManagerBylogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false); // session 유지
		String cNumber = (String) session.getAttribute("cNumber");
		System.out.println(session.getAttribute("cNumber"));
		if (cNumber == null) {
			request.setAttribute("message", "로그인 후 접속해주세요:(");
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
		}
		// 요청데이터 검증: 필수 입력항목
		if (cNumber.trim().length() == 0) {
			// 미입력시 오류 페이지 이동 처리
			request.setAttribute("message", "자격증번호를 다시입력해주세요");
			// 오류페이지로 포워드 이동
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
		}

		Manager member = managerService.findMember(cNumber);
		System.out.println(member);

		// 요청결과 받아서 응답위한 설정
		if (member != null) {
			request.setAttribute("member", member);

			request.getRequestDispatcher("checkManagerInfo.jsp").forward(request, response);
		} else {
			StringBuilder error = new StringBuilder();
			request.setAttribute("message", "등록되지 않은 맡기미회원정보 확인부탁드립니다");
			request.getRequestDispatcher("error/errorLoginManager.jsp").forward(request, response);

		}
		// 응답페이지 이동 :실패
	}

	/** 돌보미회원정보 수정 요청 서비스 메서드 */
	protected void updateManagerInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		String name = request.getParameter("name");
		String cNumber = (String) session.getAttribute("cNumber");
		String userPw = request.getParameter("userPw");
		String mobile = request.getParameter("mobile");
		String possibleArea = request.getParameter("possibleArea");
		String enviroment = request.getParameter("enviroment");
		String carrier = request.getParameter("carrier");

		if (cNumber == null) {
			request.setAttribute("message", "로그인 후 접속해주세요:(");
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
		}

		System.out.println(name + cNumber + userPw + mobile + possibleArea + enviroment + carrier);

		if (name.trim().length() == 0 || cNumber.trim().length() == 0 || userPw.trim().length() == 0
				|| mobile.trim().length() == 0 || possibleArea.trim().length() == 0 || enviroment.trim().length() == 0
				|| carrier.trim().length() == 0) {
			// 미입력시 오류 페이지 이동 처리
			request.setAttribute("message", "정확한 정보를 입력해주세요:(");
			// 오류페이지로 포워드 이동
			request.getRequestDispatcher("error/errorloginManager.jsp").forward(request, response);

		} else {
			Manager member = new Manager(cNumber, name, userPw, mobile, possibleArea, enviroment, carrier);

			int checkUpdate = managerService.updateMember(member);
			System.out.println(checkUpdate);
			if (checkUpdate != 0) {
				request.setAttribute("message", "정보가 올바르게 변경되었습니다:)");
				// 정상페이지로 포워드 이동
				request.getRequestDispatcher("success/successLoginManager.jsp").forward(request, response);
				/*
				 * RequestDispatcher nextView =
				 * request.getRequestDispatcher("loginEnd.jsp");
				 * nextView.forward(request, response);
				 */

			}
			request.setAttribute("message", "변경된 정보가 올바르지않습니다:(");
			// 오류페이지로 포워드 이동
			request.getRequestDispatcher("error/errorLogin.jsp").forward(request, response);
		}

	}

	/**돌보미 신규등록 요청 서비스 메서드 
			 * @throws Exception */
			protected void insertBoard(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException  {
				
				
				
				HttpSession session = request.getSession(false);
				
				
				
				String cNumber = (String) session.getAttribute("cNumber");
				String title = request.getParameter("title");
				String content = request.getParameter("content");
				String price = request.getParameter("price");
				String possibleDogKind = request.getParameter("possibleDogKind");
				
				System.out.println(cNumber+title+content+price+possibleDogKind);
				
			
						
			
				if (cNumber==null || cNumber.trim().length() == 0 ||
					title==null ||	title.trim().length() == 0 || 
					content==null ||content.trim().length() == 0||
					price==null ||price.trim().length() == 0||
					possibleDogKind==null ||	possibleDogKind.trim().length() == 0) 
				{
					// 미입력시 오류 페이지 이동 처리
					request.setAttribute("message", "돌보미등록 필수항목을 넣어주세요.");
					// 오류페이지로 포워드 이동
					request.getRequestDispatcher("error/errorLoginManager.jsp").forward(request, response);
					return;
				} 
					
							String check;
							try {
								check = managerService.checkCaring(cNumber);
								if(check.equals("돌봄중")){
									request.setAttribute("message", "돌보미 활동을 끝내고 등록해주세요.");
									// 오류페이지로 포워드 이동
									request.getRequestDispatcher("error/errorLoginManager.jsp").forward(request, response);
								}else{
										 Board board = new Board(cNumber,title,content,price,possibleDogKind);

											boardService.enrollBoard(board);
											request.setAttribute("message", "돌보미로 등록되었습니다 :) 사랑하는 반려견에게 애정과 관심을 나눠주세요.");
											// 오류페이지로 포워드 이동
											request.getRequestDispatcher("success/successLoginManager.jsp").forward(request, response);
										
									}
							} catch (Exception e) {
								e.printStackTrace();
							}
							

				}
			

	/** 회원정보전체조회 서비스 메서드 */

	protected void findBoardAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<Board> list = boardService.findBoardAll();

		// 요청결과 받아서 응답위한 설정
		if (list != null) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("boardList.jsp").forward(request, response);
		} else {
			StringBuilder error = new StringBuilder();
			error.append("등록된 돌보미가 없습니다.");
			request.setAttribute("message", error.toString());
			request.getRequestDispatcher("error/errorLoginManager.jsp").forward(request, response);

		}
		// 응답페이지 이동 :실패

	}

	// 돌보미회원 상세조회
	protected void findBoardBylogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String boardNumber1 = request.getParameter("boardNumber");
		System.out.println(boardNumber1);

		int boardNumber = Integer.parseInt(boardNumber1);

		Board board = boardService.findBoard(boardNumber);

		// 요청결과 받아서 응답위한 설정
		if (board != null) {
			request.setAttribute("board", board);

			request.getRequestDispatcher("checkBoard.jsp").forward(request, response);
		} else {
			/*
			 * StringBuilder error = new StringBuilder();
			 * request.setAttribute("message", "등록되지 않은 맡기미회원정보 확인부탁드립니다");
			 * request.getRequestDispatcher("error/errorLoginManager.jsp").
			 * forward(request, response);
			 */
		}
		// 응답페이지 이동 :실패
	}

	/** 돌보미회원정보전체조회(맡기미버전) 서비스 메서드 */

	protected void findBoardAllOwner(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<Board> list = boardService.findBoardAll();

		// 요청결과 받아서 응답위한 설정
		if (list != null) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("boardListOwner.jsp").forward(request, response);
		} else {
			StringBuilder error = new StringBuilder();
			error.append("등록된 돌보미가 없습니다.");
			request.setAttribute("message", error.toString());
			request.getRequestDispatcher("error/errorLoginOwner.jsp").forward(request, response);

		}
		// 응답페이지 이동 :실패

	}

	/** 돌보미 신규등록 요청 서비스 메서드 */
	protected void insertPet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		String userId = (String) session.getAttribute("userId");
		String cNumber = request.getParameter("cNumber");
		String dogNumber = request.getParameter("dogNumber");
		String dogName = request.getParameter("dogName");
		String dogKind = request.getParameter("dogKind");
		String dogAge1 = request.getParameter("dogAge");
		String gender = request.getParameter("gender");

		int dogAge = Integer.parseInt(dogAge1);

		System.out.println(cNumber + userId + dogNumber + dogName + dogKind + dogAge + gender);

		if (cNumber == null || cNumber.trim().length() == 0 || userId == null || userId.trim().length() == 0
				|| dogNumber == null || dogNumber.trim().length() == 0 || dogName == null
				|| dogName.trim().length() == 0 || dogKind == null || dogKind.trim().length() == 0 || dogAge == 0
				|| dogKind.trim().length() == 0 || gender == null || gender.trim().length() == 0) {
			// 미입력시 오류 페이지 이동 처리
			request.setAttribute("message", "강아지의 정확한 정보를 입력해주세요 :(");
			// 오류페이지로 포워드 이동
			request.getRequestDispatcher("error/errorLogin.jsp").forward(request, response);
			return;
		} else {
			Caring caring = new Caring(userId, cNumber, dogNumber, dogName, dogKind, dogAge, gender);

			caringService.enrollPet(caring);
			request.setAttribute("message", "강아지가 등록되었습니다. 시간내에 방문해주세요 :)  ");
			// 오류페이지로 포워드 이동
			request.getRequestDispatcher("success/successLoginEnd.jsp").forward(request, response);
		}

	}

	// 돌보미회원 상세조회(팻매칭테이블 검증할때)
	protected void findManagerByPet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cNumber = request.getParameter("cNumber");
		System.out.println(cNumber);
		if (cNumber == null || cNumber.trim().length() == 0) {
			request.setAttribute("message", "잘못된 접근입니다.:(");
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
		}

		Manager member = managerService.findMember(cNumber);
		System.out.println(member);
		request.setAttribute("member", member);
		request.getRequestDispatcher("checkManagerInfoCaring.jsp").forward(request, response);

	}

	// 돌보미맡기미 매칭 상세조회
	protected void findCaringBycNumber(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false); // session 유지
		String cNumber = (String) session.getAttribute("cNumber");
		System.out.println(session.getAttribute("cNumber"));

		// 요청데이터 검증: 필수 입력항목
		if (cNumber.trim().length() == 0) {
			// 미입력시 오류 페이지 이동 처리
			request.setAttribute("message", "등록된 돌봄 현황이없습니다.");
			// 오류페이지로 포워드 이동
			request.getRequestDispatcher("error/errorLoginManager.jsp").forward(request, response);
		}

		Caring caring = caringService.findCaring(cNumber);
		System.out.println(caring);

		// 요청결과 받아서 응답위한 설정
		if (caring != null) {
			request.setAttribute("caring", caring);

			request.getRequestDispatcher("showCaring.jsp").forward(request, response);
		} else {
			StringBuilder error = new StringBuilder();
			error.append("등록되지 않은 맡기미회원정보 확인부탁드립니다");
			request.setAttribute("message", error.toString());
			request.getRequestDispatcher("error/errorLogin.jsp").forward(request, response);

		}
		// 응답페이지 이동 :실패

	}

	/** 돌봄정보해제하기(게시판에서 제거) 서비스 메서드 */
	protected void deleteCaring(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		String cNumber = (String) session.getAttribute("cNumber");
		System.out.println("자격증 번호 :" + cNumber);

		// Model 요청 의뢰
		caringService.deleteCaring(cNumber);

		// 요청결과 받아서 응답위한 설정
		request.setAttribute("message", "돌보미가 해제되었습니다 :) 다음에 또 이용해주세요.");
		// 정상페이지로 포워드 이동
		request.getRequestDispatcher("success/successLoginManager.jsp").forward(request, response);

	}

	/** 돌봄정보확인하기(게시판에서 제거) 서비스 메서드 */
	protected void checkCaring(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cNumber = request.getParameter("cNumber");
		System.out.println("checkCaring" + cNumber);
		try {
			String check = managerService.checkCaring(cNumber);

			System.out.println("check: " + check);

			if (check.equals("돌봄중")) {
				request.setAttribute("message", "돌보미 활동을 끝내고 등록해주세요.");
				// 오류페이지로 포워드 이동
				request.getRequestDispatcher("error/errorLoginManager.jsp").forward(request, response);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/** get, post 요청을 처리하는 서비스 메서드 */
	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 요청 파악 : 요청데이터에서 요청을 위한 key 데이터 가져오기
		String action = request.getParameter("action");

		System.out.println("action : " + action);

		if (action != null) {
			switch (action) {
			case "login":
				login(request, response);
				break;

			case "logout":
				logout(request, response);
				break;

			case "enroll":
				enroll(request, response);
				break;

			case "findMemberBylogin":
				findMemberBylogin(request, response);
				break;

			case "updateMyInfo":
				updateMyInfo(request, response);
				break;

			case "ownerFindId":
				ownerFindId(request, response);
				break;

			case "ownerFindPw":
				ownerFindPw(request, response);
				break;

			case "loginManager":
				loginManager(request, response);
				break;

			case "logoutManager":
				logoutManager(request, response);
				break;

			case "enrollManager":
				enrollManager(request, response);
				break;

			case "managerFindId":
				managerFindId(request, response);
				break;

			case "managerFindPw":
				managerFindPw(request, response);
				break;

			case "checkIdcheckId":
				checkId(request, response);
				break;

			case "findManagerBylogin":
				findManagerBylogin(request, response);
				break;

			case "updateManagerInfo":
				updateManagerInfo(request, response);
				break;

			case "insertBoard":
				insertBoard(request, response);
				break;

			case "findBoardAll":
				findBoardAll(request, response);
				break;

			case "findBoardBylogin":
				findBoardBylogin(request, response);
				break;

			case "findBoardAllOwner":
				findBoardAllOwner(request, response);
				break;

			case "insertPet":
				insertPet(request, response);
				break;

			case "findManagerByPet":
				findManagerByPet(request, response);
				break;

			case "findCaringBycNumber":
				findCaringBycNumber(request, response);
				break;

			case "deleteCaring":
				deleteCaring(request, response);
				break;

			case "checkCaring":
				checkCaring(request, response);
				break;

			default:
				// 지원하지 않는 요청 오류 페이지 이동
			}
		} else {
			// 잘못된 요청방식 오류 페이지 이동
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		process(request, response);
	}

}
