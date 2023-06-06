import java.util.Scanner;

public class adjustmentSalary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double someSalaryActual = 0;
        double someSalaryReajust = 0;

        while (true) {
            System.out.print("Digite o seu nome (ou Sair para encerrar): ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("Sair")) {
                break;
            }

            System.out.print("Digite o seu salário atual: ");
            double salaryActual = scanner.nextDouble();
            scanner.nextLine();

            double newSalary = calcularReajusteSalario(salaryActual);

            System.out.println("Nome: " + name);
            System.out.println("Salário atual: R$" + salaryActual);
            System.out.println("Novo salário: R$" + newSalary);
            System.out.println();

            someSalaryActual += salaryActual;
            someSalaryReajust += newSalary;
        }

        System.out.println("Soma dos salários antigos: R$" + someSalaryActual);
        System.out.println("Soma dos salários reajustados: R$" + someSalaryReajust);
        System.out.println("Diferença entre os salários antigos e novos: R$" + (someSalaryReajust - someSalaryActual));
    }

    public static double calcularReajusteSalario(double salary) {
        if (salary <= 150) {
            return salary * 1.25;
        } else if (salary <= 300) {
            return salary * 1.2;
        } else if (salary <= 600) {
            return salary * 1.15;
        } else {
            return salary * 1.1;
        }
    }
}