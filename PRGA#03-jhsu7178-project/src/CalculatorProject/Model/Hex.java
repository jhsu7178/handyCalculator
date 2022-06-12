package CalculatorProject.Model;
/**
 * A {Hex} object represents the hex calculator. It can convert hex to decimal
 * and vice versa.
 */
public class Hex extends Number {
    private static final int HEX = 16; // Used since HEX is base 16.
    private String hex; // Used to store the hex letters.

    public Hex() {

    }

    /**
     * Gives the hex string.
     * @return hex String
     */
    public String toString() {
        return hex;
    }

    /**
     * Sets hex value
     * @param hex String hex from user
     */
    public void setValue(String hex) {
        this.hex = hex;
    }

    /**
     * Converts a hex string into an integer..
     * @param hex hex string to be converted into a number.
     * @return number Decimal from the converted hex string.
     * @throws {IllegalArgumentException} if length > 4 or is not a hex letter. (ABCDEF)
     */
    public Decimal getValue(String hex) {
        if (hex.length() > 4) {
            throw new IllegalArgumentException("Hex string is too long");
        }

        Decimal result = new Decimal(0);
        int hexExponent = hex.length() - 1;

        for (int i = 0; i < hex.length(); i++) {
            Decimal decimal = new Decimal();
            if (HexLetters.contains(hex.substring(i, i + 1))) {
                HexLetters hexLetter = Enum.valueOf(HexLetters.class, hex.substring(i, i + 1));
                decimal.setValue(hexLetter.getDecimal());
            } else if (Character.getNumericValue(hex.charAt(i)) >= HEX) {
                throw new IllegalArgumentException("Not valid Hex number");
            } else {
                decimal.setValue(Character.getNumericValue(hex.charAt(i)));
            }
            result.add(decimal.mul((int) Math.pow(HEX, hexExponent)));
            hexExponent--;
        }

        return result;
    }

    /**
     * Converts an Decimal number into a hex number.
     * @param num Decimal number to be converted into a hex number.
     * @return hex String from the converted integer.
     */
    public String parseDecimal(Decimal num) {
        String result = "";

        while (num.getValue() > HEX) {
            int exponent = 0;
            int exponentCount = num.getValue();

            while (exponentCount > HEX) { // Finds the exponent count from base 16
                exponentCount /= HEX;
                exponent++;
            }

            int hexNum = num.getValue() / (int) Math.pow(HEX, exponent);
            if (hexNum < 10) {
                result += hexNum;
            } else if (hexNum == HEX){
                result = result + "10";
            } else {
                result += HexLetters.getLetter(hexNum);
            }
            num.sub((int) Math.pow(HEX, exponent) * hexNum);
        }
        if (num.getValue() > 9) {
            result += HexLetters.getLetter(num.getValue());
        } else {
            result += num.toString();
        }

        return result;
    }
}