/**
 * Aplicação para leitura de dados em arquivo csv. A aplicação localiza o arquivo 
 * e calcula a quantidade de homens, mulheres, bem como a média de idade total
 * e de ambos.
 * Nota: o csv já estava com os nomes em ordem alfabética e com as datas de 
 * nascimento corrigidas, feitas no excel mesmo.
 * 
 */


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVLeitor {

	public static void main(String[] args) {
		
		String path = "C:\\Users\\Julio Santos\\Documents\\Teste\\mportal\\csv_teste_edit.csv";
		String line = "";
		double sum_age = 0;		//somatória idades
		double sum_m = 0;		//soma idades mulheres
		double sum_f =0;		//soma idades homens
		int qtde = 0;			//quantidade de dados contados
		int qtdm = 0;			//quantidade mulheres
		int qtdf = 0;			//quantidade homens
		boolean firstline = true;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			
			while((line = br.readLine()) != null) {
				if (firstline) {
				    firstline = false;
				    continue;
				  }
				String[] values = line.split(",");
				
 				sum_age += Float.parseFloat(values[5]);
 				qtde++;
 				
 				if (values[3].equals("Male"))
 				{
 					sum_m += Float.parseFloat(values[5]);
 					qtdm++;
 				}
 				else
 				{
 					sum_f += Float.parseFloat(values[5]);
 					qtdf++;
 				}
			}
			
			double media_age = sum_age / qtde;
			double media_m = sum_m / qtdm;
			double media_f = sum_f / qtdf;
			
			System.out.println("Quantidade de Homens: "+qtdm);
			System.out.println("\nQuantidade de Mulheres: "+qtdf);
			System.out.println("\nMédia da Idade de Homens e Mulheres é de: "+media_age+ " anos.");
			System.out.println("\nMédia da Idade dos Homens é de: "+media_m+ " anos.");
			System.out.println("\nMédia da Idade das Mulheres é de: "+media_f+ " anos.");
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		}

}
