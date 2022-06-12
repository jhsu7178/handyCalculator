package CalculatorProject.Controller;
import CalculatorProject.Model.Decimal;
abstract class Calculator implements Convertible {
    public abstract String add(String s1, String s2);
    public abstract String sub(String s1, String s2);
    public abstract String mul(String s1, String s2);
    public abstract String div(String s1, String s2);
    public abstract Decimal convertToDecimal(String s);

}
