import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author zeger
 *
 */
public class KelolaLembur implements Serializable{
	private static final long serialVersionUID = 3336359999096853232L;
	private List<Lembur> listLembur = new ArrayList<Lembur>();
	
	
	public void ajukanLembur(Staff staff,Date tanggalLembur){
		Lembur lembur = new Lembur();
		this.listLembur.add(lembur);
	}
	public List<Lembur> getListLembur() {
		return listLembur;
	}
	public void setListLembur(List<Lembur> listLembur) {
		this.listLembur = listLembur;
	}
}
