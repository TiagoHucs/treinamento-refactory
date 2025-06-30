package br.com.alura.service;

import br.com.alura.client.HttpService;
import br.com.alura.dominio.Abrigo;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.net.http.HttpResponse;

class AbrigoServiceTest {

    private HttpService mockClient = Mockito.mock(HttpService.class);
    private AbrigoService abrigoService = new AbrigoService(mockClient);
    private HttpResponse<String> mockResponse = Mockito.mock(HttpResponse.class);
    private Abrigo abrigo = new Abrigo("","","");

    @Test
    void verificaSe() {
    }

    @Test
    void listarAbrigos() {
    }
}