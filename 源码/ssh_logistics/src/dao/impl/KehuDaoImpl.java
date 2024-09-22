package dao.impl;

import java.sql.SQLException;
import java.util.List;

import model.Kehu;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.KehuDao;









public class KehuDaoImpl extends HibernateDaoSupport implements  KehuDao{


	public void deleteBean(Kehu Kehu) {
		this.getHibernateTemplate().delete(Kehu);
		
	}

	public void insertBean(Kehu Kehu) {
		this.getHibernateTemplate().save(Kehu);
		
	}

	@SuppressWarnings("unchecked")
	public Kehu selectBean(String where) {
		List<Kehu> list = this.getHibernateTemplate().find("from Kehu " +where);
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}

	public int selectBeanCount(String where) {
		long count = (Long)this.getHibernateTemplate().find("select count(*) from Kehu "+where).get(0);
		return (int)count;
	}

	@SuppressWarnings("unchecked")
	public List<Kehu> selectBeanList(final int start,final int limit,final String where) {
		return (List<Kehu>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)throws HibernateException, SQLException {				
				List<Kehu> list = session.createQuery("from Kehu "+where)
				.setFirstResult(start)
				.setMaxResults(limit)
				.list();
				return list;
			}
		});
	}

	public void updateBean(Kehu Kehu) {
		this.getHibernateTemplate().update(Kehu);
		
	}
	
	
}
