package br.com.alura.service;

import br.com.alura.client.HttpService;
import br.com.alura.constants.AppConstants;
import br.com.alura.dominio.Pet;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PetService {

    HttpService httpService;

    public PetService(HttpService httpService){
        this.httpService = httpService;
    }

    public void listarPetsAbrigo() throws IOException, InterruptedException {
        System.out.println("Digite o id ou nome do abrigo:");
        String idOuNome = new Scanner(System.in).nextLine();

        String uri = String.format(AppConstants.URI_PETS, idOuNome);
        HttpResponse<String> response = httpService.get(uri);

        int statusCode = response.statusCode();
        if (statusCode == 404 || statusCode == 500) {
            System.out.println("ID ou nome não cadastrado!");
        }
        String responseBody = response.body();

        Pet[] petArray = new ObjectMapper().readValue(responseBody,Pet[].class);
        List<Pet> petList = Arrays.stream(petArray).toList();

        System.out.println(AppConstants.TIT_PETS_CADASTR);
        for (Pet pet : petList) {
            System.out.println(pet.toString());
        }
    }

    public void importarPetsAbrigo() throws IOException, InterruptedException {
        System.out.println("Digite o id ou nome do abrigo:");
        String idOuNome = new Scanner(System.in).nextLine();

        System.out.println("Digite o nome do arquivo CSV:");
        String nomeArquivo = new Scanner(System.in).nextLine();

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(nomeArquivo));
        } catch (IOException e) {
            System.out.println("Erro ao carregar o arquivo: " +nomeArquivo);
        }
        String line;
        while ((line = reader.readLine()) != null) {
            String[] campos = line.split(",");
            String tipo = campos[0];
            String nome = campos[1];
            String raca = campos[2];
            int idade = Integer.parseInt(campos[3]);
            String cor = campos[4];
            Float peso = Float.parseFloat(campos[5]);

            Pet pet = new Pet(tipo,nome,raca,idade,cor,peso);

            String uri = String.format(AppConstants.URI_PETS, idOuNome);
            HttpResponse<String> response = httpService.post(uri,pet);

            int statusCode = response.statusCode();
            String responseBody = response.body();
            if (statusCode == 200) {
                System.out.println("Pet cadastrado com sucesso: " + nome);
            } else if (statusCode == 404) {
                System.out.println("Id ou nome do abrigo não encontado!");
                break;
            } else if (statusCode == 400 || statusCode == 500) {
                System.out.println("Erro ao cadastrar o pet: " + nome);
                System.out.println(responseBody);
                break;
            }
        }
        reader.close();
    }

}
