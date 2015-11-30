import java.util.Scanner;

public class FractionCalculatorTest {
    public static void main(String[] args) {

        Fraction myFraction = new Fraction(0,1);
       // System.out.println(myFractionCalculator.evaluate(myFraction,userInstructions));
        FractionCalculator myFractionCalculator = new FractionCalculator();
        //test user providing input with two consecutive operations
        String invalidInstructions = "1/2 + + 1/3";
        myFractionCalculator.evaluate(myFraction, invalidInstructions);
        //test line provided in instructions
        String courseworkInstructions = "3/4 + 1/-3 * 7 / 5";
        Fraction fraction1 = new Fraction(7,12);
        myFractionCalculator.evaluate(myFraction,courseworkInstructions);
        if (fraction1.equals(myFractionCalculator.getFraction())) System.out.println("Coursework example instructions executed correctly");
        //test consecutive lines provided by user
        String secondInstruction = "- 1/12 + 1/4";
        Fraction fraction2 = new Fraction(3,4);
        myFractionCalculator.evaluate(myFractionCalculator.getFraction(),secondInstruction);
        if (fraction2.equals(myFractionCalculator.getFraction())) System.out.println("Consecutive lines instructions executed correctly");
        //test clear instruction
        String clearInstruction = "clear";
        myFractionCalculator.evaluate(myFractionCalculator.getFraction(),clearInstruction);
        if (myFraction.equals(myFractionCalculator.getFraction())) System.out.println("Clear instructions executed correctly");
        //test negate instruction
        String negateInstruction = "1/2 + 1/4 neg + 1/2";
        Fraction fraction3 = new Fraction(-1,4);
        myFractionCalculator.evaluate(myFractionCalculator.getFraction(),negateInstruction);
        if (fraction3.equals(myFractionCalculator.getFraction())) System.out.println("Negate instructions executed correctly");
        //test absolute value instruction
        String absInstruction = "1/4 - 1/2 abs + 1/2";
        myFractionCalculator.evaluate(myFractionCalculator.getFraction(),absInstruction);
        if (fraction2.equals(myFractionCalculator.getFraction())) System.out.println("Absolute value instructions executed correctly");
    }
}
