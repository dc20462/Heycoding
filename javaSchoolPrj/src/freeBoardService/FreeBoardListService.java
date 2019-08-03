package freeBoardService;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FreeBoardDAO;
import dto.FreeBoard;


public class FreeBoardListService implements FreeBoardService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		FreeBoardDAO bDao=FreeBoardDAO.getInstance();
		List<FreeBoard> freeboardList=bDao.getFreeBoardAll();
		
		request.setAttribute("freeboardList", freeboardList);
		
		request.getRequestDispatcher("/freeboard/freeboardList.jsp").forward(request, response);
	}

}
