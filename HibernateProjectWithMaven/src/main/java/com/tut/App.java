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
		/*
		 * // creating student Student st=new Student(); Certificate ct=new
		 * Certificate();
		 * 
		 * st.setId(150); st.setName("Mahesh"); st.setCity("Danapur");
		 * 
		 * ct.setCourse("java course"); ct.setDuration("2 months");
		 * 
		 * st.setCerti(ct);
		 * 
		 * System.out.println(st);
		 * 
		 * // creating object of Address class Address ad=new Address();
		 * ad.setStreet("street1"); ad.setCity("DELHI"); ad.setOpen(true);
		 * ad.setAddedDate(new Date()); ad.setX(123.1234);
		 * 
		 * //reading image FileInputStream fis=new
		 * FileInputStream("src/main/java/dhoni.jpg"); byte [] data=new
		 * byte[fis.available()]; fis.read(data); ad.setImage(data);
		 * 
		 * Session session = factory.openSession();
		 * 
		 * Transaction tx = session.beginTransaction(); session.save(st);
		 * //session.save(ad);
		 * 
		 * tx.commit();
		 * 
		 * 
		 */
        
        
        
        
        
        
        
        Session session = factory.openSession();
        for(int i=1;i<50;i++) {

        	
            
            Transaction tx = session.beginTransaction();

            
            Student st=new Student();
            Certificate ct=new Certificate();

            st.setId(i);
            st.setName("name "+i);
            st.setCity("city "+i);
            
            ct.setCourse("java course "+i);
            ct.setDuration(i+" months");
            
            st.setCerti(ct);
            
            
            
            
            session.save(st);

        	tx.commit();
        	
        }
        
        session.close();
        factory.close();
        System.out.println("done");
    }
}
