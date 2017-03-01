package com.sdk.app.daoImpl;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import com.sdk.app.config.HiberanteConfiguration;
import com.sdk.app.dao.ClassDao;
import com.sdk.app.model.*;

@Service("ClassDao")
public class ClassDaoImpl implements ClassDao{

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Object> getData(Class className) {
		Session session = HiberanteConfiguration.getSession();
		Transaction tx = session.beginTransaction();
		List<Object> data = null;
		try{
			Criteria cr = session.createCriteria(className);
			data = cr.list();
			
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				session.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return data;
	}

	@Override
	public boolean register(UserInfo userinfo) {
		// TODO Auto-generated method stub
		
		Session session = HiberanteConfiguration.getSession();
		Transaction tx = session.beginTransaction();
	
		session.save(userinfo);
		tx.commit();
		return false;
	}

}
