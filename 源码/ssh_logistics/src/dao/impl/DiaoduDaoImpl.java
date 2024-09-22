package dao.impl;

import java.sql.SQLException;
import java.util.List;

import model.Diaodu;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.DiaoduDao;









public class DiaoduDaoImpl extends HibernateDaoSupport implements  DiaoduDao{


	public void deleteBean(Diaodu Diaodu) {
		this.getHibernateTemplate().delete(Diaodu);
		
	}

	public void insertBean(Diaodu Diaodu) {
		this.getHibernateTemplate().save(Diaodu);
		
	}

	@SuppressWarnings("unchecked")
	public Diaodu selectBean(String where) {
		List<Diaodu> list = this.getHibernateTemplate().find("from Diaodu " +where);
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}

	public int selectBeanCount(String where) {
		long count = (Long)this.getHibernateTemplate().find("select count(*) from Diaodu "+where).get(0);
		return (int)count;
	}

	@SuppressWarnings("unchecked")
	public List<Diaodu> selectBeanList(final int start,final int limit,final String where) {
		return (List<Diaodu>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)throws HibernateException, SQLException {				
				List<Diaodu> list = session.createQuery("from Diaodu "+where)
				.setFirstResult(start)
				.setMaxResults(limit)
				.list();
				return list;
			}
		});
	}

	public void updateBean(Diaodu Diaodu) {
		this.getHibernateTemplate().update(Diaodu);
		
	}
	
	
}
