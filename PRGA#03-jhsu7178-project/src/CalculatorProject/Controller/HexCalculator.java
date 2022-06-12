package CalculatorProject.Controller;
import CalculatorProject.Model.Decimal;
import CalculatorProject.Model.Hex;

/**
 * A {HexCalculator} object represents the hex calculator. It can convert hex to decimal
 * and vice versa. It can also add/sub/multi/divide other hex numbers.
 */
public class HexCalculator extends Calculator {

    public HexCalculator() {

    }

    /**
     * Adds two hex strings.
     * @param h1 Hex string 1
     * @param h2 Hex string 2
     * @return New Hex String from the two hex strings.
     */
    public String add(String h1, String h2) {
        Hex hex = new Hex();
        Decimal addition1;
        Decimal addition2;
        addition1 = hex.getValue(h1);
        addition2 = hex.getValue(h2);
        int sum = addition1.getValue() + addition2.getValue();
        addition1.setValue(sum);

        return hex.parseDecimal(addition1);
    }

    /**
     * Subtracts two hex strings.
     * @param h1 Hex string 1
     * @param h2 Hex string 2
     * @return New Hex String from the two hex strings.
     */
    public String sub(String h1, String h2) {
        Hex hex = new Hex();
        String result = "";
        Decimal suh1;
        Decimal suh2;
        suh1 = hex.getValue(h1);
        suh2 = hex.getValue(h2);
        int sum = suh1.getValue() - suh2.getValue();
        if (sum < 0) {
            result += "-";
            sum *= -1;
        }
        suh1.setValue(sum);

        return result + hex.parseDecimal(suh1);
    }

    /**
     * Multiplies two hex strings.
     * @param h1 Hex string 1
     * @param h2 Hex string 2
     * @return New Hex String from the two hex strings.
     */
    public String mul(String h1, String h2) {
        Hex hex = new Hex();

        Decimal mul1;
        Decimal mul2;
        mul1 = hex.getValue(h1);
        mul2 = hex.getValue(h2);
        int sum = mul1.getValue() * mul2.getValue();
        mul1.setValue(sum);

        return hex.parseDecimal(mul1);
    }

    /**
     * Divides two hex strings.
     * @param h1 Hex string 1
     * @param h2 Hex string 2
     * @return New Hex String from the two hex strings.
     */
    public String div(String h1, String h2) {
        Hex hex = new Hex();
        String result = "";
        Decimal div1;
        Decimal div2;
        div1 = hex.getValue(h1);
        div2 = hex.getValue(h2);
        int sum = div1.getValue() / div2.getValue();
        int remainder = div1.getValue() % div2.getValue();
        div1.setValue(sum);
        result += hex.parseDecimal(div1);
        if (remainder != 0) {
            div1.setValue(remainder);
            result += ", Remainder: ";
            result += hex.parseDecimal(div1);
        }


        return result;
    }

    /**
     * Converts a hex string into an integer..
     * @param h hex string to be converted into a number.
     * @return number Decimal from the converted hex string.
     */

    public Decimal convertToDecimal(String h) {
        Hex hex = new Hex();
        return hex.getValue(h);
    }

    /**
     * Converts an integer number into a hex number.
     * @param decimal Decimal number to be converted into a hex number.
     * @return hex String from the converted integer.
     */
    public String decimalToHex(Decimal decimal) {
        Hex hex = new Hex();
        return hex.parseDecimal(decimal);
    }
}
