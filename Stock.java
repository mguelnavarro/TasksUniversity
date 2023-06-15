import javax.swing.JOptionPane;

public class Stock {
    int[] codes = {10, 20, 30, 40, 50};
    int[] quantities = new int[50];
    public void updateQuantity(int code, int quantity) {
        int index = -1;
        for (int i = 0; i < codes.length; i++) {
            if (codes[i] == code) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            JOptionPane.showMessageDialog(null, "Produto não encontrado");
        } else {
            quantities[index] += quantity;
            JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso");
        }
    }

    public static void main(String[] args) {
        Stock stock = new Stock();

        String codigoStr = JOptionPane.showInputDialog(null, "Digite o código do produto:");
        int code = Integer.parseInt(codigoStr);

        boolean codeFound = false;
        for (int i = 0; i < stock.codes.length; i++) {
            if (stock.codes[i] == code) {
                codeFound = true;
                break;
            }
        }
        if (!codeFound) {
            JOptionPane.showMessageDialog(null, "Produto não encontrado");
            System.exit(0);
        }

        String quantityAdd = JOptionPane.showInputDialog(null, "Digite a quantidade a ser adicionada:");
        int quantityStr = Integer.parseInt(quantityAdd);
        if (quantityStr > 50) {
            JOptionPane.showMessageDialog(null, "Erro! Quantidade não aprovada! ");
            System.exit(0);
        }
        int quantity = Integer.parseInt(quantityAdd);

        stock.updateQuantity(code, quantity);

        int index = -1;
        for (int i = 0; i < stock.codes.length; i++) {
            if (stock.codes[i] == code) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            JOptionPane.showMessageDialog(null, "Produto não encontrado");
        } else {
            JOptionPane.showMessageDialog(null, "Quantidade total do produto de código " + code + ": " + stock.quantities[index]);
        }
    }
}