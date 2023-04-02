package Test;

import org.junit.Test;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class StanzaTest {

	Stanza stanza1 = new Stanza("stanza prima");
	Stanza stanza2 = new Stanza("stanza seconda");
	Attrezzo balestra = new Attrezzo("Balestra", 13);

	@Test
	public void testImpostaStanzaAdiacente() {
		stanza1.impostaStanzaAdiacente("sud", stanza2);
		assertEquals(stanza2, stanza1.getStanzaAdiacente("sud"));
	}

	@Test
	public void testGetStanzaAdiacente() {
		assertNull(stanza1.getStanzaAdiacente("est"));
	}

	@Test
	public void testAddAttrezzo() {

		assertTrue(stanza1.addAttrezzo(balestra));
	}

}
