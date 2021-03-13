/*
 * Name: Mehak Khan
 * Date: 28 April, 2019
 * Program: TestFractions
 * Description: Client code for testing Fraction Class
 */
package edu.hdsb.gwss.khan.ics4u.u4;

/**
 *
 * @author 1khanmeh3
 */
public class TestFractions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        //test - getDen, getNum, value, toString
        Fraction a = new Fraction(-4, -8);
        assert (a.getNumerator() == 1);
        assert (a.getDenominator() == 2);
        assert (a.value() == 0.5);
        assert (a.toString().equals("1/2"));

        //test - getDen, getNum, value, toString
        Fraction b = new Fraction(4, -8);
        assert (b.getNumerator() == -1);
        assert (b.getDenominator() == 2);
        assert (b.value() == -0.5);
        assert (b.toString().equals("-1/2"));

        //test - toString
        Fraction c = new Fraction(-16, 2);
        assert (c.toString(true).equals("-8"));

        //test - toString
        Fraction d = new Fraction(70, -55);
        assert (d.toString(false).equals("-14/11"));
        assert (d.toString(true).equals("-1 3/11"));

        //EQUALS
        Fraction f = new Fraction(-1, 2);
        assert (f.equals(b));

        //ADD
        assert (a.add(b).equals(new Fraction(0, 16)));
        assert (a.add(c).toString().equals("-15/2"));

        //DIVIDE
        assert (a.divide(b).toString().equals("-1"));
        assert (Fraction.divide(f, d).toString().equals("11/28"));
        assert (d.divide(a).toString().equals("-28/11"));

        //TIMES
        assert (a.times(b).equals(new Fraction(-1, 4)));
        assert (Fraction.times(a, d).equals(new Fraction(-14, 22)));
        assert (a.times(c).equals(new Fraction(-4, 1)));

        //SUBTRACT
        assert (Fraction.subtract(c, f).toString().equals("-15/2"));
        assert (a.subtract(c).toString().equals("17/2"));

        //LARGER
        assert (a.larger(b) == a);
        assert (Fraction.larger(c, d) == d);

        //INVERT
        c.invert();
        assert (c.toString().equals("-1/8"));

        //NULL - add
        assert (c.add(null).toString().equals("-1/8"));
        assert (Fraction.add(null, null).value() == 0);

        //NULL - subtract
        assert (d.subtract(null).value() == -14.0 / 11);
        assert (Fraction.subtract(null, null).value() == 0);

        //NULL - times
        assert (f.times(null).value() == -0.5);
        assert (Fraction.times(null, null).value() == 0);

        //NULL - divide
        assert (f.divide(null).value() == -0.5);
        assert (Fraction.divide(null, null).value() == 0);

        //NULL - larger
        assert (Fraction.larger(null, null).value() == 0);
        assert (f.larger(null).toString().equals("-1/2"));

        //Only numerator
        Fraction h = new Fraction(4);
        assert (h.toString().equals("4"));

        //Num = 0 if no parameters
        Fraction i = new Fraction();
        assert (i.toString().equals("0"));

        //Larger - if equal? 
        Fraction j = new Fraction(-1, 8);
        assert (j.larger(c).toString().equals("-1/8"));
        assert (i.larger(new Fraction(0)).value() == 0);

        //Equals
        Fraction k = new Fraction(22, 7);
        assert (k.divide(new Fraction(22, 7)).toString().equals("1"));

        //TEST - using math
        try {
            //CREATE NEW FRACTION (using 0's as den)
            int num = 1;
            int den = 0;
            Fraction f1 = new Fraction(num, den);
            Fraction f2 = new Fraction(3, 0);

            //VALUE
            double frac = num / den;
            assert (f1.value() == ((double) num / den));

            //ADD
            assert (f1.add(f2).value() == (f1.value() + f2.value()));
            assert (Fraction.add(f1, f2).value() == (f1.value() + f2.value()));

            //SUBTRACT
            assert (f1.subtract(f2).equals(new Fraction(1, 14)));
            assert (Fraction.subtract(f1, f2).toString().equals("1/14"));

            //TIMES
            assert (f1.times(f2).value() == (f1.value() * f2.value()));
            assert (Fraction.times(f1, f2).value() == (f1.value() * f2.value()));

        } catch (Exception e) {
            assert (true);
        }

    }
}
