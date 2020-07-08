package com.company;

import javax.swing.JOptionPane;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Cliente cliente1 = new Cliente(1, "Ronaldo");
        Scanner sc = new Scanner(System.in);

        FileWriter arq = new FileWriter("c:\\transacoes\\banco.txt");
        PrintWriter gravarArq = new PrintWriter(arq);

        int op = 0;

        while(op != 9) {

            op = Integer.parseInt(JOptionPane.showInputDialog("Digite: \n" +
                    "(1) - Criar conta\n" +
                    "(2) - Acessar Conta\n" +
                    "(9) - Sair"
            ));

            if(op == 1) {
                String numero = JOptionPane.showInputDialog(null, "Digite o numero da conta que deseja criar");
                long numeroLong = Long.parseLong(numero);
                Date data = new Date();

                cliente1.adicionaConta(numeroLong);

                gravarArq.printf("Conta " + numero + " criada em: " + data + "\n");
            }

            if(op == 2) {
                String numero = JOptionPane.showInputDialog("Digite o numero da conta que deseja acessar");
                long numeroLong = Long.parseLong(numero);
                Date data = new Date();

                cliente1.acessoContas(numeroLong);

                gravarArq.printf("Conta " + numero + " acessada em: " + data + "\n");
            }
        }

        arq.close();
    }
}
