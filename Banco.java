import javax.swing.JOptionPane;

public class Banco {

    static String[][] contas = new String[100][];

    static int numeroDeContas = 0;

    static final int COLUNA_NUMERO_CONTA = 0;
    static final int COLUNA_NOME_CLIENTE = 1;
    static final int COLUNA_SALDO = 2;
    static final int COLUNA_ANO_ABERTURA = 3;

    public static void main(String[] args) {
        int opcao;
        do {
            opcao =
                    Integer.parseInt(
                            JOptionPane.showInputDialog(
                                    "Menu de Opções\n\n" +
                                            "1. Incluir Conta\n" +
                                            "2. Alterar Conta\n" +
                                            "3. Excluir Conta\n" +
                                            "4. Listar Conta/Saldo\n" +
                                            "5. Saque\n" +
                                            "6. Depósito\n" +
                                            "7. Sair\n\n" +
                                            "Escolha uma opção:"
                            )
                    );
            switch (opcao) {
                case 1:
                    incluirConta();
                    break;
                case 2:
                    alterarConta();
                    break;
                case 3:
                    excluirConta();
                    break;
                case 4:
                    listarContas();
                    break;
                case 5:
                    saque();
                    break;
                case 6:
                    deposito();
                    break;
                case 7:
                    JOptionPane.showMessageDialog(null, "Obrigado por utilizar o banco!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
                    break;
            }
        } while (opcao != 7);
    }

    static void incluirConta() {
        if (numeroDeContas == 100) {
            JOptionPane.showMessageDialog(null, "Limite máximo de contas atingido!");
            return;
        }
        String numero = JOptionPane.showInputDialog("Digite o número da conta:");
        String nomeCliente = JOptionPane.showInputDialog(
                "Digite o nome do cliente:"
        );
        String saldoInicial = JOptionPane.showInputDialog(
                "Digite o saldo inicial:"
        );
        String anoCorrente = JOptionPane.showInputDialog("Digite o ano corrente:");

        if (buscaConta(numero) != null) {
            JOptionPane.showMessageDialog(null, "Conta já cadastrada!");
            return;
        }

        String[] conta = new String[] {
                numero,
                nomeCliente,
                saldoInicial,
                anoCorrente,
        };
        contas[numeroDeContas] = conta;
        numeroDeContas++;
        JOptionPane.showMessageDialog(null, "Conta cadastrada com sucesso!");
    }

    static void alterarConta() {
        String numero = JOptionPane.showInputDialog(
                "Digite o número da conta que deseja alterar:"
        );
        String[] conta = buscaConta(numero);     
        if (conta == null) {
            JOptionPane.showMessageDialog(null, "Conta não encontrada!");
            return;
        }
        String nomeCliente = JOptionPane.showInputDialog(
                "Digite o novo nome do cliente:"
        );
        String saldo = JOptionPane.showInputDialog("Digite o novo saldo:");
        String ano = JOptionPane.showInputDialog("Digite o novo ano de abertura:");
        conta[COLUNA_NOME_CLIENTE] = nomeCliente;
        conta[COLUNA_SALDO] = saldo;
        conta[COLUNA_ANO_ABERTURA] = ano;
        JOptionPane.showMessageDialog(null, "Conta alterada com sucesso!");
    }

    static String[] buscaConta(String numeroConta) {
        for (int i = 0; i < numeroDeContas ; i++) {
            String[] conta = contas[i];

            if (conta[COLUNA_NUMERO_CONTA].equals(numeroConta)) {
                return conta;
            }
        }
        return null;
    }

    static void excluirConta() {
        String numero = JOptionPane.showInputDialog(
                "Digite o número da conta que deseja excluir:"
        );
        String[] conta = buscaConta(numero);
        if (conta == null) {
            JOptionPane.showMessageDialog(null, "Conta não encontrada!");
            return;
        }
        for (int i = 0; i < numeroDeContas; i++) {
            if (contas[i] == conta) {
                contas[i] = null;
                numeroDeContas--;
                JOptionPane.showMessageDialog(null, "Conta excluída com sucesso!");
                return;
            }
        }
    }

    static void listarContas() {
        String mensagem = "Conta / Saldo\n\n";
        for (String[] conta : contas) {
            if (conta != null) {
                mensagem +=
                        conta[COLUNA_NUMERO_CONTA] + " / " + conta[COLUNA_SALDO] + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, mensagem);
    }

    static void saque() {
        String numero = JOptionPane.showInputDialog("Digite o número da conta:");
        String[] conta = buscaConta(numero);
        if (conta == null) {
            JOptionPane.showMessageDialog(null, "Conta não encontrada!");
            return;
        }
        double saldoAtual = Double.parseDouble(conta[COLUNA_SALDO]);
        double valorSaque = Double.parseDouble(
                JOptionPane.showInputDialog("Digite o valor do saque:")
        );
        if (valorSaque > saldoAtual) {
            JOptionPane.showMessageDialog(null, "Saldo insuficiente!");
            return;
        }
        saldoAtual -= valorSaque;
        conta[COLUNA_SALDO] = Double.toString(saldoAtual);
        JOptionPane.showMessageDialog(null, "Saque efetuado com sucesso!");
    }

    static void deposito() {
        String numero = JOptionPane.showInputDialog("Digite o número da conta:");
        String[] conta = buscaConta(numero);
        if (conta == null) {
            JOptionPane.showMessageDialog(null, "Conta não encontrada!");
            return;
        }
        double saldoAtual = Double.parseDouble(conta[COLUNA_SALDO]);
        double valorDeposito = Double.parseDouble(
                JOptionPane.showInputDialog("Digite o valor do depósito:")
        );
        saldoAtual += valorDeposito;
        conta[COLUNA_SALDO] = Double.toString(saldoAtual);
        JOptionPane.showMessageDialog(null, "Depósito efetuado com sucesso!");
    }
}