package com.dentist;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dentist.entity.Doctor;
import com.dentist.entity.Salary;
import com.dentist.entity.Staff;

public class CreateDoctor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Doctor.class)
				.addAnnotatedClass(Staff.class).addAnnotatedClass(Salary.class).buildSessionFactory();
				Session session = factory.getCurrentSession()) {

			// creating objects

			System.out.println("Creating Doctor Object");
			Doctor doctor = new Doctor("Mohd Irfan", "9318212387", "mdirfan666999@gmail.com");

			System.out.println("Creating Staff Object");
			Staff staff = new Staff("D-129 Shaheen bagh", "New Delhi", "Delhi", "Master of Doctory (MD)", "4 yrs");

			System.out.println("Creating Salary Object");
			Salary salary = new Salary("80k", "60k", "15k", "10k", "online");

			// starting transaction
			session.beginTransaction();

			// associating objects
			staff.setSalary(salary);
			doctor.setStaff(staff);

			// saving to database

			session.save(doctor);

			// commiting to database

			session.getTransaction().commit();

			System.out.println("Doctor Create Successfully");

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

	}

}
