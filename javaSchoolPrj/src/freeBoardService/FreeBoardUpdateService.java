package freeBoardService;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.FreeBoardDAO;
import dto.FreeBoard;


//파일업로드
public class FreeBoardUpdateService implements FreeBoardService {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		FreeBoard freeboard = new FreeBoard();
		String saveFolder = "/upload"; // webContent 밑에 upload
		int maxSize = 5 * 1024 * 1024; // 최대파일사이즈(5mb) 설정
		ServletContext context = request.getServletContext();
		String realFolder = context.getRealPath(saveFolder); // 실제 파일이 저장되는 폴더. upload가 아님
		System.out.print("realFolder: " + realFolder);

		MultipartRequest multi = new MultipartRequest( // 객체가 생성만 되면 파일이 업로드된다.
				request, realFolder, maxSize, "UTF-8", new DefaultFileRenamePolicy() // 같은파일이름
		);
		freeboard.setBno(Integer.parseInt(multi.getParameter("bno")));
		freeboard.setTitle(multi.getParameter("title"));
		freeboard.setContent(multi.getParameter("content"));
		/* writeService.java와 한가지 다른 점. 수정과 입력은 비슷하다. */
		String filename = multi.getFilesystemName("filename");

		/* 수정 시 이미지는 안바꿀 때 (image의 이름 그대로) */
		if (filename == null) {
//			freeboard.setFilename(multi.getParameter("nonMakeImg"));
		} else {
			//WEB-INF > lib 안에 cos.jar : 파일을 업로드할 때 쓰는 라이브러리 를 복붙해서 진행한 후
			// 파일 하나 업로드할 때 (사진 정상적 수정)
//			freeboard.setFilename(multi.getFilesystemName((String) multi.getFileNames().nextElement()));
		}
		String page=multi.getParameter("page");
		// db저장
		FreeBoardDAO bDao = FreeBoardDAO.getInstance();
		bDao.freeboardUpdate(freeboard);
		response.sendRedirect("freeboardList.do?page="+page);
	}
}
