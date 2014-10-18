package hris;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Event implements Serializable{
	private static final long serialVersionUID = 3138238580455269145L;
	private int id;
	private String nama;
	private String lokasi;
	private Date tanggalMulai;
	private Date tanggalSelesai;
	private String deskripsi;
	private List<Pegawai> peserta = new ArrayList<Pegawai>();
	private DokumentasiEvent dokumentasi;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public Date getTanggalMulai() {
		return tanggalMulai;
	}
	public void setTanggalMulai(Date tanggalMulai) {
		this.tanggalMulai = tanggalMulai;
	}
	public Date getTanggalSelesai() {
		return tanggalSelesai;
	}
	public void setTanggalSelesai(Date tanggalSelesai) {
		this.tanggalSelesai = tanggalSelesai;
	}
	public String getDeskripsi() {
		return deskripsi;
	}
	public void setDeskripsi(String deskripsi) {
		this.deskripsi = deskripsi;
	}
	public List<Pegawai> getPeserta() {
		return peserta;
	}
	public void tambahPeserta(Pegawai pegawai) {
		this.peserta.add(pegawai);
	}
	public DokumentasiEvent getDokumentasi() {
		return dokumentasi;
	}
	public void setDokumentasi(DokumentasiEvent dokumentasi) {
		this.dokumentasi = dokumentasi;
	}
	public void setPeserta(List<Pegawai> peserta) {
		this.peserta = peserta;
	}

}
