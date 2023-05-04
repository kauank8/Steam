package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class SteamController{

		public void ReadFile(String path, String name, int ano, String mes, float media) throws IOException {
			File arq = new File(path, name);
			
			if(arq.exists() && arq.isFile()) {
				FileInputStream abreFluxoarq = new FileInputStream(arq);
				InputStreamReader leitorfluxo = new InputStreamReader(abreFluxoarq);
				BufferedReader buffer = new BufferedReader(leitorfluxo);
				String linha = buffer.readLine();
				linha = buffer.readLine();
				while(linha !=null) {
					String vetLinha[] = linha.split(",");
					int anoteste = Integer.parseInt(vetLinha[1]);
					String mesteste = vetLinha[2];
					float mediateste = Float.parseFloat(vetLinha[3]);
					if(ano == anoteste) {
						if(mes.contains(mesteste)) {
							if(mediateste>=media) {
					System.out.println(vetLinha[0]+"  ||  " + "Media de jogadores ativos: " + vetLinha[3]);
					}
					}
					}
					linha=buffer.readLine();
				}
				buffer.close();
				leitorfluxo.close();
				abreFluxoarq.close();
			}
			else {
				throw new IOException("Arquivo invalido");
			}
		}
		
		public void CriaArquivo(String path, int ano, String mes, String pathoriginal, String nameoriginal) throws IOException {
			File dir = new File(path);
			if(dir.exists() && dir.isDirectory()) {
				File arq = new File(path,"KauanPaulino.csv");
						boolean existe = false;
						if(arq.exists()) {
							existe = true;
						}
				String conteudo = geraConteudo(ano, mes,arq, pathoriginal,nameoriginal);
				FileWriter abreArq = new FileWriter(arq, existe);
				PrintWriter escreveArq = new PrintWriter(abreArq);
				escreveArq.write(conteudo);
				escreveArq.flush();
				escreveArq.close();
				abreArq.close();
			} else {
				throw new IOException("Diretório Inválido");
			}
		}
			
		
		
		private String geraConteudo(int ano, String mes, File arq, String pathoriginal, String nameoriginal) throws IOException {
			StringBuffer buffer2 = new StringBuffer();
			File arqOriginal = new File(pathoriginal,nameoriginal);
			if(arqOriginal.exists() && arqOriginal.isFile()) {
				FileInputStream abreFluxoarq = new FileInputStream(arqOriginal);
				InputStreamReader leitorfluxo = new InputStreamReader(abreFluxoarq);
				BufferedReader buffer = new BufferedReader(leitorfluxo);
				String linha = buffer.readLine();
				linha = buffer.readLine();
				while(linha!=null) {
					String vetLinha[] = linha.split(",");
					int anoteste = Integer.parseInt(vetLinha[1]);
					String mesteste = vetLinha[2];
					if(ano==anoteste && mes.contains(mesteste)) {
						buffer2.append(vetLinha[0]+ "\t " +  ";" + "Media:"  +vetLinha[3]+"\n");
					}
					linha=buffer.readLine();
				}
				buffer.close();
				leitorfluxo.close();
				abreFluxoarq.close();
			}
			return buffer2.toString();
		}
}