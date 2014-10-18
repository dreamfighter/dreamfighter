package hris;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Hrd implements Serializable{
	private static final long serialVersionUID = 1625352088894454389L;
	private List<Staff> listStaff = new ArrayList<Staff>();
	
	public List<Staff> getListStaff() {
		return listStaff;
	}
	public void setListStaff(List<Staff> listStaff) {
		this.listStaff = listStaff;
	}

}
