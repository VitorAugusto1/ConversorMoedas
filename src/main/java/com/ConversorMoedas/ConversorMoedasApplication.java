package com.conversormoedas;

import java.util.Scanner;

import com.conversormoedas.api.Conversor;
import com.conversormoedas.api.ConversorEmPares;

import java.util.List;
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

			System.out.print("Deseja realizar outra conversão? (1 - Sim, 2 - Não): ");
			entrada = scanner.nextInt();

			scanner.nextLine();

		} while (entrada != 2);

		scanner.close();
		System.out.println("Encerrando programa...");

	}
}

