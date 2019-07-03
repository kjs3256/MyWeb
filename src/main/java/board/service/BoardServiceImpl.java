package board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import board.dao.BoardDao;
import board.domain.BoardVO;

public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public List<BoardVO> list() {
		return boardDao.list();
	}

	@Override
	public int delete(BoardVO boardVO) {
		return boardDao.delete(boardVO);
	}

	@Override
	public int edit(BoardVO boardVO) {
		return boardDao.update(boardVO);
	}

	@Override
	public void write(BoardVO boardVO, String id) {
		boardDao.insert(boardVO, id);
	}

	@Override
	public BoardVO read(int seq) {
		boardDao.updateReadCount(seq);
		return boardDao.select(seq);
	}
}
