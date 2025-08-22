package Ch02;

public class ProfileDto {

	private String username;
	private String age;
	private String addr;
	
	public ProfileDto() {}
	
	public ProfileDto(String username, String age, String addr) {
		super();
		this.username = username;
		this.age = age;
		this.addr = addr;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "ProfileDto [username=" + username + ", age=" + age + ", addr=" + addr + "]";
	}
	
	public static void main(String[] args) {
		
		
	}

}
