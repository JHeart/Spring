package kr.ac.hansung.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.RequestEntity.HeadersBuilder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import kr.ac.hansung.exception.ErrorResponse;
import kr.ac.hansung.exception.UserDuplicateException;
import kr.ac.hansung.exception.UserNotFoundException;
import kr.ac.hansung.model.User;
import kr.ac.hansung.service.UserService;

@RestController //@Controller + @ResponseBody
@RequestMapping("/api")
public class RestAPIController {
	
	@Autowired
	UserService userService;
	
	// --Retrieve All Users
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers(){ //header, body(json), Http.status
		
		
		
		List<User> users = userService.findAllUsers();
		if(users.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);//responseEntity-> header,body, Http.status를 담아서 requestmessage에 담을수 있다.
		}
		
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);//list of object -> json 
		//jacksondatabind가 역할을 한다.
	}
	
	
	// --Retrieve Single Users
		@RequestMapping(value="/users/{id}", method=RequestMethod.GET)
		public ResponseEntity<User> GetUser(@PathVariable("id") long id){//template variable value가 id에 담긴다. 
			
			
			
			User user = userService.findByid(id);
			if(user == null) {
				//to do list: custom exception
				throw new UserNotFoundException(id);
			}
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		
		// --Create a User
		@RequestMapping(value="/users", method=RequestMethod.POST) //Request body(json)
		public ResponseEntity<Void> createUser(@RequestBody User user,//body부분에는 없고 header에 uri만
				UriComponentsBuilder ucBuilder){ 
		//Requestbody에 있는 body에 있는 내용이 json형태로 되어있는데 객체로 변환
			if(userService.isUserExist(user)) {
				//to do list: exception
				throw new UserDuplicateException(user.getName());
			}
			userService.saveUser(user);
			
			
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("api/users/{id}").buildAndExpand(user.getId()).toUri());
			//location을 setting user.getId()가 id에 들어간다.
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
			//body는 필요없고 header를 만들어서 방금만든 사용자의 uri를 보내준다
		}
		
		// --------Update a User -----------
		
		@RequestMapping(value = "/users/{id}", method= RequestMethod.PUT)
		public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user){
			
			User currentUser = userService.findByid(id);
			
			if(currentUser == null) {
				//to do list; exception
				throw new UserNotFoundException(id);
			}
			
			currentUser.setName(user.getName());
			currentUser.setAge(user.getAge());
			currentUser.setSalary(user.getSalary());
			
			userService.updateUser(currentUser);
			
			return new ResponseEntity<User>(currentUser, HttpStatus.OK);
		}
		
		// -----------Delete a User ---------
		
		@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<User> deleteUser(@PathVariable("id") long id){
			
			User user = userService.findByid(id);
			if(user ==null) {
				//to do list: exception
				throw new UserNotFoundException(id);
			}
			userService.deleteUserById(id);
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		}
		
		// -----------------------------Delete All Users --------------------------------------
		
		@RequestMapping(value = "/users", method = RequestMethod.DELETE)
			public ResponseEntity<User> deleteAllUser(){
				
				userService.delteAllUsers();
				return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
				
			}
		
	
	
}
