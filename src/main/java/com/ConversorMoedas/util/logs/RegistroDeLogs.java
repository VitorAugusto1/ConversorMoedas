package com.conversormoedas.util.logs;

import com.conversormoedas.api.ConversorEmPares;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class RegistroDeLogs {

    private static final String LOG_FILE_PATH = "src/main/java/com/conversormoedas/util/logs/conversoes.log";

    public static void resgistrarConversoes(List<ConversorEmPares> conversoes) {
        try (PrintWriter writer = new PrintWriter(LOG_FILE_PATH)) {
            LocalDateTime agora = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            writer.println("Registro de conversões feitas em: - " + agora.format(formatter));
            writer.println();

            for (ConversorEmPares conversao : conversoes) {
                writer.println("Moeda de origem: " + conversao.getMoedaOrigem());
                writer.println("Moeda de destino: " + conversao.getMoedaDestino());
                writer.println("Taxa de câmbio: " + conversao.getTaxaCambio());
                writer.println("Valor convertido: " + conversao.getResultadoConversao());
                writer.println();
            }

        } catch (IOException e) {
            System.err.println("Erro ao registrar as conversões: " + e.getMessage());
        }
    }
    
}
