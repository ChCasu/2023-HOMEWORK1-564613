package it.uniroma3.diadia.Comandi;

import it.uniroma3.diadia.Io;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;


public class ComandoVai implements Comando {
	
	private String direzione;
	private Io io;
	private final static String NOME = "vai";

	/**
	 * esecuzione del comando
	 */
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getLabirinto().getStanzaAttuale();
		Stanza prossimaStanza = null;
		if (this.direzione == null) {
			this.io.mostraMessaggio("Dove vuoi andare? Devi specificare una direzione");
		}

		prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);
		if (prossimaStanza == null) {
			this.io.mostraMessaggio("Direzione inesistente");
			return;
		}

		partita.getLabirinto().setStanzaAttuale(prossimaStanza);
		this.io.mostraMessaggio(partita.getLabirinto().getStanzaAttuale().getNome());
		Giocatore giocatore = partita.getGiocatore();
		giocatore.setCFU(giocatore.getCFU() - 1);
	}
	
	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;
	}
	
	@Override
	public String getParametro() {
		return this.direzione;
	}

	@Override
	public void setIo(Io io) {
		this.io = io;
		
	}
	
	@Override
	public String getNome() {
		return NOME;
	}

}