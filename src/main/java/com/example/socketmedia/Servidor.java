package com.example.socketmedia;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        try (ServerSocket servidor = new ServerSocket(40000)) {
            while (true) {
                try (Socket conexao = servidor.accept();
                     ObjectOutputStream saida = new ObjectOutputStream(conexao.getOutputStream());
                     ObjectInputStream entrada = new ObjectInputStream(conexao.getInputStream())) {

                    double prova = entrada.readDouble();
                    double trabalho = entrada.readDouble();
                    double projeto = entrada.readDouble();

                    double media = (prova + trabalho + projeto) / 3;
                    saida.writeDouble(media);
                    saida.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
