
public class FractionTest {
    public static void main(String[] args) {

        // test divide by zero - should print an error and exit
        new Fraction(1, 0);

        // test multiply
        Fraction f = new Fraction(3,10);
        Fraction g = new Fraction(1,2);
        Fraction h = new Fraction(3,5);

        if (!f.equals(g.multiply(h))) System.out.println("Multiply failed");

        // test equals
        test(new Fraction(1, 2),new Fraction(1, 2),"error test 1");
        test(new Fraction(1, 2),new Fraction(3, 6),"error test 2");
        test(new Fraction(-1, 2),new Fraction(1, -2),"error test 3");
        test(new Fraction(-1, -2),new Fraction(1, 2),"error test 4");
        test(new Fraction(4, -8),new Fraction(1, 2),"error test 5");

        //test add
        Fraction x = new Fraction(3,4);
        Fraction y = new Fraction(1,2);
        Fraction z = new Fraction(1,4);
        if (!x.equals(y.add(z))) System.out.println("Add failed");

        //test subtract
        if (!z.equals(y.subtract(z))) System.out.println("Subtract failed");

        //test divide
        if (!y.equals(z.divide(y))) System.out.println("Divide failed");

        //test absValue
        Fraction k = new Fraction(1,2);
        Fraction l = new Fraction(-1,-2);
        if (!k.equals(l.absValue(l))) System.out.println("absValue failed");

        //test negate
        if (!k.equals(l.negate(l))) System.out.println("negate failed");

    }

    static void test(Fraction f1, Fraction f2, String msg){
        if (! f1.equals(f2))
            System.out.println(msg);
    }
}
