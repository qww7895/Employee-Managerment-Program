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

		int index = Integer.parseInt(str.substring(0, 1));//�ٲ�
		String name = str.substring(1, (str.length()));
		System.out.println(index);
		System.out.println(name);
		/*
		 * // ��ü���� Scanner sc = new Scanner(System.in); Calendar time =
		 * Calendar.getInstance(); Vector<String> idPwdDb = new Vector<String>();
		 * OnlyTest ot = new OnlyTest();
		 * 
		 * while (true) { // ��� ID���� String id =
		 * String.valueOf(time.get(Calendar.YEAR)); id += ot.getCount();
		 * ot.setCount(ot.getCount() + 1);
		 * 
		 * // ��� PWD���� boolean pwdSelect = false; String pwd = ""; while (pwdSelect !=
		 * true) { System.out.println("����� ��й�ȣ �Է�"); pwd = sc.next(); if (pwd.length()
		 * >= 8) { pwdSelect = false; } else { System.out.println("��й�ȣ�� 8�ڸ� ����, �ٽ��Է�");
		 * pwdSelect = true; } }
		 * 
		 * // ��� ID ���Ϳ� ���� idPwdDb.add(id + "//" + pwd); for (String s : idPwdDb) {
		 * System.out.println("�����ȣ : "+s); } }
		 */
	}
}
