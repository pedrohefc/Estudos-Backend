import dao.ClienteMapDAO;
import dao.IClienteDAO;
import model.Cliente;

import javax.swing.*;
import java.util.Set;

public class App {

    private static IClienteDAO iClienteDAO;

    public static void main(String[] args) {

        iClienteDAO = new ClienteMapDAO();
        String opcao;

        do {
            opcao = JOptionPane.showInputDialog(null,
                    "Digite:\n1 - Cadastro\n2 - Consulta\n3 - Exclusão\n4 - Alteração\n5 - Sair",
                    "Menu", JOptionPane.INFORMATION_MESSAGE);

            if (opcao == null) break; // usuário cancelou

            if (!isOpcaoValida(opcao)) {
                JOptionPane.showMessageDialog(null, "Opção inválida!");
                continue;
            }

            switch (opcao) {
                case "1" -> cadastrar();
                case "2" -> consultar();
                case "3" -> excluir();
                case "4" -> alterar();
            }

        } while (!"5".equals(opcao));

        sair();
    }

    private static void cadastrar() {
        String dados;
        String[] dadosSeparados;

        do {
            dados = JOptionPane.showInputDialog(null,
                    "Digite os dados do cliente no formato:\n" +
                            "nome, cpf, telefone, endereço, número, cidade, estado",
                    "Cadastro", JOptionPane.INFORMATION_MESSAGE);

            if (dados == null) return; // cancelou

            dadosSeparados = dados.split(",");
            if (dadosSeparados.length != 7) {
                JOptionPane.showMessageDialog(null, "Dados incompletos! Tente novamente.");
            }

        } while (dadosSeparados.length != 7);

        Cliente cliente = new Cliente(
                dadosSeparados[0].trim(),
                dadosSeparados[1].trim(),
                dadosSeparados[2].trim(),
                dadosSeparados[3].trim(),
                dadosSeparados[4].trim(),
                dadosSeparados[5].trim(),
                dadosSeparados[6].trim()
        );

        if (iClienteDAO.cadastrar(cliente)) {
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Cliente já cadastrado!");
        }
    }

    private static void consultar() {
        String cpfStr = JOptionPane.showInputDialog(null, "Digite o CPF", "Consulta", JOptionPane.INFORMATION_MESSAGE);
        if (cpfStr == null || cpfStr.isBlank()) return;

        try {
            Long cpf = Long.parseLong(cpfStr);
            Cliente cliente = iClienteDAO.consultar(cpf);
            if (cliente != null) {
                JOptionPane.showMessageDialog(null, "Cliente encontrado:\n" + cliente);
            } else {
                JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "CPF deve ser numérico!");
        }
    }

    private static void excluir() {
        String cpfStr = JOptionPane.showInputDialog(null, "Digite o CPF para excluir", "Exclusão", JOptionPane.INFORMATION_MESSAGE);
        if (cpfStr == null || cpfStr.isBlank()) return;

        try {
            Long cpf = Long.parseLong(cpfStr);
            Cliente cliente = iClienteDAO.consultar(cpf);
            if (cliente != null) {
                iClienteDAO.excluir(cpf);
                JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "CPF deve ser numérico!");
        }
    }

    private static void alterar() {
        String cpfStr = JOptionPane.showInputDialog(null, "Digite o CPF do cliente para alterar", "Alteração", JOptionPane.INFORMATION_MESSAGE);
        if (cpfStr == null || cpfStr.isBlank()) return;

        try {
            Long cpf = Long.parseLong(cpfStr);
            Cliente cliente = iClienteDAO.consultar(cpf);

            if (cliente != null) {
                String dados = JOptionPane.showInputDialog(null,
                        "Digite os novos dados no formato:\n" +
                                "nome, cpf, telefone, endereço, número, cidade, estado",
                        "Alteração", JOptionPane.INFORMATION_MESSAGE);
                if (dados == null) return;

                String[] dadosSeparados = dados.split(",");
                if (dadosSeparados.length != 7) {
                    JOptionPane.showMessageDialog(null, "Dados incompletos!");
                    return;
                }

                Cliente clienteAtualizado = new Cliente(
                        dadosSeparados[0].trim(),
                        dadosSeparados[1].trim(),
                        dadosSeparados[2].trim(),
                        dadosSeparados[3].trim(),
                        dadosSeparados[4].trim(),
                        dadosSeparados[5].trim(),
                        dadosSeparados[6].trim()
                );

                iClienteDAO.alterar(clienteAtualizado);
                JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!");

            } else {
                JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "CPF deve ser numérico!");
        }
    }

    private static boolean isOpcaoValida(String opcao) {
        Set<String> opcoesValidas = Set.of("1", "2", "3", "4", "5");
        return opcoesValidas.contains(opcao);
    }

    private static void sair() {
        JOptionPane.showMessageDialog(null, "Até logo!");
        System.exit(0);
    }
}
