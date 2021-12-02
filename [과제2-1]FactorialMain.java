import java.util.Scanner;

public class FactorialMain {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();

        for (int i=1; i<=10; i++){
            System.out.println("Factorial of " + i + " = " + getFactorial(i));
        }
    }
    private static long getFactorial(final int n){
        long factorial;
        if (n == 1) factorial = 1;
        else factorial = n * getFactorial(n-1);
        return factorial;
    }
}
