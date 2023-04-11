import javax.swing.*;
import javax.swing.plaf.FontUIResource;

import java.awt.*;
import java.awt.event.*;

public class App extends JFrame {

    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 400;
    private static final int FRAME_X = 850;
    private static final int FRAME_Y = 250; 

    private int panicCount = 0;

    private JButton btnPanic;
    private JLabel lblTop;
    private JLabel lblSmall;
    private JLabel lblBottom;

    public App() {
        this.setTitle("The Panic Button 2!");
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setLocation(FRAME_X, FRAME_Y);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);

        // Main panel setup:
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        this.add(mainPanel);
        
        // Label setup:
        lblTop = new JLabel("When in panic, click below:");
        lblSmall = new JLabel("You haven't panicked yet...");
        lblBottom = new JLabel("Feel free to click anytime.");
        lblTop.setFont(new Font("Arial", Font.PLAIN, 14));
        lblSmall.setFont(new Font("Arial", Font.PLAIN, 10));
        lblBottom.setFont(new Font("Arial", Font.PLAIN, 14));
        
        // Button setup:
        btnPanic =  new JButton("BBBBB");
        btnPanic.setPreferredSize(new Dimension(200, 200));
        btnPanic.setFont(new Font("Arial", Font.PLAIN, 28));
        btnPanic.setBackground(Color.white);
        btnPanic.setBorder(BorderFactory.createLineBorder(Color.decode("#ff70a7"), 2)); 
        btnPanic.setFocusPainted(false);
        
        btnPanic.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onClick(e);
            }
        });
        
        // Grid Bag Constraints setup and adding of the components:
        GridBagConstraints gridCons = new GridBagConstraints();
        
        gridCons.gridy = 0; // Defines component placement.
        gridCons.weighty = 0.5; // Allows components to take up the full space of the box.
        gridCons.anchor = GridBagConstraints.PAGE_START; // Aligns the components to a side (in this case, the top.)
        mainPanel.add(lblTop, gridCons);
        
        gridCons.gridy = 1;
        gridCons.anchor = GridBagConstraints.CENTER;
        mainPanel.add(btnPanic, gridCons);
        
        gridCons.gridy = 2;
        gridCons.anchor = GridBagConstraints.PAGE_START;
        mainPanel.add(lblSmall, gridCons);
        
        gridCons.gridy = 3;
        gridCons.anchor = GridBagConstraints.PAGE_END;
        mainPanel.add(lblBottom, gridCons);
        
    }

    // Event handlers:
    public void onClick(ActionEvent e) {
        panicCount += 1;
        if (panicCount == 1) {
            lblSmall.setText("You panicked: 1 time.");
            lblBottom.setText("Do you feel better now?");
        } else { lblSmall.setText(String.format("You panicked: %d times.", panicCount)); }
    }

    // Main method:
    public static void main(String[] args) throws Exception {
        App window = new App();
        window.setVisible(true);
    }
}
