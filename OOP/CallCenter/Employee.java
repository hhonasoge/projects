public class Employee {
	public enum STATUS {
		FREE, BUSY
	};
	STATUS status = STATUS.FREE;
	public STATUS getStatus() {
		return this.status;
	}
	public void setStatus(STATUS s) {
		this.status = s;
	}
}