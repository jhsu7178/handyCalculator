package CalculatorProject.Controller;
import CalculatorProject.Model.Decimal;

public class DecimalCalculator extends Calculator {

    public DecimalCalculator() {

    }

    public String add(String d1, String d2) {
        int add1 = Integer.parseInt(d1);
        int add2 = Integer.parseInt(d2);
        int sum = add1 + add2;
        Decimal decimal = new Decimal(sum);

        return decimal.toString();
    }

    public String sub(String d1, String d2) {
        int sub1 = Integer.parseInt(d1);
        int sub2 = Integer.parseInt(d2);
        int sum = sub1 - sub2;
        Decimal decimal = new Decimal(sum);

        return decimal.toString();
    }

    public String mul(String d1, String d2) {
        int mul1 = Integer.parseInt(d1);
        int mul2 = Integer.parseInt(d2);
        int sum = mul1 * mul2;
        Decimal decimal = new Decimal(sum);

        return decimal.toString();
    }

    public String div(String d1, String d2) {
        int div1 = Integer.parseInt(d1);
        int div2 = Integer.parseInt(d2);
        int sum = div1 / div2;
        Decimal decimal = new Decimal(sum);

        return decimal.toString();
    }

    public Decimal convertToDecimal(String s) {
        int convert = Integer.parseInt(s);
        return new Decimal(convert);
    }
}
