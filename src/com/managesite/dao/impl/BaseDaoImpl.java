package com.managesite.dao.impl;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.managesite.dao.BaseDao;
import com.managesite.entity.Page;
import com.managesite.entity.User;
public class BaseDaoImpl<T> implements BaseDao<T>{
private HibernateTemplate hibernateTemplate;
public HibernateTemplate getHibernateTemplate() {
	return hibernateTemplate;
}

public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
	this.hibernateTemplate = hibernateTemplate;
}

protected Class<T> class1;

@Override
public void saveEntity(T t) {
	// TODO Auto-generated method stub
	
}

@Override
public void saveOrUpdateEntity(T t) {
	// TODO Auto-generated method stub
	
}

@Override
public void updateEntity(T t) {
	// TODO Auto-generated method stub
	
}

@Override
public void deleteEntity(T t) {
	// TODO Auto-generated method stub
	
}

@Override
public T getEntity(T t) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public T loadEntity(T t) {
	// TODO Auto-generated method stub
	return null;
}
// hql1 查询需分页的记录 hql2 查询 分页记录的记录总数
@Override
public Page listPage(final String hql1, String hql2, int pageno, int pagesize) {
	// TODO Auto-generated method stub
	Page p=null;
	/*Query query=(Query) this.getHibernateTemplate().execute(new HibernateCallback<Object>(){
		{
	}
		@Override
		public Object doInHibernate(Session session) throws HibernateException,
				SQLException {
			// TODO Auto-generated method stub
			return   session.createQuery(hql1);
		}
	});*/
	Query query = getQuery(hql1);
	query.setFirstResult((pageno - 1) * pagesize);
	query.setMaxResults(pagesize);
	int rowcount=new Long((long) this.uniqueResult(hql2)).intValue();
	int pagecount = 0;
	if(rowcount%pagesize==0){
		pagecount=rowcount/pagesize;
	}
	else if(rowcount%pagesize!=0)
	{
		pagecount=rowcount/pagesize+1;
	}
	List slist=query.list();
	 if (p==null) 
		 {
		 p=new Page(pagecount,pageno, pagesize, slist,rowcount);
		 }
	return p;
}
public Query getQuery(final String hql){
return	(Query) this.getHibernateTemplate().execute(new HibernateCallback<Object>(){
		{
	}
		@Override
		public Object doInHibernate(Session session) throws HibernateException,
				SQLException {
			// TODO Auto-generated method stub
			return   session.createQuery(hql);
		}
	});
}
public Object uniqueResult(String hql, Object... objects) {
	Query query = getQuery(hql);
	for (int i = 0; i < objects.length; i++) {
		query.setParameter(i, objects[i]);
	}
	return query.uniqueResult();
}
public Session getSess(){
	return this.getHibernateTemplate().getSessionFactory().getCurrentSession();
}
public Session getSess2(){
	return this.getHibernateTemplate().execute(new HibernateCallback() {

		@Override
		public Session doInHibernate(Session arg0) throws HibernateException,
				SQLException {
			// TODO Auto-generated method stub
			Session session=arg0;
			return session;
		}
	});
}
@Override
public Page listPage() {
	// TODO Auto-generated method stub
	return null;
}
@Override
public List<T> getlist() {
	// TODO Auto-generated method stub
	return null;
}
public List<T> getlist(String hql) {
	// TODO Auto-generated method stub
	return this.hibernateTemplate.find(hql);
}
public T getEntity(Class<T> t,String id){
	return this.hibernateTemplate.get(t, id);
}

}
