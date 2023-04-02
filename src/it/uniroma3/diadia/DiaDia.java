package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.IOConsole.*;

  
import java.util.Scanner;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine"};

	private Partita partita;
	private IOConsole ioConsole;

	public DiaDia(IOConsole IO) {
		this.partita = new Partita();
		ioConsole=IO;
	}

	public void gioca() {
		String istruzione; 
		Scanner scannerDiLinee;

		ioConsole.mostraMessaggio(MESSAGGIO_BENVENUTO);
		do {	
			istruzione = ioConsole.leggiRiga();
	    }   while(!processaIstruzione(istruzione));

	}
	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);
		if(comandoDaEseguire.getNome()!=null) {
		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai")) {
			this.vai(comandoDaEseguire.getParametro());
		}
		else if (comandoDaEseguire.getNome().equals("prendi")) {
				this.prendi(comandoDaEseguire.getParametro());
		}
				else if (comandoDaEseguire.getNome().equals("posa")) {
					this.posa(comandoDaEseguire.getParametro());
				}
				else if (comandoDaEseguire.getNome().equals("stampaborsa")) {
					this.Stampaborsa();
				}
			if(comandoDaEseguire.getParametro()==null) {
				ioConsole.mostraMessaggio("inserisci una delle seguenti direzioni: nord sud est ovest.\n");
				this.vai(comandoDaEseguire.getParametro());
			}
			
			
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();

		}
		else if(comandoDaEseguire.getNome()==null) {
			ioConsole.mostraMessaggio("Comando vuoto");
			return false;
		}
			
		else
			ioConsole.mostraMessaggio("Comando inesistente");

		


		
		if (this.partita.vinta()) {
			ioConsole.mostraMessaggio("Hai vinto!");
			return true;
		} else
			return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			ioConsole.mostraMessaggio(elencoComandi[i]+" ");
		System.out.println();
	}
	
	private void prendi(String attrezzo) {
			Attrezzo attrezz=this.partita.getLabirinto().getStanzaAttuale().getAttrezzo(attrezzo);
			this.partita.getGiocatore().getBorsa().addAttrezzo(attrezz);
			this.partita.getLabirinto().getStanzaAttuale().removeAttrezzo(attrezz);
	}
	private void posa(String attrezzo) {
		if(attrezzo==null)
			ioConsole.mostraMessaggio("nessuna attrezzo selezionato...\n");
		else {
			Attrezzo attrezz=this.partita.getLabirinto().getStanzaAttuale().getAttrezzo(attrezzo);
			this.partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo);
			this.partita.getLabirinto().getStanzaAttuale().addAttrezzo(attrezz);
			
		}
	}
	
	private void Stampaborsa(){
		ioConsole.mostraMessaggio("Borsa: "+this.partita.getGiocatore().getBorsa()+"\n");
		ioConsole.mostraMessaggio("CFU: "+this.partita.getGiocatore().getCFU()+"\n");
	}
	
	
	
	
	

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			ioConsole.mostraMessaggio("Dove vuoi andare ?");
		ioConsole.mostraMessaggio("insieme al comando vai inserisci una direzione (nord, sud, est, ovest)\n\n\n\n");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getLabirinto().getStanzaAttuale().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			ioConsole.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.getLabirinto().setStanzaAttuale(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCFU();
			this.partita.getGiocatore().setCFU(cfu--);
		}
		ioConsole.mostraMessaggio(partita.getLabirinto().getStanzaAttuale().getDescrizione());
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		ioConsole.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		IOConsole console=new IOConsole();
		DiaDia gioco = new DiaDia(console);
		gioco.gioca();
	}
}