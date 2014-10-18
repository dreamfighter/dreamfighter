package hris;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KelolaLembur implements Serializable{
	private static final long serialVersionUID = 5003329582422791366L;
	private List<Lembur> listLembur = new ArrayList<Lembur>();
	
	public void ajukanLembur(Staff staff, Date tanggalLembur, Date jamMulai, Date jamSelesai, String keterangan, String status){
		Lembur lembur = new Lembur();
		lembur.setId(listLembur.size()+1);
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
	
	public void ubahLembur(Lembur lembur,Staff staff, Date tanggalLembur, Date jamMulai, Date jamSelesai, String keterangan, String status){
		
		lembur.setId(listLembur.size()+1);
		lembur.setTanggalPengajuan(new Date());
		lembur.setTanggalLembur(tanggalLembur);
		lembur.setJamMulai(jamMulai);
		lembur.setJamSelesai(jamSelesai);
		lembur.setKeterangan(keterangan);
		lembur.setStaff(staff);
		lembur.setStatusApprovalDeptHead(status);
		lembur.setStatusApprovalDivHead(status);
		
		
	}
	
	public void approveLembur(DeptHead deptHead, Lembur lembur){
		lembur.setApprovadDeptHeadOn(new Date());
		lembur.setApprovedDeptHeadBy(deptHead);
		lembur.setStatusApprovalDeptHead("APPROVED");
	}
	
	public void rejectLembur(DeptHead deptHead,Lembur lembur){
		lembur.setApprovadDeptHeadOn(new Date());
		lembur.setApprovedDeptHeadBy(deptHead);
		lembur.setStatusApprovalDeptHead("REJECTED");
	}
	
	public void approveLembur(DivHead divHead,Lembur lembur){
		lembur.setApprovadDivHeadOn(new Date());
		lembur.setApprovedDivHeadBy(divHead);
		lembur.setStatusApprovalDivHead("APPROVED");
	}
	
	public void rejectLembur(DivHead divHead,Lembur lembur){
		lembur.setApprovadDivHeadOn(new Date());
		lembur.setApprovedDivHeadBy(divHead);
		lembur.setStatusApprovalDivHead("REJECTED");
	}
	
	//TODO: send notification to deptHead and DivHead
	public void kirimNotifikasiPengajuan(Training training){
		
	}
	
	//TODO: send notification to deptHead and DivHead
	public void kirimNotifikasiPersetujuan(Training training){
		
	}
	
	//TODO: rekap detail lembur
	public void rekapLembur(){
		
	}
	
	public void tampilkanHistoryLembur(DeptHead deptHead){
		SimpleDateFormat sdf 	= new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdfTime= new SimpleDateFormat("hh.mm");
		
		printHeaderLembur(deptHead);
		
		for(Lembur lembur : listLembur){
			//System.out.println(lembur);
			if(lembur.getStaff().getDepartment().getId()==deptHead.getDepartment().getId()){
				//String.format(" ", "", lembur.getIdLembur());
				System.out.println(addPad(""+lembur.getId(),5) + "|" 
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
	
	public void tampilkanHistoryLembur(Staff staff){
		SimpleDateFormat sdf 	= new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdfTime= new SimpleDateFormat("hh.mm");
		
		printHeaderLembur(staff);
		
		for(Lembur lembur : listLembur){
			//System.out.println(lembur);
			if(lembur.getStaff().getIdPegawai()==staff.getIdPegawai()){
				//String.format(" ", "", lembur.getIdLembur());
				System.out.println(addPad(""+lembur.getId(),5) + "|" 
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
	
	public void tampilkanHistoryLembur(DivHead divHead){
		SimpleDateFormat sdf 	= new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdfTime= new SimpleDateFormat("hh.mm");
		
		printHeaderLembur(divHead);
		
		for(Lembur lembur : listLembur){
			//System.out.println(lembur);
			if(lembur.getStaff().getDepartment().getDivision().getId()==divHead.getDivision().getId()){
				//String.format(" ", "", lembur.getIdLembur());
				System.out.println(addPad(""+lembur.getId(),5) + "|" 
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
	
	public void tampilkanDaftarLembur(DeptHead deptHead){
		SimpleDateFormat sdf 	= new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdfTime= new SimpleDateFormat("hh.mm");
		
		printHeaderLembur(deptHead);
		
		for(Lembur lembur : listLembur){
			//System.out.println(lembur);
			if(lembur.getStaff().getDepartment().getId()==deptHead.getDepartment().getId() && lembur.getStatusApprovalDeptHead().equals("NEW")){
				//String.format(" ", "", lembur.getIdLembur());
				System.out.println(addPad(""+lembur.getId(),5) + "|" 
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
	
	public void tampilkanDaftarLembur(DivHead divHead){
		SimpleDateFormat sdf 	= new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdfTime= new SimpleDateFormat("hh.mm");
		
		printHeaderLembur(divHead);
		
		for(Lembur lembur : listLembur){
			//System.out.println(lembur);
			if(lembur.getStaff().getDepartment().getDivision().getId()==divHead.getDivision().getId() && lembur.getStatusApprovalDivHead().equals("NEW")){
				//String.format(" ", "", lembur.getIdLembur());
				System.out.println(addPad(""+lembur.getId(),5) + "|" 
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
	
	public List<Lembur> getListLembur() {
		return listLembur;
	}
	
	public void setListLembur(List<Lembur> listLembur) {
		this.listLembur = listLembur;
	}
	
	public Lembur cariLemburMenurutId(Staff staff,int id){
		for(Lembur lembur : listLembur){
			if(lembur.getStaff().getIdPegawai()==staff.getIdPegawai() && lembur.getId()==id){
				return lembur;
			}
		}
		return null;
	}
	
	public Lembur cariLemburMenurutId(DeptHead deptHead,int id){
		for(Lembur lembur : listLembur){
			if(lembur.getStaff().getDepartment().getDeptHead()==deptHead && lembur.getId()==id){
				return lembur;
			}
		}
		return null;
	}
	
	public Lembur cariLemburMenurutId(DivHead divHead,int id){
		for(Lembur lembur : listLembur){
			if(lembur.getStaff().getDepartment().getDivision().getDivHead()==divHead && lembur.getId()==id){
				return lembur;
			}
		}
		return null;
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
}
