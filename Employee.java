package wageManagementSystem;

import java.util.Scanner;

public class Employee {

	private String id, pwd;
	private int index;
	private DataBase db;

	public Employee(DataBase db) {
		this.db = db;
	}

	public boolean loginData() {// �α����Է�
		Scanner sc = new Scanner(System.in);
		// �����ȣ�Է�
		System.out.print("�����ȣ �Է� : ");
		id = sc.next();
		// pwd �Է�
		System.out.print("�н����� �Է� : ");
		pwd = sc.next();
		System.out.println("ID : "+id+"PW : "+pwd);
		index = Integer.parseInt(id.substring(0, 1));//�ٲ�
		String name = id.substring(1, (id.length()));//�ٲ�
		return filter(index, name, pwd);

	}

	public boolean filter(int index, String name, String pwd) {// �α���ó��
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
			System.out.print("| ��ȸ = 1\t| ��� ��ü ��ȸ = 2\t|�Է� = 3\t|���� = 4\t|���� = 5 |");
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				db.selectData(id);// �����ͺ��̽� ��ȸ
				break;
			case 2:
				db.selectAll(index);// �����ͺ��̽� ��ü��ȸ
				break;
			case 3:
				db.insertData(index,id);// �����ͺ��̽� ����
				break;
			case 4:
				db.updateData(index, id, pwd);
				;// �����ͺ��̽� ����
				break;
			case 5:
				db.deleteData(index, id, pwd);
				break;
			default:
				System.out.println("1~5������ ���ڸ� �Է�");
				continue;
			}
		}
	}
}
