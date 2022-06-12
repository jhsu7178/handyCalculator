package CalculatorProject.View;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import CalculatorProject.Controller.*;
import CalculatorProject.Model.*;

public class HexPanel extends JPanel implements ActionListener {
    private final JTextField add1;
    private final JTextField add2;
    private final JTextField bConvert;
    private final JTextField dConvert;

    private final JComboBox options;

    private final JButton calculate1;
    private final JButton calculate2;
    private final JButton calculate3;
    private final JButton clear;

    private final JLabel sum;
    private final JLabel bAnswer;
    private final JLabel dAnswer;

    private final HexCalculator hCalc;

    public HexPanel() {
        this.setSize(500,600);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        hCalc = new HexCalculator();

        add1 = new JTextField();
        add2 = new JTextField();
        bConvert = new JTextField();
        dConvert = new JTextField();


        String[] operations = {"+", "-", "*", "/"};
        options = new JComboBox(operations);

        clear = new JButton();
        sum = new JLabel();
        bAnswer = new JLabel();
        dAnswer = new JLabel();
        JLabel title1 = new JLabel();
        JLabel title2 = new JLabel();
        JLabel title3 = new JLabel();


        calculate1 = new JButton("calculate!");
        calculate2 = new JButton("calculate!");
        calculate3 = new JButton("calculate!");

        clear.addActionListener(this);
        calculate1.addActionListener(this);
        calculate2.addActionListener(this);
        calculate3.addActionListener(this);

        sum.setText("Here's your answer!");
        bAnswer.setText("Here's your answer!");
        dAnswer.setText("Here's your answer!");
        title1.setText("Hex operation calculator");
        title1.setFont(new Font("Comic Sans", Font.BOLD, 20));
        title2.setText("Convert decimal to hex");
        title2.setFont(new Font("Comic Sans", Font.BOLD, 20));
        title3.setText("Convert binary to decimal");
        title3.setFont(new Font("Comic Sans", Font.BOLD, 20));

        add1.setPreferredSize(new Dimension(100, 45));
        add2.setPreferredSize(new Dimension(100, 45));
        bConvert.setPreferredSize(new Dimension(100, 45));
        dConvert.setPreferredSize(new Dimension(100, 45));



        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();
        JPanel panel6 = new JPanel();
        JPanel panel7 = new JPanel();
        JPanel titleP1 = new JPanel();
        JPanel titleP2 = new JPanel();
        JPanel titleP3 = new JPanel();

        panel1.setPreferredSize(new Dimension(500,60));
        panel2.setPreferredSize(new Dimension(250,65));
        panel3.setPreferredSize(new Dimension(500,60));
        panel4.setPreferredSize(new Dimension(250,65));
        panel5.setPreferredSize(new Dimension(500,60));
        panel6.setPreferredSize(new Dimension(250,65));
        panel7.setPreferredSize(new Dimension(500,60));
        titleP1.setPreferredSize(new Dimension(280, 25));
        titleP2.setPreferredSize(new Dimension(250, 25));
        titleP3.setPreferredSize(new Dimension(250, 25));

        panel1.setLayout(new FlowLayout());

        panel1.add(add1);
        panel1.add(options);
        panel1.add(add2);
        panel1.add(calculate1);

        panel2.setLayout(new BorderLayout());
        panel2.add(sum);

        panel3.setLayout(new FlowLayout());
        panel3.add(bConvert);
        panel3.add(calculate2);

        panel4.setLayout(new BorderLayout());
        panel4.add(bAnswer, BorderLayout.WEST);

        panel5.setLayout(new FlowLayout());
        panel5.add(dConvert);
        panel5.add(calculate3);

        panel6.setLayout(new BorderLayout());
        panel6.add(dAnswer, BorderLayout.WEST);

        panel7.setLayout(new BorderLayout());
        clear.setText("Clear");
        panel7.add(clear, BorderLayout.SOUTH);

        titleP1.setLayout(new BorderLayout());
        titleP1.add(title1);

        titleP2.setLayout(new BorderLayout());
        titleP2.add(title2);

        titleP3.setLayout(new BorderLayout());
        titleP3.add(title3);

        this.add(titleP1);
        this.add(panel1);
        this.add(panel2);

        this.add(titleP2);
        this.add(panel3);
        this.add(panel4);

        this.add(titleP3);
        this.add(panel5);
        this.add(panel6);

        this.add(panel7);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Decimal decimal;
        if (e.getSource() == calculate1) {
            if (options.getSelectedItem().equals("+")) {
                sum.setText(hCalc.add(add1.getText(), add2.getText()));
            } else if (options.getSelectedItem().equals("-")) {
                sum.setText(hCalc.sub(add1.getText(), add2.getText()));
            } else if (options.getSelectedItem().equals("*")) {
                sum.setText(hCalc.mul(add1.getText(), add2.getText()));
            } else {
                sum.setText(hCalc.div(add1.getText(), add2.getText()));
            }
        } else if (e.getSource() == clear) {
            sum.setText("");
            add1.setText("");
            add2.setText("");
            bAnswer.setText("");
            dAnswer.setText("");
            bConvert.setText("");
            dConvert.setText("");
        } else if (e.getSource() == calculate2) {
            decimal = new Decimal((Integer.parseInt(bConvert.getText())));
            bAnswer.setText(hCalc.decimalToHex(decimal));
        } else if (e.getSource() == calculate3) {
            decimal = hCalc.convertToDecimal(dConvert.getText());
            dAnswer.setText(decimal.toString());
        }
    }
}
