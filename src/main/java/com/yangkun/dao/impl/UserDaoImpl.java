package com.yangkun.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.yangkun.dao.IUserDao;
import com.yangkun.entity.User;
import com.yangkun.utils.HiBernateUtil;

public class UserDaoImpl implements IUserDao {
	// 1.�����Ự����

	@Override
	public void save(User user) {
		// TODO save User
		// ��ʼ����
		Session s = HiBernateUtil.openSession();
		s.beginTransaction();
		// ==================================================
		s.save(user);
		// ==================================================
		// �ύ����
		s.getTransaction().commit();
		// �رջỰ
		s.close();
	}

	@Override
	public void delete(Integer id) {
		// TODO delete User by User`s id
		// ��ʼ����
		Session s = HiBernateUtil.openSession();
		s.beginTransaction();
		// ==================================================
		User user = new User();
		user.setId(id);
		s.delete(user);
		// ==================================================
		s.getTransaction().commit();
		s.close();
	}

	@Override
	public void update(User user) {
		// ��ʼ����
		Session s = HiBernateUtil.openSession();
		s.beginTransaction();
		// ==================================================
		s.update(user);
		// ==================================================
		// �ύ����
		s.getTransaction().commit();
		s.close();
	}

	@Override
	public List<User> find() {
		// TODO list all users
		Session s = HiBernateUtil.openSession();
		String hql = "from User";
		// ��ʼ����
		s.beginTransaction();
		// ==================================================
		@SuppressWarnings("rawtypes")
		Query query = s.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> users = query.list();
		// ==================================================
		// �ύ����
		s.getTransaction().commit();
		s.close();
		return users;
	}

	@Override
	public User find(Integer id) {
		// ��ʼ����
		Session s = HiBernateUtil.openSession();
		s.beginTransaction();
		// ==================================================
		User user = s.get(User.class, id);
		// ==================================================
		// �ύ����
		s.getTransaction().commit();
		s.close();
		return user;
	}

	@Override
	public int getRowCount() {
		Session s = HiBernateUtil.openSession();
		s.beginTransaction();
		//===================================================
		String hql = "SELECT COUNT(id) FROM User";
		@SuppressWarnings("rawtypes")
		Query query = s.createQuery(hql);
		//���ص�ʵ������ΪLong��
		Object result = query.uniqueResult();
		//ǿתΪLong,Ȼ��תΪint����
		Long rowCount = (Long) result;
		//===================================================
		s.getTransaction();
		s.close();
		return rowCount.intValue();
	}

	@Override
	public List<User> find(int startLine, int size) {
		Session s = HiBernateUtil.openSession();
		s.beginTransaction();
		//=====================================================
		String hql = "from User";
		@SuppressWarnings("rawtypes")
		Query query = s.createQuery(hql);
		query.setFirstResult(startLine);
		query.setMaxResults(size);
		@SuppressWarnings("unchecked")
		List<User> users = query.list();
		//=====================================================
		s.getTransaction().commit();
		s.close();
		return users;
	}

}
