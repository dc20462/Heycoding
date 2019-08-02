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

public class FreeBoardWriteService implements FreeBoardService {
	//file upload
			@Override
			public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				FreeBoard freeboard = new FreeBoard();
				String saveFolder="/upload"; //webContent 밑에 upload
				int maxSize=5*1024*1024; //최대파일사이즈(5mb) 설정
				ServletContext context = request.getServletContext();
				String realFolder=context.getRealPath(saveFolder); //실제 파일이 저장되는 폴더. upload가 아님
				System.out.print("realFolder: "+realFolder); 
				
				MultipartRequest multi = new MultipartRequest( //객체가 생성만 되면 파일이 업로드된다.
						request, realFolder, maxSize, "UTF-8", new DefaultFileRenamePolicy() //같은파일이름
						);
				
				freeboard.setId(multi.getParameter("id"));
				freeboard.setTitle(multi.getParameter("title"));
				freeboard.setContent(multi.getParameter("content"));
				
//				Enumeration<String> files = multi.getFileNames();
//				//파일이 여러개 올라갈 때
//				while(files.hasMoreElements()) {
//					String file = files.nextElement(); //하나씩 끄낸다
//					multi.getFilesystemName(file);  //이미 올라간 파일
//				}
				
				//파일 하나 업로드할 때 
//				freeboard.setFilename(multi.getFilesystemName((String)multi.getFileNames().nextElement()));
				
				//db저장
				FreeBoardDAO bDao= FreeBoardDAO.getInstance();
				bDao.freeboardWrite(freeboard);
				response.sendRedirect("freeboardList.do"); 
				
				}
}
