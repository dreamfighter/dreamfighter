import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
	private static ListPegawai listPegawai = new ListPegawai();
	private static KelolaLembur kelolaLembur = new KelolaLembur();
	
	private static BufferedReader reader;
	
	public static void main(String[] args) {
		readDataPegawai();
		System.out.println("Login Staff");
		try {
			reader = new BufferedReader(new InputStreamReader(
					System.in));
			
			System.out.print("Masukkan id:");
			int id = Integer.parseInt(reader.readLine());
			System.out.print("Masukkan password:");
			reader.readLine();
			clearConsole();
			
			Staff staff = listPegawai.getPegawaiById(id); 
			if(staff==null){
				System.out.println("Selamat Datang di System Management Lembur");
				System.out.println("Maaf Data Pegawai Anda tidak ditemukan silahkan daftarkan diri anda");
				System.out.print("Masukkan id:");
				int idPegawai = Integer.parseInt(reader.readLine());
				System.out.print("Masukkan nama:");
				String nama = reader.readLine();
				System.out.print("Masukkan alamat:");
				String alamat = reader.readLine();
				System.out.print("Masukkan no. tlp:");
				String tlp = reader.readLine();
				staff = new Staff();
				staff.setIdPegawai(idPegawai);
				staff.setNama(nama);
				staff.setAlamat(alamat);
				staff.setTlp(tlp);
				listPegawai.addPegawai(staff);
				writeDataPegawai();
			}else{
				String menu = "";
				do{
					System.out.println("Selamat Datang di System Management Lembur");
					System.out.println("id pegawai anda adalah " + staff.getIdPegawai());
					System.out.println("nama anda adalah " + staff.getNama());
					System.out.println("alamat anda adalah " + staff.getAlamat());
					System.out.println("No tlp anda adalah " + staff.getTlp());
					System.out.println("");
					System.out.println("1.Ajukan Lembur");
					System.out.println("2.Lihat History lembur");
					System.out.println("3.Lihat Status lembur");
					System.out.println("exit");
					System.out.print("Silahkan Pilih Menu:");
					menu = reader.readLine();
					
					if(menu.equals("1")){
						
					}
					
				}while(!menu.equals("exit"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void menuAjukanLembur(Staff staff) throws IOException{
		System.out.println("Anda akan mengajukan Lembur");
		System.out.print("Masukkan tanggal Lembur");
		String tanggalLemburStr = reader.readLine();
		System.out.print("Masukkan jam Mulai Lembur");
		String jamMulaiLemburStr = reader.readLine();
		System.out.print("Masukkan jam Selesai Lembur");
		String jamSelesaiLemburStr = reader.readLine();
		System.out.print("Masukkan Keterangan Lembur");
		String keterangan = reader.readLine();
	}
	
	public static void readDataPegawai(){
		try{
			FileInputStream door = new FileInputStream("pegawai.peg"); 
			ObjectInputStream reader = new ObjectInputStream(door); 
			listPegawai = new ListPegawai(); 
			listPegawai = (ListPegawai) reader.readObject();
			reader.close();
		}catch (IOException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeDataPegawai(){
			// Serialize data object to a file
			try {
				ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("pegawai.peg"));
				out.writeObject(listPegawai);
				out.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
	}
	
	public static void readDataLembur(){
		try{
			FileInputStream door = new FileInputStream("lembur.lem"); 
			ObjectInputStream reader = new ObjectInputStream(door); 
			kelolaLembur = (KelolaLembur) reader.readObject();
			reader.close();
		}catch (IOException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeDataLembur(){
			// Serialize data object to a file
			try {
				ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("lembur.lem"));
				out.writeObject(kelolaLembur);
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
