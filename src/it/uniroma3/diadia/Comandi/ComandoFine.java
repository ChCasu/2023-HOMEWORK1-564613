package it.uniroma3.diadia.Comandi;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.*;
import it.uniroma3.diadia.Io;

public class ComandoFine implements Comando{
	private Io io;
	private final String fine = "fine";
	
	@Override
	public void esegui(Partita partita) {
		partita.setFinita();
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
		return fine;
	}

}


