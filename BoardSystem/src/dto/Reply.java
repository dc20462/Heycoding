package dto;

import java.sql.Timestamp;

public class Reply {
	private int rno;
	private int bno;
	private String member_id;
	private String Content;
	private Timestamp re_date;
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
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public Timestamp getRe_date() {
		return re_date;
	}
	public void setRe_date(Timestamp re_date) {
		this.re_date = re_date;
	}
	@Override
	public String toString() {
		return "Reply [rno=" + rno + ", bno=" + bno + ", member_id=" + member_id + ", Content=" + Content + ", re_date="
				+ re_date + "]";
	}
	
}
