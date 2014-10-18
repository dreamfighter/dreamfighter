package hris;
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
	private static Hris hris 	= new Hris();
	
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

				System.out.print("Silahkan Pilih Department ID : ");
				int idDept = Integer.parseInt(reader.readLine());
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
				hris.tambahPegawai(pegawai);
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
				System.out.println("email      : " + pegawai.getEmail());
				System.out.println("jabatan    : " + ((pegawai instanceof Staff) ? "Staff" : ((pegawai instanceof DeptHead) ? "DeptHead" : "DivHead")));
				System.out.println("division   : " + ((pegawai instanceof DivHead) ? ((DivHead)pegawai).getDivision().getNama() : hris.getDepartmentByPegawai(pegawai).getDivision().getNama()));
				System.out.println("department : " + ((pegawai instanceof DivHead) ? "" : hris.getDepartmentByPegawai(pegawai).getNama()));
				
				if(pegawai instanceof Staff){
					do{
						System.out.println("");
						System.out.println("");
						System.out.println("");
						System.out.println("1.Ajukan Lembur");
						System.out.println("2.Lihat History lembur");
						System.out.println("3.Lihat Status lembur");
						System.out.println("4.Ajukan Training");
						System.out.println("5.Lihat History Training");
						System.out.println("6.Lihat Status Training");
						System.out.println("7.Lihat Event");
						System.out.println("8.Daftar Event");
						if(hris.isHrd(pegawai)){
							System.out.println("9.Tambah Event");
						}
												
						System.out.println("exit");
						System.out.print("Silahkan Pilih Menu:");
						menu = reader.readLine();
						
						if(menu.equals("1")){
							menuAjukanLembur((Staff)pegawai);
						}else if(menu.equals("2")){
							hris.getKelolaLembur().tampilkanHistoryLembur((Staff)pegawai);
						}else if(menu.equals("3")){
							menuStatusLembur((Staff)pegawai);
						}else if(menu.equals("4")){
							menuAjukanTraining((Staff)pegawai);
						}else if(menu.equals("5")){
							hris.getKelolaTraining().tampilkanHistoryTraining((Staff)pegawai);
						}else if(menu.equals("6")){
							menuStatusTraining((Staff)pegawai);
						}else if(menu.equals("7")){
							hris.getKelolaEvent().tampilkanEvent();
						}else if(menu.equals("8")){
							//menuStatusTraining((Staff)pegawai);
						}else if(menu.equals("9") && hris.isHrd(pegawai)){
							//menuStatusTraining((Staff)pegawai);
						}
						
					}while(!menu.equals("exit"));
				}else if(pegawai instanceof DeptHead){
					do{
						System.out.println("");
						System.out.println("");
						System.out.println("");
						System.out.println("1.Approve/Reject Lembur");
						System.out.println("2.Lihat Daftar Staff");
						System.out.println("3.Lihat Daftar Lembur");
						System.out.println("4.Lihat Daftar History Lembur");
						System.out.println("5.Approve/Reject Training");
						System.out.println("6.Lihat Daftar Training");
						System.out.println("7.Lihat Daftar History Training");
						System.out.println("8.Lihat Event");
						System.out.println("9.Daftar Event");
						System.out.println("exit");
						System.out.print("Silahkan Pilih Menu:");
						menu = reader.readLine();
						
						if(menu.equals("1")){
							menuApproveRejectLembur((DeptHead)pegawai);
						}else if(menu.equals("2")){
							hris.tampilkanDaftarStaff(((DeptHead)pegawai).getDepartment());
						}else if(menu.equals("3")){
							hris.getKelolaLembur().tampilkanDaftarLembur((DeptHead)pegawai);
						}else if(menu.equals("4")){
							hris.getKelolaLembur().tampilkanHistoryLembur((DeptHead)pegawai);
						}else if(menu.equals("5")){
							menuApproveRejectTraining((DeptHead)pegawai);
						}else if(menu.equals("6")){
							hris.getKelolaTraining().tampilkanDaftarTraining((DeptHead)pegawai);
						}else if(menu.equals("7")){
							hris.getKelolaTraining().tampilkanHistoryTraining((DeptHead)pegawai);
						}
						
					}while(!menu.equals("exit"));
				}else if(pegawai instanceof DivHead){
					do{
						System.out.println("");
						System.out.println("");
						System.out.println("");
						System.out.println("1.Approve/Reject Lembur");
						System.out.println("2.Lihat Daftar Staff");
						System.out.println("3.Lihat Daftar Lembur");
						System.out.println("4.Lihat Daftar History Lembur");
						System.out.println("5.Approve/Reject Training");
						System.out.println("6.Lihat Daftar Training");
						System.out.println("7.Lihat Daftar History Training");
						System.out.println("8.Lihat Event");
						System.out.println("9.Daftar Event");
						System.out.println("exit");
						System.out.print("Silahkan Pilih Menu:");
						menu = reader.readLine();
						
						if(menu.equals("1")){
							menuApproveRejectLembur((DivHead)pegawai);
						}else if(menu.equals("2")){
							hris.tampilkanDaftarStaff(((DivHead)pegawai).getDivision());
						}else if(menu.equals("3")){
							hris.getKelolaLembur().tampilkanDaftarLembur((DivHead)pegawai);
						}else if(menu.equals("4")){
							hris.getKelolaLembur().tampilkanHistoryLembur((DivHead)pegawai);
						}else if(menu.equals("5")){
							menuApproveRejectTraining((DivHead)pegawai);
						}else if(menu.equals("6")){
							hris.getKelolaTraining().tampilkanDaftarTraining((DivHead)pegawai);
						}else if(menu.equals("7")){
							hris.getKelolaTraining().tampilkanHistoryTraining((DivHead)pegawai);
						}
						
					}while(!menu.equals("exit"));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void menuApproveRejectLembur(DeptHead deptHead) throws IOException{
		hris.getKelolaLembur().tampilkanDaftarLembur(deptHead);
		System.out.println("");
		System.out.println("");
		System.out.println("Anda akan melakukan approval Lembur");
		System.out.print("Masukkan id lembur yang akan di approve/reject : ");
		String idLemburStr = reader.readLine();
		
		Lembur lembur = hris.getKelolaLembur().cariLemburMenurutId(deptHead, Integer.parseInt(idLemburStr));
		
		System.out.println("");
		System.out.println("");
		
		if(lembur==null){
			System.out.println("Maaf Data Lembur tidak ditemukan!");
		}else{

			SimpleDateFormat sdf 	= new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat sdfJam = new SimpleDateFormat("hh.mm");
			
			System.out.println("Data Lembur Staff adalah sebagai berikut : ");
			System.out.println("id pegawai         : " + lembur.getStaff().getIdPegawai());
			System.out.println("nama               : " + lembur.getStaff().getNama());
			System.out.println("tanggal pengajuan  : " + sdf.format(lembur.getTanggalPengajuan()));
			System.out.println("tanggal lembur     : " + sdf.format(lembur.getTanggalLembur()));
			System.out.println("jam mulai          : " + sdfJam.format(lembur.getJamMulai()));
			System.out.println("jam selesai        : " + sdfJam.format(lembur.getJamSelesai()));
			System.out.println("keterangan         : " + lembur.getKeterangan());
		}
		
		System.out.println("");
		System.out.println("");
		System.out.println("pilih 1 untuk approve     ");
		System.out.println("pilih 2 untuk reject      ");
		System.out.print("pilih : ");
		String pilihStr = reader.readLine();
		if(pilihStr.equals("1")){
			hris.approve(deptHead, lembur);
		}else if(pilihStr.equals("2")){
			hris.reject(deptHead, lembur);
		}
		writeDataHris();
		
	}
	
	public static void menuApproveRejectTraining(DeptHead deptHead) throws IOException{
		hris.getKelolaTraining().tampilkanDaftarTraining(deptHead);
		System.out.println("");
		System.out.println("");
		System.out.println("Anda akan melakukan approval Training");
		System.out.print("Masukkan id training yang akan di approve/reject : ");
		String idLemburStr = reader.readLine();
		
		Training training = hris.getKelolaTraining().cariTrainingMenurutId(deptHead, Integer.parseInt(idLemburStr));
		
		System.out.println("");
		System.out.println("");
		
		if(training==null){
			System.out.println("Maaf Data Training tidak ditemukan!");
		}else{

			SimpleDateFormat sdf 	= new SimpleDateFormat("dd/MM/yyyy");
			
			System.out.println("Data Training Staff adalah sebagai berikut : ");
			System.out.println("id pegawai         : " + training.getStaff().getIdPegawai());
			System.out.println("nama pegawai       : " + training.getStaff().getNama());
			System.out.println("tanggal pengajuan  : " + sdf.format(training.getTanggalPengajuan()));
			System.out.println("tanggal training   : " + sdf.format(training.getTanggalTraining()));
			System.out.println("nama training      : " + training.getNama());
			System.out.println("lokasi training    : " + training.getLokasi());
			
		}
		
		System.out.println("");
		System.out.println("");
		System.out.println("pilih 1 untuk approve     ");
		System.out.println("pilih 2 untuk reject      ");
		System.out.print("pilih : ");
		String pilihStr = reader.readLine();
		if(pilihStr.equals("1")){
			hris.approve(deptHead, training);
		}else if(pilihStr.equals("2")){
			hris.reject(deptHead, training);
		}
		writeDataHris();
		
	}
	
	public static void menuApproveRejectTraining(DivHead divHead) throws IOException{
		hris.getKelolaTraining().tampilkanDaftarTraining(divHead);
		System.out.println("");
		System.out.println("");
		System.out.println("Anda akan melakukan approval Training");
		System.out.print("Masukkan id training yang akan di approve/reject : ");
		String idTrainingStr = reader.readLine();
		
		Training training = hris.getKelolaTraining().cariTrainingMenurutId(divHead, Integer.parseInt(idTrainingStr));
		
		System.out.println("");
		System.out.println("");
		
		if(training==null){
			System.out.println("Maaf Data Training tidak ditemukan!");
		}else{

			SimpleDateFormat sdf 	= new SimpleDateFormat("dd/MM/yyyy");
			
			System.out.println("Data Training Staff adalah sebagai berikut : ");
			System.out.println("id pegawai         : " + training.getStaff().getIdPegawai());
			System.out.println("nama               : " + training.getStaff().getNama());
			System.out.println("tanggal pengajuan  : " + sdf.format(training.getTanggalPengajuan()));
			System.out.println("tanggal lembur     : " + sdf.format(training.getTanggalTraining()));
			System.out.println("nama training      : " + training.getNama());
			System.out.println("nama lokasi        : " + training.getLokasi());
			System.out.println("approval depthead  : " + training.getStatusApprovalDeptHead());
		}
		
		System.out.println("");
		System.out.println("");
		System.out.println("pilih 1 untuk approve     ");
		System.out.println("pilih 2 untuk reject      ");
		System.out.print("pilih : ");
		String pilihStr = reader.readLine();
		if(pilihStr.equals("1")){
			hris.approve(divHead, training);
		}else if(pilihStr.equals("2")){
			hris.reject(divHead, training);
		}
		writeDataHris();
		
	}
	
	public static void menuApproveRejectLembur(DivHead divHead) throws IOException{
		hris.getKelolaLembur().tampilkanDaftarLembur(divHead);
		System.out.println("");
		System.out.println("");
		System.out.println("Anda akan melakukan approval Lembur");
		System.out.print("Masukkan id lembur yang akan di approve/reject : ");
		String idLemburStr = reader.readLine();
		
		Lembur lembur = hris.getKelolaLembur().cariLemburMenurutId(divHead, Integer.parseInt(idLemburStr));
		
		System.out.println("");
		System.out.println("");
		
		if(lembur==null){
			System.out.println("Maaf Data Lembur tidak ditemukan!");
		}else{

			SimpleDateFormat sdf 	= new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat sdfJam = new SimpleDateFormat("hh.mm");
			
			System.out.println("Data Lembur Staff adalah sebagai berikut : ");
			System.out.println("id pegawai         : " + lembur.getStaff().getIdPegawai());
			System.out.println("nama               : " + lembur.getStaff().getNama());
			System.out.println("tanggal pengajuan  : " + sdf.format(lembur.getTanggalPengajuan()));
			System.out.println("tanggal lembur     : " + sdf.format(lembur.getTanggalLembur()));
			System.out.println("jam mulai          : " + sdfJam.format(lembur.getJamMulai()));
			System.out.println("jam selesai        : " + sdfJam.format(lembur.getJamSelesai()));
			System.out.println("keterangan         : " + lembur.getKeterangan());
			System.out.println("approval depthead  : " + lembur.getStatusApprovalDeptHead());
		}
		
		System.out.println("");
		System.out.println("");
		System.out.println("pilih 1 untuk approve     ");
		System.out.println("pilih 2 untuk reject      ");
		System.out.print("pilih : ");
		String pilihStr = reader.readLine();
		if(pilihStr.equals("1")){
			hris.approve(divHead, lembur);
		}else if(pilihStr.equals("2")){
			hris.reject(divHead, lembur);
		}
		writeDataHris();
		
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
			hris.getKelolaLembur().ajukanLembur(staff, sdf.parse(tanggalLemburStr), sdf.parse(tanggalLemburStr), sdf.parse(jamSelesaiLemburStr), keterangan, Hris.NEW);
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
		
		Lembur lembur = hris.getKelolaLembur().cariLemburMenurutId(staff,Integer.parseInt(idLemburStr));
		
		if(lembur==null){
			System.out.println("Maaf Data Lembur Anda tidak ditemukan!");
		}else{
			System.out.println("Status Approval Lembur DeptHead anda adalah : "+lembur.getStatusApprovalDeptHead());
			System.out.println("Status Approval Lembur DivHead anda adalah  : "+lembur.getStatusApprovalDivHead());
		}
		
	}
	
	public static void menuAjukanTraining(Staff staff) throws IOException{
		System.out.println("Anda akan mengajukan Training");
		System.out.print("Masukkan tanggal Training dd/mm/yyyy : ");
		String tanggalTrainingStr = reader.readLine();
		System.out.print("Masukkan nama training               : ");
		String namaTraining = reader.readLine();
		System.out.print("Masukkan lokasi training             : ");
		String tempatTraining = reader.readLine();
		
		SimpleDateFormat sdf 	= new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			hris.getKelolaTraining().ajukanTraining(staff, sdf.parse(tanggalTrainingStr), tempatTraining, namaTraining, Hris.NEW);
			writeDataHris();
			System.out.println("saving....");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public static void menuStatusTraining(Staff staff) throws IOException{
		System.out.println("Anda akan melihat status Training");
		System.out.print("Masukkan id Training anda :");
		String idLemburStr = reader.readLine();
		System.out.println("");
		System.out.println("");
		
		Training training = hris.getKelolaTraining().cariTrainingMenurutId(staff,Integer.parseInt(idLemburStr));
		
		if(training==null){
			System.out.println("Maaf Data Training Anda tidak ditemukan!");
		}else{
			System.out.println("Status Approval Training DeptHead anda adalah : "+training.getStatusApprovalDeptHead());
			System.out.println("Status Approval Training DivHead anda adalah  : "+training.getStatusApprovalDivHead());
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
		if(hris==null || hris.getListDivision().isEmpty()){
			initializeData();
		}
	}
	
	public static void initializeData(){
		Division div1 = new Division();
		div1.setId(1);
		div1.setNama("Technical Officer");
		
		Department dept1 = new Department();
		dept1.setId(1);
		dept1.setNama("Interface And Development");
		dept1.setDivision(div1);

		Department dept2 = new Department();
		dept2.setId(2);
		dept2.setNama("System Integration");
		dept2.setDivision(div1);

		Department dept3 = new Department();
		dept3.setId(3);
		dept3.setNama("Test And Quality Insurance");
		dept3.setDivision(div1);
		
		div1.getListDepartment().add(dept1);
		div1.getListDepartment().add(dept2);
		div1.getListDepartment().add(dept3);
		
		Division div2 = new Division();
		div2.setId(2);
		div2.setNama("Operational Officer");
		
		Department dept4 = new Department();
		dept4.setId(4);
		dept4.setNama("Application Support");
		dept4.setDivision(div2);

		Department dept5 = new Department();
		dept5.setId(5);
		dept5.setNama("Helpdesk");
		dept5.setDivision(div2);
		
		div2.getListDepartment().add(dept4);
		div2.getListDepartment().add(dept5);

		hris.getListDivision().add(div1);
		hris.getListDivision().add(div2);
		
		DivHead divHead1 = new DivHead();
		divHead1.setDivision(div1);
		divHead1.setIdPegawai(31);
		divHead1.setNama("Aswin Budikusumo");
		divHead1.setAlamat("Jalan anggrek 1 no 28. Jakarta Selatan");
		divHead1.setTlp("088959584758");
		divHead1.setEmail("aswin.budikusumo@ggs.com");
		div1.setDivHead(divHead1);
		
		DivHead divHead2 = new DivHead();
		divHead2.setDivision(div2);
		divHead2.setIdPegawai(32);
		divHead2.setNama("Setia Aji Jaya");
		divHead2.setAlamat("Jalan ploso 1 no 21. Jakarta Barat");
		divHead2.setTlp("081959584722");
		divHead2.setEmail("setia.ajijaya@ggs.com");
		div2.setDivHead(divHead2);
		
		hris.getListPegawai().add(divHead1);
		hris.getListPegawai().add(divHead2);
		
		DeptHead deptHead1 = new DeptHead();
		deptHead1.setIdPegawai(21);
		deptHead1.setDepartment(dept1);
		deptHead1.setNama("Bayu Aji");
		deptHead1.setAlamat("Jln. Pesanggrahan blok J2 Jakarta Timur");
		deptHead1.setTlp("058622175848");
		deptHead1.setEmail("bayu.aji@ggs.com");
		dept1.setDeptHead(deptHead1);
		
		DeptHead deptHead2 = new DeptHead();
		deptHead2.setIdPegawai(22);
		deptHead2.setDepartment(dept2);
		deptHead2.setNama("Adi Nugraha");
		deptHead2.setAlamat("Jln. Depok 1 blok J2 Depok");
		deptHead2.setTlp("058622345848");
		deptHead2.setEmail("adi.nugraha@ggs.com");
		dept2.setDeptHead(deptHead2);
		
		DeptHead deptHead3 = new DeptHead();
		deptHead3.setIdPegawai(23);
		deptHead3.setDepartment(dept3);
		deptHead3.setNama("Asma Wati");
		deptHead3.setAlamat("Jln. panghegar 1 Bandung");
		deptHead3.setTlp("058621155848");
		deptHead3.setEmail("asma.wati@ggs.com");
		dept3.setDeptHead(deptHead3);
		
		DeptHead deptHead4 = new DeptHead();
		deptHead4.setIdPegawai(24);
		deptHead4.setDepartment(dept4);
		deptHead4.setNama("Prayogi");
		deptHead4.setAlamat("Jln. Akusuka kamuasma no 1000x");
		deptHead4.setTlp("081514541545");
		deptHead4.setEmail("prayogi@ggs.com");
		dept4.setDeptHead(deptHead4);
		
		DeptHead deptHead5 = new DeptHead();
		deptHead5.setIdPegawai(25);
		deptHead5.setDepartment(dept5);
		deptHead5.setNama("Fitra Bayu");
		deptHead5.setAlamat("Jln. selainsuka juga cinta no.takterhingga");
		deptHead5.setTlp("08562281768");
		deptHead5.setEmail("fitra.bayu@ggs.com");
		dept5.setDeptHead(deptHead5);
		
		hris.getListPegawai().add(deptHead1);
		hris.getListPegawai().add(deptHead2);
		hris.getListPegawai().add(deptHead3);
		hris.getListPegawai().add(deptHead4);
		hris.getListPegawai().add(deptHead5);
		
		
		Staff staffDeptHead1 = new Staff();
		staffDeptHead1.setIdPegawai(1);
		staffDeptHead1.setDepartment(dept1);
		staffDeptHead1.setNama("Staff 1 Dept 1");
		staffDeptHead1.setAlamat("Jln. Staff Dept 1 no.1");
		staffDeptHead1.setTlp("08562281761");
		staffDeptHead1.setEmail("staff1.dept1@ggs.com");
		
		Staff staffDeptHead2 = new Staff();
		staffDeptHead2.setIdPegawai(2);
		staffDeptHead2.setDepartment(dept1);
		staffDeptHead2.setNama("Staff 2 Dept 1");
		staffDeptHead2.setAlamat("Jln. Staff Dept 1 no.2");
		staffDeptHead2.setTlp("08562281762");
		staffDeptHead2.setEmail("staff2.dept1@ggs.com");
		
		Staff staffDeptHead3 = new Staff();
		staffDeptHead3.setIdPegawai(3);
		staffDeptHead3.setDepartment(dept1);
		staffDeptHead3.setNama("Staff 3 Dept 1");
		staffDeptHead3.setAlamat("Jln. Staff Dept 1 no.3");
		staffDeptHead3.setTlp("08562281762");
		staffDeptHead3.setEmail("staff3.dept1@ggs.com");
		
		dept1.getListStaff().add(staffDeptHead1);
		dept1.getListStaff().add(staffDeptHead2);
		dept1.getListStaff().add(staffDeptHead3);
		
		Staff staff1DeptHead2 = new Staff();
		staff1DeptHead2.setIdPegawai(4);
		staff1DeptHead2.setDepartment(dept2);
		staff1DeptHead2.setNama("Staff 1 Dept 2");
		staff1DeptHead2.setAlamat("Jln. Staff Dept 2 no.1");
		staff1DeptHead2.setTlp("08562281721");
		staff1DeptHead2.setEmail("staff1.dept2@ggs.com");
		
		Staff staff2DeptHead2 = new Staff();
		staff2DeptHead2.setIdPegawai(5);
		staff2DeptHead2.setDepartment(dept2);
		staff2DeptHead2.setNama("Staff 2 Dept 2");
		staff2DeptHead2.setAlamat("Jln. Staff Dept 2 no.2");
		staff2DeptHead2.setTlp("08562281722");
		staff2DeptHead2.setEmail("staff2.dept2@ggs.com");
		
		Staff staff3DeptHead2 = new Staff();
		staff3DeptHead2.setIdPegawai(5);
		staff3DeptHead2.setDepartment(dept2);
		staff3DeptHead2.setNama("Staff 3 Dept 2");
		staff3DeptHead2.setAlamat("Jln. Staff Dept 2 no.3");
		staff3DeptHead2.setTlp("08562281723");
		staff3DeptHead2.setEmail("staff3.dept2@ggs.com");
		
		dept2.getListStaff().add(staff1DeptHead2);
		dept2.getListStaff().add(staff2DeptHead2);
		dept2.getListStaff().add(staff3DeptHead2);
		
		Staff staff1DeptHead3 = new Staff();
		staff1DeptHead3.setIdPegawai(6);
		staff1DeptHead3.setDepartment(dept3);
		staff1DeptHead3.setNama("Staff 1 Dept 3");
		staff1DeptHead3.setAlamat("Jln. Staff Dept 3 no.1");
		staff1DeptHead3.setTlp("08562281731");
		staff1DeptHead3.setEmail("staff1.dept3@ggs.com");
		
		Staff staff2DeptHead3 = new Staff();
		staff2DeptHead3.setIdPegawai(7);
		staff2DeptHead3.setDepartment(dept3);
		staff2DeptHead3.setNama("Staff 2 Dept 3");
		staff2DeptHead3.setAlamat("Jln. Staff Dept 3 no.2");
		staff2DeptHead3.setTlp("08562281732");
		staff2DeptHead3.setEmail("staff2.dept3@ggs.com");
		
		Staff staff3DeptHead3 = new Staff();
		staff3DeptHead3.setIdPegawai(8);
		staff3DeptHead3.setDepartment(dept3);
		staff3DeptHead3.setNama("Staff 3 Dept 3");
		staff3DeptHead3.setAlamat("Jln. Staff Dept 3 no.3");
		staff3DeptHead3.setTlp("08562281733");
		staff3DeptHead3.setEmail("staff3.dept3@ggs.com");
		
		dept3.getListStaff().add(staff1DeptHead3);
		dept3.getListStaff().add(staff2DeptHead3);
		dept3.getListStaff().add(staff3DeptHead3);
		
		Staff staff1DeptHead4 = new Staff();
		staff1DeptHead4.setIdPegawai(9);
		staff1DeptHead4.setDepartment(dept4);
		staff1DeptHead4.setNama("Staff 1 Dept 4");
		staff1DeptHead4.setAlamat("Jln. Staff Dept 4 no.1");
		staff1DeptHead4.setTlp("08562281741");
		staff1DeptHead4.setEmail("staff1.dept4@ggs.com");
		
		Staff staff2DeptHead4 = new Staff();
		staff2DeptHead4.setIdPegawai(10);
		staff2DeptHead4.setDepartment(dept4);
		staff2DeptHead4.setNama("Staff 2 Dept 4");
		staff2DeptHead4.setAlamat("Jln. Staff Dept 4 no.2");
		staff2DeptHead4.setTlp("08562281742");
		staff2DeptHead4.setEmail("staff2.dept4@ggs.com");
		
		Staff staff3DeptHead4 = new Staff();
		staff3DeptHead4.setIdPegawai(11);
		staff3DeptHead4.setDepartment(dept4);
		staff3DeptHead4.setNama("Staff 3 Dept 4");
		staff3DeptHead4.setAlamat("Jln. Staff Dept 4 no.3");
		staff3DeptHead4.setTlp("08562281743");
		staff3DeptHead4.setEmail("staff3.dept4@ggs.com");
		
		dept4.getListStaff().add(staff1DeptHead4);
		dept4.getListStaff().add(staff2DeptHead4);
		dept4.getListStaff().add(staff3DeptHead4);
		
		Staff staff1DeptHead5 = new Staff();
		staff1DeptHead5.setIdPegawai(12);
		staff1DeptHead5.setDepartment(dept5);
		staff1DeptHead5.setNama("Staff 1 Dept 5");
		staff1DeptHead5.setAlamat("Jln. Staff Dept 5 no.1");
		staff1DeptHead5.setTlp("08562281751");
		staff1DeptHead5.setEmail("staff1.dept5@ggs.com");
		
		Staff staff2DeptHead5 = new Staff();
		staff2DeptHead5.setIdPegawai(13);
		staff2DeptHead5.setDepartment(dept5);
		staff2DeptHead5.setNama("Staff 2 Dept 5");
		staff2DeptHead5.setAlamat("Jln. Staff Dept 5 no.2");
		staff2DeptHead5.setTlp("08562281752");
		staff2DeptHead5.setEmail("staff2.dept5@ggs.com");
		
		Staff staff3DeptHead5 = new Staff();
		staff3DeptHead5.setIdPegawai(14);
		staff3DeptHead5.setDepartment(dept5);
		staff3DeptHead5.setNama("Staff 3 Dept 5");
		staff3DeptHead5.setAlamat("Jln. Staff Dept 5 no.3");
		staff3DeptHead5.setTlp("08562281753");
		staff3DeptHead5.setEmail("staff3.dept5@ggs.com");
		
		dept5.getListStaff().add(staff1DeptHead5);
		dept5.getListStaff().add(staff2DeptHead5);
		dept5.getListStaff().add(staff3DeptHead5);
		
		hris.getListPegawai().add(staffDeptHead1);
		hris.getListPegawai().add(staffDeptHead2);
		hris.getListPegawai().add(staffDeptHead3);
		hris.getListPegawai().add(staff1DeptHead2);
		hris.getListPegawai().add(staff2DeptHead2);
		hris.getListPegawai().add(staff3DeptHead2);
		hris.getListPegawai().add(staff1DeptHead3);
		hris.getListPegawai().add(staff2DeptHead3);
		hris.getListPegawai().add(staff3DeptHead3);
		hris.getListPegawai().add(staff1DeptHead4);
		hris.getListPegawai().add(staff2DeptHead4);
		hris.getListPegawai().add(staff3DeptHead4);
		hris.getListPegawai().add(staff1DeptHead5);
		hris.getListPegawai().add(staff2DeptHead5);
		hris.getListPegawai().add(staff3DeptHead5);
		
		
		writeDataHris();
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
