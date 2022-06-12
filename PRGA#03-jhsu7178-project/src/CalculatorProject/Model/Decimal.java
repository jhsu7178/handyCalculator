package CalculatorProject.Model;
/**
 * A {Decimal} object represents the Decimal calculator. Wrapper class for
 * an integer.
 */
public class Decimal extends Number {

    public Decimal() {

    }


    public Decimal(int num) {
        this.number = num;
    }

    /**
     * Gives the integer.
     * @return Decimal String
     */
    public String toString() {
        return "" + number;
    }

    /**
     * Adds the integer into the object.
     * @param num integer
     * @return The added sum.
     */
    public int add(int num) {
        this.number += num;
        return this.number;
    }

    /**
     * Subtracts the integer into the object.
     * @param num integer
     * @return The subtracted sum.
     */
    public int sub(int num) {
        this.number -= num;
        return this.number;
    }

    /**
     * Multiplies the integer into the object.
     * @param num integer
     * @return The multiplied sum.
     */
    public int mul(int num) {
        this.number *= num;
        return this.number;
    }

    /**
     * Divides the integer into the object.
     * @param num integer
     * @return The divided sum.
     */
    public int div(int num) {
        this.number /= num;
        return this.number;
    }




}