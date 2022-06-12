package CalculatorProject.View;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import CalculatorProject.Model.*;

public class DataUnitConverter extends JPanel implements ActionListener {
    private final JTextField data;
    private final JComboBox options;
    private final JButton calculate;
    private final JButton clear;
    private final JTextArea answer;
    private final SizeUnit dataConverter;

    public DataUnitConverter() {
        this.setSize(500,600);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        dataConverter = new SizeUnit();
        JPanel titlePanel = new JPanel();
        JLabel title = new JLabel("Data Unit Converter");
        title.setFont(new Font("Comic Sans", Font.BOLD, 20));

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();

        data = new JTextField();
        String[] units = {"bits", "kilobits", "megabits", "gigabits", "terabits", "Bytes", "Kilobytes",
                          "Megabytes", "Gigabytes", "Terabytes"};
        options = new JComboBox(units);
        calculate = new JButton("Calculate!");
        calculate.addActionListener(this);
        clear = new JButton("Clear");
        clear.addActionListener(this);
        answer = new JTextArea("Here's your answer!",1,8);
        answer.setEditable(false);
        answer.setPreferredSize(new Dimension(333, 293));
        titlePanel.setPreferredSize(new Dimension(280, 25));
        panel1.setPreferredSize(new Dimension(500, 150));
        panel2.setPreferredSize(new Dimension(350, 300));
        panel3.setPreferredSize(new Dimension(500, 32));

        data.setPreferredSize(new Dimension(100, 45));

        titlePanel.setLayout(new BorderLayout());
        titlePanel.add(title);

        panel1.setLayout(new FlowLayout());
        panel1.add(data);
        panel1.add(options);
        panel1.add(calculate);

        panel2.setLayout(new BorderLayout());
        panel2.add(answer, BorderLayout.NORTH);

        panel3.setLayout(new BorderLayout());
        panel3.add(clear, BorderLayout.SOUTH);

        this.add(titlePanel);
        this.add(panel1);
        this.add(panel2);
        this.add(panel3);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculate) {
            String result = data.getText();
            result = result + " " + options.getSelectedItem();
            answer.setText(dataConverter.unitConvert(result));
        } else if (e.getSource() == clear) {
            data.setText("");
            answer.setText("");
        }
    }
}
