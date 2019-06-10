package com.yangkun.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HiBernateUtil {
	//声明session工厂对象
	private static SessionFactory sf;
	
	static {
		//1.创建加载配置文件对象
		Configuration conf = new Configuration();
		//2.加载配置文件路径
		conf.configure("com/yangkun/utils/hibernate.cfg.xml");
		//3.获取sessionFactory对象
		sf = conf.buildSessionFactory();
	}
	
	//返回session对象
	public static Session openSession() {
		return sf.openSession();
	}
	
	//返回SessionFactory对象
	public static SessionFactory getSessionFactory() {
		return sf;
	}
}
