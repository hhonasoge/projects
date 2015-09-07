public class bitManip {
	public static int getBit(int num, int i){
		int mask = 1 << i;
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
	public static int getOnesAfter(int num, int i) {
		int count = 0;
		while(getBit(num, i) !=0) {
			count++;
			i--;
		}
		return count;
	}
	public static int numFlips(int a, int b) {
		int tmp = a ^ b;
		int count = 0;
		for (int i=0; i<32; i++) {
			if (getBit(tmp, i) == 1) {
				count++;
			}
		}
		return count;
	}
	public static int flipBit(int num) {
		int maxOneCount = 0;
		int currCount = 0;
		int tmpCount = 0;
		int i = 31;
		while(i>-1){
			int bitVal = getBit(num, i);
			if (bitVal == 1) {
				currCount++;
				i--;
			}
			else {
					tmpCount = getOnesAfter(num, i-1);
					currCount +=tmpCount+1;
					if (currCount>maxOneCount) {
						maxOneCount = currCount;
					}
					currCount = tmpCount;
					i -= (tmpCount+1);
			}
		}
		if (currCount > maxOneCount) {
			maxOneCount = currCount;
		}
		return maxOneCount;
	}
	public static int insert(int N, int M, int i, int j) {
		int newN = clearBits(N, i, j);
		int newM = M << i;
		return newN | newM;
	}

	public static void main(String[] args) {
		// System.out.println(insert(1024, 19, 2, 6));
		// System.out.println(flipBit(1775));
		System.out.println(numFlips(29, 15));
	}

}