package hris;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KelolaTraining implements Serializable{
	private static final long serialVersionUID = 1106406257042734492L;
	private List<Training> listTraining = new ArrayList<Training>();
	
	public void rejectTraining(DivHead divHead,Training training){
		training.setApprovadDivHeadOn(new Date());
		training.setApprovedDivHeadBy(divHead);
		training.setStatusApprovalDivHead("REJECTED");
	}
	
	public void approveTraining(DeptHead deptHead,Training training){
		training.setApprovadDeptHeadOn(new Date());
		training.setApprovedDeptHeadBy(deptHead);
		training.setStatusApprovalDeptHead("APPROVED");
	}
	
	public void rejectTraining(DeptHead deptHead,Training training){
		training.setApprovadDeptHeadOn(new Date());
		training.setApprovedDeptHeadBy(deptHead);
		training.setStatusApprovalDeptHead("REJECTED");
	}
	
	public void approveTraining(DivHead divHead,Training training){
		training.setApprovadDivHeadOn(new Date());
		training.setApprovedDivHeadBy(divHead);
		training.setStatusApprovalDivHead("APPROVED");
	}
	
	public void ajukanTraining(Staff staff, Date tanggalTraining, String lokasiTraining, String namaTraining, String status){
		Training training = new Training();
		training.setNama(namaTraining);
		training.setLokasi(lokasiTraining);
		training.setId(listTraining.size()+1);
		training.setTanggalPengajuan(new Date());
		training.setTanggalTraining(tanggalTraining);
		training.setStaff(staff);
		training.setStatusApprovalDeptHead(status);
		training.setStatusApprovalDivHead(status);
		
		this.listTraining.add(training);
	}
	
	public void ubahTraining(Training training, Staff staff, Date tanggalTraining, String lokasiTraining, String namaTraining, String status){
		
		training.setNama(namaTraining);
		training.setLokasi(lokasiTraining);
		training.setId(listTraining.size()+1);
		training.setTanggalPengajuan(new Date());
		training.setTanggalTraining(tanggalTraining);
		training.setStaff(staff);
		training.setStatusApprovalDeptHead(status);
		training.setStatusApprovalDivHead(status);
		
		
	}
	
	//TODO: send notification to deptHead and DivHead
	public void kirimNotifikasiPengajuan(Training training){
		
	}
	
	//TODO: send notification to deptHead and DivHead
	public void kirimNotifikasiPersetujuan(Training training){
		
	}
	
	public void tampilkanDaftarTraining(DeptHead deptHead){
		SimpleDateFormat sdf 	= new SimpleDateFormat("dd/MM/yyyy");
		
		printHeaderTraining(deptHead);
		
		for(Training training : listTraining){
			//System.out.println(lembur);
			if(training.getStaff().getDepartment().getId()==deptHead.getDepartment().getId() && training.getStatusApprovalDeptHead().equals("NEW")){
				//String.format(" ", "", lembur.getIdLembur());
				System.out.println(addPad(""+training.getId(),5) + "|" 
						+ addPad(training.getStatusApprovalDeptHead(), 7) + "|" 
						+ addPad(""+training.getStaff().getNama(),19) + "|" 
						+ addPad(sdf.format(training.getTanggalTraining()),15) + "|" 
						+ addPad(sdf.format(training.getTanggalPengajuan()),17) + "|" 
						+ addPad(training.getNama(),10) + "|" 
						+ addPad(training.getLokasi(),12));
			}
		}
	}
	
	public void tampilkanDaftarTraining(DivHead divHead){
		SimpleDateFormat sdf 	= new SimpleDateFormat("dd/MM/yyyy");
		
		printHeaderTraining(divHead);
		
		for(Training training : listTraining){
			//System.out.println(lembur);
			if(training.getStaff().getDepartment().getDivision().getId()==divHead.getDivision().getId() && training.getStatusApprovalDivHead().equals("NEW")){
				//String.format(" ", "", lembur.getIdLembur());
				System.out.println(addPad(""+training.getId(),5) + "|" 
						+ addPad(training.getStatusApprovalDeptHead(), 7) + "|" 
						+ addPad(training.getStatusApprovalDivHead(), 10) + "|"  
						+ addPad(""+training.getStaff().getNama(),19) + "|" 
						+ addPad(""+training.getStaff().getDepartment().getNama(),25) + "|" 
						+ addPad(sdf.format(training.getTanggalTraining()),15) + "|" 
						+ addPad(sdf.format(training.getTanggalPengajuan()),17) + "|" 
						+ addPad(training.getNama(),10) + "|" 
						+ addPad(training.getLokasi(),12));
			}
		}
	}
	
	private void printHeaderTraining(Staff staff){
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("History Training : " + staff.getNama());
		System.out.println("=========================================================================================================");
		System.out.println("id   |status depthead |status divhead |tanggal Training |tanggal pengajuan |nama training |lokasi        ");
		System.out.println("=========================================================================================================");
	}
	
	private void printHeaderTraining(DivHead divHead){
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("Daftar Training Division: " + divHead.getDivision().getNama());
		System.out.println("=========================================================================================================");
		System.out.println("id   |status depthead |status divhead |tanggal Training |tanggal pengajuan |nama training |lokasi        ");
		System.out.println("=========================================================================================================");
	}
	
	private void printHeaderTraining(DeptHead deptHead){
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("Daftar Training Department: " + deptHead.getDepartment().getNama());
		System.out.println("=========================================================================================================");
		System.out.println("id   |status depthead |status divhead |tanggal Training |tanggal pengajuan |nama training |lokasi        ");
		System.out.println("=========================================================================================================");
	}
	
	public void tampilkanHistoryTraining(DivHead divHead){
		SimpleDateFormat sdf 	= new SimpleDateFormat("dd/MM/yyyy");
		
		printHeaderTraining(divHead);
		
		for(Training training : listTraining){
			//System.out.println(lembur);
			if(training.getStaff().getDepartment().getDivision().getId()==divHead.getDivision().getId()){
				//String.format(" ", "", lembur.getIdLembur());
				System.out.println(addPad(""+training.getId(),5) + "|" 
						+ addPad(training.getStatusApprovalDeptHead(), 16) + "|" 
						+ addPad(training.getStatusApprovalDivHead(), 10) + "|" 
						+ addPad(""+training.getStaff().getNama(),19) + "|" 
						+ addPad(""+training.getStaff().getDepartment().getNama(),25) + "|" 
						+ addPad(sdf.format(training.getTanggalTraining()),15) + "|" 
						+ addPad(sdf.format(training.getTanggalPengajuan()),18) + "|" 
						+ addPad(training.getNama(),10) + "|" 
						+ addPad(training.getLokasi(),12));
			}
		}
	}
	
	public void tampilkanHistoryTraining(DeptHead deptHead){
		SimpleDateFormat sdf 	= new SimpleDateFormat("dd/MM/yyyy");
		
		printHeaderTraining(deptHead);
		
		for(Training training : listTraining){
			//System.out.println(lembur);
			if(training.getStaff().getDepartment().getId()==deptHead.getDepartment().getId()){
				//String.format(" ", "", lembur.getIdLembur());
				System.out.println(addPad(""+training.getId(),5) + "|" 
						+ addPad(training.getStatusApprovalDeptHead(), 7) + "|" 
						+ addPad(""+training.getStaff().getNama(),19) + "|" 
						+ addPad(sdf.format(training.getTanggalTraining()),15) + "|" 
						+ addPad(sdf.format(training.getTanggalPengajuan()),18) + "|" 
						+ addPad(training.getNama(),10) + "|" 
						+ addPad(training.getLokasi(),12));
			}
		}
	}
	
	public void tampilkanHistoryTraining(Staff staff){
		SimpleDateFormat sdf 	= new SimpleDateFormat("dd/MM/yyyy");
		
		printHeaderTraining(staff);
		
		for(Training training : listTraining){
			//System.out.println(lembur);
			if(training.getStaff().getIdPegawai()==staff.getIdPegawai()){
				//String.format(" ", "", lembur.getIdLembur());
				System.out.println(addPad(""+training.getId(),5) + "|" 
						+ addPad(training.getStatusApprovalDeptHead(), 16) + "|" 
						+ addPad(training.getStatusApprovalDivHead(), 15) + "|" 
						+ addPad(sdf.format(training.getTanggalTraining()),17) + "|" 
						+ addPad(sdf.format(training.getTanggalPengajuan()),18) + "|" 
						+ addPad(training.getNama(),10) + "|" 
						+ addPad(training.getLokasi(),12));
			}
		}
	}
	
	public Training cariTrainingMenurutId(Staff staff,int id){
		for(Training training : listTraining){
			if(training.getStaff().getIdPegawai()==staff.getIdPegawai() && training.getId()==id){
				return training;
			}
		}
		return null;
	}
	
	public Training cariTrainingMenurutId(DeptHead deptHead,int id){
		for(Training training : listTraining){
			if(training.getStaff().getDepartment().getDeptHead()==deptHead && training.getId()==id){
				return training;
			}
		}
		return null;
	}
	
	public Training cariTrainingMenurutId(DivHead divHead,int id){
		for(Training training : listTraining){
			if(training.getStaff().getDepartment().getDivision().getDivHead()==divHead && training.getId()==id){
				return training;
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
