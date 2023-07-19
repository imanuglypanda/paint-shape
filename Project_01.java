import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Project_01 extends JFrame implements ActionListener {
    private Container container;
    private JPanel pn1, pn2;
    private GraphicsPanel gp;
    private JButton btn[];
    private String btnText[] = {"Triangle", "Square", "Circle", "Box", "Red", "Green", "Blue", "Mageta"};

    public Project_01() {
        super("Project 01");
        container = getContentPane();
        container.setLayout(new BorderLayout(10, 10));
        getRootPane().setBorder(BorderFactory.createEmptyBorder(5, 2, 20, 2));

        // Instance Object for using GraphicsPanel's method
        gp = new GraphicsPanel();
        btn = new JButton[8];
        
        createPanel1();
        createPanel2();

        // add Panels in the position
        add(pn1, BorderLayout.PAGE_START);
        add(gp, BorderLayout.CENTER);
        add(pn2, BorderLayout.PAGE_END);

        setForeground(Color.black);
        setDefaultCloseOperation(3);
        setSize(1024, 768);
        setVisible(true);
    }

    public void createPanel1() {
        pn1 = new JPanel();
        pn1.setPreferredSize(new Dimension(1000, 50));
        pn1.setLayout(new FlowLayout());
        pn1.setBorder(new LineBorder(Color.black, 1));
        
        for (int i = 0; i < 8; i++) {
            btn[i] = new JButton(btnText[i]);
            btn[i].setFont(new Font("Tahoma", 1, 15));
            btn[i].addActionListener(this);
			pn1.add(btn[i]);
        }
    }

    // create panel for shape status and color report
    public void createPanel2() {
        pn2 = new JPanel();
        pn2.setPreferredSize(new Dimension(1000, 25));
        pn2.setBorder(BorderFactory.createBevelBorder(0));
        pn2.setBorder(new LineBorder(Color.black, 1));
    }

    public void paint(Graphics graphics) {
        super.paint(graphics);
        drawStatus(pn2.getGraphics());
    }

    public void drawStatus(Graphics graphics) {
        graphics.setFont(new Font("Tahoma", 1, 17));
        graphics.drawString("Shape : " + btnText[gp.status], 10, 20);
        graphics.drawString("Color : " + btnText[gp.colorStatus], 800, 20);
    }

    // Button's action change status(Shape Status) then repaint
    public void actionPerformed(ActionEvent action) {
        for (int n = 0; n < btn.length; n++) {
            if (action.getSource() == btn[n])
                if (n < 4)  gp.status = n;
                else        gp.colorStatus = n;
        }
        repaint();
    }

    public String toString() { return gp.toString(); }

    public static void main(String[] args) {
        new Project_01();
    }
}
