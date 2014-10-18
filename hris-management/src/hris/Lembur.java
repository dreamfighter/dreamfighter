package hris;
import java.io.Serializable;
import java.util.Date;


public class Lembur extends Aktifitas implements Serializable{
	private static final long serialVersionUID = -2826958021280897727L;
	
	private Date tanggalLembur;
	private Date jamMulai;
	private Date jamSelesai;
	private String keterangan;
	
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
	

}
