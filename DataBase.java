package wageManagementSystem;

import java.util.Scanner;
import java.util.Vector;
import java.util.Calendar;

public class DataBase {
	private Vector<DataSheet> dbList;
	private String[] user = { "������", "�����", "������", "�漮��", "���쾾", "���Ծ�", "������", "����", "�����" };

	DataBase() {
		dbList = new Vector<DataSheet>(10);
		// ������
		// �⺻ 10ĭ, Ȯ��� �ִ� 10+90ĭ�� ������ ������
		dbList.add(new DataSheet());
		dbList.elementAt(0).setAll("�����", "20190609", "00000000", true, 40, 5);
		dbList.elementAt(0).setIndex(0);
		System.out.println(dbList.size());
		for (int i = 1; i < user.length; i++) {
			dbList.add(new DataSheet());
			dbList.elementAt(i).setAll(user[i], "20190609", "00000000", false, 20 + i, i);
			dbList.elementAt(i).setIndex(i);
			System.out.println(user[i]);
		}
		System.out.println(dbList.size());
	}

	public void selectData(String id) {
		// �ڱ� ����̸��� �Է��ϸ� �ڱ� �����͸� ���� �޼ҵ�
		System.out.println("\t\t<<�޿� ���� ���α׷�>>\t\t");
		System.out.println("--------------------");
		System.out.println("����̸�\t" + "�������\t" +"�����ȣ\t"+"�������");
		for (int count = 0; count < dbList.size(); count++) {
			if (dbList.elementAt(count).getIndex()==count) {
				// ���� ������ ���
				// ��� Ŭ���� ������ ���γ��� ����***********
				// ���� System.out.println(dbList.elementAt(count).name);
				System.out.println("--------------------");
				System.out.print(dbList.elementAt(count).getName() + "\t");
				System.out.print(dbList.elementAt(count).getAge() + "\t");
				System.out.print(dbList.elementAt(count).getIndex()+dbList.elementAt(count).getId()+ "\t");
				System.out.println(dbList.elementAt(count).getLevel());
				// ������� ã�� �ݺ��� Ż��
			}
		}
	}

	public void selectAll(int index) {
		// ��� DB������ ���� �żҵ�
		// ��ü�� ������ Ȯ��
		System.out.println("\t\t<<�޿� ���� ���α׷�>>\t\t");
		System.out.println("--------------------");
		System.out.println("����̸�\t|" + "�������\t|" + "�������\t");
		if (dbList.elementAt(index).isManager() == true) {
			// ������ ������
			for (int count = 0; count < dbList.size(); count++) {
				// ��ü ������ ���
				// ��� Ŭ���� ������ ���γ��� ����***********
				System.out.println("--------------------");
				System.out.print(dbList.elementAt(count).getName() + "\t|  ");
				System.out.print(dbList.elementAt(count).getAge() + "\t|  ");
				System.out.println(dbList.elementAt(count).getLevel());
			}
		} else {
			// ���� ����
			System.out.println("���� ����");
		}
	}

	public void insertData(int index, String id) {
		Scanner sc = new Scanner(System.in);
		Calendar ca = Calendar.getInstance();
		// DB ������ �Է�.
		// �Ŵ����� ����
		if (dbList.elementAt(index).isManager() == true) {
			// ������ ������
			DataSheet ds = new DataSheet();
			// ds.setIndex(sc.nextInt());//�����ȣ
			System.out.print("����̸� : ");
			String newName = sc.next();// ����̸�

			String newId = String.valueOf(ds.getIndex()) + String.valueOf(ca.get(Calendar.YEAR))
					+ String.valueOf(ca.get(Calendar.MONTH));// ������̵�
			System.out.println("��� ���̵� : " + newId);
			String newPw = "00000000";// ��й�ȣ
			System.out.println("��� ��й�ȣ" + newPw);
			boolean newIsManager = false; // ������or�����
			System.out.println("��� ���� : ");
			int newAge = sc.nextInt(); // ����
			System.out.println("��� ���� : ");
			int newLevel = sc.nextInt(); // ����
			ds.setAll(newName, newId, newPw, newIsManager, newAge, newLevel);
			dbList.add(ds);
			System.out.println("������ �Է� �Ϸ�");
		} else {
			// ���� ����
			System.out.println("���� ����");
		}
	}

	public void updateData(int index, String id, String pw) {
		Scanner sc = new Scanner(System.in);
		DataSheet update = exact(index, id, pw);
		if (update.isManager() == true) {
			// DB��ȣ�� �ش��ϴ� ���� ��� ��ġ
			System.out.print("������ ����ǰǰ���? Y/N : ");
			String isTrue = sc.nextLine();
			if (isTrue.equals("Y")) {
				dbList.remove(index);
				System.out.println("�����Ͽ����ϴ�");
			} else {
				System.out.println("�������� �ʰ� ���ư��ϴ�");
			}
		} else {
			System.out.println("���Ѿ���");
		}
		sc.close();
	}

	public void deleteData(int index, String id, String pw) {
		// DB��ȣ�� ������� DB������ ����. �Ŵ����� ����
		// DB��ȣ�� �ش��ϴ� ������ ����ѵ� ������ ������� ��Ȯ���� ����
		Scanner sc = new Scanner(System.in);
		DataSheet delete = exact(index, id, pw);
		if (delete.isManager() == true) {
			// DB��ȣ�� �ش��ϴ� ���� ��� ��ġ
			System.out.print("������ ����ǰǰ���? Y/N : ");
			String isTrue = sc.nextLine();
			if (isTrue.equals("Y")) {
				dbList.remove(index);
				System.out.println("�����Ͽ����ϴ�");
			} else {
				System.out.println("�������� �ʰ� ���ư��ϴ�");
			}
		} else {
			System.out.println("���Ѿ���");
		}
		sc.close();
	}

	public DataSheet exact(int index, String id, String pw) {

		for (int count = 0; count < dbList.size(); count++) {
			if (dbList.elementAt(count).getIndex() == index) {
				if (dbList.elementAt(count).getId().equals(id) && dbList.elementAt(count).getPw().equals(pw)) {
					System.out.println("�α��� ����");

					return dbList.elementAt(count);
					// ������� ã�� �ݺ��� Ż��
				}
			}
		}
		// ������� ã�� �ݺ��� Ż��
		System.out.println("�α��� ����\t �ٽ� �Է�");
		return null;
	}

	public boolean compare(int index, String id, String pw) {
		for (int count = 0; count < dbList.size(); count++) {
			if (dbList.elementAt(count).getIndex() == index) {
				System.out.println("�ε���Ȯ��");
				if (dbList.elementAt(count).getId().equals(id) && dbList.elementAt(count).getPw().equals(pw)) {
					System.out.println("���̵��н�����Ȯ��");
					if (dbList.elementAt(count).isManager() == true) {
						System.out.println("�����ڸ��� �����ϼ̽��ϴ�." + dbList.elementAt(count).getName() + "�� �������������� �̵��մϴ�");
					} else {
						System.out.println("����ڸ��� �����ϼ̽��ϴ�." + dbList.elementAt(count).getName() + "�� ��ȸ�������� �̵��մϴ�");
					}
					return true;
					// ������� ã�� �ݺ��� Ż��
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
		// ������� ã�� �ݺ��� Ż��
		return false;
	}

}