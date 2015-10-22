package global;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseImpl implements Database{ //팩토리 패턴의 p33 예제2-1
	// ORACLE_DRIVER를 getter,setter없이 외부에서 변경. 번호로.
	private String driver, url, userid, password;//1
	private Connection connection;
	
	public DatabaseImpl(String driver, String url, String userid, String password/*2*/) {
		this.driver = driver;
		this.url = url;
		this.userid = userid;
		this.password = password;//3
	}
	
	
	public Connection getConnection() {
		try {
			   Class.forName(driver);
			   connection = DriverManager.getConnection(url, userid, password); //싱글톤 패턴.
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
}	
