package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.FreeBoard;
import dto.FreeReply;

public class FreeBoardDAO {
	private FreeBoardDAO() {
	}

	private static FreeBoardDAO dao = new FreeBoardDAO();

	public static FreeBoardDAO getInstance() {
		return dao;
	}
	
	// 페이징
	public List<FreeBoard> getFreeBoardPage(int start, int size) {
		List<FreeBoard> list = new ArrayList<FreeBoard>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		// desc 부분 안함 /*+index_desc(BOARD_BNO_IDX)*/
		String sql = " select * from " + 
				"    (select rownum as rn," + 
				"     a.bno, a.id, a.title, a.content, a.write_date, a.read_count, a.reply_count" + 
				"    from (select * from tbl_freeboard order by bno desc) a" + 
				"    where rownum<=?) b" + 
				"    where b.rn>=? "; 
//		String sql="select * from "
//				+"(select /*+index_desc(BOARD_BNO_IDX)*/ rownum as rn, "
//				+"a.bno, a.member_id, a.title, a.content, a.write_date, a.read_count,"
//				+ "a.reply_count,a.filename "
//				+"from (select * from board order by bno desc) a "
//				+"where rownum<=?)b "
//				+"where b.rn>=?";
		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, start+size);
			ps.setInt(2, start+1);
			rs = ps.executeQuery();
			while (rs.next()) {
				FreeBoard freeboard = new FreeBoard();
				freeboard.setBno(rs.getInt("bno"));
				freeboard.setId(rs.getString("id"));
				freeboard.setTitle(rs.getString("title"));
				freeboard.setContent(rs.getString("content"));
				freeboard.setWrite_date(rs.getTimestamp("write_date"));
				freeboard.setRead_count(rs.getInt("read_count"));
				freeboard.setReply_count(rs.getInt("reply_count"));
				list.add(freeboard);
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

	public List<FreeBoard> getFreeBoardAll() {
		List<FreeBoard> list = new ArrayList<FreeBoard>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from tbl_freeboard";
		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				FreeBoard freeboard = new FreeBoard();
				freeboard.setBno(rs.getInt("bno"));
				freeboard.setId(rs.getString("id"));
				freeboard.setTitle(rs.getString("title"));
				freeboard.setContent(rs.getString("content"));
				freeboard.setWrite_date(rs.getTimestamp("write_date"));
				freeboard.setRead_count(rs.getInt("read_count"));
				freeboard.setReply_count(rs.getInt("reply_count"));
				list.add(freeboard);
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

	public void freeboardWrite(FreeBoard freeboard) {
		Connection conn = null;
		PreparedStatement ps = null; 
		String sql = "insert into tbl_freeboard(bno, id, title, content, filename) "
				+ "values(freeboard_seq.nextval,?,?,?,? )";
		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, freeboard.getId());
			ps.setString(2, freeboard.getTitle());
			ps.setString(3, freeboard.getContent());
			int n = ps.executeUpdate();
			if (n == 1) {
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

	public FreeBoard getFreeBoard(int bno) {
		FreeBoard freeboard = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from tbl_freeboard where bno=?";

		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bno);
			rs = ps.executeQuery();

			while (rs.next()) {
				freeboard = new FreeBoard();
				freeboard.setBno(rs.getInt("bno"));
				freeboard.setId(rs.getString("id"));
				freeboard.setTitle(rs.getString("title"));
				freeboard.setContent(rs.getString("content"));
				freeboard.setWrite_date(rs.getTimestamp("write_date"));
				freeboard.setRead_count(rs.getInt("read_count"));
				freeboard.setReply_count(rs.getInt("reply_count"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBConn.close(rs);
			DBConn.close(ps);
			DBConn.close(conn);
		}
		return freeboard;
	}

	public void read_count_update(int bno){
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update tbl_freeboard set read_count=read_count+1 where bno=?";
		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bno);
			int n = ps.executeUpdate();
			if(n==1) {
				conn.commit(); 
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBConn.close(ps);
			DBConn.close(conn);
		}
	}
	
	public void freeboardUpdate(FreeBoard freeboard) { 
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update tbl_freeboard set title=?, content=?, filename=? where bno=?";
		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, freeboard.getTitle());
			ps.setString(2, freeboard.getContent());
			ps.setInt(3, freeboard.getBno());
			
			int n = ps.executeUpdate();
			if(n==1) {
				conn.commit(); 
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBConn.close(ps);
			DBConn.close(conn);
		}
	}
	
	public void freeboardDelete(int bno) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "delete from tbl_freeboard where bno=?";
		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bno);
			int n = ps.executeUpdate();
			if(n==1) {
				conn.commit();
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
		String sql = "select count(*) from tbl_freeboard";
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

	public void freereplyWrite(FreeReply freereply) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql1 = "update tbl_freeboard set reply_count=reply_count+1 where bno=?";
		String sql2 = "insert into freereply(rno, bno, id, content) values(reply_seq.nextval, ?, ?, ?)";
		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql1);
			ps.setInt(1, freereply.getBno());
			int m = ps.executeUpdate();
			ps.close();
			
			ps = conn.prepareStatement(sql2);
			ps.setInt(1, freereply.getBno());
			ps.setString(2, freereply.getId());
			ps.setString(3, freereply.getContent());
			int n = ps.executeUpdate();
			//1이면 커밋이었으나 이 때에는 무조건 되게 해야함
			if(m==1 && n==1) {
				DBConn.commit(conn);
			}else {
				//DBConn.rollback(conn);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBConn.close(ps);
			DBConn.close(conn);
		}
	}
	
	public void freereplyDelete(int rno) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select bno from tbl_freereply where rno=? ";
		String sql1 = "update board set reply_count=reply_count-1 where bno=?";
		String sql2 = "delete from tbl_freereply where rno=?";
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
				//DBConn.rollback(conn);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBConn.close(ps);
			DBConn.close(conn);
		}
		return;
	}
	
	public List<FreeReply> getReplyList(int bno){
		List<FreeReply> list = new ArrayList<FreeReply>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = " select * from tbl_freereply ";
		try {
			conn=DBConn.getConnect();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				FreeReply freereply = new FreeReply(); //안빼먹게 주의, 위치주의
				freereply.setRno(rs.getInt("rno"));
				freereply.setBno(rs.getInt("bno"));
				freereply.setId(rs.getString("Id"));
				freereply.setContent(rs.getString("content"));
				freereply.setRe_date(rs.getTimestamp("re_date"));
				list.add(freereply); //안빼먹게 주의ㅣ 
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