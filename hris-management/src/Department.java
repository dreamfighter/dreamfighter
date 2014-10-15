import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Department implements Serializable{
	private static final long serialVersionUID = 2789574685205899870L;
	private int id;
	private String nama;
	private DeptHead deptHead = new DeptHead();
	private Division division = new Division();
	private List<Staff> listStaff = new ArrayList<Staff>();
	
	public DeptHead getDeptHead() {
		return deptHead;
	}
	public void setDeptHead(DeptHead deptHead) {
		this.deptHead = deptHead;
	}
	
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public List<Staff> getListStaff() {
		return listStaff;
	}
	public void setListStaff(List<Staff> listStaff) {
		this.listStaff = listStaff;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Division getDivision() {
		return division;
	}
	public void setDivision(Division division) {
		this.division = division;
	}

}
