package CalculatorProject.Model;

abstract class Number {
    public int number;

    public abstract String toString();


    public int getValue() {
        return number;
    }

    public void setValue(int num) {
        this.number = num;
    }
}