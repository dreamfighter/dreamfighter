package hris;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GroupEvent implements Serializable{
	private static final long serialVersionUID = -7914059142096523240L;
	private List<Department> departments = new ArrayList<Department>();
	private Event event;
	
	public List<Department> getDepartments() {
		return departments;
	}
	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
}
