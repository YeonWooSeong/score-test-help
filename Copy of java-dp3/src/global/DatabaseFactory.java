package global;

public class DatabaseFactory { //팩토리 패턴
	public static Database getDatabase(Vendor vendor, String id, String pass){
		String driver = null;
		String url = null;
		switch (vendor) {
		case ORACLE:
			driver = Constants.ORACLE_DRIVER;
			url = Constants.ORACLE_URL;
			break;	
		case MYSQL:
			driver = Constants.MYSQL_DRIVER;
			url = Constants.MYSQL_URL;
			break;
		case MSSQL:
			driver = Constants.MSSQL_DRIVER;
			url = Constants.MSSQL_URL;
			break;
		case MARIADB:
			driver = Constants.MARIADB_DRIVER;
			url = Constants.MARIADB_URL;
			break;
		default:
			break;
		}
		return new DatabaseImpl(driver, url, id, pass);
	}
}
