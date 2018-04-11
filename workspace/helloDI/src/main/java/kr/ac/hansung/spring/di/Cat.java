package kr.ac.hansung.spring.di;

import lombok.Setter;

@Setter
public class Cat implements AnimalType{
	
	private String myName;
	
	@Override
	public void sound() {
		System.out.println("Cat name =" + myName + ":" +"Meow");
		
	}

}
