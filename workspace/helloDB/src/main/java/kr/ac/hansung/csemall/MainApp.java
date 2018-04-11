package kr.ac.hansung.csemall;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("kr/ac/hansung/conf/beans.xml");// empty container
																												

		OfferDAO offerDAO = (OfferDAO) context.getBean("offerDAO");
		
		System.out.println("The record count is" + offerDAO.getRowCount());
		context.close();
	}
}