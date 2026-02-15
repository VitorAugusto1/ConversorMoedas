package com.conversormoedas;

import java.util.Scanner;

import com.conversormoedas.api.Conversor;
import com.conversormoedas.api.ConversorEmPares;
import com.conversormoedas.util.GeradorDeArquivo;
import com.conversormoedas.util.logs.RegistroDeLogs;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

public class ConversorMoedasApplication {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int entrada;

		String moedaOrigem;
		String moedaDestino;
		double valor;

		Conversor conversor = new Conversor();
		List<ConversorEmPares>conversoes = new ArrayList<>();

		do {
			System.out.print("Digite a moeda de origem (3 caracteres): ");
			moedaOrigem = scanner.nextLine().toUpperCase();

			System.out.print("Digite a moeda de destino (3 caracteres): ");
			moedaDestino = scanner.nextLine().toUpperCase();

			System.out.print("Digite o valor: ");
			valor = scanner.nextDouble();

			scanner.nextLine();

			ConversorEmPares conversao = conversor.converter(moedaOrigem, moedaDestino, valor);
			conversoes.add(conversao);

			RegistroDeLogs.resgistrarConversoes(conversoes);

			System.out.print("Deseja realizar outra conversão? (1 - Sim, 2 - Não): ");
			entrada = scanner.nextInt();

			scanner.nextLine();

		} while (entrada != 2);

		scanner.close();
		System.out.println("Encerrando programa...");

		GeradorDeArquivo geradorDeArquivo = new GeradorDeArquivo();

		try {
			geradorDeArquivo.salvarListaJson(conversoes);
			System.out.println("Conversões salvas em arquivo JSON com sucesso!");
		} catch (IOException e) {
			System.out.println("Erro ao salvar o arquivo JSON: " + e.getMessage());
		}

	}
}

