package com.barofarm.meat;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class BaroFarmDaoImpl implements IF_BaroFarmDao {
	private static String mapperQuery="com.barofarm.meat.IF_BaroFarmDao";
	
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public void insert(BaroFarmVo bfvo) {
		System.out.println("dao test insert");
		System.out.println(bfvo.toString());
		
		sqlSession.insert(mapperQuery+".insert", bfvo);
	}

	@Override
	public List<BaroFarmVo> select() throws Exception {
		
		return sqlSession.selectList(mapperQuery+".select");
	}

	@Override
	public void delete(String delno) throws Exception {
		System.out.println("DAO delete TEST 삭제할 번호: " + delno);
		
		sqlSession.delete(mapperQuery+".delete", delno);
		
	}

	@Override
	public BaroFarmVo updata(String updata) throws Exception {
		System.out.println("DAO updata TEST 수정할번호: " +updata);
		
		return sqlSession.selectOne(mapperQuery+".updata", updata);
	}

	@Override
	public void updatasave(BaroFarmVo vo) throws Exception {

		sqlSession.update(mapperQuery+".updatasave", vo);
	}
}
