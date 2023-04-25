package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;


public class StanzaBuia extends Stanza {
	private String torcia;
	
	public StanzaBuia(String nome, String torcia) {
		super(nome);
		this.torcia=torcia;
	}
	
	@Override
	public String getDescrizione() {
		String stanzabuia="questa � una stanza molto buia...";
		if(!hasAttrezzo(torcia))
			return stanzabuia;
		return super.getDescrizione();
	}

}
