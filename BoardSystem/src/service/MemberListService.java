package service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dto.Member;

public class MemberListService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		MemberDAO dao = MemberDAO.getInstance();
		// dao에 접속
		List<Member> memberList=dao.getMemberAll();
		// 리스트 가져오는 함수 호출
		request.setAttribute("memberList", memberList);
		// 디비에서 멤버리스트를 request에 담고
		request.getRequestDispatcher("/member/list.jsp").forward(request, response);
		// 멤버 안에 list.jsp 페이지를 만들고 그 페이지로 request, response를 가지고 포워딩한다. (다음페이지로 간다)
		// 아직 response에는 값이 없다.없지만 기본 매개변수라 두개 다 넣어둔 것임
		
	}

}
