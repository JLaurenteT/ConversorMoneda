package main;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        final String dolar= "USD";
        final String pesoArgentino= "ARS";
        final String realBrasileño= "BRL";
        final String pesoColombiano= "COP";
        final String key= "07740141c78338e39cd2cc27";
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("""
                    ************************************************************
                    Sea bienvenido/a al Conversor de Moneda =]
                    
                    1) Dólar =>> Peso argentino
                    2) Peso argentino =>> Dólar
                    3) Dólar =>> Real brasileño
                    4) Real brasileño =>> Dólar
                    5) Dólar =>> Peso colombiano
                    6) Peso colombiano =>> Dólar
                    7) Salir
                    
                    Elija una opción válida:
                    ************************************************************
                    """);

            var opcion = sc.nextInt();
            switch (opcion){
                case 1 -> {
                    System.out.println("Ingrese el monto en dólares a convertir:");
                    convertir(dolar, pesoArgentino, key, sc.nextDouble());
                }
                case 2 -> {
                    System.out.println("Ingrese el monto en pesos argentinos a convertir:");
                    convertir(pesoArgentino, dolar, key, sc.nextDouble());
                }
                case 3 -> {
                    System.out.println("Ingrese el monto en dólares a convertir:");
                    convertir(dolar, realBrasileño, key, sc.nextDouble());
                }
                case 4 -> {
                    System.out.println("Ingrese el monto en reales brasileños a convertir:");
                    convertir(realBrasileño, dolar, key, sc.nextDouble());
                }
                case 5 -> {
                    System.out.println("Ingrese el monto en dólares a convertir:");
                    convertir(dolar, pesoColombiano, key, sc.nextDouble());
                }
                case 6 -> {
                    System.out.println("Ingrese el monto en pesos colombianos a convertir:");
                    convertir(pesoColombiano, dolar, key, sc.nextDouble());
                }
                case 7 -> {
                    return;
                }
                default -> System.out.println("¡Opción no válida! Por favor, elija una opción del 1 al 7.");
            }
        }while (true);


    }
    public static void convertir(String moneda1, String moneda2, String key, Double monto) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        String direccion = "https://v6.exchangerate-api.com/v6/"+key+"/pair/"+moneda1+"/"+moneda2+"/"+monto;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Conversor conversor = gson.fromJson(response.body(), Conversor.class);
        System.out.println("El valor "+monto+" "+moneda1+" equivale a "+conversor.conversion_result()+" "+moneda2);
    }

}
