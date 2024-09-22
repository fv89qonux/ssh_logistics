package dao;

import java.util.List;

import model.Dingchedan;


public interface DingchedanDao  {
	
	
	
	public void insertBean(Dingchedan Dingchedan);
	
	public void deleteBean(Dingchedan Dingchedan);
	
	public void updateBean(Dingchedan Dingchedan);

	public Dingchedan selectBean(String where);
	
	public List<Dingchedan> selectBeanList(final int start, final int limit,final String where);
	
	public int selectBeanCount(final String where);
	
	
}
