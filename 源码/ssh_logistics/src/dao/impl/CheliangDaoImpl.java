package dao.impl;

import java.sql.SQLException;
import java.util.List;

import model.Cheliang;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.CheliangDao;









public class CheliangDaoImpl extends HibernateDaoSupport implements  CheliangDao{


	public void deleteBean(Cheliang Cheliang) {
		this.getHibernateTemplate().delete(Cheliang);
		
	}

	public void insertBean(Cheliang Cheliang) {
		this.getHibernateTemplate().save(Cheliang);
		
	}

	@SuppressWarnings("unchecked")
	public Cheliang selectBean(String where) {
		List<Cheliang> list = this.getHibernateTemplate().find("from Cheliang " +where);
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}

	public int selectBeanCount(String where) {
		long count = (Long)this.getHibernateTemplate().find("select count(*) from Cheliang "+where).get(0);
		return (int)count;
	}

	@SuppressWarnings("unchecked")
	public List<Cheliang> selectBeanList(final int start,final int limit,final String where) {
		return (List<Cheliang>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)throws HibernateException, SQLException {				
				List<Cheliang> list = session.createQuery("from Cheliang "+where)
				.setFirstResult(start)
				.setMaxResults(limit)
				.list();
				return list;
			}
		});
	}

	public void updateBean(Cheliang Cheliang) {
		this.getHibernateTemplate().update(Cheliang);
		
	}
	
	
}
