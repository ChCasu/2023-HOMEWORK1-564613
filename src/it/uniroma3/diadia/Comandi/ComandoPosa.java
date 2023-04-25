package it.uniroma3.diadia.Comandi;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.*;
import it.uniroma3.diadia.Io;

public class ComandoPosa implements Comando {
	private Io io;
	private String NomeAttrezzo;
	private final String Posa = "posa";

	public void esegui(Partita partita) {
		Attrezzo attrezz = partita.getGiocatore().getBorsa().getAttrezzo(NomeAttrezzo);
		if (attrezz == null)
			io.mostraMessaggio("nessuna attrezzo selezionato...\n");
		else {
			
			partita.getLabirinto().getStanzaAttuale().addAttrezzo(attrezz);
			partita.getGiocatore().getBorsa().removeAttrezzo(NomeAttrezzo);
	}
	}
		
		@Override
		public void setParametro(String parametro) {
			this.NomeAttrezzo  = parametro;
		}

		@Override
		public String getParametro() {
			return this.NomeAttrezzo;
		}

		@Override
		public void setIo(Io io) {
			this.io = io;
		}

		@Override
		public String getNome() {
			return Posa;
		}
}

