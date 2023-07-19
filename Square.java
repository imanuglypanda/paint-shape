import java.awt.Graphics;

public class Square extends Point {
    private int size;

    public Square() { }

    public Square(int x1, int y1, int size) {
        super(x1, y1);
        setSize(size);
    }

    public void setSize(int size) { this.size = size; }
    public int getSize() { return this.size; }

    public void draw(Graphics graphics) {
        int x2 = x1 + size;
        int y2 = y1 + size;

        graphics.drawLine(x1, y1, x2, y1);
        graphics.drawLine(x1, y1, x1, y2);
        graphics.drawLine(x2, y1, x2, y2);
        graphics.drawLine(x1, y2, x2, y2);

        graphics.drawString(x1 + ", " + y1, x1, y1 - 15); // Upper-Left
        graphics.drawString(x2 + ", " + y1, x2, y1 - 15); // Upper-Right
        graphics.drawString(x1 + ", " + y2, x1, y2 + 20); // Bottom-Left
        graphics.drawString(x2 + ", " + y2, x2, y2 + 20); // Bottom-Right
    }

    public String toString() { 
        return  "\nSquare position : " + super.toString() +
                "\n[Square Size = " + getSize() + "]";
    }
}
