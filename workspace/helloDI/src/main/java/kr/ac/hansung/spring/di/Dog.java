package kr.ac.hansung.spring.di;

import lombok.Setter;

@Setter
public class Dog implements AnimalType {
	
	private String myName;

/*	public void setMyName(String myName) {
		this.myName = myName;
	}*/



	@Override
	public void sound() {
		
		System.out.println("Dog name =" + myName + ":" +"Bow Wow");

	}

}
