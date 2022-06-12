package CalculatorProject.View;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import CalculatorProject.Model.*;
public class DownloadPanel extends JPanel implements ActionListener {

    private final JComboBox fileOptions;
    private final JComboBox bandOptions;
    private final JButton calculate;
    private final JButton clear;
    private final JTextField file;
    private final JTextField band;
    private final RateUnit dataConverter;
    private final JTextField result;

    public DownloadPanel() {
        this.setSize(500,600);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        dataConverter = new RateUnit();
        JPanel titlePanel = new JPanel();
        JLabel title = new JLabel("Download Calculator");
        title.setFont(new Font("Comic Sans", Font.BOLD, 20));
        file = new JTextField();
        band = new JTextField();

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();

        JLabel fileName = new JLabel("File Size");
        JLabel bandName = new JLabel("Bandwidth");
        clear = new JButton("Clear");
        clear.addActionListener(this);
        calculate = new JButton("Calculate!");
        calculate.addActionListener(this);
        result = new JTextField("Here's your answer!");
        result.setPreferredSize(new Dimension(300, 40));
        result.setFont(new Font("Ariel Black", Font.BOLD, 20));
        result.setEditable(false);
        String[] fileOptionArray = {"Bytes", "Kilobytes", "Megabytes", "Gigabytes", "Terabytes"};
        String[] bandOptionArray = {"bit/s", "Kbit/s","Mbit/s", "Gbit/s", "Tbit/s"};
        fileOptions = new JComboBox(fileOptionArray);
        bandOptions = new JComboBox(bandOptionArray);

        panel1.setPreferredSize(new Dimension(340, 40));
        panel1.setLayout(new GridLayout(2,3,1,3));
        panel1.add(fileName);
        panel1.add(file);
        panel1.add(fileOptions);
        panel1.add(bandName);
        panel1.add(band);
        panel1.add(bandOptions);

        panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panel2.setPreferredSize(new Dimension(340, 50));
        panel2.add(calculate);
        panel2.add(clear);

        panel3.setLayout(new FlowLayout(FlowLayout.CENTER, 0,0));
        panel3.setPreferredSize(new Dimension(340, 90));
        panel3.add(result);
        titlePanel.setPreferredSize(new Dimension(280, 60));
        titlePanel.setLayout(new BorderLayout());
        titlePanel.add(title);

        this.add(titlePanel);
        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
        this.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculate) {
            String fileSize = file.getText() + " " + fileOptions.getSelectedItem();
            String bandwidth = band.getText() + " " + bandOptions.getSelectedItem();
            result.setText(dataConverter.download(fileSize, bandwidth));
        } else if (e.getSource() == clear) {
            file.setText("");
            band.setText("");
            result.setText("");
        }
    }
}
