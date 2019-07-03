package board.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import board.domain.BoardVO;
import board.service.BoardService;
import member.service.AuthInfo;

@Controller
@RequestMapping(value="/board/*")
public class BoardController {
	private BoardService boardService;
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}

	@RequestMapping(value="list")
	public String list(HttpSession session, Model model) {
		List<BoardVO> boardList = boardService.list();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH:mm");
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		model.addAttribute("authInfo", authInfo);
		model.addAttribute("sdf",sdf);
		model.addAttribute("boardList", boardList);
		return "board/list";
	}
	@RequestMapping(value="read/{seq}")
	public String read(HttpSession session, Model model, @PathVariable int seq) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH:mm");
		
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		model.addAttribute("authInfo", authInfo);
		model.addAttribute("sdf",sdf);
		model.addAttribute("boardVO", boardService.read(seq));
		return "board/read";
	}
	@RequestMapping(value="write", method=RequestMethod.GET)
	public String write(HttpSession session, Model model) {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		if(authInfo == null) {
			return "redirect:/login";
		}
		model.addAttribute("boardVO",new BoardVO());
		return "board/write";
	}
	@RequestMapping(value="write", method=RequestMethod.POST)
	public String write(@Valid BoardVO boardVO, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "board/write";
		}
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		boardService.write(boardVO, authInfo.getId());
		return "redirect:/board/list";
	}
	@RequestMapping(value="edit/{seq}", method=RequestMethod.GET)
	public String edit(@PathVariable int seq, HttpSession session, Model model) {
		BoardVO boardVO = boardService.read(seq);
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		if(!authInfo.getNickname().equals(boardVO.getNickname())) {
			return "redirect:/board/read/"+seq;
		}
		model.addAttribute("boardVO", boardVO);
		return "board/edit";
	}
	@RequestMapping(value="edit/{seq}", method=RequestMethod.POST)
	public String edit(@Valid BoardVO boardVO,BindingResult result, 
			HttpSession session, Model model) {
		if(result.hasErrors()) {
			return "board/edit";
		}else {
			boardService.edit(boardVO);
			return "redirect:/board/list";
		}
	}
	@RequestMapping(value="delete/{seq}", method=RequestMethod.GET)
	public String delete(@PathVariable int seq, HttpSession session, Model model) {
		BoardVO vo = boardService.read(seq);
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		if(!authInfo.getNickname().equals(vo.getNickname())) {
			return "redirect:/board/read/"+seq;
		}
		model.addAttribute("seq", seq);
		return "board/delete";
	}
	@RequestMapping(value="delete", method=RequestMethod.POST)
	public String delete(int seq, Model model) {
		int rowCount;
		
		BoardVO boardVO = new BoardVO();
		boardVO.setSeq(seq);
		
		rowCount = boardService.delete(boardVO);
		
		if(rowCount == 0) {
			model.addAttribute("seq", seq);
			return "/board/delete";
		}else {
			return "redirect:/board/list";
		}
	}
}
