package wageManagementSystem;

import java.util.Scanner;

public class Employee {

	private String id, pwd;
	private int index;
	private DataBase db;

	public Employee(DataBase db) {
		this.db = db;
	}

	public boolean loginData() {// 로그인입력
		Scanner sc = new Scanner(System.in);
		// 사원번호입력
		System.out.print("사원번호 입력 : ");
		id = sc.next();
		// pwd 입력
		System.out.print("패스워드 입력 : ");
		pwd = sc.next();
		System.out.println("ID : "+id+"PW : "+pwd);
		index = Integer.parseInt(id.substring(0, 1));//바꿈
		String name = id.substring(1, (id.length()));//바꿈
		return filter(index, name, pwd);

	}

	public boolean filter(int index, String name, String pwd) {// 로그인처리
		boolean tf = db.compare(index, name, pwd);
		if (tf == true) {
			return tf;
		} else {
			return tf;
		}
	}

	public void choose() {
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.print("| 조회 = 1\t| 사원 전체 조회 = 2\t|입력 = 3\t|변경 = 4\t|삭제 = 5 |");
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				db.selectData(id);// 데이터베이스 조회
				break;
			case 2:
				db.selectAll(index);// 데이터베이스 전체조회
				break;
			case 3:
				db.insertData(index,id);// 데이터베이스 변경
				break;
			case 4:
				db.updateData(index, id, pwd);
				;// 데이터베이스 삭제
				break;
			case 5:
				db.deleteData(index, id, pwd);
				break;
			default:
				System.out.println("1~5까지의 숫자만 입력");
				continue;
			}
		}
	}
}
