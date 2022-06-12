package CalculatorProject.View;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

import CalculatorProject.Controller.*;
import CalculatorProject.Model.*;
public class BatchPanel extends JPanel implements ActionListener {
    private final BinaryCalculator binaryCalc;
    private final HexCalculator hexCalc;
    private final SizeUnit sizeCalc;
    private final RateUnit rateCalc;
    private final FrequencyUnit freqCalc;
    private final Decimal d;
    private final JLabel status;
    private final JButton filePick;

    public BatchPanel() {
        binaryCalc = new BinaryCalculator();
        hexCalc = new HexCalculator();
        sizeCalc = new SizeUnit();
        rateCalc = new RateUnit();
        freqCalc = new FrequencyUnit();
        d = new Decimal();
        status = new JLabel("Status");
        filePick = new JButton("Choose a file");
        filePick.addActionListener(this);
        JLabel title = new JLabel("Batch File Reader");
        title.setFont(new Font("Comic Sans", Font.BOLD, 20));

        this.setSize(500,600);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        JPanel titlePanel = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        titlePanel.setPreferredSize(new Dimension(500,100));
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0,0));
        titlePanel.add(title);

        panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 0,0));
        panel1.setPreferredSize(new Dimension(500, 100));
        panel1.add(new JLabel("Click to read a file!"));
        panel1.add(filePick);

        panel2.setPreferredSize(new Dimension(180, 100));
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        panel2.add(status);

        this.add(titlePanel);
        this.add(panel1);
        this.add(panel2);
        this.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == filePick) {
            JFileChooser choices = new JFileChooser();
            choices.setMultiSelectionEnabled(false);
            choices.setFileFilter(new FileNameExtensionFilter(".txt files", "txt"));
            choices.setCurrentDirectory(new File(new File("src").getAbsolutePath()));

            File file;
            Scanner input;
            int response;
            response = choices.showOpenDialog(null);

            if (response == JFileChooser.APPROVE_OPTION) {
                file = choices.getSelectedFile();
                try {
                    input = new Scanner(file);
                    if (file.isFile()) {
                        PrintStream output = new PrintStream(new File("answers.txt"));
                        String command;
                        if (input.hasNextLine()) {
                            command = input.nextLine();
                        }

                        while (input.hasNextLine()) {
                            command = input.nextLine();
                            if (command.contains("//") && input.hasNextLine()) {
                                command = input.nextLine();
                            }
                            String result = calculatorChoice(command, binaryCalc, hexCalc, sizeCalc, rateCalc, freqCalc, d);
                            output.println("|" + command + "|");
                            output.println(result);
                        }
                    }
                    status.setText("Check folder for answers!");
                } catch (FileNotFoundException exception) {
                    status.setText("File not found!");
                }
            }
        }
    }

    /**
     * Reads the user keywords to choose which calculator to use and gets their answer.
     * @param input String input from the user.
     * @param binaryCalc binary calculator class
     * @param hexCalc hex calculator class
     * @param sizeCalc bandwidth calculator class
     * @param rateCalc bandwidth calculator class
     * @param freqCalc bandwidth calculator class
     * @return String result the answers to the users question.
     */
    private static String calculatorChoice(String input, BinaryCalculator binaryCalc, HexCalculator hexCalc, SizeUnit sizeCalc,
                                          RateUnit rateCalc, FrequencyUnit freqCalc, Decimal d) {
        String result = "";

        if (input.toLowerCase().contains("calculate binary")) {
            input = input.substring(17);
            result = binaryCalculation(input, binaryCalc);
        } else if (input.toLowerCase().contains("convert binary to decimal")) {
            input = input.substring(26);
            result += binaryCalc.convertToDecimal(input);
        } else if (input.toLowerCase().contains("convert decimal to binary")) {
            input = input.substring(26);
            d.setValue(Integer.parseInt(input));
            result = binaryCalc.decimalToBinary(d);
        } else if (input.toLowerCase().contains("calculate hexadecimal")) {
            input = input.substring(22);
            result = hexCalculation(input, hexCalc);
        } else if (input.toLowerCase().contains("convert hexadecimal to decimal")) {
            input = input.substring(31);
            result += hexCalc.convertToDecimal(input);
        } else if (input.toLowerCase().contains("convert decimal to hexadecimal")) {
            input = input.substring(31);
            d.setValue(Integer.parseInt(input));
            result = hexCalc.decimalToHex(d);
        } else if (input.toLowerCase().contains("convert data unit to")) {
            input = input.substring(21);
            result = sizeCalc.unitConvert(input);
        } else if (input.toLowerCase().contains("calculate download/upload time")) {
            input = input.substring(31);
            String fileSize = input.substring(0, input.indexOf("s") + 1);
            String bandwidth = input.substring(input.indexOf("s") + 2);
            result = rateCalc.download(fileSize, bandwidth);
        } else if (input.toLowerCase().contains("calculate website bandwidth")) {
            input = input.substring(28);
            result = websiteFix(input, freqCalc);
        } else if (input.toLowerCase().contains("convert monthly usage to bandwidth")) {
            input = input.substring(35);
            result = hostFix(input, rateCalc);
        } else {
            result = "Invalid Input, Try again!";
        }

        return result;
    }

    /**
     * Helper function to divide both the binary values to be added
     * @param input User input for the addition, subtraction, multiplication and division calculators.
     * @param binaryCalc binary calculator class.
     * @return String result the answer to the users question.
     */
    private static String binaryCalculation(String input, BinaryCalculator binaryCalc) {
        String operation = input.substring(0,1);
        String binary = input.substring(2);
        String binary1 = binary.substring(0, binary.indexOf(" "));
        String binary2 = binary.substring(binary.indexOf(" ") + 1);

        switch (operation) {
            case "+":
                input = binaryCalc.add(binary1, binary2);
                break;
            case "-":
                input = binaryCalc.sub(binary1, binary2);
                break;
            case "*":
                input = binaryCalc.mul(binary1, binary2);
                break;
            default:
                input = binaryCalc.div(binary1, binary2);
                break;
        }

        return input;
    }

    /**
     * Helper function to divide both the hex values to be added
     * @param input User input for the addition, subtraction, multiplication and division calculators.
     * @param hexCalc hex calculator class.
     * @return String result the answer to the users question.
     */
    private static String hexCalculation(String input, HexCalculator hexCalc) {
        String operation = input.substring(0,1);
        String hex = input.substring(2);
        String hex1 = hex.substring(0, hex.indexOf(" "));
        String hex2 = hex.substring(hex.indexOf(" ") + 1);

        switch (operation) {
            case "+":
                input = hexCalc.add(hex1, hex2);
                break;
            case "-":
                input = hexCalc.sub(hex1, hex2);
                break;
            case "*":
                input = hexCalc.mul(hex1, hex2);
                break;
            default:
                input = hexCalc.div(hex1, hex2);
                break;
        }

        return input;
    }

    /**
     * Fixes the user string to properly use the bandwidth calculator.
     * @param input User input for the website bandwidth calculator to be fixed.
     * @param freqCalc Frequency class.
     * @return String result with the answer.
     */
    private static String websiteFix(String input, FrequencyUnit freqCalc) {
        String pageView = "";
        String result = "";
        for (int i = 0; i < 3; i++) {
            pageView = pageView + input.substring(0, input.indexOf(" "));
            input = input.substring(input.indexOf(" ") + 1);
            if (i < 2) {
                pageView += " ";
            }
        }

        String pageSize = input.substring(0, input.indexOf("s") + 1);
        int redundancy = Integer.parseInt(input.substring(input.indexOf("s") + 2));
        result = freqCalc.website(pageView, pageSize, redundancy);

        return result;
    }

    /**
     * Fixes the user string to properly use the bandwidth calculator.
     * @param input User input for the hosting bandwidth calculator to be fixed.
     * @param rateCalc Rate class.
     * @return String result with the answer.
     */
    private static String hostFix(String input, RateUnit rateCalc) {
        String monthlyUse = input.substring(0, input.indexOf('s') + 1);
        String bandwidth = input.substring(input.indexOf('s') + 2);

        return rateCalc.hostBandwidth(monthlyUse, bandwidth);
    }

}
