package dto;

import java.sql.Timestamp;

public class FreeBoard {
	private int bno;
	private String id;
	private String title;
	private String content;
	private Timestamp write_date;
	private int read_count;
	private int reply_count;
	
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
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getWrite_date() {
		return write_date;
	}
	public void setWrite_date(Timestamp write_date) {
		this.write_date = write_date;
	}
	public int getRead_count() {
		return read_count;
	}
	public void setRead_count(int read_count) {
		this.read_count = read_count;
	}
	public int getReply_count() {
		return reply_count;
	}
	public void setReply_count(int reply_count) {
		this.reply_count = reply_count;
	}
	@Override
	public String toString() {
		return "FreeBoard [bno=" + bno + ", id=" + id + ", title=" + title + ", content=" + content + ", write_date="
				+ write_date + ", read_count=" + read_count + ", reply_count=" + reply_count + "]";
	}
}