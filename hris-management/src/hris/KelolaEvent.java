package hris;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KelolaEvent implements Serializable{
	private static final long serialVersionUID = 5609186821408372327L;
	private List<GroupEvent> groupsEvent = new ArrayList<GroupEvent>();
	private List<Event> events = new ArrayList<Event>();
	
	public void tambahEvent(String nama, String lokasi,Date tanggalMulai, Date tanggalSelesai, String deskipsi){
		Event event = new Event();
		event.setDeskripsi(deskipsi);
		event.setLokasi(lokasi);
		event.setNama(nama);
		event.setTanggalMulai(tanggalMulai);
		event.setTanggalSelesai(tanggalSelesai);
		events.add(event);
	}
	
	public void ubahEvent(Event event,String nama, String lokasi,Date tanggalMulai, Date tanggalSelesai, String deskipsi){
		event.setDeskripsi(deskipsi);
		event.setLokasi(lokasi);
		event.setNama(nama);
		event.setTanggalMulai(tanggalMulai);
		event.setTanggalSelesai(tanggalSelesai);
	}
	
	public void daftarEvent(Event event,Pegawai pegawai){
		event.tambahPeserta(pegawai);
	}
	
	public void kirimNotifikasi(Event event,Department department){
		GroupEvent groupEvent = new GroupEvent();
		groupEvent.getDepartments().add(department);
		groupEvent.setEvent(event);
		groupsEvent.add(groupEvent);
		//TODO: send notifikasi event
	}
	
	public void kirimNotifikasiUpdate(Event event){
		for(GroupEvent groups:groupsEvent){
			if(groups.getEvent().equals(event)){
				//TODO: send notifikasi update
			}
		}
	}
	
	public void rekapPesertaEvent(Event event){
		printHeaderPegawai(event);
		for(Pegawai pegawai:event.getPeserta()){
			System.out.println(
					addPad(""+pegawai.getIdPegawai(),5) + "|" + 
					addPad(pegawai.getNama(), 19) + "|" + 
					addPad(pegawai.getNama(), 26) + "|" + 
					addPad(pegawai.getNama(), 26) + "|" +
					addPad(pegawai.getEmail(),35) + "|" + 
					addPad(pegawai.getTlp(),18) + "|" + 
					addPad(pegawai.getAlamat(),54)
					);
		}
	}
	
	public void tampilkanEvent(){
		SimpleDateFormat sdf 	= new SimpleDateFormat("dd/MM/yyyy");
		printHeaderEvent();
		for(Event event:events){
			System.out.println(
					addPad(""+event.getId(), 5) + "|" +
					addPad(event.getNama(), 25) + "|" +
					addPad(sdf.format(event.getTanggalMulai()), 14) + "|" + 
					addPad(sdf.format(event.getTanggalMulai()), 16) + "|" + 
					addPad(event.getLokasi(), 14) + "|" +
					addPad(event.getDeskripsi(), 14) + "|"
					);
		}
	}
	
	//TODO: tampilkan dokumentasi
	public void tampilkanDokumentasi(Event event){
		//SimpleDateFormat sdf 	= new SimpleDateFormat("dd/MM/yyyy");
		
		event.getDokumentasi();
	}
	
	private void printHeaderEvent(){
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("Daftar Events");
		System.out.println("=========================================================================================================");
		System.out.println("id   |nama event               |tanggal mulai |tanggal selesai |lokasi        |deskripsi                                      ");
		System.out.println("=========================================================================================================");
	}
	

	
	private void printHeaderPegawai(Event event){
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("Daftar Peserta Event: " + event.getNama());
		System.out.println("=============================================================================================================================================================================================");
		System.out.println("id   |nama staff         |division                  |department                |email                              |no. tlp           |alamat                                                ");
		System.out.println("=============================================================================================================================================================================================");
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}
	
	private String addPad(String str,int number){
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
