package aplicacao;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import entidades.Produto;
import entidades.ProdutoUsado;
import entidades.ProdutoImportado;

public class Programa {

	public static void main(String[] args) {
		String nome;
		double preco, taxa;
		
		Scanner sc = new Scanner(System.in);
		
		List<Produto> list= new ArrayList<>();
		System.out.println("Digite quantos produtos voce quer cadastrar: ");
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			System.out.println("Produto comun, usado, importado (c/u/i)");
			char tipo = sc.next().charAt(0);
			sc.nextLine();
			System.out.println("Digite o nome do seu produto: ");
			nome = sc.nextLine();
			System.out.println("Digite o preco do seu produto");
			preco = sc.nextDouble();
			switch (tipo) {
				case ('c'):
					list.add(new Produto(nome, preco));
					break;
				case ('u'):
					System.out.println("Digite a data de fabricacao (DD/MM/YYYY):");
					LocalDate data = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
					list.add(new ProdutoUsado(nome, preco, data));
					break;
				case ('i'):
					System.out.println("Digite o valor da taxa: ");
					taxa = sc.nextDouble();
					list.add(new ProdutoImportado (nome, preco, taxa));
					break;
				default:
					System.out.println("Valor digitado não encontrado, tente novamente");
					break;
				}
			
			
			}
		
		System.out.println("ETIQUETAS: ");
		for (Produto produto : list) {
			System.out.println(produto.etiqueta());
		}
		sc.close();
	}

}
