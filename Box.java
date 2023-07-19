import java.awt.Graphics;

public class Box extends Point {
    private int width, height, length;

    public Box() { }

    public Box(int x1, int y1, int width, int height, int length) {
        super(x1, y1);
        setWidth(width);
        setHeight(height);
        setLength(length);
    }

    public void setWidth(int width) { this.width = width; }
    public void setHeight(int height) { this.height = height; }
    public void setLength(int length) { this.length = length; }

    public int getWidth() { return this.width; }
    public int getHeight() { return this.height; }
    public int getLength() { return this.length; }

    public void draw(Graphics graphics) { // Draw Box
        int x2 = x1 + width;
        int y2 = y1 + height;

        // Front Box
        graphics.drawLine(x1, y1, x2, y1);
        graphics.drawLine(x1, y1, x1, y2);
        graphics.drawLine(x1, y2, x2, y2);
        graphics.drawLine(x2, y1, x2, y2);

        graphics.drawString(x1 + ", " + y1, x1, y1 - 15);
        graphics.drawString(x2 + ", " + y1, x2, y1 - 15);
        graphics.drawString(x1 + ", " + y2, x1, y2 + 20);
        graphics.drawString(x2 + ", " + y2, x2, y2 + 20);
        

        // Box length
        graphics.drawLine(x1, y1, x1 + length, y1 - length);
        graphics.drawLine(x2, y1, x2 + length, y1 - length);
        graphics.drawLine(x1, y2, x1 + length, y2 - length);
        graphics.drawLine(x2, y2, x2 + length, y2 - length);

        int n1 = x1 + length; // n1 = x1
        int n2 = y1 - length; // n2 = y1
        int n3 = x2 + length; // n3 = x2
        int n4 = y2 - length; // n4 = y2
    
        // Back Box
        graphics.drawLine(n1, n2, n3, n2);
        graphics.drawLine(n1, n2, n1, n4);
        graphics.drawLine(n1, n4, n3, n4);
        graphics.drawLine(n3, n2, n3, n4);

        graphics.drawString(n1 + ", " + n2, n1, n2 - 15);
        graphics.drawString(n3 + ", " + n2, n3, n2 - 15);
        graphics.drawString(n1 + ", " + n4, n1, n4 + 20);
        graphics.drawString(n3 + ", " + n4, n3, n4 + 20);
    }

    public String toString() {
        return  "\nBox position : " + super.toString() +
                "\n[Width = " + this.width + 
                "\n Height = "  + this.height + 
                "\n Length = " + this.length + "]";
    }
}
