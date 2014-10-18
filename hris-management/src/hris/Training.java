package hris;

import java.io.Serializable;
import java.util.Date;

public class Training extends Aktifitas implements Serializable{
	private static final long serialVersionUID = 6065372923837501201L;
	private String nama;
	private String lokasi;
	private Date tanggalTraining;
	
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
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
	
	
}
