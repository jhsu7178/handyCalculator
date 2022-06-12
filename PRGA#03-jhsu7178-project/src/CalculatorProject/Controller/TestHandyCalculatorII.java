package CalculatorProject.Controller;
import CalculatorProject.Model.*;

/**
 * A {TestCalculator} object that is not used in the main program for now. Simply make the new object
 * if you wish to see functionality in Main. Everything is called in the constructor.
 */
public class TestHandyCalculatorII {
    public TestHandyCalculatorII() {

        // Decimal objects
        System.out.println("DECIMAL OBJECT TESTING");
        Decimal d = new Decimal(10);
        d.setValue(20);
        System.out.println(d.toString());
        System.out.println(d.getValue());
        d.setValue(-1);
        System.out.println(d.toString());
        System.out.println(d.getValue());
        d.setValue(29920);
        System.out.println(d.toString());
        System.out.println(d.getValue());


        // Binary objects
        System.out.println("BINARY OBJECT TESTING");
        Binary b = new Binary();
        System.out.println(b.parseDecimal(d));
        System.out.println(b.getValue("10010"));
        System.out.println(b.getValue("0"));
        System.out.println(b.getValue("101010101"));
        System.out.println();

        // Enum hexletter object tests
        System.out.println("ENUM HELPER CLASS TEST");
        HexLetters[] h = HexLetters.values();

        for (int i = 0; i < h.length; i++) {
            System.out.print(HexLetters.getLetter(10) + " ");
        }
        System.out.println();

        // Additional Hex object tests.
        System.out.println("HEX OBJECT TESTING");
        Hex hehe = new Hex();

        d.setValue(7840);
        System.out.println(hehe.parseDecimal(d));
        HexLetters kek = Enum.valueOf(HexLetters.class, "A");
        System.out.println(kek.getDecimal());
        System.out.println(h[0]);
        String result = "" + h[0];
        System.out.println(result);
        System.out.println(hehe.getValue("14"));
        System.out.println(hehe.parseDecimal(d));
        System.out.println(hehe.getValue("1AB2"));
        System.out.println(hehe.getValue("A423"));
        System.out.println(hehe.getValue("AA"));

        d.setValue(299);
        System.out.println(hehe.parseDecimal(d));
        System.out.println();

        // Realistically the Binary and Hex UNITs handle the parsing, so the calculator doesn't (This is kind of a mistake)
        // Binary Calculator tests
        System.out.println("BINARY CALC TESTS");
        BinaryCalculator bCalc = new BinaryCalculator();
        System.out.println(bCalc.add("10010", "110101"));
        System.out.println(bCalc.add("101", "1"));
        System.out.println(bCalc.add("1001011", "11010111"));
        System.out.println(bCalc.sub("10010", "110101"));
        System.out.println(bCalc.sub("101", "1"));
        System.out.println(bCalc.sub("1001011", "11010111"));
        System.out.println(bCalc.mul("10010", "110101"));
        System.out.println(bCalc.mul("101", "1"));
        System.out.println(bCalc.mul("1001011", "11010111"));
        System.out.println(bCalc.div("10010", "110101"));
        System.out.println(bCalc.div("101", "1"));
        System.out.println(bCalc.div("1001011", "11010111"));
        System.out.println();

        // Hex Calculator tests
        System.out.println("HEX CALC TESTS");
        HexCalculator hCalc = new HexCalculator();
        System.out.println(hCalc.add("AB14", "92"));
        System.out.println(hCalc.add("BBB1", "1"));
        System.out.println(hCalc.add("B14", "A"));
        System.out.println(hCalc.sub("AB14", "92"));
        System.out.println(hCalc.sub("BBB1", "1"));
        System.out.println(hCalc.sub("B14", "A"));
        System.out.println(hCalc.mul("AB14", "92"));
        System.out.println(hCalc.mul("BBB1", "1"));
        System.out.println(hCalc.mul("B14", "A"));
        System.out.println(hCalc.div("AB14", "92"));
        System.out.println(hCalc.div("BBB1", "1"));
        System.out.println(hCalc.div("B14", "A"));
        System.out.println();

        // Size unit tests
        SizeUnit sCalc = new SizeUnit();
        System.out.println(sCalc.unitConvert("500 Megabytes"));
        System.out.println(sCalc.unitConvert("21 Terabytes"));
        System.out.println(sCalc.unitConvert("2 bits"));

        // Rate unit tests
        RateUnit rCalc = new RateUnit();
        System.out.println(rCalc.download("500 Megabytes", "5 Mbit/s"));
        System.out.println(rCalc.download("11 Bytes", "1 Mbit/s"));
        System.out.println(rCalc.download("32 Megabytes", "5 Tbit/s"));
        System.out.println(rCalc.hostBandwidth("1000 Gigabytes", "Mbit/s"));
        System.out.println(rCalc.hostBandwidth("125 Megabytes", "Gbit/s"));
        System.out.println(rCalc.hostBandwidth("2 Terabytes", "bit/s"));
        System.out.println(rCalc.bandwidthInMonths("1000 Mbit/s", "Terabytes"));
        System.out.println(rCalc.bandwidthInMonths("125 Gbit/s", "Megabytes"));
        System.out.println(rCalc.bandwidthInMonths("2 Tbit/s", "Kilobytes"));

        // Frequency Unit tests
        FrequencyUnit fCalc = new FrequencyUnit();
        System.out.println(fCalc.website("1000 Per Day", "500 Kilobytes", 2));
        System.out.println(fCalc.website("22 Per Year", "21 Bytes", 10));
        System.out.println(fCalc.website("1 Per Day", "500 Terabytes", 1));




        // Error Tests
       // System.out.println(b.getValue("100102"));
     //   System.out.println(b.getValue("100101110101001011"));
     //  System.out.println(hehe.getValue("HIJK"));
      //  System.out.println(hehe.getValue("AAAAA"));


    }

}



