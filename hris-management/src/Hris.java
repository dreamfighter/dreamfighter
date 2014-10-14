import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Hris implements Serializable{
	private static final long serialVersionUID = 6313470848522073042L;
	public static final String NEW = "NEW";
	private List<Division> listDivision;
	private List<Pegawai> listPegawai = new ArrayList<Pegawai>();
	private List<Lembur> listLembur = new ArrayList<Lembur>();	

	public List<Pegawai> getListPegawai() {
		return listPegawai;
	}

	public void setListPegawai(List<Pegawai> listPegawai) {
		this.listPegawai = listPegawai;
	}
	
	public Pegawai getPegawaiById(int id){
		for (int i = 0; i < listPegawai.size(); i++) {
			if(listPegawai.get(i).getIdPegawai()==id){
				return listPegawai.get(i);
			}
		}
		return null;
	}
	
	public void addPegawai(Pegawai pegawai){
		listPegawai.add(pegawai);
	}

	public List<Division> getListDivision() {
		return listDivision;
	}

	public void setListDivision(List<Division> listDivision) {
		this.listDivision = listDivision;
	}
	
	public void ajukanLembur(Staff staff, Date tanggalLembur, Date jamMulai, Date jamSelesai, String keterangan, String status){
		Lembur lembur = new Lembur();
		lembur.setIdLembur(listLembur.size()+1);
		lembur.setTanggalPengajuan(new Date());
		lembur.setTanggalLembur(tanggalLembur);
		lembur.setJamMulai(jamMulai);
		lembur.setJamSelesai(jamSelesai);
		lembur.setKeterangan(keterangan);
		lembur.setStaff(staff);
		lembur.setStatus(status);
		
		this.listLembur.add(lembur);
	}
	
	public List<Lembur> getListLembur() {
		return listLembur;
	}
	
	public void setListLembur(List<Lembur> listLembur) {
		this.listLembur = listLembur;
	}
	
	public void printHistoryLembur(Staff staff){
		SimpleDateFormat sdf 	= new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdfTime= new SimpleDateFormat("hh.mm");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("History Lembur : " + staff.getNama());
		System.out.println("===================================================================================");
		System.out.println("id   |status |tanggal lembur |tanggal pengajuan |jam mulai |jam selesai |keterangan ");
		System.out.println("===================================================================================");
		for(Lembur lembur : listLembur){
			//System.out.println(lembur);
			if(lembur.getStaff().getIdPegawai()==staff.getIdPegawai()){
				//String.format(" ", "", lembur.getIdLembur());
				System.out.println(addPad(""+lembur.getIdLembur(),5) + "|" + addPad(lembur.getStatus(), 7) + "|" + addPad(sdf.format(lembur.getTanggalLembur()),15) + "|" + addPad(sdf.format(lembur.getTanggalPengajuan()),18) + "|" + addPad(sdfTime.format(lembur.getJamMulai()),10) + "|" + addPad(sdfTime.format(lembur.getJamSelesai()),12) + "|" + lembur.getKeterangan());
			}
		}
	}
	
	public Lembur getLemburByStaffAndId(Staff staff,int id){
		for(Lembur lembur : listLembur){
			if(lembur.getStaff().getIdPegawai()==staff.getIdPegawai() && lembur.getIdLembur()==id){
				return lembur;
			}
		}
		return null;
	}
	
	public String addPad(String str,int number){
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<number;i++){
			if(str.length()>i){
				sb.append(str.charAt(i));
			}else{
				sb.append(" ");
			}
		}
		return sb.toString();
	}
}
