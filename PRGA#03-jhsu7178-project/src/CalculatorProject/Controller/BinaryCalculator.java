package CalculatorProject.Controller;
import CalculatorProject.Model.Decimal;
import CalculatorProject.Model.Binary;

public class BinaryCalculator extends Calculator {
    public BinaryCalculator() {

    }

    /**
     * Adds the two binary strings.
     * @param b1 Binary String 1
     * @param b2 Binary String 2
     * @return String with the added binary number
     */
    public String add(String b1, String b2) {
        Binary binary = new Binary();
        Decimal addition1;
        Decimal addition2;
        addition1 = binary.getValue(b1);
        addition2 = binary.getValue(b2);
        int sum = addition1.getValue() + addition2.getValue();
        addition1.setValue(sum);

        return binary.parseDecimal(addition1);
    }

    /**
     * Subtracts the two binary strings.
     * @param b1 Binary String 1
     * @param b2 Binary String 2
     * @return String with the added binary number
     */
    public String sub(String b1, String b2) {
        Binary binary = new Binary();
        String result = "";
        Decimal sub1;
        Decimal sub2;
        sub1 = binary.getValue(b1);
        sub2 = binary.getValue(b2);
        int sum = sub1.getValue() - sub2.getValue();
        if (sum < 0) {
            result += "-";
            sum *= -1;
        }
        sub1.setValue(sum);

        return result + binary.parseDecimal(sub1);
    }

    /**
     * Multiplies the two binary strings.
     * @param b1 Binary String 1
     * @param b2 Binary String 2
     * @return String with the added binary number
     */
    public String mul(String b1, String b2) {
        Binary binary = new Binary();

        Decimal mul1;
        Decimal mul2;
        mul1 = binary.getValue(b1);
        mul2 = binary.getValue(b2);
        int sum = mul1.getValue() * mul2.getValue();
        mul1.setValue(sum);

        return binary.parseDecimal(mul1);
    }

    /**
     * Divides the two binary strings.
     * @param b1 Binary String 1
     * @param b2 Binary String 2
     * @return String with the added binary number
     */
    public String div(String b1, String b2) {
        Binary binary = new Binary();
        String result = "";
        Decimal div1;
        Decimal div2;
        div1 = binary.getValue(b1);
        div2 = binary.getValue(b2);
        int sum = div1.getValue() / div2.getValue();
        int remainder = div1.getValue() % div2.getValue();
        div1.setValue(sum);
        result += binary.parseDecimal(div1);
        if (remainder != 0) {
            div1.setValue(remainder);
            result += ", Remainder: ";
            result += binary.parseDecimal(div1);
        }
        return result;
    }

    /**
     * Converts binary into a decimal number.
     * @param b Binary String to be converted into a decimal
     * @return int decimal number that was converted from binary.
     * @throws {IllegalArgumentException} if the binary number is longer than 16 bits.
     */

    public Decimal convertToDecimal(String b) {
        Binary binary = new Binary();
        return binary.getValue(b);
    }

    /**
     * Converts a decimal number into a binary number.
     * @param decimal the integer number to be converted into a binary.
     * @return String containing the binary number.
     */
    public String decimalToBinary(Decimal decimal) {
        Binary binary = new Binary();
        return binary.parseDecimal(decimal);
    }
}
