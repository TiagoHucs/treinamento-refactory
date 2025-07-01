package br.com.alura.commands;

import br.com.alura.client.HttpService;
import br.com.alura.service.PetService;

import java.io.IOException;

public class ImportarPetsAbrigoCommand implements Command{

    @Override
    public void execute() {
        try {
            HttpService httpService = new HttpService();
            PetService service = new PetService(httpService);
            service.importarPetsAbrigo();
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

}
