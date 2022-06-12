package CalculatorProject.View;
import javax.swing.*;
import java.awt.*;

public class CalculatorTabs extends JPanel {
    public CalculatorTabs() {
        super(new GridLayout(1,1));

        JTabbedPane calculateTab = new JTabbedPane();
        JComponent binaryCalc = new BinaryPanel();
        calculateTab.addTab("Binary Calculator", null, binaryCalc, "Calculates binary stuff");
        JComponent hexCalc = new HexPanel();
        calculateTab.addTab("Hex Calculator", null, hexCalc, "Calculates hex stuff");
        JComponent unitCalc = new DataUnitConverter();
        calculateTab.addTab("Data Unit Converter", null, unitCalc, "Converts data units");
        JComponent downloadCalc = new DownloadPanel();
        calculateTab.addTab("Download/Upload Time Calculator", null, downloadCalc, "Calculates download time.");
        JComponent websiteCalc = new WebsitePanel();
        calculateTab.addTab("Website Bandwidth Calculator", null, websiteCalc, "Calculates website bandwidth");
        JComponent hostCalc = new HostingPanel();
        calculateTab.addTab("Hosting Bandwidth Converter", null, hostCalc, "Calculates hosting bandwidth");
        JComponent batchCalc = new BatchPanel();
        calculateTab.addTab("Batch file reader", null, batchCalc, "Reads file input");
        add(calculateTab);

    }
}
