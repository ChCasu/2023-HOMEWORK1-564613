package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaProtected extends StanzaProtected {

	private int cont_Attrezzi = 0;
	private int attivatore = 0;
	private static final int SOGLIA_MAGICA = 2;

	public StanzaMagicaProtected(String nome) {
		this(nome, SOGLIA_MAGICA);
	}

	public StanzaMagicaProtected(String nome, int soglia) {
		super(nome);
		this.attivatore = soglia;
	}

	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		StringBuilder nomeInvertito;
		int pesoX2 = attrezzo.getPeso() * 2;
		nomeInvertito = new StringBuilder(attrezzo.getNome());
		nomeInvertito = nomeInvertito.reverse();
		attrezzo = new Attrezzo(nomeInvertito.toString(), pesoX2);
		return attrezzo;
	}
	
	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.cont_Attrezzi>this.attivatore ) {
			this.attrezzi[numeroAttrezzi] = attrezzo;
		}
			this.numeroAttrezzi++;
			return super.addAttrezzo(attrezzo);

	}

}


