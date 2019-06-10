package wageManagementSystem;

import java.util.Calendar;
import java.util.Scanner;
import java.util.Vector;

public class OnlyTest {
	private int count;

	OnlyTest() {
		count = 0;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public static void main(String[] args) {
		String str = "020190609";

		int index = Integer.parseInt(str.substring(0, 1));//바꿈
		String name = str.substring(1, (str.length()));
		System.out.println(index);
		System.out.println(name);
		/*
		 * // 객체생성 Scanner sc = new Scanner(System.in); Calendar time =
		 * Calendar.getInstance(); Vector<String> idPwdDb = new Vector<String>();
		 * OnlyTest ot = new OnlyTest();
		 * 
		 * while (true) { // 사원 ID생성 String id =
		 * String.valueOf(time.get(Calendar.YEAR)); id += ot.getCount();
		 * ot.setCount(ot.getCount() + 1);
		 * 
		 * // 사원 PWD생성 boolean pwdSelect = false; String pwd = ""; while (pwdSelect !=
		 * true) { System.out.println("사용할 비밀번호 입력"); pwd = sc.next(); if (pwd.length()
		 * >= 8) { pwdSelect = false; } else { System.out.println("비밀번호는 8자리 이하, 다시입력");
		 * pwdSelect = true; } }
		 * 
		 * // 사원 ID 벡터에 저장 idPwdDb.add(id + "//" + pwd); for (String s : idPwdDb) {
		 * System.out.println("사원번호 : "+s); } }
		 */
	}
}
