package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.Member;

public class MemberDAO {
	//싱글톤객체 만들기
	private MemberDAO() {} 
	//생성자를 private로.내부에서 객체를 만들면 읽을 때 한 번만 만든다.
	//static 형태로
	private static MemberDAO mDao = new MemberDAO();
	public static MemberDAO getInstance() {
		return mDao;
	}//객체를 싱글톤으로 만들기 끝. 밖에서 만들면 메모리 공간이 다 따로 생기는데 그렇게 안되게 함
	
	public void insertMember(Member member) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into member values(?,?,?,?,?,?)";
		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.getId());
			ps.setString(2, member.getPw());
			ps.setString(3, member.getName());
			ps.setString(4, member.getGender());
			ps.setString(5, member.getAddr());
			ps.setString(6, member.getTel());
			int n = ps.executeUpdate();
			if(n==1) {
				DBConn.commit(conn);
			} //오토커밋 안되고 두개가 다 작업되었을 때만 커밋.(동시에 넣을 때)
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBConn.close(ps);
			DBConn.close(conn);
		}
	}
	
	public List<Member> getMemberAll(){
		List<Member> list = new ArrayList<Member>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from member";
		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Member member = new Member();
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setName(rs.getString("name"));
				member.setGender(rs.getString("gender"));
				member.setAddr(rs.getString("addr"));
				member.setTel(rs.getString("tel"));
				list.add(member);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBConn.close(rs);
			DBConn.close(ps);
			DBConn.close(conn);
		}
		System.out.println(list.toString());
		return list;		
	}

	//1 data select
	public Member getMember(String id) {
		Member member = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from member where id=?";
		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				member=new Member();
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setName(rs.getString("name"));
				member.setGender(rs.getString("gender"));
				member.setAddr(rs.getString("addr"));
				member.setTel(rs.getString("tel"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBConn.close(rs);
			DBConn.close(ps);
			DBConn.close(conn);
		}
		return member;
	}

	// UPDATE
	public void update(Member member) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update member set name=?, pw=?, gender=?, addr=?, tel=? where id=?";
		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.getName());
			ps.setString(2, member.getPw());
			ps.setString(3, member.getGender());
			ps.setString(4, member.getAddr());
			ps.setString(5, member.getTel());
			ps.setString(6, member.getId());
			int n = ps.executeUpdate();
			if(n==1) {
				conn.commit(); //오토커밋을 false로 해놔서 써줌. 안했으면 안해도됨
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBConn.close(ps);
			DBConn.close(conn);
		}
	}
	
	// DELETE
	public void delete(String id) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "delete from member where id=?";
		System.out.print("delete");
	try {
		conn = DBConn.getConnect();
		ps = conn.prepareStatement(sql);
		ps.setString(1, id);
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
	
}