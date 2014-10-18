package hris;

import java.io.Serializable;
import java.util.Date;

public class Aktifitas implements Serializable{
	private static final long serialVersionUID = 6628380625273781492L;
	private int id;
	private Date tanggalPengajuan;
	private Staff staff;
	private String statusApprovalDeptHead;
	private String statusApprovalDivHead;
	private DivHead approvedDivHeadBy;
	private Date approvadDivHeadOn;
	private DeptHead approvedDeptHeadBy;
	private Date approvadDeptHeadOn;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getTanggalPengajuan() {
		return tanggalPengajuan;
	}
	public void setTanggalPengajuan(Date tanggalPengajuan) {
		this.tanggalPengajuan = tanggalPengajuan;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
