package dao;

import java.util.List;

import model.Cheliang;


public interface CheliangDao  {
	
	
	
	public void insertBean(Cheliang Cheliang);
	
	public void deleteBean(Cheliang Cheliang);
	
	public void updateBean(Cheliang Cheliang);

	public Cheliang selectBean(String where);
	
	public List<Cheliang> selectBeanList(final int start, final int limit,final String where);
	
	public int selectBeanCount(final String where);
	
	
}
