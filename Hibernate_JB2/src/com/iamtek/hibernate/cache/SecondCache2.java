package com.iamtek.hibernate.cache;

import com.iamtek.hibernate.cache.dto.UserDetails2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SecondCache2 {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure("/hibernate.cfg2.xml").addAnnotatedClass(UserDetails2.class).buildSessionFactory();

        //data
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        for (int i = 1; i < 11; i++) {
            UserDetails2 user = new UserDetails2();
            user.setUserName("User " + i);
            session.save(user);
        }
        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();
        session.beginTransaction();
        UserDetails2 user = session.get(UserDetails2.class, 1);
        session.getTransaction().commit();
        session.close();

        Session session2 = sessionFactory.openSession();
        session2.beginTransaction();
        UserDetails2 user2 = session2.get(UserDetails2.class, 1);
        session2.getTransaction().commit();
        session2.close();

        sessionFactory.close( );
    }
}
