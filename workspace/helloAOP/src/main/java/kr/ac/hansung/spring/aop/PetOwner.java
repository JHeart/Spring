package kr.ac.hansung.spring.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import lombok.RequiredArgsConstructor;

//@RequiredArgsConstructor
public class PetOwner {

	/* private final AnimalType animal; */
	@Autowired
	@Qualifier(value = "qf_cat")
	private AnimalType animal;

	/*
	 * public PetOwner(AnimalType animal) { super(); this.animal = animal; }
	 */

	public void play() {
		animal.sound();
	}
}
