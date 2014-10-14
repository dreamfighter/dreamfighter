import java.io.Serializable;


public class DivHead extends Pegawai implements Serializable{
	private static final long serialVersionUID = 1331860900167194921L;
	private Division division;
	
	public Division getDivision() {
		return division;
	}
	public void setDivision(Division division) {
		this.division = division;
	}
	
}
