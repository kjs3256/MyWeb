package member.service;

import org.springframework.transaction.annotation.Transactional;

import member.dao.MemberDao;
import member.domain.MemberVO;
import member.exception.MemberNotFoundException;

public class ChangePasswordService {
	private MemberDao memberDao;
	
	public ChangePasswordService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	@Transactional
	public void changePassword(String id, String oldPwd, String newPwd) {
		MemberVO member = memberDao.selectById(id);
		if(member == null) {
			throw new MemberNotFoundException();
		}
		member.changePassword(oldPwd, newPwd);
		memberDao.update(member);
	}
}
