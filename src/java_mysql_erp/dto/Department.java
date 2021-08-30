package java_mysql_erp.dto;

public class Department {
	private int code;
	private String name;
	private int floor;
	
	public Department() {
		// TODO Auto-generated constructor stub
	}

	public Department(int code) {
		this.code = code;
	}

	public Department(int code, String name, int floor) {
		this.code = code;
		this.name = name;
		this.floor = floor;
	}

	public int getDeptNo() {
		return code;
	}

	public void setDeptNo(int code) {
		this.code = code;
	}

	public String getDeptName() {
		return name;
	}

	public void setDeptName(String name) {
		this.name = name;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	@Override
	public String toString() {
		return String.format("Department [deptNo=%s, deptName=%s, floor=%s]", code, name, floor);
	}
	
}
