package freeBoardService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FreeBoardDAO;

public class FreeReplyDeleteService implements FreeBoardService {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String page = request.getParameter("page");
		int rno = Integer.parseInt(request.getParameter("rno"));
		int bno = Integer.parseInt(request.getParameter("bno"));
		FreeBoardDAO bDao = FreeBoardDAO.getInstance();
		bDao.freereplyDelete(rno);
		response.sendRedirect("freeboardView.do?bno="+bno+"&page="+page);
	}
}
