package dao;

import java.util.List;

import model.ChuRuku;


public interface ChuRukuDao  {
	
	
	
	public void insertBean(ChuRuku ChuRuku);
	
	public void deleteBean(ChuRuku ChuRuku);
	
	public void updateBean(ChuRuku ChuRuku);

	public ChuRuku selectBean(String where);
	
	public List<ChuRuku> selectBeanList(final int start, final int limit,final String where);
	
	public int selectBeanCount(final String where);
	
	
}
