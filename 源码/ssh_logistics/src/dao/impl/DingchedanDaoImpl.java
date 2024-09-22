package dao.impl;

import java.sql.SQLException;
import java.util.List;

import model.Dingchedan;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.DingchedanDao;









public class DingchedanDaoImpl extends HibernateDaoSupport implements  DingchedanDao{


	public void deleteBean(Dingchedan Dingchedan) {
		this.getHibernateTemplate().delete(Dingchedan);
		
	}

	public void insertBean(Dingchedan Dingchedan) {
		this.getHibernateTemplate().save(Dingchedan);
		
	}

	@SuppressWarnings("unchecked")
	public Dingchedan selectBean(String where) {
		List<Dingchedan> list = this.getHibernateTemplate().find("from Dingchedan " +where);
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}

	public int selectBeanCount(String where) {
		long count = (Long)this.getHibernateTemplate().find("select count(*) from Dingchedan "+where).get(0);
		return (int)count;
	}

	@SuppressWarnings("unchecked")
	public List<Dingchedan> selectBeanList(final int start,final int limit,final String where) {
		return (List<Dingchedan>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)throws HibernateException, SQLException {				
				List<Dingchedan> list = session.createQuery("from Dingchedan "+where)
				.setFirstResult(start)
				.setMaxResults(limit)
				.list();
				return list;
			}
		});
	}

	public void updateBean(Dingchedan Dingchedan) {
		this.getHibernateTemplate().update(Dingchedan);
		
	}
	
	
}
