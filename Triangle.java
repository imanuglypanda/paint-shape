import java.awt.*;

public class Triangle extends Point {
    private int base, height;

    public Triangle() { }

    public Triangle(int x1, int y1, int base, int height) {
        super(x1, y1);
        setBase(base);
        setHeight(height);
    }

    public void setBase(int base) { this.base = base; }
    public void setHeight(int height) { this.height = height; }

    public int getBase() { return this.base; }
    public int getHeight() { return this.height; }

    public void draw(Graphics graphics) {
        // Line one
        int n1 = ((x1 << 1) - base) >> 1; // reflection of x2
        int y2 = y1 + height;
        graphics.drawLine(x1, y1, n1, y2);
        graphics.drawString(x1 + ", " + y1, x1, y1 - 15);

        // Line two
        int n2 = ((x1 << 1) + base) >> 1;
        graphics.drawLine(n1, y2, n2, y2);
        graphics.drawString(n1 + ", " + y2, n1, y2 + 20);

        // Line three
        graphics.drawLine(x1, y1, n2, y2);
        graphics.drawString(n2 + ", " + y2, n2, y2 + 20);
    }

    public String toString() {
        return  "\nTriangle position : " + super.toString() +
                "\n[Base = " + getBase() + " Height = " + getHeight() + "]";
    }
}
