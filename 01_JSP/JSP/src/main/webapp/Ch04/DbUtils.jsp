<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,java.sql.*,Ch05.*" %>
<%!

	//속성(DB연결 관련된 멤버)
	//DB CONN DATA
	private static String id="root";
	private static String pw="1234";
	private static String url="jdbc:mysql://localhost:3306/opendatadb"; //JDBC/mySQL/서비스번호/DB명
		
	//JDBC참조변수
	private static Connection conn=null;			// DBMS 의 특정 DB와 연결되는 객체
	private static PreparedStatement pstmt=null;	// SQL Query 전송용 객체
	private static ResultSet rs=null;				// Select 결과물 저장 객체
	
	//싱글톤 패턴 처리
	
	
	//기능
	public static void conn() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver"); 			//JDBC 드라이버 로딩
		System.out.println("Driver Loading Success...");	
		conn=DriverManager.getConnection(url,id,pw);		//드라이버 매니저를 통해 객체 -> DB 연결처리 Connection
		System.out.println("DB CONNECTED...");
	}
	public static void disConn(Connection conn) throws Exception{
		conn.close();
	}
	public static void disConn(Connection conn,PreparedStatement pstmt) throws Exception{
		pstmt.close();
		conn.close();
	}
	public static void disConn(Connection conn,PreparedStatement pstmt,ResultSet rs) throws Exception{
		rs.close();
		pstmt.close();
		conn.close();
	}
	public static int insertUser(UserDto userDto) throws Exception{
		pstmt=conn.prepareStatement("insert into tbl_user values(?,?,?,?,?,?,?)");
		pstmt.setString(1, userDto.getUserid());
		pstmt.setString(2, userDto.getPassword());
		pstmt.setString(3, userDto.getRepassword());
		pstmt.setString(4, userDto.getUsername());
		pstmt.setString(5, userDto.getZipcode());
		pstmt.setString(6, userDto.getAddr1());
		pstmt.setString(7, userDto.getAddr2());
		int result=pstmt.executeUpdate();
		
		return -1;
	}
%>

<%
	//
	String url=(String)request.getAttribute("url");
	Integer serviceNo=(Integer)request.getAttribute("serviceNo");
	if(url.contains("/join")){
		conn(); //DBCONN
		UserDto dto=(UserDto)request.getAttribute("userDto");
		int result=insertUser(dto); // PreparedStatement 객체생성
		//DBDISCONN
		disConn(conn,pstmt);	// 자원제거
		//REDIRECT(login.jsp)
		if(result>0)
			response.sendRedirect("./login.jsp");
		else
			;
	}
	
%>