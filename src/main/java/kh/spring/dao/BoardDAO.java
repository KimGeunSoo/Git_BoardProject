package kh.spring.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.BoardDTO;
import kh.spring.statics.BoardConfigurator;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSession db;
	
	public List<BoardDTO> listBoardAll() throws Exception {
		return db.selectList("Board.selectListAll");
	}
	
	public List<BoardDTO> listByCpage(int cpage) throws Exception {
		int startRowNum = (cpage - 1) * BoardConfigurator.recodeCountPerPage + 1;
		int endRowNum = startRowNum + BoardConfigurator.recodeCountPerPage - 1;

		Map<String,Integer> map = new HashMap<>();
		map.put("startRowNum",startRowNum);
		map.put("endRowNum",endRowNum);
		return db.selectList("Board.selectAllByPage",map);
	}
}

