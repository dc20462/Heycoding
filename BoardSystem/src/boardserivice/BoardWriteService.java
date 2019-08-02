package boardserivice;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BoardDAO;
import dto.Board;

public class BoardWriteService implements BoardService {
	//file upload
		@Override
		public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub

			Board board = new Board();
			String saveFolder="/upload"; //webContent 밑에 upload
			int maxSize=5*1024*1024; //최대파일사이즈(5mb) 설정
			ServletContext context = request.getServletContext();
			String realFolder=context.getRealPath(saveFolder); //실제 파일이 저장되는 폴더. upload가 아님
			System.out.print("realFolder: "+realFolder); 
			
			MultipartRequest multi = new MultipartRequest( //객체가 생성만 되면 파일이 업로드된다.
					request, realFolder, maxSize, "UTF-8", new DefaultFileRenamePolicy() //같은파일이름
					);
			
			board.setMember_id(multi.getParameter("member_id"));
			board.setTitle(multi.getParameter("title"));
			board.setContent(multi.getParameter("content"));
			
//			Enumeration<String> files = multi.getFileNames();
//			//파일이 여러개 올라갈 때
//			while(files.hasMoreElements()) {
//				String file = files.nextElement(); //하나씩 끄낸다
//				multi.getFilesystemName(file);  //이미 올라간 파일
//			}
			
			//WEB-INF > lib 안에 cos.jar : 파일을 업로드할 때 쓰는 라이브러리 를 복붙해서 진행한 후
			//파일 하나 업로드할 때 
			board.setFilename(multi.getFilesystemName((String)multi.getFileNames().nextElement()));
			
			//db저장
			BoardDAO bDao= BoardDAO.getInstance();
			bDao.boardWrite(board);
			response.sendRedirect("boardList.do"); 
			
			}
			
	
}