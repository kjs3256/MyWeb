package member.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import member.domain.MemberVO;
import member.exception.AlreadyExistingMemberException;
import member.exception.AlreadyExistingNicknameException;
import member.service.MemberService;

@Controller
@RequestMapping("/register/*")
public class RegisterController {
	
	private MemberService memberService;
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	@RequestMapping(value="agree")
	public String step1() {
		return "register/agree";
	}
	@RequestMapping(value="regist", method=RequestMethod.POST)
	public String step2(@RequestParam(value="agree", defaultValue="false") Boolean agree,
			Model model) {
		if(!agree) {
			return "register/agree";
		}
		model.addAttribute("formData", new RegisterCommand());
		return "register/regist";
	}
	@RequestMapping(value="regist",method=RequestMethod.GET)
	public String step2() {
		return "redirect:/register/agree";
	}
	@RequestMapping(value="welcome", method=RequestMethod.POST)
	public String step3(@ModelAttribute("formData")RegisterCommand regCmd, Errors errors ) {
		new RegisterValidator().validate(regCmd, errors);
		if(errors.hasErrors()) {
			return "register/regist";
		}
		try {
			MemberVO memberConfirm = memberService.memberConfirm(regCmd.getId());
			if(memberConfirm != null) {
				throw new AlreadyExistingMemberException("dup id " + regCmd.getId());
			}
			MemberVO nicknameCheck = memberService.nicknameCheck(regCmd.getNickname());
			if(nicknameCheck != null) {
				throw new AlreadyExistingNicknameException("dup nickname "+regCmd.getNickname());
			}
			MemberVO memberVO = new MemberVO(regCmd.getId(), 
					regCmd.getPassword(), 
					regCmd.getNickname(),
					new Date());
			memberService.regist(memberVO);
			return "register/welcome";
		}catch(AlreadyExistingMemberException e) {
			errors.rejectValue("id", "duplicate");
			return "register/regist";
		}catch(AlreadyExistingNicknameException e) {
			errors.rejectValue("nickname", "duplicate.nickname");
			return "register/regist";
		}
	}
}
