package CalculatorProject.Model;

public class SizeUnit extends Unit{
    private String size;

    public SizeUnit(String size) {
        this.size = size;
    }

    public SizeUnit() {

    }

    /**
     * Converts the user input into every other unit.
     * @param input String with the decimal value and unit.
     * @return String a Giant string with all of its conversions.
     * @throws {IllegalArgumentException} if the decimal value is less than 1, or more than 1000.
     */
    public String unitConvert(String input) {
        String result = "";
        double data = Double.parseDouble(input.substring(0, input.indexOf(" "))); //cuts the decimal
        String unit = input.substring(input.indexOf(" ") + 1); // cuts the unit

        if (data < 1 || data > 1000) {
            throw new IllegalArgumentException();
        }

        // Converts to bits.
        if (!unit.equalsIgnoreCase("bits")) {
            data = unitInBits(data, unit);
            result = result + data + " bits\n";
        }

        // Readds every unit other than the given one and reconverts the bits from above.
        for (int i = 0; i < NUM_UNITS.length; i++) {
            if(!unit.equalsIgnoreCase(UNITS[i])) {
                result += data / NUM_UNITS[i];
                result = result + " " + UNITS[i];
                if (i < NUM_UNITS.length - 1) {
                    result += "\n";
                }
            }
        }

        return result;
    }

    public String toString() {
        return this.size;
    }

}
