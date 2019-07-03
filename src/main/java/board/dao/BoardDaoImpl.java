package board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import board.domain.BoardVO;

public class BoardDaoImpl implements BoardDao{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	public BoardDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	public BoardDaoImpl() {}
	public void setSqlMapClient(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	@Override
	public List<BoardVO> list() {
		return sqlSessionTemplate.selectList("list");
	}

	@Override
	public int delete(BoardVO boardVO) {
		return sqlSessionTemplate.delete("boardDao.delete", boardVO);
	}

	@Override
	public int update(BoardVO boardVO) {
		return sqlSessionTemplate.update("boardDao.update", boardVO);
	}

	@Override
	public void insert(BoardVO boardVO, String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("boardVO", boardVO);
		map.put("id", id);
		sqlSessionTemplate.insert("boardDao.insert", map);
	}

	@Override
	public BoardVO select(int seq) {
		BoardVO vo = (BoardVO)sqlSessionTemplate.selectOne("select", seq);
		return vo;
	}

	@Override
	public int updateReadCount(int seq) {
		return sqlSessionTemplate.update("updateCount", seq);
	}
}
