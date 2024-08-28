package com.barofarm.meat;

import java.util.List;

public interface IF_BaroFarmService {
	public void insert(BaroFarmVo bfvo)throws Exception;
	public List<BaroFarmVo> select()throws Exception;
	public void delete(String delno)throws Exception;
	public BaroFarmVo updata(String updata)throws Exception;
	public void updatasave(BaroFarmVo vo)throws Exception;


}
