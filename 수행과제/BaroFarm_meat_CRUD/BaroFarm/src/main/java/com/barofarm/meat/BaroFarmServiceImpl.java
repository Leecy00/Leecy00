package com.barofarm.meat;


import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class BaroFarmServiceImpl implements IF_BaroFarmService {
	
	@Inject
	IF_BaroFarmDao bfdao;
	
	@Override
	public void insert(BaroFarmVo bfvo) throws Exception {
		System.out.println("service insert test");
		System.out.println(bfvo.toString());
		
		bfdao.insert(bfvo);
	}

	@Override
	public List<BaroFarmVo> select() throws Exception {

		return bfdao.select();
	}

	@Override
	public void delete(String delno) throws Exception {
		System.out.println("service delete TEST 삭제할 번호: " + delno);
		
		bfdao.delete(delno);
	}

	@Override
	public BaroFarmVo updata(String updata) throws Exception {
		System.out.println("service updata TEST 수정할번호: " +updata);
		
		return bfdao.updata(updata);
	}

	@Override
	public void updatasave(BaroFarmVo vo) throws Exception {
		
		bfdao.updatasave(vo);
	}



	
}
