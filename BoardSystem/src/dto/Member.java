package dto;

public class Member {
	//이 이름들은 폼네임과 테이블 필드의 이름과 같이 적어주는 게 안헷갈리고 좋다.
	private String id;
	private String pw;
	private String name;
	private String gender;
	private String addr;
	private String tel;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	//편한 이유??
	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", name=" + name + ", gender=" + gender + ", addr=" + addr + ", tel="
				+ tel + "]";
	}
	

	
}
