import javax.swing.JOptionPane;

public class Estoque {
    int[] codigos = {10, 20, 30, 40, 50};
    int[] quantidades = new int[50];
    public void atualizarQuantidade(int codigo, int quantidade) {
        int index = -1;
        for (int i = 0; i < codigos.length; i++) {
            if (codigos[i] == codigo) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            JOptionPane.showMessageDialog(null, "Produto não encontrado");
        } else {
            quantidades[index] += quantidade;
            JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso");
        }
    }

    public static void main(String[] args) {
        Estoque estoque = new Estoque();

        String codigoStr = JOptionPane.showInputDialog(null, "Digite o código do produto:");
        int codigo = Integer.parseInt(codigoStr);

        boolean codigoEncontrado = false;
        for (int i = 0; i < estoque.codigos.length; i++) {
            if (estoque.codigos[i] == codigo) {
                codigoEncontrado = true;
                break;
            }
        }
        if (!codigoEncontrado) {
            JOptionPane.showMessageDialog(null, "Produto não encontrado");
            System.exit(0);
        }

        String quantidadeStr = JOptionPane.showInputDialog(null, "Digite a quantidade a ser adicionada:");
        int quantityStr = Integer.parseInt(quantidadeStr);
        if (quantityStr > 50) {
            JOptionPane.showMessageDialog(null, "Erro! Quantidade não aprovada! ");
            System.exit(0);
        }
        int quantidade = Integer.parseInt(quantidadeStr);

        estoque.atualizarQuantidade(codigo, quantidade);

        int index = -1;
        for (int i = 0; i < estoque.codigos.length; i++) {
            if (estoque.codigos[i] == codigo) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            JOptionPane.showMessageDialog(null, "Produto não encontrado");
        } else {
            JOptionPane.showMessageDialog(null, "Quantidade total do produto de código " + codigo + ": " + estoque.quantidades[index]);
        }
    }
}