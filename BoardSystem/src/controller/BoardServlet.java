package controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardserivice.BoardDeleteService;
import boardserivice.BoardListPageService;
import boardserivice.BoardListService;
import boardserivice.BoardService;
import boardserivice.BoardUpdateFormService;
import boardserivice.BoardUpdateService;
import boardserivice.BoardViewService;
import boardserivice.BoardWriteFormService;
import boardserivice.BoardWriteService;
import boardserivice.ReplyDeleteService;
import boardserivice.ReplyWriteService;

/**
 * Servlet implementation class BoardServlet
 * 커맨드 역할을 한다.
 */
@WebServlet("*.do")
//서블릿을 부르는 url = .do (맵핑)
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService service=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardServlet() {
        super();
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//리스판스 : 세션, 쿠키
		// 리케스트 : 요청
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
			throws ServletException, IOException{
		String requestURI = request.getRequestURI(); //전체 경로 (0부터시작) BoardSystem/boardList.do
		String contextPath = request.getContextPath(); //현재 경로 (BoardSystem) /boardList.do
		String command = requestURI.substring(contextPath.length()); //list.do를 command로 잘라오겠다. 시작위치만 적고 끝위치 생략함. contextPath부터 끝까지라는 뜻
		//전체 - 현재 = do.
		//기능에 맞게 접속
		if(command.equals("/boardList.do")) {
			service=new BoardListPageService();
			
		}else if(command.equals("/boardWriteForm.do")) {
			service=new BoardWriteFormService();
			
		}else if(command.equals("/boardWrite.do")) {
			service=new BoardWriteService();
			
		}else if(command.equals("/boardView.do")){
			service=new BoardViewService();
			
		}else if(command.equals("/boardUpdateForm.do")) {
			service=new BoardUpdateFormService();
			
		}else if(command.equals("/boardUpdate.do")) {
			service=new BoardUpdateService();
			
		}else if(command.equals("/boardDelete.do")) {
			service=new BoardDeleteService();
			
		}else if(command.equals("/replyWrite.do")){
			service=new ReplyWriteService();
			
		}else if(command.equals("/replyDelete.do")) {
			service=new ReplyDeleteService();
	
		}
		service.execute(request, response);
	}
}
