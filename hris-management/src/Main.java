import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
	//private static ListPegawai listPegawai 			= new ListPegawai();
	private static Hris hris 	= new Hris();
	//private static KelolaLembur kelolaLembur 		= new KelolaLembur();
	
	private static BufferedReader reader;
	
	public static void main(String[] args) {
		readDataHris();
		System.out.println("Login Staff");
		try {
			reader = new BufferedReader(new InputStreamReader(
					System.in));
			
			System.out.print("Masukkan id       : ");
			int id = Integer.parseInt(reader.readLine());
			System.out.print("Masukkan password : ");
			reader.readLine();
			clearConsole();
			
			Pegawai pegawai = hris.getPegawaiById(id); 
			if(pegawai==null){
				System.out.println("Selamat Datang di System Management Lembur");
				System.out.println("Maaf Data Pegawai Anda tidak ditemukan silahkan daftarkan diri anda");
				System.out.print("Silahkan Pilih Department : ");
				System.out.print("Masukkan id      :");
				int idPegawai = Integer.parseInt(reader.readLine());
				System.out.print("Masukkan nama    :");
				String nama = reader.readLine();
				System.out.print("Masukkan alamat  :");
				String alamat = reader.readLine();
				System.out.print("Masukkan no. tlp :");
				String tlp = reader.readLine();
				pegawai = new Staff();
				pegawai.setIdPegawai(idPegawai);
				pegawai.setNama(nama);
				pegawai.setAlamat(alamat);
				pegawai.setTlp(tlp);
				hris.addPegawai(pegawai);
				writeDataHris();
			}else{
				String menu = "";
				
				System.out.println("");
				System.out.println("");
				System.out.println("Selamat Datang di System Management Lembur");
				System.out.println("id pegawai : " + pegawai.getIdPegawai());
				System.out.println("nama       : " + pegawai.getNama());
				System.out.println("alamat     : " + pegawai.getAlamat());
				System.out.println("No tlp     : " + pegawai.getTlp());
				
				if(pegawai instanceof Staff){
					do{
						System.out.println("");
						System.out.println("");
						System.out.println("");
						System.out.println("1.Ajukan Lembur");
						System.out.println("2.Lihat History lembur");
						System.out.println("3.Lihat Status lembur");
						System.out.println("exit");
						System.out.print("Silahkan Pilih Menu:");
						menu = reader.readLine();
						
						if(menu.equals("1")){
							menuAjukanLembur((Staff)pegawai);
						}else if(menu.equals("2")){
							hris.printHistoryLembur((Staff)pegawai);
						}else if(menu.equals("3")){
							menuStatusLembur((Staff)pegawai);
						}
						
					}while(!menu.equals("exit"));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void menuAjukanLembur(Staff staff) throws IOException{
		System.out.println("Anda akan mengajukan Lembur");
		System.out.print("Masukkan tanggal Lembur dd/mm/yyyy : ");
		String tanggalLemburStr = reader.readLine();
		System.out.print("Masukkan jam Mulai Lembur hh.mm    : ");
		String jamMulaiLemburStr = reader.readLine();
		System.out.print("Masukkan jam Selesai Lembur hh.mm  : ");
		String jamSelesaiLemburStr = reader.readLine();
		System.out.println("Masukkan Keterangan Lembur         : ");
		String keterangan = reader.readLine();
		
		jamSelesaiLemburStr 	= tanggalLemburStr + " " + jamSelesaiLemburStr;
		tanggalLemburStr 		= tanggalLemburStr + " " + jamMulaiLemburStr;
		SimpleDateFormat sdf 	= new SimpleDateFormat("dd/MM/yyyy hh.mm");
		
		try {
			hris.ajukanLembur(staff, sdf.parse(tanggalLemburStr), sdf.parse(tanggalLemburStr), sdf.parse(jamSelesaiLemburStr), keterangan, Hris.NEW);
			writeDataHris();
			System.out.println("saving....");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public static void menuStatusLembur(Staff staff) throws IOException{
		System.out.println("Anda akan melihat status Lembur");
		System.out.print("Masukkan id Lembur anda :");
		String idLemburStr = reader.readLine();
		System.out.println("");
		System.out.println("");
		
		Lembur lembur = hris.getLemburByStaffAndId(staff,Integer.parseInt(idLemburStr));
		
		if(lembur==null){
			System.out.println("Maaf Data Lembur Anda tidak ditemukan!");
		}else{
			System.out.println("Status Lembur anda adalah : "+lembur.getStatus());
		}
		
	}
	
	public static void readDataHris(){
		try{
			FileInputStream door = new FileInputStream("hris.dat"); 
			ObjectInputStream reader = new ObjectInputStream(door); 
			hris = (Hris) reader.readObject();
			reader.close();
		}catch (IOException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeDataHris(){
			// Serialize data object to a file
			try {
				ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("hris.dat"));
				out.writeObject(hris);
				out.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
	}

	public final static void clearConsole() {
		try {
			final String os = System.getProperty("os.name");
			Runtime.getRuntime().exec("clear");
			System.out.print('\u000C');
			if (os.contains("Windows")) {
				Runtime.getRuntime().exec("cls");
			} else {
				Runtime.getRuntime().exec("clear");
			}
		} catch (final Exception e) {
			// Handle any exceptions.
			e.printStackTrace();
		}
	}
}
