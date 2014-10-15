import java.io.Serializable;
import java.util.Date;


public class Lembur implements Serializable{
	private static final long serialVersionUID = -2826958021280897727L;
	
	private int idLembur;
	private Date tanggalLembur;
	private Date tanggalPengajuan;
	private Date jamMulai;
	private Date jamSelesai;
	private String keterangan;
	private Staff staff;
	private String statusApprovalDeptHead;
	private String statusApprovalDivHead;
	private DivHead approvedDivHeadBy;
	private Date approvadDivHeadOn;
	private DeptHead approvedDeptHeadBy;
	private Date approvadDeptHeadOn;
	
	public int getIdLembur() {
		return idLembur;
	}
	public void setIdLembur(int idLembur) {
		this.idLembur = idLembur;
	}
	public Date getTanggalPengajuan() {
		return tanggalPengajuan;
	}
	public void setTanggalPengajuan(Date tanggalPengajuan) {
		this.tanggalPengajuan = tanggalPengajuan;
	}
	public Date getTanggalLembur() {
		return tanggalLembur;
	}
	public void setTanggalLembur(Date tanggalLembur) {
		this.tanggalLembur = tanggalLembur;
	}
	public Date getJamMulai() {
		return jamMulai;
	}
	public void setJamMulai(Date jamMulai) {
		this.jamMulai = jamMulai;
	}
	public Date getJamSelesai() {
		return jamSelesai;
	}
	public void setJamSelesai(Date jamSelesai) {
		this.jamSelesai = jamSelesai;
	}
	public String getKeterangan() {
		return keterangan;
	}
	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
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
	

}
