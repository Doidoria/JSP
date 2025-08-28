package Ch05;

public class UserDto {

	private String userid;
	private String password;
	private String repassword;
	private String username;
	private String zipcode;
	private String addr1;
	private String addr2;
	private int phone1;
	private int phone2;
	private int phone3;
	private int tel1;
	private int tel2;
	private int tel3;
	private String email;
	private String birth;
	private int birth1;
	private int birth2;
	private int birth3;
	
	public UserDto() {}

	public UserDto(String userid, String password, String repassword, String username, String zipcode, String addr1,
			String addr2, int phone1, int phone2, int phone3, int tel1, int tel2, int tel3, String email,
			String birth) {
		super();
		this.userid = userid;
		this.password = password;
		this.repassword = repassword;
		this.username = username;
		this.zipcode = zipcode;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.phone3 = phone3;
		this.tel1 = tel1;
		this.tel2 = tel2;
		this.tel3 = tel3;
		this.email = email;
		this.birth = birth;
	}

	public UserDto(String userid, String password, String repassword, String username, String zipcode, String addr1,
			String addr2, int phone1, int phone2, int phone3, int tel1, int tel2, int tel3, String email, String birth,
			int birth1, int birth2, int birth3) {
		super();
		this.userid = userid;
		this.password = password;
		this.repassword = repassword;
		this.username = username;
		this.zipcode = zipcode;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.phone3 = phone3;
		this.tel1 = tel1;
		this.tel2 = tel2;
		this.tel3 = tel3;
		this.email = email;
		this.birth = birth;
		this.birth1 = birth1;
		this.birth2 = birth2;
		this.birth3 = birth3;
	}

	public int getBirth1() {
		return birth1;
	}

	public void setBirth1(int birth1) {
		this.birth1 = birth1;
	}

	public int getBirth2() {
		return birth2;
	}

	public void setBirth2(int birth2) {
		this.birth2 = birth2;
	}

	public int getBirth3() {
		return birth3;
	}

	public void setBirth3(int birth3) {
		this.birth3 = birth3;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public int getPhone1() {
		return phone1;
	}

	public void setPhone1(int phone1) {
		this.phone1 = phone1;
	}

	public int getPhone2() {
		return phone2;
	}

	public void setPhone2(int phone2) {
		this.phone2 = phone2;
	}

	public int getPhone3() {
		return phone3;
	}

	public void setPhone3(int phone3) {
		this.phone3 = phone3;
	}

	public int getTel1() {
		return tel1;
	}

	public void setTel1(int tel1) {
		this.tel1 = tel1;
	}

	public int getTel2() {
		return tel2;
	}

	public void setTel2(int tel2) {
		this.tel2 = tel2;
	}

	public int getTel3() {
		return tel3;
	}

	public void setTel3(int tel3) {
		this.tel3 = tel3;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		return "UserDto [아이디 : " + userid + ", 비밀번호 : " + password + ", 비밀번호 확인 : " + repassword + ", 이름 : "
				+ username + ", 우편번호 : " + zipcode + ", 주소 : " + addr1 + ", 상세주소 : " + addr2 + ", 휴대폰 : " +phone1+"-"+
				+phone2+"-"+phone3+", 전화번호 : "+tel1+"-"+ tel2+"-"+tel3+ ", email : " + email + ", 생년월일 양력/음력 : "+birth
				+ "생년월일 : "+birth1+birth2+birth3+"]";
	}

	
}
