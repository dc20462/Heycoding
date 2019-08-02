package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConn {
	public static Connection getConnect() {
		//static을 넣으면 객체 안부르고 바로 부를 수 있다.
		Connection conn=null;
		try {
			Context initContext = new InitialContext();
			//envContext : 자바 컴파일환경
			Context envContext  = (Context)initContext.lookup("java:/comp/env");			
			DataSource ds = (DataSource)envContext.lookup("jdbc/mvc_oracle");
			conn = ds.getConnection();
			//*** jsp에서 트랜젝션(한 작업 단위로 묶는 것) : 안해주면 자동 트루(디폴트,아무것도 안하면 무조건 커밋)라 수신은 되고 발신은 안되고 한쪽만 되는 경우가 생김.
			conn.setAutoCommit(false); //커미션 닫았을때 커밋
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return conn;
	}
	//DB 종료하는 것
	public static void close(Connection conn) {
	//1. connection
		try {
			conn.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void close(PreparedStatement ps) {
		//
			try {
				ps.close();
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	
	public static void close(ResultSet rs) {
		//
			try {
				rs.close();
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		
	//commit
	public static void commit(Connection con) {
		try {
			con.commit();
			System.out.println("commit success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//커밋을 확정짓기 전에 되지않고 내가 호출할 때만 된다.
	//이 기능은 쇼핑몰 등에 필요한데 판매테이블 입력과 동시에 재고테이블은 감소될 때 등
	//insert, update, delete에만 사용. 읽어올 때 (select)는 필요없다.
	public static void rollback(Connection con) {
		try {
			con.rollback();
			System.out.println("rollback success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
