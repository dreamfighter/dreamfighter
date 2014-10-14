import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class KelolaLembur {
	public static void main(String[] args){
		System.out.println("Tambah Lembur");
		BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
		try {
			String dateString = reader.readLine();
			System.out.println("date String = "+dateString);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
