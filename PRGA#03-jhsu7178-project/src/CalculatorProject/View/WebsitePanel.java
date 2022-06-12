package CalculatorProject.View;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import CalculatorProject.Model.*;

public class WebsitePanel extends JPanel implements ActionListener {
    private final JComboBox pageOptions;
    private final JComboBox sizeOptions;
    private final JButton calculate;
    private final JButton clear;
    private final JTextField page;
    private final JTextField size;
    private final JTextField redun;
    private final FrequencyUnit dataConverter;
    private final JTextArea result;

    public WebsitePanel() {
        this.setSize(500,600);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        dataConverter = new FrequencyUnit();
        JPanel titlePanel = new JPanel();
        JLabel title = new JLabel("Website Bandwidth Calculator");
        title.setFont(new Font("Comic Sans", Font.BOLD, 20));

        calculate = new JButton("Calculate!");
        calculate.addActionListener(this);
        clear = new JButton("Clear");
        clear.addActionListener(this);

        result = new JTextArea("Here's your Answer!",5,1);
        JLabel pageName = new JLabel("Page Views");
        JLabel sizeName = new JLabel("Average Page Size");
        JLabel redunName = new JLabel("Redundancy Factor");

        page = new JTextField();
        size = new JTextField();
        redun = new JTextField();

        String[] pageOptionArray = {"Per Second", "Per Minute", "Per Hour", "Per Day", "Per Month", "Per Year"};
        String[] sizeOptionArray = {"Bytes", "Kilobytes", "Megabytes", "Gigabytes", "Terabytes"};
        pageOptions = new JComboBox(pageOptionArray);
        sizeOptions = new JComboBox(sizeOptionArray);

        result.setFont(new Font("Comic Sans", Font.PLAIN, 12));
        result.setPreferredSize(new Dimension(450, 100));
        result.setEditable(false);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();

        titlePanel.setPreferredSize(new Dimension(380, 60));
        titlePanel.setLayout(new BorderLayout());
        titlePanel.add(title);

        panel1.setPreferredSize(new Dimension(340, 80));
        panel1.setLayout(new GridLayout(3,3,1,5));
        panel1.add(pageName);
        panel1.add(page);
        panel1.add(pageOptions);
        panel1.add(sizeName);
        panel1.add(size);
        panel1.add(sizeOptions);
        panel1.add(redunName);
        panel1.add(redun);

        panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panel2.setPreferredSize(new Dimension(340, 50));
        panel2.add(calculate);
        panel2.add(clear);

        panel3.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        panel3.setPreferredSize(new Dimension(480, 150));
        panel3.add(result);

        this.add(titlePanel);
        this.add(panel1);
        this.add(panel2);
        this.add(panel3);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculate) {
            String pageViews = page.getText() + " " + pageOptions.getSelectedItem();
            String pageSize = size.getText() + " " + sizeOptions.getSelectedItem();
            int redundancy = Integer.parseInt(redun.getText());
            result.setText(dataConverter.website(pageViews, pageSize, redundancy));
        } else if (e.getSource() == clear) {
            page.setText("");
            size.setText("");
            redun.setText("");
            result.setText("");
        }
    }
}
