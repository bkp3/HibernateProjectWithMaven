package com.tut;


import java.io.FileInputStream;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        System.out.println( "Project Started!!!" );
        
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        
//        creating student
        Student st=new Student();
        st.setId(15);
        st.setName("Mahesh");
        st.setCity("Danapur");
        System.out.println(st);
        
//        creating object of Address class
        Address ad=new Address();
        ad.setStreet("street1");
        ad.setCity("DELHI");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(123.1234);
        
        //reading image
        FileInputStream fis=new FileInputStream("src/main/java/dhoni.jpg");
        byte [] data=new byte[fis.available()];
        fis.read(data);
        ad.setImage(data); 
        
        Session session = factory.openSession();
        
        Transaction tx = session.beginTransaction();
        session.save(st);
        session.save(ad);
        
        tx.commit();
        
        session.close();
        
        System.out.println("done");
    }
}
