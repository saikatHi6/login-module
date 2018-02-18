package org.common.login.module;

import org.common.login.utility.DBUtilityFactory;
import org.hibernate.Session;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Session session = DBUtilityFactory.getSessionFacotry().openSession();
        session.beginTransaction();
        
        
        String sql = "select version()";

        String result = (String) session.createNativeQuery(sql).getSingleResult();
        System.out.println(result);

        session.getTransaction().commit();
        session.close();

        
        DBUtilityFactory.shutDown();
        
        
    }
}
