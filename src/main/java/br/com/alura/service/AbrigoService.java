package br.com.alura.service;

import br.com.alura.client.HttpService;
import br.com.alura.constants.AppConstants;
import br.com.alura.dominio.Abrigo;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AbrigoService {

    HttpService httpService;

    public AbrigoService(HttpService httpService){
        this.httpService = httpService;
    }

    public  void cadastrarAbrigo() throws IOException, InterruptedException {
        System.out.println("Digite o nome do abrigo:");
        String nome = new Scanner(System.in).nextLine();
        System.out.println("Digite o telefone do abrigo:");
        String telefone = new Scanner(System.in).nextLine();
        System.out.println("Digite o email do abrigo:");
        String email = new Scanner(System.in).nextLine();

        String uri = AppConstants.URI_ABRIGOS;
        HttpResponse<String> response = httpService.post(uri,new Abrigo(nome,telefone,email));

        int statusCode = response.statusCode();
        String responseBody = response.body();
        if (statusCode == 200) {
            System.out.println("Abrigo cadastrado com sucesso!");
            System.out.println(responseBody);
        } else if (statusCode == 400 || statusCode == 500) {
            System.out.println("Erro ao cadastrar o abrigo:");
            System.out.println(responseBody);
        }
    }

    public void listarAbrigos() throws IOException, InterruptedException {

        HttpResponse<String> response = httpService.get(AppConstants.URI_ABRIGOS);
        String responseBody = response.body();
        Abrigo[] abrigos = new ObjectMapper().readValue(responseBody,Abrigo[].class);
        List<Abrigo> abrigoList = Arrays.stream(abrigos).toList();

        if(abrigoList.isEmpty()){
            System.out.println(AppConstants.MSG_N_ABRIG_CADASTR);
        } else {
            mostrarAbrigosCadastrados(abrigoList);
        }
    }

    private static void mostrarAbrigosCadastrados(List<Abrigo> abrigoList) {
        System.out.println(AppConstants.TIT_ABRIG_CADASTR);
        for (Abrigo abrigo : abrigoList) {
            long id = abrigo.getId();
            String nome = abrigo.getNome();
            System.out.println(String.format("%s - %s", id, nome));
        }
    }

}
