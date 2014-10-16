package hris;

import java.util.Date;

public class Training {
	private int idTraining;
	private String nama;
	private String lokasi;
	private Date tanggalTraining;
	private Date tanggalPengajuan;
	
	private Staff staff;
	private String statusApprovalDeptHead;
	private String statusApprovalDivHead;
	private DivHead approvedDivHeadBy;
	private Date approvadDivHeadOn;
	private DeptHead approvedDeptHeadBy;
	private Date approvadDeptHeadOn;
	public int getIdTraining() {
		return idTraining;
	}
	public void setIdTraining(int idTraining) {
		this.idTraining = idTraining;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	public String getStatusApprovalDeptHead() {
		return statusApprovalDeptHead;
	}
	public void setStatusApprovalDeptHead(String statusApprovalDeptHead) {
		this.statusApprovalDeptHead = statusApprovalDeptHead;
	}
	public String getStatusApprovalDivHead() {
		return statusApprovalDivHead;
	}
	public void setStatusApprovalDivHead(String statusApprovalDivHead) {
		this.statusApprovalDivHead = statusApprovalDivHead;
	}
	public DivHead getApprovedDivHeadBy() {
		return approvedDivHeadBy;
	}
	public void setApprovedDivHeadBy(DivHead approvedDivHeadBy) {
		this.approvedDivHeadBy = approvedDivHeadBy;
	}
	public Date getApprovadDivHeadOn() {
		return approvadDivHeadOn;
	}
	public void setApprovadDivHeadOn(Date approvadDivHeadOn) {
		this.approvadDivHeadOn = approvadDivHeadOn;
	}
	public DeptHead getApprovedDeptHeadBy() {
		return approvedDeptHeadBy;
	}
	public void setApprovedDeptHeadBy(DeptHead approvedDeptHeadBy) {
		this.approvedDeptHeadBy = approvedDeptHeadBy;
	}
	public Date getApprovadDeptHeadOn() {
		return approvadDeptHeadOn;
	}
	public void setApprovadDeptHeadOn(Date approvadDeptHeadOn) {
		this.approvadDeptHeadOn = approvadDeptHeadOn;
	}
	public String getLokasi() {
		return lokasi;
	}
	public void setLokasi(String lokasi) {
		this.lokasi = lokasi;
	}
	public Date getTanggalTraining() {
		return tanggalTraining;
	}
	public void setTanggalTraining(Date tanggalTraining) {
		this.tanggalTraining = tanggalTraining;
	}
	public Date getTanggalPengajuan() {
		return tanggalPengajuan;
	}
	public void setTanggalPengajuan(Date tanggalPengajuan) {
		this.tanggalPengajuan = tanggalPengajuan;
	}
	
	
}
