package it.uniroma3.diadia.Comandi;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.Io;

public class ComandoGuarda implements Comando {
	private final String guarda= "guarda";
	private Io io;
	
	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio("Stanza attuale: "+ partita.getLabirinto().getStanzaAttuale().toString());
	}
	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getParametro() {
		return null;
	}


	@Override
	public void setIo(Io io) {
		this.io = io;
	}
	
	@Override
	public String getNome() {
		return guarda;
	}

}
