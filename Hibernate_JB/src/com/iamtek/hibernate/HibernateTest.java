package com.iamtek.hibernate;

import com.iamtek.hibernate.dto.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class HibernateTest {

    public static void main(String[] args) {

        UserDetails user = new UserDetails();
        user.setUserId(1);
        user.setUserName("1 user");
        user.setAddress("1 user address");
        user.setJoinedDate(new Date());
        user.setDescription("1 user desc");
        user.setTransientField("not saved");

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();

    }
}
