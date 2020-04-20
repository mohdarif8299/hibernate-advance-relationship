package com.dentist;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dentist.entity.Doctor;
import com.dentist.entity.Salary;
import com.dentist.entity.Staff;

public class ReadDoctor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Doctor.class)
				.addAnnotatedClass(Staff.class).addAnnotatedClass(Salary.class).buildSessionFactory();
				Session session = factory.getCurrentSession()) {

			// starting transaction
			session.beginTransaction();

			// int doctorID = 2;

			String name = "Mohd Arif";

			Query query = session.createQuery("from Doctor where name = :id");
			query.setParameter("id", name);
			query.setMaxResults(1);
			Doctor doctor = (Doctor) query.getSingleResult();
			System.out.println("Doctor's name = " + doctor.getName());
			System.out.println("Doctor's number = " + doctor.getNumber());
			System.out.println("Doctor's email = " + doctor.getEmail());
			System.out.println("Doctor's address = " + doctor.getStaff().getAddress());
			System.out.println("Doctor's city = " + doctor.getStaff().getCity());
			System.out.println("Doctor's state = " + doctor.getStaff().getState());
			System.out.println("Doctor's Qualification = " + doctor.getStaff().getQualification());
			System.out.println("Doctor's Experiece = " + doctor.getStaff().getExperience());
			System.out.println("Doctor's Gross Salary = " + doctor.getStaff().getSalary().getGrossSalary());

			// reading details from database

			// commiting to database

			session.getTransaction().commit();

			System.out.println("Doctor Create Successfully");

		}

	}

}
