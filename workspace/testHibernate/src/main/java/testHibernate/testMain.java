package testHibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class testMain {

	private static SessionFactory sessionFactory;
	
	public static void main(String[] args) {
		
		/*Configuration conf = new Configuration();
		conf.configure("hibernate.cfg.xml");
		sessionFactory = conf.buildSessionFactory();*/
		
		
		sessionFactory = new Configuration().configure().buildSessionFactory();
		//sessionFactroy는 하나 생성 session을 생성
		/*
		Category category1= new Category();
		category1.setName("Computer");
		
		Category category2= new Category();
		category2.setName("Car");
		
		Product product1 = new Product();
		product1.setName("notebook1");
		product1.setPrice(1000);
		product1.setDescription("Power notebook!!!");
		product1.setCategory(category1);
		
		//양방향이 되야 하니
		category1.getProducts().add(product1);
		
		
		Product product2 = new Product();
		product2.setName("DeskTop");
		product2.setPrice(300);
		product2.setDescription("Power DeskTop!!!");
		product2.setCategory(category1);
		
		category1.getProducts().add(product2);
		
		
		
		Product product3 = new Product();
		product3.setName("Sonata");
		product3.setPrice(100000000);
		product3.setDescription("대중적인 자동차!!!");
		product3.setCategory(category2);
		
		category2.getProducts().add(product3);*/ //one to many
		
		Person person1 = new Person();
		person1.setFirstName("JHeart");
		person1.setLastName("Lee");
		
		License license1 = new License();
		license1.setLicenseNumber("123456");
		license1.setIssueDate(new Date());
		license1.setPerson(person1);//unidirection license-> person
		
		person1.setLicense(license1);
		
		Person person2 =  new Person();
		person2.setFirstName("Alice");
		person2.setLastName("Lee");
		
		License license2 = new License();
		license2.setLicenseNumber("453256");
		license2.setIssueDate(new Date());
		license2.setPerson(person2);
		
		person2.setLicense(license2);
		
		Session session = sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		
		
		session.save(person1); //sql statement
		session.save(person2); //sql statement
		
		
		tx.commit();
		session.close();
	}

}
