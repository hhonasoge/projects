import java.util.*;
public class callCenter {
	private int numDirectors = 10;
	private int numManagers = 10;
	private int numRespondents = 10;
	ArrayList<Employee> directors = new ArrayList<Employee>();
	ArrayList<Employee> managers = new ArrayList<Employee>();
	ArrayList<Employee> respondents = new ArrayList<Employee>();
	public callCenter() {
		for (int i=0; i<numDirectors; i++) {
			directors.add(new Employee());
		}
		for (int i=0; i<numManagers; i++) {
			managers.add(new Employee());
		}
		for (int i=0; i<numRespondents; i++) {
			respondents.add(new Employee());
		}
	}
	public void dispatchCall() {
		for (int i=0; i<numRespondents; i++) {
			Employee respondent = respondents.get(i);
			if (respondent.getStatus() == Employee.STATUS.FREE) {
				respondent.setStatus(Employee.STATUS.BUSY);
				System.out.println("Respondent answered");
				return;
			}
		}
		for (int i=0; i<numManagers; i++) {
			Employee manager = managers.get(i);
			if (manager.getStatus() == Employee.STATUS.FREE) {
				manager.setStatus(Employee.STATUS.BUSY);
				System.out.println("Manager answered");
				return;
			}
		}
		for (int i=0; i<numRespondents; i++) {
			Employee director = directors.get(i);
			if (director.getStatus() == Employee.STATUS.FREE) {
				director.setStatus(Employee.STATUS.BUSY);
				System.out.println("Director answered");
				return;
			}
		}
		System.out.println("Everyone is busy");
		return;
	}
	public static void main(String[] args) {
		callCenter center = new callCenter();
		for (int i=0; i<31; i ++) {
			center.dispatchCall();
		}
	}
}