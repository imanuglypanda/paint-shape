import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GraphicsPanel extends JPanel implements MouseListener, MouseMotionListener {
    private Triangle triangle;
    private Square square;
    private Circle circle;
    private Box box;
    protected int status;
    protected int colorStatus;
    protected int xM, yM;

    public GraphicsPanel() {
        setDoubleBuffered(true);
        triangle = new Triangle(200, 300, 250, 100);
        square = new Square(200, 300, 150);
        circle = new Circle(200, 200, 100);
        box = new Box(320, 219, 200, 200, 100);
        this.colorStatus = 4;
        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    // check status to draw
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawString("[" + xM + ", " + yM + "]", 20, 20);
        
        // Choose Color
        switch(this.colorStatus) {
            case 4:
                graphics.setColor(Color.RED);
                break;
            case 5:
                graphics.setColor(Color.GREEN);
                break;
            case 6:
                graphics.setColor(Color.BLUE);
                break;
            case 7:
                graphics.setColor(Color.MAGENTA);
                break;
            default:
                this.colorStatus = 4;
        }

        // Check Status
        switch(status) {
            case 0:
                triangle.draw(graphics);
                break;
            case 1:
                square.draw(graphics);
                break;
            case 2:
                circle.draw(graphics);
                break;
            case 3:
                box.draw(graphics);
                break;
        }
    }

    public void mousePressed(MouseEvent e) {
        switch(status) {
            case 0:
                triangle.setX1(e.getX());
                triangle.setY1(e.getY());     
                break;
            case 1:
                square.setX1(e.getX());
                square.setY1(e.getY());
                break;
            case 2:
                circle.setX1(e.getX());
                circle.setY1(e.getY());
                break;
            case 3:
                box.setX1(e.getX());
                box.setY1(e.getY());
                break;
        }
        repaint();
    }

    public void mouseDragged(MouseEvent e) {
        final int x2 = e.getX();
        final int y2 = e.getY();

        switch(status) {
            case 0:
                triangle.setBase((x2 - triangle.x1) << 1);
                triangle.setHeight(y2 - triangle.y1);
                break;
            case 1:
                square.setSize(x2 - square.x1);
                break;
            case 2:
                circle.setRadius(x2 - circle.x1);   
                break;
            case 3:
                box.setWidth(x2 - box.x1);
                box.setHeight(y2 - box.y1);
                box.setLength((x2 - box.x1) >> 1);
                break;
        }
        repaint();
    }

    public void mouseMoved(MouseEvent e) {
        this.xM = e.getX();
        this.yM = e.getY();
        repaint();
    }
    // not use
    public void mouseReleased(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public String toString() {
        return  triangle.toString() +
                square.toString() +
                circle.toString() +
                box.toString();
    }
}
