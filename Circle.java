import java.awt.Graphics;

public class Circle extends Point {
    private int radius;

    public Circle() { }
    
    public Circle(final int x1, final int y1, final int radius) {
        super(x1, y1);
        setRadius(radius);
    }
    
    public void setRadius(final int radius) { this.radius = radius; }
    public int getRadius() { return this.radius; }

    public void draw(Graphics graphics) {
        graphics.drawOval(x1 - 1, y1 - 1, 2, 2);
        graphics.drawOval(x1 - radius, y1 - radius, radius << 1, radius << 1);
        graphics.drawString(x1 + ", " + y1, x1, y1 - 15);
    }

    public String toString() { 
        return  "\nCircle position : " + super.toString() +
                "\n[ Radius = " + getRadius() + "]"; 
    }
}
