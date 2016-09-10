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

	/** �ñ��ȸ������ Service ��ü ���� */
	private OwnerService ownerService = new OwnerService();

	/** ������ȸ������ Service ��ü ���� */
	private ManagerService managerService = new ManagerService();

	/** ������ȸ������ Service ��ü ���� */
	private BoardService boardService = new BoardService();

	/** ��������ϸ�Ī Service ��ü ���� */
	private CaringService caringService = new CaringService();

	/** �ñ�̷α��� ��û ���� �޼��� */
	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��û������ ����: view login.jsp
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");

		// ��û������ ����: �ʼ� �Է��׸�
		if (userId == null || userId.trim().length() == 0 || userPw == null || userPw.trim().length() == 0) {
			// ���Է½� ���� ������ �̵� ó��
			request.setAttribute("message", "�α��������� �Է��Ͻñ� �ٶ��ϴ�.");
			// ������������ ������ �̵�
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
		}
		// Model ��û �Ƿ�
		HashMap<String, String> loginMap = ownerService.login(userId, userPw);

		// ��û��� �޾Ƽ� �������� ����
		if (loginMap != null) {
			// ���������� �̵� :����
			request.setAttribute("loginMap", loginMap);

			// HttpSession : �α��� ~ �α׾ƿ�(Ÿ�Ӿƿ�) �Ҷ����� ������������ (����)
			HttpSession session = request.getSession(true);// �⺻ true
			session.setAttribute("userId", userId);
			session.setAttribute("name", loginMap.get("name"));
			session.setAttribute("grade", loginMap.get("grade"));

			request.getRequestDispatcher("loginEnd.jsp").forward(request, response);
		} else {
			StringBuilder error = new StringBuilder();
			error.append("���̵� �Ǵ� ��й�ȣ�� �ٽ� Ȯ���ϼ���.");
			error.append("\n");
			error.append("Ȥ�� ��ϵ��� �ʾҽ��ϴ�.");
			request.setAttribute("message", error.toString());
			request.getRequestDispatcher("error/error.jsp").forward(request, response);

		}
		// ���������� �̵� :����

	}

	// �ñ�� �α׾ƿ��ϱ�
	protected void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ���� �α���
		HttpSession session = request.getSession(false);

		if (session.getAttribute("userId") != null && session != null) {

			session.removeAttribute("userId");
			session.removeAttribute("name");
			session.removeAttribute("grade");

			session.invalidate();
			response.sendRedirect("index.jsp");

			// nextView.redirect(request, response);
		} else {
			request.setAttribute("message", "�α����� ���񽺸� �Է��Ͻñ� �ٶ��ϴ�.");
			// ������������ ������ �̵�
			request.getRequestDispatcher("index.jsp").forward(request, response);

		}

	}

	/** �ñ��ȸ������ ��û ���� �޼��� */
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
			// ���Է½� ���� ������ �̵� ó��
			request.setAttribute("message", "�ñ��ȸ������ �ʼ��׸��� �־��ּ���.");
			// ������������ ������ �̵�
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
			return;
		} else {
			Owner member = new Owner(userId, name, userPw, mobile, address);

			ownerService.enroll(member);
			RequestDispatcher nextView = request.getRequestDispatcher("loginCheck.jsp");
			nextView.forward(request, response);
		}

	}

	// ���̵��ߺ��˻�

	protected void checkId(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userId = request.getParameter("userId");

		try {
			int re = ownerService.checkedId(userId);
			System.out.println(userId);
			String data = "";
			if (re != 1) {
				data = "��밡���� ���̵��Դϴ�.";
				request.setAttribute("checkData", data);
				request.getRequestDispatcher("ownerEnroll.jsp").forward(request, response);
			} else if (re == 1) {
				data = "�ߺ��� ���̵��Դϴ�.";
				request.setAttribute("checkData", data);
				request.getRequestDispatcher("ownerEnroll.jsp").forward(request, response);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/** �ñ��ȸ������ ���� ��û ���� �޼��� */
	protected void updateMyInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		String name = request.getParameter("name");
		String userId = (String) session.getAttribute("userId");
		String userPw = request.getParameter("userPw");
		String mobile = request.getParameter("mobile");
		String address = request.getParameter("address");

		if (userId == null) {
			request.setAttribute("message", "�α��� �� �������ּ���:(");
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
		}

		if (name.trim().length() == 0 || userId.trim().length() == 0 || userPw.trim().length() == 0
				|| mobile.trim().length() == 0 || address.trim().length() == 0) {
			// ���Է½� ���� ������ �̵� ó��
			request.setAttribute("message", "��Ȯ�� ������ �Է����ּ���:(");
			// ������������ ������ �̵�
			request.getRequestDispatcher("error/error.jsp").forward(request, response);

		} else {
			Owner member = new Owner(userId, name, userPw, mobile, address);

			int checkUpdate = ownerService.updateMember(member);
			System.out.println(checkUpdate);
			if (checkUpdate != 0) {
				request.setAttribute("message", "������ �ùٸ��� ����Ǿ����ϴ�:)");
				// ������������ ������ �̵�
				request.getRequestDispatcher("success/successLoginEnd.jsp").forward(request, response);
				/*
				 * RequestDispatcher nextView =
				 * request.getRequestDispatcher("loginEnd.jsp");
				 * nextView.forward(request, response);
				 */

			}
			request.setAttribute("message", "����� ������ �ùٸ����ʽ��ϴ�:(");
			// ������������ ������ �̵�
			request.getRequestDispatcher("error/errorLogin.jsp").forward(request, response);
		}

	}

	// �ñ��ȸ�� ����ȸ
	protected void findMemberBylogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false); // session ����
		String userId = (String) session.getAttribute("userId");
		System.out.println(session.getAttribute("userId"));
		if (userId == null) {
			request.setAttribute("message", "�α��� �� �������ּ���:(");
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
		}
		// ��û������ ����: �ʼ� �Է��׸�
		if (userId.trim().length() == 0) {
			// ���Է½� ���� ������ �̵� ó��
			request.setAttribute("message", "���̵� �ٽ��Է����ּ���");
			// ������������ ������ �̵�
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
		}

		Owner member = ownerService.findMember(userId);
		System.out.println(member);

		// ��û��� �޾Ƽ� �������� ����
		if (member != null) {
			request.setAttribute("member", member);

			request.getRequestDispatcher("checkMyInfo.jsp").forward(request, response);
		} else {
			StringBuilder error = new StringBuilder();
			error.append("��ϵ��� ���� �ñ��ȸ������ Ȯ�κ�Ź�帳�ϴ�");
			request.setAttribute("message", error.toString());
			request.getRequestDispatcher("error/errorLogin.jsp").forward(request, response);

		}
		// ���������� �̵� :����

	}

	/** �ñ��ȸ�����̵�ã�� ���� �޼��� */
	protected void ownerFindId(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��û������ ����: view findIdPw.jsp
		String name = request.getParameter("name");
		String mobile = request.getParameter("mobile");
		System.out.println(name);
		System.out.println(mobile);

		// ��û������ ����: �ʼ� �Է��׸�
		if (name.trim().length() == 0 || mobile.trim().length() == 0) {
			// ���Է½� ���� ������ �̵� ó��
			request.setAttribute("message", "�ڽ��� �̸��� �ڵ�����ȣ�� �ٽ� Ȯ�ιٶ��ϴ�:(");
			// ������������ ������ �̵�
			RequestDispatcher nextView = request.getRequestDispatcher("error/error.jsp");
			nextView.forward(request, response);
		}
		// Model ��û �Ƿ�
		String findId = ownerService.findId(name, mobile);
		System.out.println("\n## findId: " + findId);

		// ��û��� �޾Ƽ� �������� ����
		if (findId != null) {
			request.setAttribute("findId", findId);
			request.setAttribute("message", "����� ���̵�� " + findId + "�Դϴ�:)");
			// ������������ ������ �̵�
			request.getRequestDispatcher("success/success.jsp").forward(request, response);

			// request.getRequestDispatcher("findId.jsp").forward(request,
			// response);
		} else {
			// StringBuilder error = new StringBuilder();
			request.setAttribute("message", "�ñ��ȸ���� �ƴϽðų� �߸��� ������ �Է��Ͽ����ϴ�:(");
			request.getRequestDispatcher("error/error.jsp").forward(request, response);

		}
		// ���������� �̵� :����

	}

	/** �ñ��ȸ�����̵�ã�� ���� �޼��� */
	protected void managerFindId(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��û������ ����: view findIdPw.jsp
		String name = request.getParameter("name");
		String mobile = request.getParameter("mobile");
		System.out.println(name);
		System.out.println(mobile);

		// ��û������ ����: �ʼ� �Է��׸�
		if (name.trim().length() == 0 || mobile.trim().length() == 0) {
			// ���Է½� ���� ������ �̵� ó��
			request.setAttribute("message", "�ڽ��� �̸��� �ڵ�����ȣ�� �ٽ� Ȯ�ιٶ��ϴ�:(");
			// ������������ ������ �̵�
			RequestDispatcher nextView = request.getRequestDispatcher("error/error.jsp");
			nextView.forward(request, response);
		}
		// Model ��û �Ƿ�
		String cNumber = managerService.findcNumber(name, mobile);
		System.out.println("\n## cNumber: " + cNumber);

		// ��û��� �޾Ƽ� �������� ����
		if (cNumber != null) {
			request.setAttribute("cNumber", cNumber);
			request.setAttribute("message", "����� �ڰݹ�ȣ�� :)" + cNumber + "�Դϴ�.");
			// ������������ ������ �̵�
			request.getRequestDispatcher("success/success.jsp").forward(request, response);

			// request.getRequestDispatcher("findId.jsp").forward(request,
			// response);
		} else {
			// StringBuilder error = new StringBuilder();
			request.setAttribute("message", "������ȸ���� �ƴϽðų� �߸��� ������ �Է��Ͽ����ϴ�:(");
			request.getRequestDispatcher("error/error.jsp").forward(request, response);

		}
		// ���������� �̵� :����

	}

	/** �ñ��ȸ����й�ȣã�� ���� �޼��� */

	protected void ownerFindPw(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��û������ ����: view findIdPw.jsp
		String userId = request.getParameter("userId");
		String mobile = request.getParameter("mobile");
		System.out.println(userId);
		System.out.println(mobile);

		// ��û������ ����: �ʼ� �Է��׸�
		if (userId.trim().length() == 0 || mobile.trim().length() == 0) {
			// ���Է½� ���� ������ �̵� ó��
			request.setAttribute("message", "�ڽ��� �̸��� �ڵ�����ȣ�� �ٽ� Ȯ�ιٶ��ϴ�:(");
			// ������������ ������ �̵�
			RequestDispatcher nextView = request.getRequestDispatcher("error/error.jsp");
			nextView.forward(request, response);
		}
		// Model ��û �Ƿ�
		String findPw = ownerService.findPw(userId, mobile);
		System.out.println("\n## findPw: " + findPw);

		// ��û��� �޾Ƽ� �������� ����
		if (findPw != null) {
			request.setAttribute("findPw", findPw);
			request.setAttribute("message", "����� ��й�ȣ�� " + findPw + "�Դϴ�:)");
			// ������������ ������ �̵�
			request.getRequestDispatcher("success/success.jsp").forward(request, response);

			// request.getRequestDispatcher("findId.jsp").forward(request,
			// response);
		} else {
			// StringBuilder error = new StringBuilder();
			request.setAttribute("message", "�ñ��ȸ���� �ƴϽðų� �߸��� ������ �Է��Ͽ����ϴ�:(");
			request.getRequestDispatcher("error/error.jsp").forward(request, response);

		}

	}

	/** �����̷α��� ��û ���� �޼��� */
	protected void loginManager(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cNumber = request.getParameter("cNumber");
		String userPw = request.getParameter("userPw");
		System.out.println(cNumber);
		System.out.println(userPw);

		// ��û������ ����: �ʼ� �Է��׸�
		if (cNumber == null || cNumber.trim().length() == 0 || userPw == null || userPw.trim().length() == 0) {
			// ���Է½� ���� ������ �̵� ó��
			request.setAttribute("message", "�α��������� �Է��Ͻñ� �ٶ��ϴ�.");
			// ������������ ������ �̵�
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
		}
		// Model ��û �Ƿ�
		HashMap<String, String> loginMap = managerService.login(cNumber, userPw);

		// ��û��� �޾Ƽ� �������� ����
		if (loginMap != null) {
			// ���������� �̵� :����
			request.setAttribute("loginMap", loginMap);

			// HttpSession : �α��� ~ �α׾ƿ�(Ÿ�Ӿƿ�) �Ҷ����� ������������ (����)
			HttpSession session = request.getSession(true);// �⺻ true
			session.setAttribute("cNumber", cNumber);
			session.setAttribute("name", loginMap.get("name"));
			session.setAttribute("grade", loginMap.get("grade"));

			System.out.println(loginMap.get("name"));

			request.getRequestDispatcher("loginEndManager.jsp").forward(request, response);
		} else {
			// StringBuilder error = new StringBuilder();
			request.setAttribute("message", "�α��� ������ �ٽ��ѹ� Ȯ�����ּ��� :(");
			request.getRequestDispatcher("error/error.jsp").forward(request, response);

		}

	}

	// �α׾ƿ��ϱ�
	protected void logoutManager(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// �α��� ��������� ����
		// ���� �α���
		HttpSession session = request.getSession(false);

		if (session.getAttribute("cNumber") != null && session != null) {

			session.removeAttribute("cNumber");
			session.removeAttribute("name");
			session.removeAttribute("grade");

			session.invalidate();
			response.sendRedirect("index.jsp");

			// nextView.redirect(request, response);
		} else {
			request.setAttribute("message", "�α����� ���񽺸� �Է��Ͻñ� �ٶ��ϴ�.");
			// ������������ ������ �̵�
			request.getRequestDispatcher("login.jsp").forward(request, response);

		}

	}

	/** ������ȸ������ ��û ���� �޼��� */
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
			// ���Է½� ���� ������ �̵� ó��
			request.setAttribute("message", "�ñ��ȸ������ �ʼ��׸��� �־��ּ���.");
			// ������������ ������ �̵�
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
		} else {
			Manager member = new Manager(cNumber, name, userPw, mobile, posssibleArea, enviroment, carrier);

			managerService.enrollManager(member);
			RequestDispatcher nextView = request.getRequestDispatcher("loginCheck.jsp");
			nextView.forward(request, response);
		}

	}

	/** ������ȸ����й�ȣã�� ���� �޼��� */

	protected void managerFindPw(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��û������ ����: view findIdPw.jsp
		String cNumber = request.getParameter("cNumber");
		String mobile = request.getParameter("mobile");
		System.out.println(cNumber);
		System.out.println(mobile);

		// ��û������ ����: �ʼ� �Է��׸�
		if (cNumber.trim().length() == 0 || mobile.trim().length() == 0) {
			// ���Է½� ���� ������ �̵� ó��
			request.setAttribute("message", "�ڽ��� �ڰݹ�ȣ�� �ڵ�����ȣ�� �ٽ� Ȯ�ιٶ��ϴ�:(");
			// ������������ ������ �̵�
			RequestDispatcher nextView = request.getRequestDispatcher("error/error.jsp");
			nextView.forward(request, response);
		}
		// Model ��û �Ƿ�
		String findPw = managerService.findPw(cNumber, mobile);
		System.out.println("\n## findPw: " + findPw);

		// ��û��� �޾Ƽ� �������� ����
		if (findPw != null) {
			request.setAttribute("findPw", findPw);
			request.setAttribute("message", "����� ��й�ȣ�� " + findPw + "�Դϴ�:)");
			// ������������ ������ �̵�
			request.getRequestDispatcher("success/success.jsp").forward(request, response);

			// request.getRequestDispatcher("findId.jsp").forward(request,
			// response);
		} else {
			// StringBuilder error = new StringBuilder();
			request.setAttribute("message", "�ñ��ȸ���� �ƴϽðų� �߸��� ������ �Է��Ͽ����ϴ�:(");
			request.getRequestDispatcher("error/error.jsp").forward(request, response);

		}

	}

	// ������ȸ�� ����ȸ
	protected void findManagerBylogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false); // session ����
		String cNumber = (String) session.getAttribute("cNumber");
		System.out.println(session.getAttribute("cNumber"));
		if (cNumber == null) {
			request.setAttribute("message", "�α��� �� �������ּ���:(");
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
		}
		// ��û������ ����: �ʼ� �Է��׸�
		if (cNumber.trim().length() == 0) {
			// ���Է½� ���� ������ �̵� ó��
			request.setAttribute("message", "�ڰ�����ȣ�� �ٽ��Է����ּ���");
			// ������������ ������ �̵�
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
		}

		Manager member = managerService.findMember(cNumber);
		System.out.println(member);

		// ��û��� �޾Ƽ� �������� ����
		if (member != null) {
			request.setAttribute("member", member);

			request.getRequestDispatcher("checkManagerInfo.jsp").forward(request, response);
		} else {
			StringBuilder error = new StringBuilder();
			request.setAttribute("message", "��ϵ��� ���� �ñ��ȸ������ Ȯ�κ�Ź�帳�ϴ�");
			request.getRequestDispatcher("error/errorLoginManager.jsp").forward(request, response);

		}
		// ���������� �̵� :����
	}

	/** ������ȸ������ ���� ��û ���� �޼��� */
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
			request.setAttribute("message", "�α��� �� �������ּ���:(");
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
		}

		System.out.println(name + cNumber + userPw + mobile + possibleArea + enviroment + carrier);

		if (name.trim().length() == 0 || cNumber.trim().length() == 0 || userPw.trim().length() == 0
				|| mobile.trim().length() == 0 || possibleArea.trim().length() == 0 || enviroment.trim().length() == 0
				|| carrier.trim().length() == 0) {
			// ���Է½� ���� ������ �̵� ó��
			request.setAttribute("message", "��Ȯ�� ������ �Է����ּ���:(");
			// ������������ ������ �̵�
			request.getRequestDispatcher("error/errorloginManager.jsp").forward(request, response);

		} else {
			Manager member = new Manager(cNumber, name, userPw, mobile, possibleArea, enviroment, carrier);

			int checkUpdate = managerService.updateMember(member);
			System.out.println(checkUpdate);
			if (checkUpdate != 0) {
				request.setAttribute("message", "������ �ùٸ��� ����Ǿ����ϴ�:)");
				// ������������ ������ �̵�
				request.getRequestDispatcher("success/successLoginManager.jsp").forward(request, response);
				/*
				 * RequestDispatcher nextView =
				 * request.getRequestDispatcher("loginEnd.jsp");
				 * nextView.forward(request, response);
				 */

			}
			request.setAttribute("message", "����� ������ �ùٸ����ʽ��ϴ�:(");
			// ������������ ������ �̵�
			request.getRequestDispatcher("error/errorLogin.jsp").forward(request, response);
		}

	}

	/**������ �űԵ�� ��û ���� �޼��� 
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
					// ���Է½� ���� ������ �̵� ó��
					request.setAttribute("message", "�����̵�� �ʼ��׸��� �־��ּ���.");
					// ������������ ������ �̵�
					request.getRequestDispatcher("error/errorLoginManager.jsp").forward(request, response);
					return;
				} 
					
							String check;
							try {
								check = managerService.checkCaring(cNumber);
								if(check.equals("������")){
									request.setAttribute("message", "������ Ȱ���� ������ ������ּ���.");
									// ������������ ������ �̵�
									request.getRequestDispatcher("error/errorLoginManager.jsp").forward(request, response);
								}else{
										 Board board = new Board(cNumber,title,content,price,possibleDogKind);

											boardService.enrollBoard(board);
											request.setAttribute("message", "�����̷� ��ϵǾ����ϴ� :) ����ϴ� �ݷ��߿��� ������ ������ �����ּ���.");
											// ������������ ������ �̵�
											request.getRequestDispatcher("success/successLoginManager.jsp").forward(request, response);
										
									}
							} catch (Exception e) {
								e.printStackTrace();
							}
							

				}
			

	/** ȸ��������ü��ȸ ���� �޼��� */

	protected void findBoardAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<Board> list = boardService.findBoardAll();

		// ��û��� �޾Ƽ� �������� ����
		if (list != null) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("boardList.jsp").forward(request, response);
		} else {
			StringBuilder error = new StringBuilder();
			error.append("��ϵ� �����̰� �����ϴ�.");
			request.setAttribute("message", error.toString());
			request.getRequestDispatcher("error/errorLoginManager.jsp").forward(request, response);

		}
		// ���������� �̵� :����

	}

	// ������ȸ�� ����ȸ
	protected void findBoardBylogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String boardNumber1 = request.getParameter("boardNumber");
		System.out.println(boardNumber1);

		int boardNumber = Integer.parseInt(boardNumber1);

		Board board = boardService.findBoard(boardNumber);

		// ��û��� �޾Ƽ� �������� ����
		if (board != null) {
			request.setAttribute("board", board);

			request.getRequestDispatcher("checkBoard.jsp").forward(request, response);
		} else {
			/*
			 * StringBuilder error = new StringBuilder();
			 * request.setAttribute("message", "��ϵ��� ���� �ñ��ȸ������ Ȯ�κ�Ź�帳�ϴ�");
			 * request.getRequestDispatcher("error/errorLoginManager.jsp").
			 * forward(request, response);
			 */
		}
		// ���������� �̵� :����
	}

	/** ������ȸ��������ü��ȸ(�ñ�̹���) ���� �޼��� */

	protected void findBoardAllOwner(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<Board> list = boardService.findBoardAll();

		// ��û��� �޾Ƽ� �������� ����
		if (list != null) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("boardListOwner.jsp").forward(request, response);
		} else {
			StringBuilder error = new StringBuilder();
			error.append("��ϵ� �����̰� �����ϴ�.");
			request.setAttribute("message", error.toString());
			request.getRequestDispatcher("error/errorLoginOwner.jsp").forward(request, response);

		}
		// ���������� �̵� :����

	}

	/** ������ �űԵ�� ��û ���� �޼��� */
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
			// ���Է½� ���� ������ �̵� ó��
			request.setAttribute("message", "�������� ��Ȯ�� ������ �Է����ּ��� :(");
			// ������������ ������ �̵�
			request.getRequestDispatcher("error/errorLogin.jsp").forward(request, response);
			return;
		} else {
			Caring caring = new Caring(userId, cNumber, dogNumber, dogName, dogKind, dogAge, gender);

			caringService.enrollPet(caring);
			request.setAttribute("message", "�������� ��ϵǾ����ϴ�. �ð����� �湮���ּ��� :)  ");
			// ������������ ������ �̵�
			request.getRequestDispatcher("success/successLoginEnd.jsp").forward(request, response);
		}

	}

	// ������ȸ�� ����ȸ(�ָ�Ī���̺� �����Ҷ�)
	protected void findManagerByPet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cNumber = request.getParameter("cNumber");
		System.out.println(cNumber);
		if (cNumber == null || cNumber.trim().length() == 0) {
			request.setAttribute("message", "�߸��� �����Դϴ�.:(");
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
		}

		Manager member = managerService.findMember(cNumber);
		System.out.println(member);
		request.setAttribute("member", member);
		request.getRequestDispatcher("checkManagerInfoCaring.jsp").forward(request, response);

	}

	// �����̸ñ�� ��Ī ����ȸ
	protected void findCaringBycNumber(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false); // session ����
		String cNumber = (String) session.getAttribute("cNumber");
		System.out.println(session.getAttribute("cNumber"));

		// ��û������ ����: �ʼ� �Է��׸�
		if (cNumber.trim().length() == 0) {
			// ���Է½� ���� ������ �̵� ó��
			request.setAttribute("message", "��ϵ� ���� ��Ȳ�̾����ϴ�.");
			// ������������ ������ �̵�
			request.getRequestDispatcher("error/errorLoginManager.jsp").forward(request, response);
		}

		Caring caring = caringService.findCaring(cNumber);
		System.out.println(caring);

		// ��û��� �޾Ƽ� �������� ����
		if (caring != null) {
			request.setAttribute("caring", caring);

			request.getRequestDispatcher("showCaring.jsp").forward(request, response);
		} else {
			StringBuilder error = new StringBuilder();
			error.append("��ϵ��� ���� �ñ��ȸ������ Ȯ�κ�Ź�帳�ϴ�");
			request.setAttribute("message", error.toString());
			request.getRequestDispatcher("error/errorLogin.jsp").forward(request, response);

		}
		// ���������� �̵� :����

	}

	/** �������������ϱ�(�Խ��ǿ��� ����) ���� �޼��� */
	protected void deleteCaring(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		String cNumber = (String) session.getAttribute("cNumber");
		System.out.println("�ڰ��� ��ȣ :" + cNumber);

		// Model ��û �Ƿ�
		caringService.deleteCaring(cNumber);

		// ��û��� �޾Ƽ� �������� ����
		request.setAttribute("message", "�����̰� �����Ǿ����ϴ� :) ������ �� �̿����ּ���.");
		// ������������ ������ �̵�
		request.getRequestDispatcher("success/successLoginManager.jsp").forward(request, response);

	}

	/** ��������Ȯ���ϱ�(�Խ��ǿ��� ����) ���� �޼��� */
	protected void checkCaring(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cNumber = request.getParameter("cNumber");
		System.out.println("checkCaring" + cNumber);
		try {
			String check = managerService.checkCaring(cNumber);

			System.out.println("check: " + check);

			if (check.equals("������")) {
				request.setAttribute("message", "������ Ȱ���� ������ ������ּ���.");
				// ������������ ������ �̵�
				request.getRequestDispatcher("error/errorLoginManager.jsp").forward(request, response);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/** get, post ��û�� ó���ϴ� ���� �޼��� */
	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��û �ľ� : ��û�����Ϳ��� ��û�� ���� key ������ ��������
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
				// �������� �ʴ� ��û ���� ������ �̵�
			}
		} else {
			// �߸��� ��û��� ���� ������ �̵�
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
