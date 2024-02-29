package com.example.socketmedia;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) {

        double prova = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor da Prova:"));
        double trabalho = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor da Trabalho:"));
        double projeto = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do Projeto integrador:"));

        try (Socket conexao = new Socket("127.0.0.1", 40000)) {

            ObjectOutputStream saida = new ObjectOutputStream(conexao.getOutputStream());
            ObjectInputStream entrada = new ObjectInputStream(conexao.getInputStream());


            saida.writeDouble(prova);
            saida.writeDouble(trabalho);
            saida.writeDouble(projeto);
            saida.flush();

            double media = entrada.readDouble();

            JOptionPane.showMessageDialog(null, "Sua media é: " + media);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
