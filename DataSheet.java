package wageManagementSystem;

public class DataSheet {
	//������
	private int index;//�����ȣ
	private String name;//����̸�
	private String id;//������̵�
	private String pw;//��й�ȣ
	private boolean isManager; //������or�����
	private int age; //����
	private int level; //����
	private int realAnnual;//���Ŀ���
	private int endAnnual;//��������
	//������
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
