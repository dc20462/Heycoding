package controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import freeBoardService.FreeBoardListPageService;
import freeBoardService.FreeBoardViewService;
import mainService.MainFreeBoardListService;
import mainService.MainMemberJoinService;
import mainService.MainService;
import mainService.MainViewService;

/**
 * Servlet implementation class BoardServlet
 */
@WebServlet("*.main") 
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MainService service=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doProcess(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doProcess(request,response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String requestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command=requestURI.substring(contextPath.length());
		
		if(command.equals("/mainView.main")) {
			service=new MainViewService();
		}else if(command.equals("/idchk.main")) {
			//service=new MainViewService();
		}else if(command.equals("/join.main")) {
			service=new MainMemberJoinService();
		}else if(command.equals("/freeboardList.main")) {
			//System.out.println("aa0");
			service=new MainFreeBoardListService();
		}else if(command.equals("/secretboardList.main")) {
//			service=new MainFreeBoardListService();
		}
		service.execute(request, response); 	
	}
}
