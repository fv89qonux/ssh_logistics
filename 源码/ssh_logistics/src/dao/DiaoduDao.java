package dao;

import java.util.List;

import model.Diaodu;


public interface DiaoduDao  {
	
	
	
	public void insertBean(Diaodu Diaodu);
	
	public void deleteBean(Diaodu Diaodu);
	
	public void updateBean(Diaodu Diaodu);

	public Diaodu selectBean(String where);
	
	public List<Diaodu> selectBeanList(final int start, final int limit,final String where);
	
	public int selectBeanCount(final String where);
	
	
}
