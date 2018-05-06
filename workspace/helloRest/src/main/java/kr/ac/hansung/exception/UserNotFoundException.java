package kr.ac.hansung.exception;


public class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4451685904043827749L;
	
	
	private long userId;

	public UserNotFoundException(long userId) {
		super();
		this.userId = userId;
	}

	public long getUserId() {
		return userId;
	}


	


}
