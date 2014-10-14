import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class KelolaLembur implements Serializable{
	private static final long serialVersionUID = 3336359999096853232L;
	private List<Lembur> listLembur = new ArrayList<Lembur>();
	public List<Lembur> getListLembur() {
		return listLembur;
	}
	public void setListLembur(List<Lembur> listLembur) {
		this.listLembur = listLembur;
	}
}
