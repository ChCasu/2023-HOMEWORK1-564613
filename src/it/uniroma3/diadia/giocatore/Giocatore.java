package it.uniroma3.diadia.giocatore;


public class Giocatore {
	private int cfu;
	private Borsa borsa;
	static final private int CFU_INIZIALI = 20;
	public Giocatore() {
		cfu=CFU_INIZIALI;
		this.borsa=new Borsa();
		
	}
	public int getCFU() {
		return this.cfu;
		
	}
	public void setCFU(int newCFU) {
		this.cfu=this.cfu+newCFU;
	}

	public Borsa getBorsa() {
		 return borsa;
	}
	public void setBorsa(Borsa borsa) {
		this.borsa=borsa;
	}

	
}
