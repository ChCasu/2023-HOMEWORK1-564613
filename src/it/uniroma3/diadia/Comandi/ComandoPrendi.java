package it.uniroma3.diadia.Comandi;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.DiaDia;

import it.uniroma3.diadia.Io;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {

	private final static String Prendi = "prendi";
	private Io io;
	private String nomeAttrezzo;


	
	@Override
	public void esegui(Partita partita) {
		Attrezzo a = partita.getLabirinto().getStanzaAttuale().getAttrezzo(nomeAttrezzo);
		float PesoLibero=((partita.getGiocatore().getBorsa().getPesoMax())-partita.getGiocatore().getBorsa().getPeso());
		if(PesoLibero!=0) {
			partita.getGiocatore().getBorsa().addAttrezzo(a);
			partita.getLabirinto().getStanzaAttuale().removeAttrezzo(a);
		} 
		else {
			io.mostraMessaggio("Attrezzo troppo pesante!");
		}
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo  = parametro;

	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}

	@Override
	public void setIo(Io io) {
		this.io = io;
	}
	
	@Override
	public String getNome() {
		return Prendi;
	}

}
