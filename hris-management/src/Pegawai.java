import java.io.Serializable;


public class Pegawai implements Serializable{
	private int idPegawai;
	private String nama;
	private String alamat;
	private String tlp;
	
	public int getIdPegawai() {
		return idPegawai;
	}
	public void setIdPegawai(int idPegawai) {
		this.idPegawai = idPegawai;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	public String getTlp() {
		return tlp;
	}
	public void setTlp(String tlp) {
		this.tlp = tlp;
	}
}
