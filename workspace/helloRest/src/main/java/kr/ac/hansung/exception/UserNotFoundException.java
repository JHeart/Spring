package kr.ac.hansung.exception;


public class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4451685904043827749L;
	//class의 버전을 확인할떄 사용한다. 나중에 serialization deserialization을 수행할때 맞는지 확인할떄 사용
	
	private long userId;

	public UserNotFoundException(long userId) {
		super();
		this.userId = userId;
	}

	public long getUserId() {
		return userId;
	}


	


}
