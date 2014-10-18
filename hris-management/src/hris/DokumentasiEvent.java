package hris;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DokumentasiEvent implements Serializable{
	private static final long serialVersionUID = 814203895978227085L;
	private String laporan;
	private List<String> listFoto = new ArrayList<String>();
	public String getLaporan() {
		return laporan;
	}
	public void setLaporan(String laporan) {
		this.laporan = laporan;
	}
	public List<String> getListFoto() {
		return listFoto;
	}
	public void setListFoto(List<String> listFoto) {
		this.listFoto = listFoto;
	}
}
