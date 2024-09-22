package dao.impl;

import java.sql.SQLException;
import java.util.List;

import model.Cangzu;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.CangzuDao;









public class CangzuDaoImpl extends HibernateDaoSupport implements  CangzuDao{


	public void deleteBean(Cangzu Cangzu) {
		this.getHibernateTemplate().delete(Cangzu);
		
	}

	public void insertBean(Cangzu Cangzu) {
		this.getHibernateTemplate().save(Cangzu);
		
	}

	@SuppressWarnings("unchecked")
	public Cangzu selectBean(String where) {
		List<Cangzu> list = this.getHibernateTemplate().find("from Cangzu " +where);
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}

	public int selectBeanCount(String where) {
		long count = (Long)this.getHibernateTemplate().find("select count(*) from Cangzu "+where).get(0);
		return (int)count;
	}

	@SuppressWarnings("unchecked")
	public List<Cangzu> selectBeanList(final int start,final int limit,final String where) {
		return (List<Cangzu>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)throws HibernateException, SQLException {				
				List<Cangzu> list = session.createQuery("from Cangzu "+where)
				.setFirstResult(start)
				.setMaxResults(limit)
				.list();
				return list;
			}
		});
	}

	public void updateBean(Cangzu Cangzu) {
		this.getHibernateTemplate().update(Cangzu);
		
	}
	
	
}
