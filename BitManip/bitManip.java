public class bitManip {
	public static int getBit(int num, int i){
		int mask = i << 1;
		int val = num & mask;
		return val != 0 ? 1 : 0;
	}
	public static int setBit(int num, int i) {
		int mask = 1 << i;
		return num | mask;
	}
	public static int clearBit(int num, int i) {
		int mask = ~(1<<i);
		return num & mask;
	}
	public static int updateBit(int num, int i, boolean isOne){
		int val = isOne ? 1 : 0;
		int mask = ~(1<<i);
		return (num & mask)| (val << i);
	}
	public static void main(String[] args) {
		System.out.println(getBit(3, 1));
		System.out.println(setBit(4, 0));
		System.out.println(clearBit(4, 2));
		System.out.println(updateBit(4, 0, true));
	}

}