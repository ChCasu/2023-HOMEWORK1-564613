package it.uniroma3.diadia;

import java.util.ArrayList;
import java.util.List;

public class IOSimulator implements Io {
	
	private List<String> messaggiUsciti;
	private int indexMessaggiUsciti;
	private int indexMessaggiComposti;

	private List<String> messaggi;
	private int indexmessaggiletti;

	public List<String> getMessaggiProdotti(){
		return messaggi;
	}

	public void setMessaggiProdotti(List<String> messaggiProdotti) {
		this.messaggi = messaggiProdotti;
	}


	public IOSimulator(List<String> righeDaLeggere) {
		this.messaggi = righeDaLeggere;
		this.indexmessaggiletti = 0;
		this.indexMessaggiUsciti = 0;
		this.messaggiUsciti = new ArrayList<String>();
	}

	@Override
	public String leggiRiga() {
		String riga = null;

		riga = this.messaggi.get(indexmessaggiletti);
		this.indexmessaggiletti++;
		return riga;
	}

	@Override
	public void mostraMessaggio(String msg) {
		this.messaggiUsciti.add(this.indexMessaggiComposti,msg);
		this.indexMessaggiComposti++;
	}

	public String nextMessaggio() {
		String next = this.messaggiUsciti.get(indexMessaggiComposti);
		this.indexMessaggiComposti++;
		return next;
	}

	public boolean hasNextMessaggio() {
		return this.indexMessaggiUsciti < this.indexMessaggiComposti;
	}

}