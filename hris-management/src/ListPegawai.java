import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class ListPegawai implements Serializable{
	private static final long serialVersionUID = 4622458914625941465L;
	private List<Staff> listStaff = new ArrayList<Staff>();
	
	public List<Staff> getListStaff() {
		return listStaff;
	}
	public void setListStaff(List<Staff> listStaff) {
		this.listStaff = listStaff;
	}
	
	public void addPegawai(Staff staff){
		listStaff.add(staff);
	}
	
	public Staff getPegawaiById(int id){
		for (int i = 0; i < listStaff.size(); i++) {
			if(listStaff.get(i).getIdPegawai()==id){
				return listStaff.get(i);
			}
		}
		return null;
	}

}
