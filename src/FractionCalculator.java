import java.util.Arrays;
import java.util.Scanner;

public class FractionCalculator
{
    public static void main(String[] args) {
        System.out.print("Hello! You are running Fraction Calculator designed by Liudmila Veshneva. Please input your instructions: ");
        Scanner myScanner = new Scanner(System.in);
        FractionCalculator myCalculator = new FractionCalculator();
        String myInstructions = "";

        while (myScanner.hasNextLine()) {
            myInstructions = myScanner.nextLine();
            if (myInstructions.equals("q") || myInstructions.equals("quit") || myInstructions.equals("Q") || myInstructions.equals("")) {
                System.out.println("Goodbye");
                break;
            } else {
                myCalculator.evaluate(myCalculator.result, myInstructions);
                if (myCalculator.errorFlag) {
                    System.out.println("Error");
                    myCalculator.errorFlag = false;
                } else {
                    System.out.println(myCalculator.result.toString());
                }
            }
        }
        myScanner.close();
    }

    private Fraction result;
    private String operation;
    private Boolean errorFlag = false;

    public FractionCalculator()
    {
        result = new Fraction (0,1);
        operation = "None";
    }

    public void evaluate(Fraction fraction, String inputString) {
        String[] myInstructions = parseInstructions(inputString);
        result.setNumerator(fraction.getNumerator());
        result.setDenominator(fraction.getDenominator());

        for (int i = 0; i < myInstructions.length; i++) {
            if (errorFlag != true) {
                if (Character.isLetter(myInstructions[i].charAt(0))) {
                    executeInstruction(myInstructions[i]);
                } else if (Character.isDigit(myInstructions[i].charAt(0))) {
                    Fraction myFraction = new Fraction(0, 1);
                    myFraction.setNumerator(Integer.parseInt(myInstructions[i].substring(0, 1)));
                    if (myInstructions[i].length() > 1) {
                        myFraction.setDenominator(Integer.parseInt(myInstructions[i].substring(2)));
                    } else {
                        myFraction.setDenominator(1);
                    }
                    if (operation.equals("None")) {
                        result.setNumerator(myFraction.getNumerator());
                        result.setDenominator(myFraction.getDenominator());
                    } else {
                        calculate(myFraction);
                        operation = "None";
                    }
                } else if (myInstructions[i].equals("*") || myInstructions[i].equals("+") || myInstructions[i].equals("-") || myInstructions[i].equals("/")) {
                    rememberOperation(myInstructions[i]);
                } else {
                    throwError();
                }
            } else {
                break;
            }
        }
    }

    private void calculate (Fraction myFraction)
    {
        Fraction fraction = new Fraction(0,1);
        if(operation.equals("*"))
        {
            fraction = result.multiply(myFraction);
        }
        else if (operation.equals("+"))
        {
            fraction = result.add(myFraction);
        }
        else if (operation.equals("-"))
        {
            fraction = result.subtract(myFraction);
        }
        else if (this.operation.equals("/"))
        {
            fraction = result.divide(myFraction);
        }
        result.setNumerator(fraction.getNumerator());
        result.setDenominator(fraction.getDenominator());
    }

    private void executeInstruction(String myInstruction)
    {
        if(Character.toLowerCase(myInstruction.charAt(0))=='a')
        {
            Fraction fraction;
            fraction = result.absValue(result);
            result.setNumerator(fraction.getNumerator());
            result.setDenominator(fraction.getDenominator());

        }
        else if (Character.toLowerCase(myInstruction.charAt(0))=='n')
        {
            Fraction fraction;
            fraction=result.negate(result);
            result.setNumerator(fraction.getNumerator());
            result.setDenominator(fraction.getDenominator());
        }
        else if (Character.toLowerCase(myInstruction.charAt(0))=='c') {
            result.setNumerator(0);
            result.setDenominator(1);
        }
        else
        {
            throwError();
        }
    }

    private void throwError()
    {
        reset();
        errorFlag = true;
    }

    private void rememberOperation(String myOperator)
    {
        if(operation.equals("None"))
        {
            operation=myOperator;
        }
        else
        {
            throwError();
        }
    }

    private void reset()
    {
        result.setNumerator(0);
        result.setDenominator(1);
        operation="None";
    }

    private String [] parseInstructions (String instructions)
    {
        String [] instructionsArray = new String [getNumberOfItemsInString(instructions)];
        Arrays.fill(instructionsArray, "");
        int myItem = 0;
        for (int i=0; i<instructions.length(); i++)
            if (!(Character.isSpaceChar(instructions.charAt(i))))
            {
                instructionsArray[myItem]=instructionsArray[myItem] + instructions.substring(i,i+1);
            }
            else
            {
                myItem = myItem+1;
            }
        return instructionsArray;
    }

    private int getNumberOfItemsInString(String myString)
    {
        int NumberOfItems=0;
        for (int i=0; i<myString.length(); i++)
        {
            if (!(Character.isSpaceChar(myString.charAt(i))))
            {
                //do nothing
            }
            else
            {
                NumberOfItems++;
            }
        }
        return NumberOfItems+1;
    }
    public Fraction getFraction()
    {
        return result;
    }
}
