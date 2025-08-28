package Ch05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbUtils {

	//속성(DB연결 관련된 멤버)
	//DB CONN DATA
	private static String id="root";
	private static String pw="1234";
	private static String url="jdbc:mysql://localhost:3306/opendatadb"; //JDBC/mySQL/서비스번호/DB명
		
	//JDBC참조변수
	private static Connection conn=null;			// DBMS 의 특정 DB와 연결되는 객체
	private static PreparedStatement pstmt=null;	// SQL Query 전송용 객체
	private static ResultSet rs=null;				// Select 결과물 저장 객체
	
	//기능
	public static void conn() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver"); // JDBC 드라이버 로딩
		System.out.println("Driver Loading Success...");
		conn=DriverManager.getConnection(url, id, pw); // 드라이버 매니저를 통해 객체 -> DB 연결처리 Connection
		System.out.println("DB CONNECTED...");
	}
	public static void disConn(Connection conn) throws Exception {
		conn.close();
	}
	public static void disConn(Connection conn, PreparedStatement pstmt) throws Exception {
		pstmt.close();
		conn.close();
	}
	public static void disConn(Connection conn, PreparedStatement pstmt, ResultSet rs) throws Exception {
		rs.close();
		pstmt.close();
		conn.close();
	}
	public static int insertUser(UserDto userDto) throws Exception {
		pstmt = conn.prepareStatement("insert into tbl_user values(?,?,?,?,?,?,?)");
		pstmt.setString(1, userDto.getUserid());
		pstmt.setString(2, userDto.getPassword());
		pstmt.setString(3, userDto.getRepassword());
		pstmt.setString(4, userDto.getUsername());
		pstmt.setString(5, userDto.getZipcode());
		pstmt.setString(6, userDto.getAddr1());
		pstmt.setString(7, userDto.getAddr2());
		int result=pstmt.executeUpdate();

		return result;
	}
	public static UserDto selectOne(String username) throws Exception {

		return null;
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
	
	
	public static int insertMember(MemberDto memberDto) throws Exception 
	{
		//tbl_member 에 dto 값 저장 후 int 반환
		return -1;

	}
	public static MemberDto selectMember(String userid) throws Exception{
		
		pstmt=conn.prepareStatement("select * from tbl_user where userid=?");
		pstmt.setString(1, userid);
		rs=pstmt.executeQuery();
		UserDto dto=null;
		if(rs!=null) {
			if(rs.next()) {
				dto=new UserDto();
				dto.setUserid(rs.getString("userid"));
				dto.setUserid(rs.getString("password"));
				dto.setUserid(rs.getString("repassword"));
				dto.setUserid(rs.getString("username"));
				dto.setUserid(rs.getString("zipcode"));
				dto.setUserid(rs.getString("addr1"));
				dto.setUserid(rs.getString("addr2"));
			}
			
		}
		//tbl_member 에 userid 와 일치하는 데이터 받아와 MemberDto로 반환  
		return dto;
	}
	
	public static void TxStart() throws Exception{
		if(conn!=null)
			conn.setAutoCommit(false);
	}
	public static void TxEnd() throws Exception {
		if(conn!=null)
			conn.commit();
	}
	public static void RollBack() throws Exception {
		if(conn!=null)
			conn.rollback();	
	}
}
