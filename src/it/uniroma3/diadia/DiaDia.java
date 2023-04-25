package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Stanza;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.IOConsole.*;
import it.uniroma3.diadia.Comandi.Comando;
import it.uniroma3.diadia.Comandi.FabbricaDiComandi;
import it.uniroma3.diadia.Comandi.FabbricaDiComandiFisarmonica;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author docente di POO (da un'idea di Michael Kolling and David J. Barnes)
 * 
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""
			+ "Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n"
			+ "Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"
			+ "I locali sono popolati da strani personaggi, " + "alcuni amici, altri... chissa!\n"
			+ "Ci sono attrezzi che potrebbero servirti nell'impresa:\n"
			+ "puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n"
			+ "o regalarli se pensi che possano ingraziarti qualcuno.\n\n"
			+ "Per conoscere le istruzioni usa il comando 'aiuto'.";

	static final private String[] elencoComandi = { "vai", "aiuto", "fine", "prendi", "posa", "guarda" };

	private Partita partita;
	private Io io;

	public DiaDia(Io ioconsole) {
		this.io = ioconsole;
		this.partita = new Partita();

	}

	public void gioca() {
		String istruzione;
		io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		do {
			istruzione = io.leggiRiga();
		} while (!processaIstruzione(istruzione));

	}

	

/**
	 * Processa una istruzione
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false
	 *         altrimenti
	 */
	
	
	/*
	 * 
	 * private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);
		if (comandoDaEseguire.getNome() != null) {
			if (comandoDaEseguire.getNome().equals("fine")) {
				this.fine();
				return true;
			} else if (comandoDaEseguire.getNome().equals("vai")) {
				this.vai(comandoDaEseguire.getParametro());
			} else if (comandoDaEseguire.getNome().equals("prendi")) {
				this.prendi(comandoDaEseguire.getParametro());
			} else if (comandoDaEseguire.getNome().equals("borsa")) {
				this.Stampaborsa();
			} else if (comandoDaEseguire.getNome().equals("posa")) {
				this.posa(comandoDaEseguire.getParametro());
			} else if (comandoDaEseguire.getNome().equals("stampaborsa")) {
				this.Stampaborsa();
			} else if (comandoDaEseguire.getNome().equals("aiuto")) {
				this.aiuto();
			} else if (comandoDaEseguire.getNome().equals("guarda")) {
				this.guarda();
			}
			if (comandoDaEseguire.getParametro() == null) {
				io.mostraMessaggio("inserisci una delle seguenti direzioni: nord sud est ovest.\n");
				this.vai(comandoDaEseguire.getParametro());
			}

			else if (comandoDaEseguire.getNome() == null) {
				io.mostraMessaggio("Comando vuoto");
				return false;
			}
		} else
			io.mostraMessaggio("Comando inesistente");
	 * 
	 */
	
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire;
		FabbricaDiComandiFisarmonica fabbrica =new FabbricaDiComandiFisarmonica(this.io);
		comandoDaEseguire = fabbrica.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita);
		if (this.partita.vinta())

		System.out.println("Hai vinto!");
		
		else if (!this.partita.giocatoreVivo()) 

			System.out.println("Non hai più CFU...");

		return this.partita.isFinita();
		
	
	}

	public static void main(String[] argc) {
		IOConsole console = new IOConsole();
		Io io=new IOConsole();
		DiaDia gioco = new DiaDia(console);
		gioco.gioca();
	}

}
