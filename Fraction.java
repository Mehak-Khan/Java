/*
 * Name: Mehak Khan
 * Date: 28 April, 2019
 * Program: Fractions
 * Description: Create a class that works with fractions using methods
 */
package edu.hdsb.gwss.khan.ics4u.u4;

/**
 *
 * @author 1khanmeh3
 */
public class Fraction {

    //INSTANCE VARIABLES 
    private int numerator;
    private int denominator;

    // Numerator is 0 if no parameters passed
    public Fraction() {
        this.numerator = 0;
        this.denominator = 1;
    }

    //INITIALIZE DENOMINATOR TO 1 if only numerator passed
    public Fraction(int numerator) {
        this.numerator = numerator;
        denominator = 1;
    }

    /*IF DEN IS NEGATIVE, SET NUM TO NEGATIVE and DEN POSITIVE
    throw exception if denominator is zero
    **/
    public Fraction(int num, int denom) throws Exception {
        if (denom == 0) {
            throw new Exception("DEN CAN NOT BE ZERO");
        }
        numerator = (denom < 0 ? -num : num);
        denominator = (denom < 0 ? -denom : denom);
        reduce();
    }

    //GETTER num
    public int getNumerator() {
        return numerator;
    }

    //GETTER denom
    public int getDenominator() {
        return denominator;
    }

    //EXACT VALUE
    public double value() {
        return (double) this.getNumerator() / this.getDenominator();
    }

    //NON STATIC LARGER
    public Fraction larger(Fraction f) {
        return larger(this, f);

    }

    //STATIC LARGER
    public static Fraction larger(Fraction f, Fraction g) {
        if (f == null && g == null) {
            return new Fraction();
        }

        if (f == null) {
            return g;
        }
        if (g == null) {
            return f;
        }
        if (f.value() > g.value()) {
            // f.reduce();
            return f;
        } else {
            //g.reduce();
            return g;
        }

    }

    //IMPROPER
    public String toString() {
        return toString(false);
    }

    //IMPROPER AND PROPER
    public String toString(boolean isMixed) {
        //den is never negative 
        if (denominator < 0) {
            denominator = Math.abs(denominator);
            numerator = -1 * numerator;
        }

        //num and den can never be both negative
        if (denominator < 0 && numerator < 0) {
            numerator = Math.abs(numerator);
            denominator = Math.abs(denominator);
        }
        if (isMixed == false) {
            if (denominator != 1) {
                return numerator + "/" + denominator;
            }
            //if den = 1, return num only
            return numerator + "";

        } else {
            int wholeNum = numerator / denominator;
            //can't be proper if wholeNum is zero
            if (wholeNum == 0) {
                return toString(true);
            }
            //if left over is zero, only print wholeNum
            if (numerator - (denominator * wholeNum) == 0) {
                return wholeNum + "";
            }
            return wholeNum + " " + Math.abs(numerator - (denominator * wholeNum)) + "/" + denominator;
        }
    }

    //REDUCE
    private void reduce() {
        int gcd;
        if (numerator < 0) {
            gcd = gcd(-numerator, denominator);
        } else {
            gcd = gcd(numerator, denominator);
        }
        if (gcd != 0) {
            numerator = numerator / gcd;
            denominator = denominator / gcd;
        }
    }

    //GCD
    public static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        } else {
            return gcd(q, p % q);
        }
    }

    //ADD - NON STATIC
    public Fraction add(Fraction f) {
        return add(this, f);
    }

    //ADD -  STATIC
    public static Fraction add(Fraction f, Fraction g) {
        Fraction answer = new Fraction();
        if (f == null && g == null) {
            return answer; //returns 0 (value) as answer has no parameters
        }

        if (f == null) {
            return g;
        }
        if (g == null) {
            return f;
        }

        answer.numerator = (g.getNumerator() * f.getDenominator()) + (f.getNumerator() * g.getDenominator());
        answer.denominator = (g.getDenominator() * f.getDenominator());
        answer.reduce();
        return answer;
    }

    //SUBTRACT - NON STATIC
    public Fraction subtract(Fraction f) throws Exception {
        return subtract(this, f);
    }

    //SUBTRACT - STATIC
    public static Fraction subtract(Fraction g, Fraction f) {
        Fraction answer = new Fraction();
        if (f == null && g == null) {
            return answer;
        }
        if (f == null) {
            return g;
        }
        if (g == null) {
            return f;
        }
        answer.numerator = (g.getNumerator() * f.getDenominator()) - (f.getNumerator() * g.getDenominator());
        answer.denominator = (g.getDenominator() * f.getDenominator());
        return answer;
    }

    //TIMES - NON STATIC
    public Fraction times(Fraction f) {
        return times(this, f);
    }

    //TIMES -  STATIC
    public static Fraction times(Fraction f, Fraction g) {
        Fraction answer = new Fraction();
        if (f == null && g == null) {
            return answer;
        }
        if (f == null) {
            return g;
        }
        if (g == null) {
            return f;
        }

        answer.numerator = g.getNumerator() * f.getNumerator();
        answer.denominator = g.getDenominator() * f.getDenominator();
        answer.reduce();
        return answer;
    }

    //DIVIDE - NON STATIC
    public Fraction divide(Fraction f) {
        return divide(this, f);
    }

    //DIVIDE - STATIC
    public static Fraction divide(Fraction g, Fraction f) {
        Fraction answer = new Fraction();
        if (f == null && g == null) {
            return answer;
        }
        if (f == null) {
            return g;
        }
        if (g == null) {
            return f;
        }

        answer.numerator = g.getNumerator() * f.getDenominator();
        answer.denominator = g.getDenominator() * f.getNumerator();
        answer.reduce();
        return answer;
    }

    //INVERT
    public void invert() throws Exception {
        if (numerator == 0) {
            throw new Exception("DEN CANNOT BE ZERO");
        }
        int store = denominator;
        denominator = numerator;
        numerator = store;
    }

    //EQUALS
    public boolean equals(Fraction f) {
        return this.value() == f.value();
    }

}
