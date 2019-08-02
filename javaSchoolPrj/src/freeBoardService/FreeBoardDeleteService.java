package freeBoardService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FreeBoardDAO;

public class FreeBoardDeleteService implements FreeBoardService {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int bno=Integer.parseInt(request.getParameter("bno"));
		String page=request.getParameter("page");
		FreeBoardDAO bDao=FreeBoardDAO.getInstance();
		bDao.freeboardDelete(bno);
		response.sendRedirect("freeboardList.do?page="+page);
		
	}


}
