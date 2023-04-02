package Test;
import org.junit.Test;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;




public class PartitaTest {

	Partita partita = new Partita();
	Stanza stanza = new Stanza("Stanza");

	@Test
	public void testGetStanzaVincente() {
		assertEquals("Biblioteca", partita.getLabirinto().getStanzaFinale().getNome());
	}
	@Test
	public void testIsFinita() {

		assertFalse(partita.isFinita());
	}

	@Test
	public void testSetStanzaCorrente() {
		partita.getLabirinto().setStanzaAttuale(stanza);
		assertEquals(stanza, partita.getLabirinto().getStanzaAttuale());
	}



}
