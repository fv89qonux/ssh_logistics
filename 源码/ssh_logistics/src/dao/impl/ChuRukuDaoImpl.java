package dao.impl;

import java.sql.SQLException;
import java.util.List;

import model.ChuRuku;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.ChuRukuDao;









public class ChuRukuDaoImpl extends HibernateDaoSupport implements  ChuRukuDao{


	public void deleteBean(ChuRuku ChuRuku) {
		this.getHibernateTemplate().delete(ChuRuku);
		
	}

	public void insertBean(ChuRuku ChuRuku) {
		this.getHibernateTemplate().save(ChuRuku);
		
	}

	@SuppressWarnings("unchecked")
	public ChuRuku selectBean(String where) {
		List<ChuRuku> list = this.getHibernateTemplate().find("from ChuRuku " +where);
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}

	public int selectBeanCount(String where) {
		long count = (Long)this.getHibernateTemplate().find("select count(*) from ChuRuku "+where).get(0);
		return (int)count;
	}

	@SuppressWarnings("unchecked")
	public List<ChuRuku> selectBeanList(final int start,final int limit,final String where) {
		return (List<ChuRuku>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)throws HibernateException, SQLException {				
				List<ChuRuku> list = session.createQuery("from ChuRuku "+where)
				.setFirstResult(start)
				.setMaxResults(limit)
				.list();
				return list;
			}
		});
	}

	public void updateBean(ChuRuku ChuRuku) {
		this.getHibernateTemplate().update(ChuRuku);
		
	}
	
	
}
