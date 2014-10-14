import java.io.Serializable;
import java.util.Date;


public class Lembur implements Serializable{
	private static final long serialVersionUID = -2826958021280897727L;
	
	private int idLembur;
	private Date tanggalPengajuan;
	private Date jamMulai;
	private Date jamSelesai;
	private String keterangan;
	private Staff staff;
	
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
	

}
