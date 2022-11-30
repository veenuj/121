package oneTOoneDemo.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class deletingInstructor {
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
		
	
			
	
			session.beginTransaction();
			
			int theId = 1;
			instructorDemo temInstructor =
					session.get(instructorDemo.class, theId);
			

			// delete it
			if(temInstructor != null) {
				System.out.println("deleting the details of  instructor"+temInstructor);
				// NOTE: this will ALSO delete details object because CascadeType.ALL
				session.delete(temInstructor);
			}
			
			
			session.getTransaction().commit();
			
			System.out.println("!!!!!!!DATA SAVED!!!!!!");
			
			
		} finally {
			factory.close();
		}
				

	}
}
