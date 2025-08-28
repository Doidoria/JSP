package Servlet;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

public class DbUtils {
	//속성(DB 연결관련된 멤버)
	// DB CONN DATA
	private static String id = "root";
	private static String pw = "1234";
	private static String url = "jdbc:mysql://localhost:3306/opendatadb";

	// JDBC참조변수
	private static Connection conn = null; // DBMS 의 특정 DB와 연결되는 객체
	private static PreparedStatement pstmt = null; // SQL Query 전송용 객체
	private static ResultSet rs = null; // Select 결과물 담을 객체

	// 기능
	public static void conn() throws Exception {
		// 드라이브 클래스 메모리 공간 적재
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Loading Success...");
		// Connection conn 멤버에 Connection 객체 연결
		conn = DriverManager.getConnection(url, id, pw);
		System.out.println("DB CONNECTED...");
	}
	
	public static void disConn() throws Exception {
		//rs / pstmt / conn close 처리
		if(rs!=null)
			rs.close();
		if(pstmt!=null)
			pstmt.close();
		if(conn!=null)
			conn.close();
	}
	
	public static int insertUser(String userid, String password) throws Exception 
	{
		pstmt = conn.prepareStatement("insert into tbl_user values(?,?,?,?,?,?,?)");
		pstmt.setString(1, userid);
		pstmt.setString(2, password);
		pstmt.setString(3, "");
		pstmt.setString(4, "");
		pstmt.setString(5, "");
		pstmt.setString(6, "");
		pstmt.setString(7, "");
		int result = pstmt.executeUpdate();
		
		return result;

	}
	
	public static UserDto selectUser(String userid) throws Exception{
		
		pstmt = conn.prepareStatement("select * from tbl_user where userid=?");	//userid와 일치하는 행 찾기
		pstmt.setString(1,userid);
		rs = pstmt.executeQuery();
		UserDto dto=null;
		if(rs!=null && rs.next()){
			dto=new UserDto();
			dto.setUserid(rs.getString("userid"));
			dto.setPassword(rs.getString("password"));
		}
		return dto;
	}
}
