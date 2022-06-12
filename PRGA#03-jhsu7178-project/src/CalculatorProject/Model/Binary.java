package CalculatorProject.Model;

/**
 * A {Binary} object used to store and return decimal values of the given Binary.
 */
public class Binary extends Number {
    private static final int BINARY = 2;
    private String binary;

    public Binary() {

    }

    public Binary(String b) {
        this.binary = b;
    }

    public String toString() {
        return binary;
    }

    public void setValue(String binary) {
        this.binary = binary;
    }


    /**
     * Converts binary into a decimal number.
     * @param binary Binary String to be converted into a decimal
     * @return int decimal number that was converted from binary.
     * @throws {IllegalArgumentException} if the binary number is longer than 16 bits.
     */
    public Decimal getValue(String binary) {
        if (binary.length() > 16) {
            throw new IllegalArgumentException("Binary Argument Too Long.");
        }

        int binaryLength = binary.length();
        Decimal decimal = new Decimal(0);

        // Converts the binary to a decimal.
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) != '0' && binary.charAt(i) != '1') {
                throw new IllegalArgumentException("Not A Valid Binary Number.");
            }
            decimal.add(Character.getNumericValue(binary.charAt(i)) * (int) Math.pow(BINARY, binaryLength - 1));
            binaryLength--;
        }

        return decimal;
    }


    /**
     * Converts a decimal number into a binary number.
     * @param decimal the integer number to be converted into a binary.
     * @return String containing the binary number.
     */
    public String parseDecimal(Decimal decimal) {
        int exponentCount = 0;
        int decimalConvert = decimal.getValue();
        String number = "";

        // Used to find the exponent to be raised to.
        while (BINARY <= decimalConvert) {
            decimalConvert = decimalConvert / BINARY;
            exponentCount++;
        }

        // Used to convert into binary.
        int exponentSub = exponentCount;
        for (int i = 0; i <= exponentCount; i++) {
            if (decimal.getValue() - (int) Math.pow(BINARY, exponentSub) >= 0) {
                number = number + "1";
                decimal.setValue(decimal.getValue() - (int) Math.pow(BINARY, exponentSub));
            } else {
                number = number + "0";
            }
            exponentSub--;
        }

        return number;
    }


}