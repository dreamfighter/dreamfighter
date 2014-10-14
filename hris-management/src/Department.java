import java.io.Serializable;
import java.util.List;


public class Department implements Serializable{
	private static final long serialVersionUID = 2789574685205899870L;
	private String nama;
	private List<Staff> listStaff;
	
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

}
