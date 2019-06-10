package wageManagementSystem;

import java.util.Scanner;
import java.util.Vector;
import java.util.Calendar;

public class DataBase {
	private Vector<DataSheet> dbList;
	private String[] user = { "시현이", "재경이", "소윤이", "경석이", "영우씨", "종규씨", "혀녕이", "기루룩", "강사님" };

	DataBase() {
		dbList = new Vector<DataSheet>(10);
		// 생성자
		// 기본 10칸, 확장시 최대 10+90칸의 공간을 차지함
		dbList.add(new DataSheet());
		dbList.elementAt(0).setAll("덩허니", "20190609", "00000000", true, 40, 5);
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
		// 자기 사원이름을 입력하면 자기 데이터만 보는 메소드
		System.out.println("\t\t<<급여 관리 프로그램>>\t\t");
		System.out.println("--------------------");
		System.out.println("사원이름\t" + "사원나이\t" +"사원번호\t"+"사원직급");
		for (int count = 0; count < dbList.size(); count++) {
			if (dbList.elementAt(count).getIndex()==count) {
				// 개인 데이터 출력
				// 사원 클래스 생성후 세부내용 제작***********
				// 예시 System.out.println(dbList.elementAt(count).name);
				System.out.println("--------------------");
				System.out.print(dbList.elementAt(count).getName() + "\t");
				System.out.print(dbList.elementAt(count).getAge() + "\t");
				System.out.print(dbList.elementAt(count).getIndex()+dbList.elementAt(count).getId()+ "\t");
				System.out.println(dbList.elementAt(count).getLevel());
				// 사원정보 찾음 반복문 탈출
			}
		}
	}

	public void selectAll(int index) {
		// 모든 DB내용을 보는 매소드
		// 객체의 권한을 확인
		System.out.println("\t\t<<급여 관리 프로그램>>\t\t");
		System.out.println("--------------------");
		System.out.println("사원이름\t|" + "사원나이\t|" + "사원직급\t");
		if (dbList.elementAt(index).isManager() == true) {
			// 권한이 있을떄
			for (int count = 0; count < dbList.size(); count++) {
				// 전체 데이터 출력
				// 사원 클래스 생성후 세부내용 제작***********
				System.out.println("--------------------");
				System.out.print(dbList.elementAt(count).getName() + "\t|  ");
				System.out.print(dbList.elementAt(count).getAge() + "\t|  ");
				System.out.println(dbList.elementAt(count).getLevel());
			}
		} else {
			// 권한 없음
			System.out.println("권한 없음");
		}
	}

	public void insertData(int index, String id) {
		Scanner sc = new Scanner(System.in);
		Calendar ca = Calendar.getInstance();
		// DB 데이터 입력.
		// 매니저만 가능
		if (dbList.elementAt(index).isManager() == true) {
			// 권한이 있을떄
			DataSheet ds = new DataSheet();
			// ds.setIndex(sc.nextInt());//사원번호
			System.out.print("사원이름 : ");
			String newName = sc.next();// 사원이름

			String newId = String.valueOf(ds.getIndex()) + String.valueOf(ca.get(Calendar.YEAR))
					+ String.valueOf(ca.get(Calendar.MONTH));// 사원아이디
			System.out.println("사원 아이디 : " + newId);
			String newPw = "00000000";// 비밀번호
			System.out.println("사원 비밀번호" + newPw);
			boolean newIsManager = false; // 관리자or사용자
			System.out.println("사원 나이 : ");
			int newAge = sc.nextInt(); // 나이
			System.out.println("사원 직급 : ");
			int newLevel = sc.nextInt(); // 직급
			ds.setAll(newName, newId, newPw, newIsManager, newAge, newLevel);
			dbList.add(ds);
			System.out.println("데이터 입력 완료");
		} else {
			// 권한 없음
			System.out.println("권한 없음");
		}
	}

	public void updateData(int index, String id, String pw) {
		Scanner sc = new Scanner(System.in);
		DataSheet update = exact(index, id, pw);
		if (update.isManager() == true) {
			// DB번호에 해당하는 정보 출력 위치
			System.out.print("정말로 지우실건가요? Y/N : ");
			String isTrue = sc.nextLine();
			if (isTrue.equals("Y")) {
				dbList.remove(index);
				System.out.println("삭제하였습니다");
			} else {
				System.out.println("삭제하지 않고 돌아갑니다");
			}
		} else {
			System.out.println("권한없음");
		}
		sc.close();
	}

	public void deleteData(int index, String id, String pw) {
		// DB번호를 기반으로 DB데이터 삭제. 매니저만 가능
		// DB번호에 해당하는 정보를 출력한뒤 정말로 지울건지 재확인후 삭제
		Scanner sc = new Scanner(System.in);
		DataSheet delete = exact(index, id, pw);
		if (delete.isManager() == true) {
			// DB번호에 해당하는 정보 출력 위치
			System.out.print("정말로 지우실건가요? Y/N : ");
			String isTrue = sc.nextLine();
			if (isTrue.equals("Y")) {
				dbList.remove(index);
				System.out.println("삭제하였습니다");
			} else {
				System.out.println("삭제하지 않고 돌아갑니다");
			}
		} else {
			System.out.println("권한없음");
		}
		sc.close();
	}

	public DataSheet exact(int index, String id, String pw) {

		for (int count = 0; count < dbList.size(); count++) {
			if (dbList.elementAt(count).getIndex() == index) {
				if (dbList.elementAt(count).getId().equals(id) && dbList.elementAt(count).getPw().equals(pw)) {
					System.out.println("로그인 성공");

					return dbList.elementAt(count);
					// 사원정보 찾음 반복문 탈출
				}
			}
		}
		// 사원정보 찾음 반복문 탈출
		System.out.println("로그인 실패\t 다시 입력");
		return null;
	}

	public boolean compare(int index, String id, String pw) {
		for (int count = 0; count < dbList.size(); count++) {
			if (dbList.elementAt(count).getIndex() == index) {
				System.out.println("인덱스확인");
				if (dbList.elementAt(count).getId().equals(id) && dbList.elementAt(count).getPw().equals(pw)) {
					System.out.println("아이디패스워드확인");
					if (dbList.elementAt(count).isManager() == true) {
						System.out.println("관리자모드로 접근하셨습니다." + dbList.elementAt(count).getName() + "님 관리자페이지로 이동합니다");
					} else {
						System.out.println("사용자모드로 접근하셨습니다." + dbList.elementAt(count).getName() + "님 조회페이지로 이동합니다");
					}
					return true;
					// 사원정보 찾음 반복문 탈출
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
		// 사원정보 찾음 반복문 탈출
		return false;
	}

}