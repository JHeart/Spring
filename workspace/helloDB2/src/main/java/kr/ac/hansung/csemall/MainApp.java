package kr.ac.hansung.csemall;


import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("kr/ac/hansung/conf/beans.xml");
		
		OfferDAO offerDAO = (OfferDAO) context.getBean("offerDAO");

		System.out.println("The record count is " + offerDAO.getRowCount());
		
		List<Offer> offerList = offerDAO.getOffers();
		
		// toString 메서드 실행된다
		for(Offer offer: offerList)
			System.out.println(offer);
		
		Offer offer = new Offer();
		offer.setName("nykim");
		offer.setEmail("www.hansung.ac.kr");
		offer.setText("an instructor of spring framework");
		// insert
		if(offerDAO.insert(offer)) {
			System.out.println("Object is inserted successfully");
		}
		else
			System.out.println("Object insert failed");
		
		offer = offerDAO.getOffer("nykim");
		offer.setName("Namyun Kim");
		// update
		if(offerDAO.update(offer)) {
			System.out.println("Object is updateed successfully");
		}
		else
			System.out.println("Object update failed");
		
		offer = offerDAO.getOffer("Namyun Kim");
		System.out.println(offer);
		
		if(offerDAO.delete(offer.getId())) {
			System.out.println("Object is delete successfully");
		}
		else
			System.out.println("Object delete failed");
		
		
		context.close();
	}
}
