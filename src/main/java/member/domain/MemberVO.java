package member.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;


@Alias("BoardVO")
public class MemberVO {
	private String id;
	private String password;
	private String nickname;
	private Date regdate;
	
	
	public MemberVO(String id, String password, String nickname, Date regdate) {
		this.id = id;
		this.password = password;
		this.nickname = nickname;
		this.regdate = regdate;
	}
	public MemberVO() {}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public void changePassword(String oldPwd, String newPwd) {
		if(oldPwd == null) {
			oldPwd = "1";
			password = "1";
		}
		if(!password.equals(oldPwd))
			throw new member.exception.IdPasswordNotMatchingException();
		this.password = newPwd;
	}
	public boolean matchPassword(String pwd) {
		return this.password.equals(pwd);
	}
}
