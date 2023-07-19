public class Point {
    protected int x1, y1;

    public Point() { }

    public Point(int x1, int y1) {
        setX1(x1);
        setY1(y1);
    }

    public void setX1(int x1) { this.x1 = x1; }
    public void setY1(int y1) { this.y1 = y1; }

    public int getX1() { return this.x1; }
    public int getY1() { return this.y1; }

    public String toString() { return "[x = " + getX1() + " , y = "  + getY1() + "]"; }
}
