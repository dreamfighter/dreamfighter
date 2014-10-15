package hris;
import java.io.Serializable;

public class Staff extends Pegawai implements Serializable{
	private static final long serialVersionUID = -5470164101185207300L;
	private Department department;
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
}
