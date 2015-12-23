import java.util.*;
public class VendingMachine {
	private int rows;
	private int columns;
	public static final int CAPACITY = 25;
	private ArrayList<ArrayList<LinkedList<Item>>> machine;
	public VendingMachine(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		machine = new ArrayList<ArrayList<LinkedList<Item>>>();

		for (int i=0; i<rows; i++) {
			ArrayList<LinkedList<Item>> itemColumns = new ArrayList<LinkedList<Item>>();
			for (int j=0; j<columns; j++) {
				itemColumns.add(new LinkedList<Item>());
			}
			machine.add(itemColumns);
		}
	}
	public void restock(Item item, char row, int column) {
		int columnNum = column - 1;
		int rowNum = (int) row - 'A';
		if (rowNum<0 || rowNum>rows-1) { System.out.println("Specify Row from A-Z"); return;}
		if (column<0 || columnNum > columns-1) {System.out.println("Column Index out of range"); return;}

		LinkedList<Item> itemQueue = machine.get(rowNum).get(columnNum);
		int size = itemQueue.size();
		int numToRestock = CAPACITY - size;
		for (int i=0; i<numToRestock; i++) {
			itemQueue.add(new Item(item));
		}
	}
	public ItemWithChange giveItem(char row, int column, double amountGiven){
		int rowNum = (int) row - 'A';
		int columnNum = column - 1;
		LinkedList<Item> itemList = machine.get(rowNum).get(columnNum);
		Item item;
		double change = 0.00;
		if (itemList.size()>0){
			item = itemList.remove();
		} else {
			System.out.println("No items in this slot. Sorry!");
			return null;
		}
		if (amountGiven > item.getCost()) {
			change = Math.round((amountGiven - item.getCost()) * 100.0) / 100.0;
			System.out.println("Your change is $" + change);
		}
		return new ItemWithChange(item, change);
	}
	public void print(){
		for (int i=0; i<rows; i++) { 
			for (int j=0; j<columns; j++) {
				char rowChar = (char) (i + 'A');
				String itemType = "";
				LinkedList<Item> itemList = machine.get(i).get(j);
				int size = itemList.size();
				if (size>0) {
					itemType = size + " " + itemList.peek().getName();
				} else {
					itemType = "Empty";
				}
				System.out.print("|"+rowChar+Integer.toString(j)+": " + itemType + "| ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		VendingMachine machine = new VendingMachine(5, 5);
		Item Doritos = new Item("Doritos", 1.25);
		machine.restock(Doritos, 'E', 5);
		machine.print();
		ItemWithChange firstDoritos = machine.giveItem('E', 5, 1.26);
		System.out.println(firstDoritos.change);
		System.out.println(firstDoritos.item.getName());
		machine.print();
	}
}