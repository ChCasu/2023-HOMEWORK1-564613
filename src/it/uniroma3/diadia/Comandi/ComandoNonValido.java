package it.uniroma3.diadia.Comandi;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.Io;

public class ComandoNonValido implements Comando{
	private final String comando = "comando";
	private Io io;
	private final String[] elencoComandi = { "vai", "aiuto", "fine", "prendi", "posa", "guarda" };
	
	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio("comando non valido...");
		for(int i=0;i<elencoComandi.length;i++) {
			io.mostraMessaggio(elencoComandi[i]+" ");
		}
		
	}
	@Override
	public void setParametro(String Parametro) {
		
	}
	
	@Override
	public String getParametro() {
		return null;
		
	}
	
	@Override
	public void setIo(Io io) {
		this.io=io;
	}
	@Override
	public String getNome() {
		return comando;
	}
	
	
	
	

}
