package kr.ac.hansung.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import kr.ac.hansung.model.User;

@Service
public class UserService {

	private static final AtomicLong counter = new AtomicLong();//id를 자동으로 생성하기위해서
	
	private static List<User> users;
	
	public UserService() {
		
		users = new ArrayList<User>();
		
		users.add(new User(counter.incrementAndGet(), "Sam", 30, 70000));//id,name,age,salary
		users.add(new User(counter.incrementAndGet(), "Tom", 40, 50000));
		users.add(new User(counter.incrementAndGet(), "Jennie", 45, 30000));
		users.add(new User(counter.incrementAndGet(), "Sam", 50, 40000));
	}
	
	public List<User> findAllUsers(){
		return users;
	}
	
	public User findByid(long id) {
		for (User user: users) {
			if(user.getId() ==id) {
				return user;
			}
		}
		return null;
	}
	
	public User findByName(String name) {
		for(User user: users) {
			if(user.getName().equalsIgnoreCase(name)) {
				return user;
			}
		}
		return null;
	}
	
	public void saveUser(User user) {
		user.setId(counter.incrementAndGet());
		users.add(user);
	}
	
	public void updateUser(User user) {
		int index = users.indexOf(user);
		users.set(index, user);
	}
	
	public void deleteUserById(long id) {
		
		for(Iterator<User> iterator = users.iterator(); iterator.hasNext();) {
			User user= iterator.next();
			if(user.getId() ==id) {
				iterator.remove();
			}
		}
	}
	
	public boolean isUserExist (User user) {
		return findByName(user.getName()) != null;
	}
	
	public void delteAllUsers() {
		users.clear();
	}
	
}
