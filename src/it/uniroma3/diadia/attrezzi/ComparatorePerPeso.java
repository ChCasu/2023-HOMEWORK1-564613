package it.uniroma3.diadia.attrezzi;
import java.util.*;
public class ComparatorePerPeso implements Comparator<Attrezzo>{
	public int compare(Attrezzo att1, Attrezzo att2) {
		if(att1.getPeso()-att2.getPeso()==0) {
			return att1.getNome().compareTo(att2.getNome());
		}else
			return att1.getPeso()-att2.getPeso();
	}
	

}
