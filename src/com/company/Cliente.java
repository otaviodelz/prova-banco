package com.company;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Cliente {
    private int idCliente;
    private String nomeCliente;

    private ArrayList<Conta> contas;

    public Cliente(int idCliente, String nomeCliente) {
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;

        setContas(new ArrayList<>());
    }

    public void adicionaConta(long numeroConta) {
        Conta conta = new Conta(numeroConta);
        getContas().add(conta);
    }

    public void criaConta(long numero) {
        Scanner sc = new Scanner(System.in);

        adicionaConta(numero);
    }

    public void acessoContas(long numero) throws IOException {
        FileWriter arq = new FileWriter("c:\\transacoes\\conta" +numero+ ".txt");

        getContas().forEach(conta -> {
            PrintWriter gravarArq = new PrintWriter(arq);
            if(conta.getNumeroConta() == numero) {
                Scanner sc = new Scanner(System.in);
                int op = 0;

                while(op != 9) {
                    op = Integer.parseInt(JOptionPane.showInputDialog(
                            "Digite: \n" +
                                    "(1) - Depósito\n" +
                                    "(2) - Saque\n" +
                                    "(3) - Saldo\n" +
                                    "(9) - Sair"
                    ));

                    if(op == 1) {
                        Date data = new Date();
                        String input = JOptionPane.showInputDialog("Digite o valor: ");
                        double valor = Double.parseDouble(input);
                        conta.depositar(valor);

                        gravarArq.printf("Deposito com o valor de " + valor + " efetuado em: " + data + "\n");
                    }

                    if(op == 2) {
                        Date data = new Date();
                        String input = JOptionPane.showInputDialog("Digite o valor: ");
                        double valor = Double.parseDouble(input);
                        conta.sacar(valor);

                        gravarArq.printf("Saque com o valor de " + valor + " efetuado em: " + data + "\n");
                    }

                    if(op == 3) {
                        Date data = new Date();
                        double saldo = conta.getSaldo();
                        String mensagem = "Saldo: " + saldo;
                        JOptionPane.showMessageDialog(null, mensagem, "alert", JOptionPane.INFORMATION_MESSAGE);

                        gravarArq.printf("Saldo visualizado em:" + data + "\n");
                    }
                }
            }
        }); arq.close();
    }

    public ArrayList<Conta> getContas() {
        return contas;
    }

    public void setContas(ArrayList<Conta> contas) {
        this.contas = contas;
    }
}
