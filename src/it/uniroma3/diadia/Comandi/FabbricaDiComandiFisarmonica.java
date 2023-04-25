package it.uniroma3.diadia.Comandi;

import java.util.Scanner;


import it.uniroma3.diadia.Io;

public class FabbricaDiComandiFisarmonica {

	private Io io;
	public FabbricaDiComandiFisarmonica(Io io) {
		this.io = io;
	}
	
	public Comando costruisciComando(String istruzione) {
		Scanner scannerDiParole = new Scanner(istruzione);
		String nomeComando = null;
		String parametro = null;
		Comando comando = null;
		if (scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next(); // prima parola: nome del comando
		if (scannerDiParole.hasNext())
			parametro = scannerDiParole.next();
		// seconda parola: eventuale parametro

		if (nomeComando.equals("vai"))
			comando = new ComandoVai();
		else if (nomeComando.equals("prendi"))
			comando = new ComandoPrendi();
		else if (nomeComando.equals("posa"))
			comando = new ComandoPosa();
		else if (nomeComando.equals("aiuto"))
			comando = new Comandohelp();
		else if (nomeComando.equals("fine"))
			comando = new ComandoFine();
		else if (nomeComando.equals("guarda"))
			comando = new ComandoGuarda();
		else
			comando = new ComandoNonValido();
		comando.setParametro(parametro);
		comando.setIo(this.io);
		return comando;
		//scannerDiParole.close();
	}
}
