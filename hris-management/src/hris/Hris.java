package hris;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Hris implements Serializable{
	private static final long serialVersionUID = 6313470848522073042L;
	public static final String NEW 		= "NEW";
	public static final String APPROVED = "APPROVED";
	public static final String REJECTED = "REJECTED";
	private List<Division> listDivision = new ArrayList<Division>();
	private List<Pegawai> listPegawai = new ArrayList<Pegawai>();
	private KelolaLembur kelolaLembur = new KelolaLembur();
	private KelolaTraining kelolaTraining = new KelolaTraining();
	private KelolaEvent kelolaEvent = new KelolaEvent();
	private Hrd hrd = new Hrd();

	public void approve(DivHead divHead, Lembur lembur){
		kelolaLembur.approveLembur(divHead, lembur);
	}
	
	public void approve(DeptHead deptHead, Lembur lembur){
		kelolaLembur.approveLembur(deptHead, lembur);
	}
	
	public void reject(DivHead divHead, Lembur lembur){
		kelolaLembur.rejectLembur(divHead, lembur);
	}
	
	public void reject(DeptHead deptHead, Lembur lembur){
		kelolaLembur.rejectLembur(deptHead, lembur);
	}
	
	public void approve(DivHead divHead, Training training){
		kelolaTraining.approveTraining(divHead, training);
	}
	
	public void approve(DeptHead deptHead, Training training){
		kelolaTraining.approveTraining(deptHead, training);
	}
	
	public void reject(DivHead divHead, Training training){
		kelolaTraining.rejectTraining(divHead, training);
	}
	
	public void reject(DeptHead deptHead, Training training){
		kelolaTraining.rejectTraining(deptHead, training);
	}
	
	public List<Pegawai> getListPegawai() {
		return listPegawai;
	}

	public void setListPegawai(List<Pegawai> listPegawai) {
		this.listPegawai = listPegawai;
	}
	
	private void printHeaderStaff(Department department){
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("Daftar Staff Department: " + department.getNama());
		System.out.println("=======================================================================================================================================");
		System.out.println("id   |nama staff         |email                              |no. tlp           |alamat                                                ");
		System.out.println("=======================================================================================================================================");
	}
	
	private void printHeaderStaff(Division division){
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("Daftar Staff Division: " + division.getNama());
		System.out.println("=======================================================================================================================================");
		System.out.println("id   |nama staff         |department                |email                              |no. tlp           |alamat                                                ");
		System.out.println("=======================================================================================================================================");
	}
	
	public void tampilkanDaftarStaff(Department department){
		printHeaderStaff(department);
		for(Staff staff : department.getListStaff()){
			System.out.println(addPad(""+staff.getIdPegawai(),5) + "|" + addPad(staff.getNama(), 19) + "|" + addPad(""+staff.getEmail(),35) + "|" + addPad(staff.getTlp(),18) + "|" + addPad(staff.getAlamat(),54));
		}
	}
	
	public void tampilkanDaftarStaff(Division division){
		printHeaderStaff(division);
		for(Department department:division.getListDepartment()){
			for(Staff staff : department.getListStaff()){
				System.out.println(addPad(""+staff.getIdPegawai(),5) + "|" + addPad(staff.getNama(), 19) + "|" + addPad(department.getNama(), 26) + "|" + addPad(""+staff.getEmail(),35) + "|" + addPad(staff.getTlp(),18) + "|" + addPad(staff.getAlamat(),54));
			}
		}
	}
	
	public boolean isHrd(Pegawai pegawai){
		for(Staff staff:hrd.getListStaff()){
			if(staff.getIdPegawai()==pegawai.getIdPegawai()){
				return true;
			}
		}
		return false;
	}
	
	public Pegawai getPegawaiById(int id){
		for (int i = 0; i < listPegawai.size(); i++) {
			if(listPegawai.get(i).getIdPegawai()==id){
				return listPegawai.get(i);
			}
		}
		return null;
	}
	
	public Department getDepartmentByPegawai(Pegawai pegawai){
		if(pegawai instanceof Staff){
			return ((Staff)pegawai).getDepartment();
		}else if(pegawai instanceof DeptHead){
			return ((DeptHead)pegawai).getDepartment();
		}
		return null;
	}
	
	public void tambahPegawai(Pegawai pegawai){
		listPegawai.add(pegawai);
	}

	public List<Division> getListDivision() {
		return listDivision;
	}

	public void setListDivision(List<Division> listDivision) {
		this.listDivision = listDivision;
	}
	
	public void printDivision(){

		for(Division div:listDivision){
			System.out.println("["+div.getId()+"] " + div.getNama());

			for(Department dept:div.getListDepartment()){
				System.out.println("["+dept.getId()+"] " + dept.getNama());

			}

		}
	}

	public KelolaLembur getKelolaLembur() {
		return kelolaLembur;
	}

	public void setKelolaLembur(KelolaLembur kelolaLembur) {
		this.kelolaLembur = kelolaLembur;
	}

	public KelolaTraining getKelolaTraining() {
		return kelolaTraining;
	}

	public void setKelolaTraining(KelolaTraining kelolaTraining) {
		this.kelolaTraining = kelolaTraining;
	}
	
	private String addPad(String str,int number){
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<number;i++){
			if(str.length()>i){
				sb.append(str.charAt(i));
			}else{
				sb.append(" ");
			}
		}
		return sb.toString();
	}

	public Hrd getHrd() {
		return hrd;
	}

	public void setHrd(Hrd hrd) {
		this.hrd = hrd;
	}

	public KelolaEvent getKelolaEvent() {
		return kelolaEvent;
	}

	public void setKelolaEvent(KelolaEvent kelolaEvent) {
		this.kelolaEvent = kelolaEvent;
	}
}
