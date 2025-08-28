package Ch06;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestDto {
	
	private String username;
	private int age;
	private LocalDateTime date;
	
	public TestDto () {}

	public TestDto(String username, int age, LocalDateTime date) {
		super();
		this.username = username;
		this.age = age;
		this.date = date;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public LocalDateTime getDate() {
		return date;
	}

//	public void setDate(LocalDateTime date) {
//	    this.date=date;
//	}
	
	public void setStringtoDate(String date) {
		System.out.println("setStringtoDate : "+date);
		DateTimeFormatter fmtin=DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		this.date=LocalDateTime.parse(date,fmtin);
	}

	@Override
	public String toString() {
		return "TestDto [이름 : " + username + ", 나이 : " + age + ", 날짜 : " + date + "]";
	}
	
	
}
