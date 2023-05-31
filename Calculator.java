import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Main {
    public static void main(String[] args) {
        double result = 0;
        boolean Operation = true;
        JTextField textField = new JTextField(10);

        while (true) {
            String userInput;
            if (Operation) {
                userInput = JOptionPane.showInputDialog("Digite um número (ou 'sair' para encerrar):");
                Operation = false;
            } else {
                userInput = JOptionPane.showInputDialog("Digite o número a ser operado (ou 'sair' para encerrar):");
            }

            if (userInput.equalsIgnoreCase("sair")) {
                break;
            }

            double number = Double.parseDouble(userInput);

            String operator = JOptionPane.showInputDialog("Digite o operador (+, -, *, /) ou '=' para finalizar:");

            if (operator.equals("=")) {
                break;
            }

            switch (operator) {
                case "+":
                    result += number;
                    break;
                case "-":
                    result -= number;
                    break;
                case "*":
                    result *= number;
                    break;
                case "/":
                    result /= number;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Operador inválido!");
                    break;
            }

            textField.setText(String.valueOf(result));

            JOptionPane.showMessageDialog(null, "Número acumulado: " + result, "Painel", JOptionPane.PLAIN_MESSAGE, null);
        }

        JOptionPane.showMessageDialog(null, "Resultado final: " + result);
        JOptionPane.showMessageDialog(null, "Calculadora encerrada.");
    }
}
