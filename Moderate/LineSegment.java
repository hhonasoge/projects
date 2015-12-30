public class LineSegment {
	public Point a, b;
	public double slope;
	public double yInt;
	public LineSegment(Point a, Point b){
		this.a = a;
		this.b = b;
		this.slope = (b.y - a.y)/(b.x-a.x);
		this.yInt = b.y - slope*b.x;
	}
	public Point findIntersection(LineSegment line){
		if (!isBetween(line)) return null;
		if (line.slope == this.slope) return null;
		double xIntersect = (this.yInt - line.yInt)/(line.slope - this.slope);
		double yIntersect = this.slope*xIntersect+this.yInt;
		return new Point(xIntersect, yIntersect);
	}
	public boolean isBetween(LineSegment line){
		double thisAx = this.a.x;
		double thisAy = this.a.y;
		double thisBx = this.b.x;
		double thisBy = this.b.y;
		double lineAx = line.a.x;
		double lineAy = line.a.y;
		double lineBx = line.b.x;
		double lineBy = line.b.y;
		if (thisAx < thisBx){
			if (lineAx < lineBx){
				if (lineAx > thisBx)return false;
			} else {
				if (lineBx>thisBx)return false;
			}
		} else {
			if (lineAx < lineBx){
				if (lineAx > thisAx) return false;
			} else {
				if (lineBx > thisAx) return false;
			}
		}
		if (thisAy < thisBy){
			if (lineAy < lineBy){
				if (lineAy > thisBy)return false;
			} else {
				if (lineBy>thisBy)return false;
			}
		} else {
			if (lineAy < lineBy){
				if (lineAy > thisAy) return false;
			} else {
				if (lineBy > thisAy) return false;
			}
		}
		return true;
	}
	public static void main(String[] args){
		Point a = new Point(0, 0);
		Point b = new Point(10, 10);
		LineSegment firstLine = new LineSegment(a, b);
		Point x = new Point(0, 10);
		Point y = new Point(10, 0);
		LineSegment secondLine = new LineSegment(x, y);
		Point z = firstLine.findIntersection(secondLine);
		System.out.println(z.x);
		System.out.println(z.y);
	}
}