package oneTOoneDemo.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class creatingInstructor {

	public static void main(String[] args) {



		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(instructorDetails.class)
				.addAnnotatedClass(instructorDemo.class)
				.buildSessionFactory();


		// create session
		Session session = factory.getCurrentSession();

		try {

			
			instructorDemo tempInstructor = 
					new instructorDemo("anuj","dhiman","veenuj@gmail.com");

			instructorDetails tempInstructorDetail = 
					new instructorDetails("http://www.youtube.com/dhiman", "badminton");


			// associate objects
			tempInstructor.setinstructorDetails(tempInstructorDetail);




			session.beginTransaction();


			// save instructor
			// NOTE: this will ALSO save details object because CascadeType.ALL
			System.out.println("saving the first&last name and emailID:"+tempInstructor);
			session.save(tempInstructor);


			session.getTransaction().commit();

			System.out.println("!!!!!!!DATA SAVED!!!!!!");


		} finally {
			factory.close();
		}


	}
}
