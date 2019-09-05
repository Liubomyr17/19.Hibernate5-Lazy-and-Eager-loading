package com.infotech.client;

import com.infotech.entities.Employee;
import com.infotech.model.Address;
import com.infotech.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.Date;

public class FetchDataClientTest {

    public static void main(String[] args) {

        Employee employee = null;
        try( Session session = HibernateUtil.getSessionFactory().openSession()) {

            employee = session.get (Employee.class,1);
            System.out.println (employee);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        if(employee != null){
            employee.getAddressList ().forEach (System.out::println);

        }
    }

}