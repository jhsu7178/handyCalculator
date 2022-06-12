package CalculatorProject.View;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        BinaryPanel binaryPanel = new BinaryPanel();
        CalculatorTabs tabs = new CalculatorTabs();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit button
        this.setTitle("Calculator");
        this.setSize(500,580);
        this.setLayout(new BorderLayout());
        ImageIcon icon = new ImageIcon("calculator.png");
        this.setIconImage(icon.getImage());
        JLabel welcome = new JLabel("Welcome to the CSS Handy Calculator");
        welcome.setHorizontalAlignment(JLabel.CENTER);
        this.add(welcome, BorderLayout.CENTER);
        this.add(tabs);

        this.setVisible(true);
    }
}
