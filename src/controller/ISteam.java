package controller;

import java.io.IOException;

public interface ISteam {
	public void ReadFile(String path, String name, int ano, String mes,float media) throws IOException;
}
