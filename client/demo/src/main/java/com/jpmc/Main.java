package com.jpmc;

import java.io.FileOutputStream;
import java.io.IOException;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public class Main {

    public static void main(String[] args) {
        HttpResponse<byte[]> request = Unirest.get(
            "http://localhost:8080/dowload?file=eu.jar"
        ).asBytes();
        if (request.getStatus() == 400) {
            System.out.println("Erro ao pedir arquivo");
            System.exit(1);
        }
        if (request.getStatus() == 404) {
            System.out.println("servidor não encontrado");
            System.exit(1);
        }
        if (request.getStatus() == 500) {
            System.out.println("erro interno do servidor");
            System.exit(1);
        }

        try (FileOutputStream out = new FileOutputStream("example.txt")) {
            out.write(request.getBody());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
