package view;

import java.io.IOException;

import javax.swing.JOptionPane;

import controller.SteamController;

public class main2 {
	public static void main(String[] args) {
		SteamController arq = new SteamController();
		int ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano desejado"));
		float media = Float.parseFloat(JOptionPane.showInputDialog("Digite a media"));
		String mes = JOptionPane.showInputDialog("Digite o mes");
		String pathoriginal = "C:\\kauan";
		String nameoriginal = "SteamCharts.csv";
		
		try {
			arq.ReadFile(pathoriginal, nameoriginal, ano, mes, media);
		} catch (IOException e) {
			e.printStackTrace();
	}
		try {
			arq.CriaArquivo(pathoriginal, ano, mes, pathoriginal, nameoriginal);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
