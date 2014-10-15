import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Hris implements Serializable{
	private static final long serialVersionUID = 6313470848522073042L;
	public static final String NEW 		= "NEW";
	public static final String APPROVED = "APPROVED";
	public static final String REJECTED = "REJECTED";
	private List<Division> listDivision = new ArrayList<Division>();
	private List<Pegawai> listPegawai = new ArrayList<Pegawai>();
	private List<Lembur> listLembur = new ArrayList<Lembur>();	

	public List<Pegawai> getListPegawai() {
		return listPegawai;
	}

	public void setListPegawai(List<Pegawai> listPegawai) {
		this.listPegawai = listPegawai;
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
	
	public void addPegawai(Pegawai pegawai){
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
	
	public void approveLembur(DeptHead deptHead,Lembur lembur){
		lembur.setApprovadDeptHeadOn(new Date());
		lembur.setApprovedDeptHeadBy(deptHead);
		lembur.setStatusApprovalDeptHead(APPROVED);
	}
	
	public void rejectLembur(DeptHead deptHead,Lembur lembur){
		lembur.setApprovadDeptHeadOn(new Date());
		lembur.setApprovedDeptHeadBy(deptHead);
		lembur.setStatusApprovalDeptHead(REJECTED);
	}
	
	public void approveLembur(DivHead divHead,Lembur lembur){
		lembur.setApprovadDivHeadOn(new Date());
		lembur.setApprovedDivHeadBy(divHead);
		lembur.setStatusApprovalDivHead(APPROVED);
	}
	
	public void rejectLembur(DivHead divHead,Lembur lembur){
		lembur.setApprovadDivHeadOn(new Date());
		lembur.setApprovedDivHeadBy(divHead);
		lembur.setStatusApprovalDivHead(REJECTED);
	}
	
	public void ajukanLembur(Staff staff, Date tanggalLembur, Date jamMulai, Date jamSelesai, String keterangan, String status){
		Lembur lembur = new Lembur();
		lembur.setIdLembur(listLembur.size()+1);
		lembur.setTanggalPengajuan(new Date());
		lembur.setTanggalLembur(tanggalLembur);
		lembur.setJamMulai(jamMulai);
		lembur.setJamSelesai(jamSelesai);
		lembur.setKeterangan(keterangan);
		lembur.setStaff(staff);
		lembur.setStatusApprovalDeptHead(status);
		lembur.setStatusApprovalDivHead(status);
		
		this.listLembur.add(lembur);
	}
	
	public List<Lembur> getListLembur() {
		return listLembur;
	}
	
	public void setListLembur(List<Lembur> listLembur) {
		this.listLembur = listLembur;
	}
	
	public void printDaftarStaff(Department department){
		printHeaderStaff(department);
		for(Staff staff : department.getListStaff()){
			System.out.println(addPad(""+staff.getIdPegawai(),5) + "|" + addPad(staff.getNama(), 19) + "|" + addPad(""+staff.getEmail(),35) + "|" + addPad(staff.getTlp(),18) + "|" + addPad(staff.getAlamat(),54));
		}
	}
	
	public void printDaftarStaff(Division division){
		printHeaderStaff(division);
		for(Department department:division.getListDepartment()){
			for(Staff staff : department.getListStaff()){
				System.out.println(addPad(""+staff.getIdPegawai(),5) + "|" + addPad(staff.getNama(), 19) + "|" + addPad(department.getNama(), 26) + "|" + addPad(""+staff.getEmail(),35) + "|" + addPad(staff.getTlp(),18) + "|" + addPad(staff.getAlamat(),54));
			}
		}
	}
	
	public void printDaftarLembur(DeptHead deptHead){
		SimpleDateFormat sdf 	= new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdfTime= new SimpleDateFormat("hh.mm");
		
		printHeaderLembur(deptHead);
		
		for(Lembur lembur : listLembur){
			//System.out.println(lembur);
			if(lembur.getStaff().getDepartment().getId()==deptHead.getDepartment().getId() && lembur.getStatusApprovalDeptHead().equals(NEW)){
				//String.format(" ", "", lembur.getIdLembur());
				System.out.println(addPad(""+lembur.getIdLembur(),5) + "|" 
						+ addPad(lembur.getStatusApprovalDeptHead(), 7) + "|" 
						+ addPad(""+lembur.getStaff().getNama(),19) + "|" 
						+ addPad(sdf.format(lembur.getTanggalLembur()),15) + "|" 
						+ addPad(sdf.format(lembur.getTanggalPengajuan()),18) + "|" 
						+ addPad(sdfTime.format(lembur.getJamMulai()),10) + "|" 
						+ addPad(sdfTime.format(lembur.getJamSelesai()),12) + "|" 
						+ lembur.getKeterangan());
			}
		}
	}
	
	public void printDaftarLembur(DivHead divHead){
		SimpleDateFormat sdf 	= new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdfTime= new SimpleDateFormat("hh.mm");
		
		printHeaderLembur(divHead);
		
		for(Lembur lembur : listLembur){
			//System.out.println(lembur);
			if(lembur.getStaff().getDepartment().getDivision().getId()==divHead.getDivision().getId() && lembur.getStatusApprovalDivHead().equals(NEW)){
				//String.format(" ", "", lembur.getIdLembur());
				System.out.println(addPad(""+lembur.getIdLembur(),5) + "|" 
						+ addPad(lembur.getStatusApprovalDeptHead(), 7) + "|" 
						+ addPad(lembur.getStatusApprovalDivHead(), 10) + "|"  
						+ addPad(""+lembur.getStaff().getNama(),19) + "|" 
						+ addPad(""+lembur.getStaff().getDepartment().getNama(),25) + "|" 
						+ addPad(sdf.format(lembur.getTanggalLembur()),15) + "|" 
						+ addPad(sdf.format(lembur.getTanggalPengajuan()),18) + "|" 
						+ addPad(sdfTime.format(lembur.getJamMulai()),10) + "|" 
						+ addPad(sdfTime.format(lembur.getJamSelesai()),12) + "|" 
						+ lembur.getKeterangan());
			}
		}
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
	
	private void printHeaderLembur(DeptHead deptHead){
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("Daftar Lembur Department: " + deptHead.getDepartment().getNama());
		System.out.println("========================================================================================================");
		System.out.println("id   |status |nama staff         |tanggal lembur |tanggal pengajuan |jam mulai |jam selesai |keterangan ");
		System.out.println("========================================================================================================");
	}
	
	private void printHeaderLembur(DivHead divHead){
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("Daftar Lembur Division: " + divHead.getDivision().getNama());
		System.out.println("==================================================================================================================================");
		System.out.println("id   |status depthead |status    |nama staff         |department               |tanggal lembur |tanggal pengajuan |jam mulai |jam selesai |keterangan ");
		System.out.println("==================================================================================================================================");
	}
	
	private void printHeaderLembur(Staff staff){
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("History Lembur : " + staff.getNama());
		System.out.println("==============================================================================================================================");
		System.out.println("id   |status depthead |status divhead |tanggal lembur |tanggal pengajuan |jam mulai |jam selesai |keterangan                  ");
		System.out.println("==============================================================================================================================");
	}
	
	public void printHistoryLembur(DivHead divHead){
		SimpleDateFormat sdf 	= new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdfTime= new SimpleDateFormat("hh.mm");
		
		printHeaderLembur(divHead);
		
		for(Lembur lembur : listLembur){
			//System.out.println(lembur);
			if(lembur.getStaff().getDepartment().getDivision().getId()==divHead.getDivision().getId()){
				//String.format(" ", "", lembur.getIdLembur());
				System.out.println(addPad(""+lembur.getIdLembur(),5) + "|" 
						+ addPad(lembur.getStatusApprovalDeptHead(), 16) + "|" 
						+ addPad(lembur.getStatusApprovalDivHead(), 10) + "|" 
						+ addPad(""+lembur.getStaff().getNama(),19) + "|" 
						+ addPad(""+lembur.getStaff().getDepartment().getNama(),25) + "|" 
						+ addPad(sdf.format(lembur.getTanggalLembur()),15) + "|" 
						+ addPad(sdf.format(lembur.getTanggalPengajuan()),18) + "|" 
						+ addPad(sdfTime.format(lembur.getJamMulai()),10) + "|" 
						+ addPad(sdfTime.format(lembur.getJamSelesai()),12) + "|" 
						+ lembur.getKeterangan());
			}
		}
	}
	
	public void printHistoryLembur(DeptHead deptHead){
		SimpleDateFormat sdf 	= new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdfTime= new SimpleDateFormat("hh.mm");
		
		printHeaderLembur(deptHead);
		
		for(Lembur lembur : listLembur){
			//System.out.println(lembur);
			if(lembur.getStaff().getDepartment().getId()==deptHead.getDepartment().getId()){
				//String.format(" ", "", lembur.getIdLembur());
				System.out.println(addPad(""+lembur.getIdLembur(),5) + "|" 
						+ addPad(lembur.getStatusApprovalDeptHead(), 7) + "|" 
						+ addPad(""+lembur.getStaff().getNama(),19) + "|" 
						+ addPad(sdf.format(lembur.getTanggalLembur()),15) + "|" 
						+ addPad(sdf.format(lembur.getTanggalPengajuan()),18) + "|" 
						+ addPad(sdfTime.format(lembur.getJamMulai()),10) + "|" 
						+ addPad(sdfTime.format(lembur.getJamSelesai()),12) + "|" 
						+ lembur.getKeterangan());
			}
		}
	}
	
	public void printHistoryLembur(Staff staff){
		SimpleDateFormat sdf 	= new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdfTime= new SimpleDateFormat("hh.mm");
		
		printHeaderLembur(staff);
		
		for(Lembur lembur : listLembur){
			//System.out.println(lembur);
			if(lembur.getStaff().getIdPegawai()==staff.getIdPegawai()){
				//String.format(" ", "", lembur.getIdLembur());
				System.out.println(addPad(""+lembur.getIdLembur(),5) + "|" 
						+ addPad(lembur.getStatusApprovalDeptHead(), 16) + "|" 
						+ addPad(lembur.getStatusApprovalDivHead(), 15) + "|" 
						+ addPad(sdf.format(lembur.getTanggalLembur()),15) + "|" 
						+ addPad(sdf.format(lembur.getTanggalPengajuan()),18) + "|" 
						+ addPad(sdfTime.format(lembur.getJamMulai()),10) + "|" 
						+ addPad(sdfTime.format(lembur.getJamSelesai()),12) + "|" 
						+ lembur.getKeterangan());
			}
		}
	}
	
	public Lembur getLemburByStaffAndId(Staff staff,int id){
		for(Lembur lembur : listLembur){
			if(lembur.getStaff().getIdPegawai()==staff.getIdPegawai() && lembur.getIdLembur()==id){
				return lembur;
			}
		}
		return null;
	}
	
	public Lembur getLemburByDeptHeadAndId(DeptHead deptHead,int id){
		for(Lembur lembur : listLembur){
			if(lembur.getStaff().getDepartment().getDeptHead()==deptHead && lembur.getIdLembur()==id){
				return lembur;
			}
		}
		return null;
	}
	
	public Lembur getLemburByDivHeadAndId(DivHead divHead,int id){
		for(Lembur lembur : listLembur){
			if(lembur.getStaff().getDepartment().getDivision().getDivHead()==divHead && lembur.getIdLembur()==id){
				return lembur;
			}
		}
		return null;
	}
	
	public String addPad(String str,int number){
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
}
