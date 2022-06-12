package CalculatorProject.Model;

abstract class Unit {

    public abstract String toString();
    public static final String[] UNITS = {"kilobits", "megabits", "gigabits", "terabits", "Bytes",
            "Kilobytes", "Megabytes", "Gigabytes", "Terabytes"};
    public static final double[] NUM_UNITS = {Math.pow(10, 3), Math.pow(10, 6), Math.pow(10, 9),
            Math.pow(10, 12), 8, 8000, Math.pow(10, 6) * 8.0,
            Math.pow(10, 9) * 8.0, Math.pow(10, 12) * 8.0};
    public static final String[] TRIMMED_BITS = {"Kbit/s", "Mbit/s", "Gbit/s", "Tbit/s"};
    public static final String[] TIME = {"Per Minute", "Per Hour", "Per Day", "Per Week", "Per Month", "Per Year"};
    public static final int secondToYear = 31540000;
    public static final int secondToMonth = 2628000;
    public static final int secondToWeek = 604800;
    public static final int secondToDay = 86400;
    public static final int secondToHour = 3600;
    public static final int secondToMinute = 60;

    /**
     * Converts the data to bits.
     * @param data Double decimal value
     * @param unit String unit
     * @return double the data converted into bits.
     */
    public double unitInBits(double data, String unit) {
        for (int i = 0; i < UNITS.length; i++) {
            if (unit.equalsIgnoreCase(UNITS[i])) {
                data *= NUM_UNITS[i];
            }
        }
        return data;
    }

    /**
     * Takes out the /s and turns it into the normal looking name.
     * @param unit String unit that looks like bit/s
     * @return String converted bit/s into bits
     */
    public String downloadUnits(String unit) {
        for (int i = 0; i < TRIMMED_BITS.length; i++) {
            if (unit.equalsIgnoreCase(TRIMMED_BITS[i])) {
                unit = UNITS[i];
            }
        }

        return unit;
    }

    /**
     * Converts seconds into amount of days, hours, minutes and seconds.
     * @param resultInSeconds double time in seconds
     * @return String with the amount of days, hours, minutes and seconds
     * from said seconds.
     */
    public String time(double resultInSeconds) {
        String result = "~";

        if (resultInSeconds > secondToDay) {
            long days =  (long) resultInSeconds / secondToDay;
            result = result + days + " days ";
            resultInSeconds = resultInSeconds - (days * secondToDay);
        }

        if (resultInSeconds > secondToHour) {
            long hours = (long) resultInSeconds / secondToHour;
            result = result + hours + " hours ";
            resultInSeconds = resultInSeconds - (hours * secondToHour);
        }

        if (resultInSeconds > secondToMinute) {
            long minutes = (long) resultInSeconds / secondToMinute;
            result = result + minutes + " minutes ";
            resultInSeconds = resultInSeconds - (minutes * secondToMinute);
        }

        if (resultInSeconds >= 1) {
            result = result + (int) resultInSeconds + " second";
        } else {
            result = result + resultInSeconds + " second";
        }

        if (resultInSeconds > 1) {
            result = result + "s";
        }

        return result;
    }

    /**
     * Changes the time into seconds.
     * @param time String to convert each unit into seconds.
     * @return int seconds converted from the time table.
     */
    public int timeInSeconds(String time) {
        int[] timeTable = {secondToMinute, secondToHour, secondToDay, secondToWeek, secondToMonth, secondToYear};
        int seconds = 0;
        for (int i = 0; i < TIME.length; i++) {
            if (time.equalsIgnoreCase(TIME[i])) {
                seconds = timeTable[i];
            }
        }
        return seconds;
    }
}
