package dao.impl;

import java.sql.SQLException;
import java.util.List;

import model.Caiwu;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.CaiwuDao;









public class CaiwuDaoImpl extends HibernateDaoSupport implements  CaiwuDao{


	public void deleteBean(Caiwu Caiwu) {
		this.getHibernateTemplate().delete(Caiwu);
		
	}

	public void insertBean(Caiwu Caiwu) {
		this.getHibernateTemplate().save(Caiwu);
		
	}

	@SuppressWarnings("unchecked")
	public Caiwu selectBean(String where) {
		List<Caiwu> list = this.getHibernateTemplate().find("from Caiwu " +where);
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}

	public int selectBeanCount(String where) {
		long count = (Long)this.getHibernateTemplate().find("select count(*) from Caiwu "+where).get(0);
		return (int)count;
	}

	@SuppressWarnings("unchecked")
	public List<Caiwu> selectBeanList(final int start,final int limit,final String where) {
		return (List<Caiwu>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)throws HibernateException, SQLException {				
				List<Caiwu> list = session.createQuery("from Caiwu "+where)
				.setFirstResult(start)
				.setMaxResults(limit)
				.list();
				return list;
			}
		});
	}

	public void updateBean(Caiwu Caiwu) {
		this.getHibernateTemplate().update(Caiwu);
		
	}
	
	
}
