package CalculatorProject.Model;

/**
 * A {HexLetters} enum class to find and change between special hex letter cases.
 */
public enum HexLetters {
    A(10), B(11), C(12), D(13), E(14), F(15);
    private final int decimal;

    HexLetters(int decimal) {
        this.decimal = decimal;
    }


    public int getDecimal() {
        return decimal;
    }

    public static HexLetters getLetter(int num) {
        HexLetters[] h = HexLetters.values();
        return h[num - 10];
    }

    /**
     * Finds if the letter is part of the Hex.
     * @param letter String checks if this letter is part of the enum class.
     * @return boolean if it is or not.
     */
    public static boolean contains(String letter) {
        HexLetters[] h = HexLetters.values();
        Boolean result = false;
        for (HexLetters hexLetters : h) {
            String comparison = "" + hexLetters;
            if (comparison.equals(letter)) {
                result = true;
                break;
            }
        }

        return result;
    }
}
