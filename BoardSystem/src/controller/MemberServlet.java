package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dto.Member;
import service.MemberDeleteService;
import service.MemberJoinFormService;
import service.MemberJoinService;
import service.MemberListService;
import service.MemberUpdateFormService;
import service.MemberUpdateService;
import service.Service;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/member")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Service service = null;
    /**
     * Default constructor. 
     */
    public MemberServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String command = request.getParameter("command");
		if(command.equals("list")) {
			//cut
			//이 내용을 MemberListService.java로 옮긴다.
//			MemberDAO dao = MemberDAO.getInstance();
//			List<Member> memberList=dao.getMemberAll();
//			request.setAttribute("memberList", memberList);
//			request.getRequestDispatcher("/member/list").forward(request, response);
			service = new MemberListService();
			
		}
		else if(command.equals("joinForm")) {
			//이거에 따라서 처리한다.
			service = new MemberJoinFormService();
		}
		else if (command.equals("join")) {
			service = new MemberJoinService();
		} 
		else if(command.equals("updateForm")) {
			service = new MemberUpdateFormService();
		}
		else if(command.equals("update")) {
			service = new MemberUpdateService();
		}
		else if(command.equals("delete")) {
			service = new MemberDeleteService();
		}		
		service.execute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");  //한글깨짐방지
		doGet(request, response);
	}

}
