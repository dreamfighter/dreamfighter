import java.io.Serializable;


public class Pegawai implements Serializable{
	private static final long serialVersionUID = -6137353195365892063L;
	private int idPegawai;
	private String nama;
	private String alamat;
	private String tlp;
	private String email;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
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
