package controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import freeBoardService.FreeBoardDeleteService;
import freeBoardService.FreeBoardListPageService;
import freeBoardService.FreeBoardService;
import freeBoardService.FreeBoardUpdateFormService;
import freeBoardService.FreeBoardUpdateService;
import freeBoardService.FreeBoardViewService;
import freeBoardService.FreeBoardWriteFormService;
import freeBoardService.FreeBoardWriteService;
import freeBoardService.FreeReplyDeleteService;
import freeBoardService.FreeReplyWriteService;

/**
 * Servlet implementation class FreeBoardServlet
 */
@WebServlet("*.do")
public class FreeBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private FreeBoardService service=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreeBoardServlet() {
        super();
    }

    public void init(ServletConfig config) throws ServletException {
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doProcess(request, response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String requestURI = request.getRequestURI(); //전체 경로 (0부터시작) BoardSystem/boardList.do
		String contextPath = request.getContextPath(); //현재 경로 (BoardSystem) /boardList.do
		String command = requestURI.substring(contextPath.length()); //list.do를 command로 잘라오겠다. 시작위치만 적고 끝위치 생략함. contextPath부터 끝까지라는 뜻
		
		if(command.equals("/freeboardList.do")) {
			service=new FreeBoardListPageService();
			
		}else if(command.equals("/freeboardWriteForm.do")) {
			service=new FreeBoardWriteFormService();
			
		}else if(command.equals("/freeboardWrite.do")) {
			service=new FreeBoardWriteService();
			
		}else if(command.equals("/freeboardView.do")){
			service=new FreeBoardViewService();
			
		}else if(command.equals("/freeboardUpdateForm.do")) {
			service=new FreeBoardUpdateFormService();
			
		}else if(command.equals("/freeboardUpdate.do")) {
			service=new FreeBoardUpdateService();
			
		}else if(command.equals("/freeboardDelete.do")) {
			service=new FreeBoardDeleteService();
			
		}else if(command.equals("/freereplyWrite.do")){
			service=new FreeReplyWriteService();
			
		}else if(command.equals("/freereplyDelete.do")) {
			service=new FreeReplyDeleteService();
	
		}
		service.execute(request, response);
	
	}
}
