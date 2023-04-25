package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.attrezzi.Attrezzo;
public class StanzaMagica extends Stanza{
	private static final int soglia=1;
	private int attrezziLasciati;
	private int attrezziSoglia;
	
	public StanzaMagica(String nome) {
		this(nome, soglia);
	}
	public StanzaMagica(String nome, int soglia) {
		super(nome);
		this.attrezziLasciati=0;
		this.attrezziSoglia=soglia;
	}
	
	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		StringBuilder invertiNome=new StringBuilder(attrezzo.getNome());
		invertiNome= invertiNome.reverse();
		int peso2=attrezzo.getPeso()*2;
		attrezzo=new Attrezzo(invertiNome.toString(),peso2);
		return attrezzo;

	}
	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(this.attrezziLasciati>this.attrezziSoglia)
			attrezzo=this.modificaAttrezzo(attrezzo);
		this.attrezziLasciati++;
		return super.addAttrezzo(attrezzo);
	}
	

}
