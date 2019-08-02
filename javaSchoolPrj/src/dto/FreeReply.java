package dto;

import java.sql.Timestamp;

public class FreeReply {
	private int rno;
	private int bno;
	private String id;
	private Timestamp re_date;
	private String content;
	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id= id;
	}
	public Timestamp getRe_date() {
		return re_date;
	}
	public void setRe_date(Timestamp re_date) {
		this.re_date = re_date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "FreeReply [rno=" + rno + ", bno=" + bno + ", id=" + id + ", re_date=" + re_date
				+ ", content=" + content + "]";
	}
}
