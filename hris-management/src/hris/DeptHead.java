package hris;
import java.io.Serializable;


public class DeptHead extends Pegawai implements Serializable{
	private static final long serialVersionUID = 6799583478563051613L;
	private Department department;
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
}
