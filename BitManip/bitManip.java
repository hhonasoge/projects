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
	public static int clearBits(int N, int i, int j) {
		int mask1 = ~(-1 >>> (31-i));
		int mask2 = (-1 >>> (32-j));
		int mask3 = mask1 | mask2;
		return N & mask3;

	}
	public static int insert(int N, int M, int i, int j){
		int newN = clearBits(N, i, j);
		int newM = M << i;
		return newN | newM;
	}
	public static void main(String[] args) {
		System.out.println(insert(1024, 19, 2, 6));
	}

}