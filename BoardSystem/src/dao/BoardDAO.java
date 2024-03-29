package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.Board;
import dto.Reply;

public class BoardDAO {
	private BoardDAO() {
	}

	private static BoardDAO dao = new BoardDAO();

	public static BoardDAO getInstance() {
		return dao;
	}
	
	// 페이징
	public List<Board> getBoardPage(int start, int size) {
		List<Board> list = new ArrayList<Board>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//String sql = "select * from board order by bno desc limit?,?"; //mysql
		//oracle 서브쿼리 사용 .limit 없음
		String sql = " select * from " + 
				"    (select /*+index_desc(BOARD_BNO_IDX)*/ rownum as rn," + 
				"     a.bno, a.member_id, a.title, a.content, a.write_date, a.read_count, a.reply_count, a.filename" + 
				"    from (select * from board order by bno desc) a" + 
				"    where rownum<=?) b" + 
				"    where b.rn>=? "; 
		//where rownum 마지막
		//where b.rn 시작
		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, start+size);
			ps.setInt(2, start+1);
			rs = ps.executeQuery();
			while (rs.next()) {
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setMember_id(rs.getString("member_id"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWrite_date(rs.getTimestamp("write_date"));
				board.setRead_count(rs.getInt("read_count"));
				board.setReply_count(rs.getInt("reply_count"));
				board.setFilename(rs.getString("filename"));
				list.add(board);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBConn.close(rs);
			DBConn.close(ps);
			DBConn.close(conn);
		}
		return list;
	}

	public List<Board> getBoardAll() {
		List<Board> list = new ArrayList<Board>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from board";
		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setMember_id(rs.getString("member_id"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWrite_date(rs.getTimestamp("write_date"));
				board.setRead_count(rs.getInt("read_count"));
				board.setReply_count(rs.getInt("reply_count"));
				board.setFilename(rs.getString("filename"));
				list.add(board);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBConn.close(rs);
			DBConn.close(ps);
			DBConn.close(conn);
		}
		return list;
	}

	public void boardWrite(Board board) {
		Connection conn = null;
		PreparedStatement ps = null; // 쿼리생성
		// ResultSet rs = null; select 할 때만
		String sql = "insert into board(bno, member_id, title, content, filename) "
				+ "values(board_seq.nextval,?,?,?,? )";
		// 시퀀스 (bno)
		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, board.getMember_id());
			ps.setString(2, board.getTitle());
			ps.setString(3, board.getContent());
			ps.setString(4, board.getFilename());
			int n = ps.executeUpdate();
			// because commit false
			// executeupdate는 변경된 레코드 개수 (int)값이 나온다.
			if (n == 1) {
				/* DBConn.commit(conn); */
				conn.commit();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBConn.close(ps);
			DBConn.close(conn);
		}
		return;
	}

	public Board getBoard(int bno) {
		Board board = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from board where bno=?";

		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bno);
			rs = ps.executeQuery();

			while (rs.next()) {
				board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setMember_id(rs.getString("member_id"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWrite_date(rs.getTimestamp("write_date"));
				board.setRead_count(rs.getInt("read_count"));
				board.setReply_count(rs.getInt("reply_count"));
				board.setFilename(rs.getString("filename"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBConn.close(rs);
			DBConn.close(ps);
			DBConn.close(conn);
		}
		return board;
	}

	public void read_count_update(int bno){
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update board set read_count=read_count+1 where bno=?";
		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bno);
			int n = ps.executeUpdate();
			if(n==1) {
				conn.commit(); //DBConn.commit(con);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBConn.close(ps);
			DBConn.close(conn);
		}
	}
	
	public void boardUpdate(Board board) { //한꺼번에 가져올때는 클래스를 선언한다.
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update board set title=?, content=?, filename=? where bno=?";
		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, board.getTitle());
			ps.setString(2, board.getContent());
			ps.setString(3, board.getFilename());
			ps.setInt(4, board.getBno());
			
			int n = ps.executeUpdate();
			if(n==1) {
				conn.commit(); //DBConn.commit(con);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBConn.close(ps);
			DBConn.close(conn);
		}
	}
	
	public void boardDelete(int bno) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "delete from board where bno=?";
		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bno);
			int n = ps.executeUpdate();
			if(n==1) {
				conn.commit(); //DBConn.commit(conn);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBConn.close(ps);
			DBConn.close(conn);
		}
	}

	public int getTotalCount() {  //메소드 개수
		int n = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select count(*) from board";
		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				n=rs.getInt(1); //얻어지는값?
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBConn.close(rs);
			DBConn.close(ps);
			DBConn.close(conn);
		}
		return n;
	}
	public void replyWrite(Reply reply) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql1 = "update board set reply_count=reply_count+1 where bno=?";
		String sql2 = "insert into reply(rno, bno, member_id, content) values(reply_seq.nextval, ?, ?, ?)";
		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql1);
			ps.setInt(1, reply.getBno());
			int m = ps.executeUpdate();
			ps.close();
			
			ps = conn.prepareStatement(sql2);
			ps.setInt(1, reply.getBno());
			ps.setString(2, reply.getMember_id());
			ps.setString(3, reply.getContent());
			int n = ps.executeUpdate();
			//1이면 커밋이었으나 이 때에는 무조건 되게 해야함
			if(m==1 && n==1) {
				DBConn.commit(conn);
			}else {
				DBConn.rollback(conn);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBConn.close(ps);
			DBConn.close(conn);
		}
	}
	
	public void replyDelete(int rno) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//(int rno, int bno)에서 bno를 안가져오면 
		String sql = "select bno from reply where rno=? ";
		String sql1 = "update board set reply_count=reply_count-1 where bno=?";
		String sql2 = "delete from reply where rno=?";
		try {
			conn=DBConn.getConnect();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, rno);
			rs=ps.executeQuery();
			int bno = -1;
			if(rs.next()) { //1개의 데이터가 있으면
				bno = rs.getInt(1);
			}
			ps.close();
			
			ps=conn.prepareStatement(sql1);
			ps.setInt(1, bno);
			int m = ps.executeUpdate();
			ps.close();
			
			ps=conn.prepareStatement(sql2);
			ps.setInt(1, rno);
			int n = ps.executeUpdate();
			if(m==1 && n==1) {
				DBConn.commit(conn);
			}else {
				DBConn.rollback(conn);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBConn.close(ps);
			DBConn.close(conn);
		}
		return;
	}
	
	public List<Reply> getReplyList(int bno){
		List<Reply> list = new ArrayList<Reply>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = " select * from reply ";
		try {
			conn=DBConn.getConnect();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Reply reply = new Reply(); //안빼먹게 주의, 위치주의
				reply.setRno(rs.getInt("rno"));
				reply.setBno(rs.getInt("bno"));
				reply.setMember_id(rs.getString("member_id"));
				reply.setContent(rs.getString("content"));
				reply.setRe_date(rs.getTimestamp("re_date"));
				list.add(reply); //안빼먹게 주의ㅣ 
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBConn.close(ps);
			DBConn.close(conn);
		}
		return list;
	}
}