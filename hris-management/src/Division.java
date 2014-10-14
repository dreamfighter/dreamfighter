import java.io.Serializable;
import java.util.List;


public class Division implements Serializable{
	private static final long serialVersionUID = 6877611495573484918L;
	private int id;
	private String nama;
	private List<Department> listDepartment;
	
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public List<Department> getListDepartment() {
		return listDepartment;
	}
	public void setListDepartment(List<Department> listDepartment) {
		this.listDepartment = listDepartment;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
