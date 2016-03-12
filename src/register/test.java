package register;

import sql.readSql;

public class test {

	public static void main(String[] args) {

		GetInfo test = new GetInfo();

		String username = "justin";
		String userEmail = "justin@yknotstudios.com";
		
		readSql read = new readSql();
		read.displayTable();
		
	}

}
