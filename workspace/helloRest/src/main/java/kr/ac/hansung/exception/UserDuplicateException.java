package kr.ac.hansung.exception;

public class UserDuplicateException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 897279887202237915L;

	
	private String username;
	
	public UserDuplicateException(String username) {
		super();
		this.username = username;
	}
	public String getUserName() {
		return username;
	}
}
