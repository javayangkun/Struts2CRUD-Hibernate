package com.yangkun.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HiBernateUtil {
	//����session��������
	private static SessionFactory sf;
	
	static {
		//1.�������������ļ�����
		Configuration conf = new Configuration();
		//2.���������ļ�·��
		conf.configure("com/yangkun/utils/hibernate.cfg.xml");
		//3.��ȡsessionFactory����
		sf = conf.buildSessionFactory();
	}
	
	//����session����
	public static Session openSession() {
		return sf.openSession();
	}
	
	//����SessionFactory����
	public static SessionFactory getSessionFactory() {
		return sf;
	}
}
