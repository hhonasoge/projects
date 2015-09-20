public class Item {
	private String name;
	private double cost;
	public Item(String name, double cost) {
		this.name = name;
		this.cost = cost;
	}
	public Item(Item item) {
		this.name = item.name;
		this.cost = item.cost;
	}
	public String getName(){
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getCost(){
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
}