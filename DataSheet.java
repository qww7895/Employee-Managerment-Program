package wageManagementSystem;

public class DataSheet {
	//데이터
	private int index;//사원번호
	private String name;//사원이름
	private String id;//사원아이디
	private String pw;//비밀번호
	private boolean isManager; //관리자or사용자
	private int age; //나이
	private int level; //직급
	private int realAnnual;//세후연봉
	private int endAnnual;//세전연봉
	//생성자
	public DataSheet() {
		
	}
	public void setAll(String name, String id, String pw, boolean isManager, int age, int level) {
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.isManager = isManager;
		this.age = age;
		this.level = level;
	}
	//Getter Setter
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isManager() {
		return isManager;
	}
	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
}
