package br.com.alura.service;

import br.com.alura.client.HttpService;
import br.com.alura.constants.AppConstants;
import br.com.alura.dominio.Abrigo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

class AbrigoServiceTest {

    private HttpService mockClient;
    private AbrigoService abrigoService;
    private HttpResponse<String> mockResponse;
    private Abrigo abrigo;

    @BeforeEach
    public void setUp(){
        mockClient = Mockito.mock(HttpService.class);
        abrigoService = new AbrigoService(mockClient);
        mockResponse = Mockito.mock(HttpResponse.class);
        abrigo = new Abrigo("Teste","61969669632","teste@email.com");
    }

    @Test
    void listarAbrigosTest() throws IOException, InterruptedException {
        abrigo.setId(0L);
        String expectedAbrigosCadastrados = "Abrigos Cadastrados:";
        String expectedIdENome = "0 - Teste";

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        Mockito.when(mockResponse.body()).thenReturn("[{"+ abrigo.toString() +"}]");
        Mockito.when(mockClient.get(Mockito.anyString())).thenReturn(mockResponse);

        abrigoService.listarAbrigos();

        String[] lines = baos.toString().split(System.lineSeparator());
        String actualAbrigosCadastrados = lines[0];
        String actualIdENome = lines[1];

        Assertions.assertEquals(expectedAbrigosCadastrados, actualAbrigosCadastrados);
        Assertions.assertEquals(expectedIdENome, actualIdENome);
    }

}