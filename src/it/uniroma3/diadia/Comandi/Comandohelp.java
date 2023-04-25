package it.uniroma3.diadia.Comandi;

import it.uniroma3.diadia.attrezzi.Attrezzo;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.Io;

public class Comandohelp implements Comando {
	static final private String[] elencoComandi = { "vai", "aiuto", "fine", "prendi", "posa", "guarda" };
	private final String help = "aiuto";
	private Io io;

	public void esegui(Partita partita) {
		for (int i = 0; i < elencoComandi.length; i++) {
			io.mostraMessaggio(elencoComandi[i] + " ");
		}
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setIo(Io io) {
		this.io = io;

	}

	@Override
	public String getNome() {
		return help;

	}

}
