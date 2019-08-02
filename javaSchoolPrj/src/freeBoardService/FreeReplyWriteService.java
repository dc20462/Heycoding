package freeBoardService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FreeBoardDAO;
import dto.FreeReply;

public class FreeReplyWriteService implements FreeBoardService {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String page = request.getParameter("page");
		FreeReply freereply = new FreeReply();
		freereply.setBno(Integer.parseInt(request.getParameter("bno")));
		freereply.setId(request.getParameter("id"));
		freereply.setContent(request.getParameter("content"));
		FreeBoardDAO dao = FreeBoardDAO.getInstance();
		dao.freereplyWrite(freereply);
		response.sendRedirect("freeboardView.do?bno="+freereply.getBno()+"&page="+page);
	}
}
