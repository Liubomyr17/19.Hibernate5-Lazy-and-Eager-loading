package com.infotech.client;

import com.infotech.entities.Employee;
import com.infotech.model.Address;
import com.infotech.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.Date;

public class SaveDataClientTest {

    public static void main(String[] args) {
        try( Session session = HibernateUtil.getSessionFactory().openSession()) {

            createEmployee(session);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    private static void createEmployee(Session session) {
        session.beginTransaction();
        Integer id =(Integer)session.save(getEmployee());
        System.out.println("Employee is created  with Id::"+id);
        session.getTransaction().commit();

    }

    private static Employee getEmployee(){
        Employee employee= new Employee();
        employee.setEmployeeName("Barry Bingel");
        employee.setEmail("barry.cs2017@gmail.com");
        employee.setSalary(50000.00);
        employee.setDoj(new Date());

        Address address1 = new Address ();
        address1.setCity ("Chennai");
        address1.setPincode (90123L);
        address1.setState ("IL");
        address1.setStreet ("Park St.");

        Address address2 = new Address ();
        address2.setCity ("Puno");
        address2.setPincode (100123L);
        address2.setState ("MH");
        address2.setStreet ("XYZ Street");

        employee.getAddressList ().add (address1);
        employee.getAddressList ().add (address2);

        return employee;
    }
}