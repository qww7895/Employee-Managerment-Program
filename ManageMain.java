package wageManagementSystem;

import java.util.Scanner;

public class ManageMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DataBase db = new DataBase();
		Employee emp = new Employee(db);
		boolean dbCon = false;
		while (true) {
			dbCon = emp.loginData();
			
			if (dbCon) {
				emp.choose();
			}else {
				System.out.println("실패~ 다시");
			}
		}
	}

}
