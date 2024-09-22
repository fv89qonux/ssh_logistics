package dao;

import java.util.List;

import model.Kehu;


public interface KehuDao  {
	
	
	
	public void insertBean(Kehu Kehu);
	
	public void deleteBean(Kehu Kehu);
	
	public void updateBean(Kehu Kehu);

	public Kehu selectBean(String where);
	
	public List<Kehu> selectBeanList(final int start, final int limit,final String where);
	
	public int selectBeanCount(final String where);
	
	
}
