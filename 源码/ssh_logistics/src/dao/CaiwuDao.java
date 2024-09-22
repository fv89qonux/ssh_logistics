package dao;

import java.util.List;

import model.Caiwu;


public interface CaiwuDao  {
	
	
	
	public void insertBean(Caiwu Caiwu);
	
	public void deleteBean(Caiwu Caiwu);
	
	public void updateBean(Caiwu Caiwu);

	public Caiwu selectBean(String where);
	
	public List<Caiwu> selectBeanList(final int start, final int limit,final String where);
	
	public int selectBeanCount(final String where);
	
	
}
