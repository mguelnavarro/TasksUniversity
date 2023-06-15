import java.util.Scanner;

public class FibonacciNumber {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Numero Fibonacci");
        System.out.print("Digite um número: ");
        int number = scanner.nextInt();
        int [] fibonacci = { 0,1,2,3,5,8,13,21,34,55,89,144,233,377,610,987};
        boolean present = false;
        for (int i = 0; i < fibonacci.length; i++) {
            if (fibonacci[i] == number) {
                present = true;
                break;
            }
        }

        if (present) {
            System.out.println("O número " + number + "não está presente na sequencia Fibonacci");
        } else {
            System.out.println("O número " + number + "está presente na sequencia Fibonacci");
        }
    }

}