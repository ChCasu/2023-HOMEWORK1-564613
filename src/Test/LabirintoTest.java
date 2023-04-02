package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class LabirintoTest {
	Labirinto lab;
	Stanza stanza1;

	@Before
	public void setUp() {
		lab = new Labirinto();
		lab.creaStanze();
		stanza1=new Stanza("stanza 1");
	}
	
	@Test
	public void testSetStanzaCorrente() {
		lab.setStanzaAttuale(stanza1);
		assertEquals(stanza1, lab.getStanzaAttuale());
	}


	@Test
	public void testGetStanzaVincente() {
		assertEquals("Biblioteca", lab.getStanzaFinale().getNome());
	}



	@Test
	public void testGetStanzaCorrente() {
		assertEquals("Atrio", lab.getStanzaAttuale().getNome());
	}

}
