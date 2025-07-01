package br.com.alura.commands;

import br.com.alura.client.HttpService;
import br.com.alura.service.AbrigoService;

import java.io.IOException;

public class CadastrarAbrigoCommand implements Command{

    @Override
    public void execute() {
        try {
            HttpService httpService = new HttpService();
            AbrigoService abrigoService = new AbrigoService(httpService);
            abrigoService.cadastrarAbrigo();
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

}
