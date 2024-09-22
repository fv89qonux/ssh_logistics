package dao;

import java.util.List;

import model.Cangzu;


public interface CangzuDao  {
	
	
	
	public void insertBean(Cangzu Cangzu);
	
	public void deleteBean(Cangzu Cangzu);
	
	public void updateBean(Cangzu Cangzu);

	public Cangzu selectBean(String where);
	
	public List<Cangzu> selectBeanList(final int start, final int limit,final String where);
	
	public int selectBeanCount(final String where);
	
	
}
