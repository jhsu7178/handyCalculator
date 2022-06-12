package CalculatorProject.Model;

/**
 * A {FrequencyUnit} Handles the frequency Calculator operations using the string view, size and redundancy factor.
 */
public class FrequencyUnit extends Unit {
    private String view;
    private String size;
    private int redundancyFactor;

    public FrequencyUnit() {

    }

    public FrequencyUnit(String view, String size, int redundancy) {
        this.view = view;
        this.size = size;
        this.redundancyFactor = redundancy;
    }

    /**
     *
     * @param views String page views with the decimal and amount of time.
     * @param size String page size with decimal and unit
     * @param redundancy int redundancy factor.
     * @return String with the amount of bandwidth needed in megabits and GBs.
     * @throws {IllegalArgumentException }if the decimals are less than 1 or more than 1000. Also if redundancy is less than 1
     * or more than 10. Also if page size is less than 1 or more than 1024.
     */
    public String website(String views, String size, int redundancy) {
        double pageView = Double.parseDouble(views.substring(0, views.indexOf(" ")));
        String timeUnit = views.substring(views.indexOf(" ") + 1);

        if (pageView < 1 || pageView > 1000) {
            throw new IllegalArgumentException();
        }

        double pageSize = Double.parseDouble(size.substring(0, size.indexOf(" ")));
        String dataUnit = size.substring(size.indexOf(" ") + 1);

        if (pageSize < 1 || pageSize > 1024) {
            throw new IllegalArgumentException();
        }

        if (redundancy < 1 || redundancy > 10) {
            throw new IllegalArgumentException();
        }

        int seconds = timeInSeconds(timeUnit);
        pageView = pageView / seconds;
        pageSize = unitInBits(pageSize, dataUnit);
        pageSize = pageSize / NUM_UNITS[1];
        double bandwidth = pageView * pageSize;
        double bandwidthInGbMonths = bandwidth * 0.000125 * secondToMonth;

        return "Actual bandwidth needed is " + bandwidth + " Mbit/s\nor " + bandwidthInGbMonths +
                " GB per month.\nWith redundancy factor of " + redundancy + ", the bandwidth needed " +
                "is\n" + (bandwidth * redundancy) + " Mbit/s or\n" + (bandwidthInGbMonths * redundancy) +
                " GB per month.";
    }

    /**
     * Converts to string
     * @return String view, size and redundancy factor.
     */
    public String toString() {
        return view + " " + size + " " + redundancyFactor;
    }
}
