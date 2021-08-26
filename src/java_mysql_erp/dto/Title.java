package java_mysql_erp.dto;

public class Title {
	private int code;
	private String name;
	
	
	public Title() {
		// TODO Auto-generated constructor stub
	}

	public Title(int code) {
		this.code = code;
	}

	public Title(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public int getCode() {
		return code;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("Title [code=%s, name=%s]", code, name);
	}
	
	
	
}
