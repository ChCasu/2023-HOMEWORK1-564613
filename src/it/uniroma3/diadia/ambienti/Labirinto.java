package it.uniroma3.diadia.ambienti;



public class Labirinto {


	private Stanza stanzaAttuale;
	private Stanza stanzaFinale;

	
	public static LabirintoBuilder newBuilder(){
		return new LabirintoBuilder();
	}

    
    /*
     *     
      //Crea tutte le stanze e le porte di collegamento
  
    public void creaStanze() {

		// crea gli attrezzi 
    	Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
		Attrezzo torcia = new Attrezzo("torcia",2);
    	
		// crea stanze del labirinto 
		Stanza atrio = new StanzaMagica("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new StanzaBuia("Laboratorio Campus","torcia");
		Stanza biblioteca = new Stanza("Biblioteca");
		
		//collega le stanze 
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);

      //
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);
		atrio.addAttrezzo(torcia);

		// il gioco comincia nell'atrio
        stanzaAttuale = atrio;  
		stanzaFinale = biblioteca;
    }
     * 
     * 
     */
	



	public Stanza getStanzaFinale() {
		return this.stanzaFinale;
	}

	public void setStanzaAttuale(Stanza stanzaCorrente) {
		this.stanzaAttuale = stanzaCorrente;
	}
	public void setStanzaFinale(Stanza stanzaVincente) {
		this.stanzaFinale=stanzaVincente;
	}

	public Stanza getStanzaAttuale() {
		return this.stanzaAttuale;
		
	}

}
