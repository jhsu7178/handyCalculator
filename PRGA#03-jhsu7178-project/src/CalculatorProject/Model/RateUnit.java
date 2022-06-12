package CalculatorProject.Model;

public class RateUnit extends Unit {
    private String rate;
    private String bandwidth;

    public RateUnit(String rate, String bandwidth) {
        this.rate = rate;
        this.bandwidth = bandwidth;
    }

    public RateUnit() {

    }

    /**
     * Calculates the time needed to download.
     * @param size String file size with the decimal and unit.
     * @param bandwidth String bandwidth with the decimal and unit.
     * @return String wth the time needed to download.
     * @throws {IllegalArgumentException} if the decimals are less than 1 or more than 1000.
     */
    public String download(String size, String bandwidth) {
        double data1 = Double.parseDouble(size.substring(0, size.indexOf(" ")));
        String unit1 = size.substring(size.indexOf(" ") + 1);

        if (data1 < 1 || data1 > 1000) {
            throw new IllegalArgumentException();
        }

        double data2 = Double.parseDouble(bandwidth.substring(0, bandwidth.indexOf(" ")));
        String unit2 = bandwidth.substring(bandwidth.indexOf(" ") + 1);

        if (data2 < 1 || data2 > 1000) {
            throw new IllegalArgumentException();
        }

        if (!unit2.equalsIgnoreCase("bit/s")) {
            unit2 = downloadUnits(unit2);
            data2 = unitInBits(data2, unit2);
        }

        data1 = unitInBits(data1, unit1);

        double resultInSeconds = data1 / data2;

        return time(resultInSeconds);
    }


    /**
     * Converts the amount of bandwidth per month in megabits per second.
     * @param monthUse String with the decimal and units.
     * @return String with the equal amount in megabits.
     * @throws {IllegalArgumentException} if the decimal is less than 1 or more than 1000.
     */
    public String hostBandwidth(String monthUse, String band) {
        String result = "";
        double monthlyUse = Double.parseDouble(monthUse.substring(0, monthUse.indexOf(" ")));

        if (monthlyUse < 1 || monthlyUse > 1000) {
            throw new IllegalArgumentException();
        }

        String unit = monthUse.substring(monthUse.indexOf(" ") + 1);
        double bandwidth = unitInBits(monthlyUse, unit);
        for (int i = 0; i < TRIMMED_BITS.length; i++) {
            if (TRIMMED_BITS[i].equals(band)) {
                bandwidth = bandwidth / NUM_UNITS[i];
            }
        }
        bandwidth = bandwidth / secondToMonth;
        result = result + monthUse + " per month\nis equivalent to\n" + bandwidth + " " + band;
        return result;
    }

    public String bandwidthInMonths(String bandwidth, String month) {
        double bandUse = Double.parseDouble(bandwidth.substring(0, bandwidth.indexOf(" ")));
        String result = "";
        if (bandUse < 1 || bandUse > 1000) {
            throw new IllegalArgumentException();
        }

        String unit = downloadUnits(bandwidth.substring(bandwidth.indexOf(" ") + 1));
        double monthUse = unitInBits(bandUse, unit);
        monthUse *= secondToMonth;
        for (int i = 0; i < UNITS.length; i++) {
            if (UNITS[i].equals(month)) {
                monthUse /= NUM_UNITS[i];
            }
        }
        result = result + bandwidth + " is equivalent to " + monthUse + " " + month + " per month.";
        return result;
    }

    public String toString() {
        return rate + " " + bandwidth;
    }

}
