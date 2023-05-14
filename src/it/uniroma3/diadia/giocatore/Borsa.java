package it.uniroma3.diadia.giocatore;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.ComparatorePerPeso;


public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Map<String, Attrezzo> attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;
	private int peso;

	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new TreeMap<>();
		this.numeroAttrezzi = 0;
		this.peso=0;
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		this.attrezzi.put(attrezzo.getNome(), attrezzo);
		this.numeroAttrezzi++;
		this.peso+=attrezzo.getPeso();
		return true;
	}


	public int getPesoMax() {
		return pesoMax;
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for (int i = 0; i < this.numeroAttrezzi; i++)
			if (nomeAttrezzo!=null && this.attrezzi.containsKey(nomeAttrezzo))
				a = this.attrezzi.get(nomeAttrezzo);
		return a;
	}

	public int getPeso() {
		return this.peso;
	}
	public boolean getSpaziolibero(Attrezzo attrezzo) {
		if(attrezzo!=null&&this.getPesoMax()-this.getPeso()>=attrezzo.getPeso()){
			return true;
		}else
			return false;
		
	}

	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo) != null;
	}

	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		if (nomeAttrezzo != null) {
			a=attrezzi.remove(nomeAttrezzo);
		}
		return a;
	}
	

	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa (" + this.getPeso() + "kg/" + this.getPesoMax() + "kg): ");
			s.append("\n");
			s.append(this.getContenutoOrdinatoPerNome().toString());
			s.append("\n");
			s.append(this.getContenutoOrdinatoPerPeso().toString());
			s.append("\n");
			s.append(this.getContenutoRaggruppatoPerPeso().toString());
		} else
			s.append("Borsa vuota");
		return s.toString();
	}
	
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		SortedSet<Attrezzo> s = new TreeSet<Attrezzo>(new ComparatorePerPeso());
		s.addAll(this.attrezzi.values());
		return s;
	}
	
	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		List<Attrezzo> attrezzo= new ArrayList<>();
		attrezzo.addAll(this.attrezzi.values());
		Collections.sort(attrezzo, new ComparatorePerPeso());
		return attrezzo;
	}
	
	public SortedSet<Attrezzo>getContenutoOrdinatoPerNome(){
		return new TreeSet<Attrezzo>(this.attrezzi.values());
	}
	
	Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		Map<Integer,Set<Attrezzo>> map = new HashMap<>();
		for(Attrezzo a: this.attrezzi.values()) {
			if(map.containsKey(a.getPeso())) {
				map.get(a.getPeso()).add(a);
			}
			else {
					Set<Attrezzo> attrezzoSet=new HashSet<>();
					attrezzoSet.add(a);
					map.put(a.getPeso(), attrezzoSet);
				}
				
			}
			return map;
		}


}

