package CalculatorProject.View;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import CalculatorProject.Model.*;

public class HostingPanel extends JPanel implements ActionListener {
    private final JComboBox monthOptions;
    private final JComboBox bandOptions;
    private final JButton calculate;
    private final JButton clear;
    private final JTextField month;
    private final JTextField band;
    private final RateUnit dataConverter;
    private final JTextArea result;

    public HostingPanel() {
        this.setSize(500,600);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        dataConverter = new RateUnit();
        JPanel titlePanel = new JPanel();
        JLabel title = new JLabel("Download Calculator");
        title.setFont(new Font("Comic Sans", Font.BOLD, 20));
        month = new JTextField();
        band = new JTextField();

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();
        JPanel panel3 = new JPanel();

        JLabel monthName = new JLabel("Monthly Usage");
        JLabel bandName = new JLabel("Bandwidth");
        clear = new JButton("Clear");
        clear.addActionListener(this);

        calculate = new JButton("Calculate!");
        calculate.addActionListener(this);

        result = new JTextArea("Here's your answer!", 1, 8);
        result.setPreferredSize(new Dimension(300, 40));
        result.setFont(new Font("Ariel Black", Font.BOLD, 20));
        result.setEditable(false);
        result.setPreferredSize(new Dimension(330, 180));
        String[] fileOptionArray = {"Bytes", "Kilobytes", "Megabytes", "Gigabytes", "Terabytes"};
        String[] bandOptionArray = {"bit/s", "Kbit/s","Mbit/s", "Gbit/s", "Tbit/s"};
        monthOptions = new JComboBox(fileOptionArray);
        bandOptions = new JComboBox(bandOptionArray);

        panel1.setPreferredSize(new Dimension(340, 40));
        panel1.setLayout(new GridLayout(1,3,1,3));
        panel1.add(monthName);
        panel1.add(month);
        panel1.add(monthOptions);


        panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panel2.setPreferredSize(new Dimension(340, 50));
        panel2.add(calculate);
        panel2.add(clear);

        panel4.setLayout(new BorderLayout());
        panel4.setPreferredSize(new Dimension(140,50));
        panel4.add(new JLabel("is equivalent to"), BorderLayout.CENTER);

        panel5.setPreferredSize(new Dimension(340, 40));
        panel5.setLayout(new GridLayout(1,3,1,3));
        panel5.add(bandName);
        panel5.add(band);
        panel5.add(bandOptions);

        panel3.setLayout(new FlowLayout(FlowLayout.CENTER, 0,0));
        panel3.setPreferredSize(new Dimension(340, 190));
        panel3.add(result);
        titlePanel.setPreferredSize(new Dimension(280, 60));
        titlePanel.setLayout(new BorderLayout());
        titlePanel.add(title);

        this.add(titlePanel);
        this.add(panel1);
        this.add(panel4);
        this.add(panel5);
        this.add(panel2);
        this.add(panel3);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculate) {
            if (band.getText().equals("")) {
                String monthlyUse = month.getText() + " " + monthOptions.getSelectedItem();
                String bandOp = "" + bandOptions.getSelectedItem();
                result.setText(dataConverter.hostBandwidth(monthlyUse, bandOp));
            } else if (month.getText().equals("")) {
                String bandUse = band.getText() + " " + bandOptions.getSelectedItem();
                String monthOp = "" + monthOptions.getSelectedItem();
                result.setText(dataConverter.bandwidthInMonths(bandUse, monthOp));
            }
        } else if (e.getSource() == clear) {
            month.setText("");
            band.setText("");
            result.setText("");
        }
    }


}


