package Test.ambienti;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class LabirintoTest {
	Labirinto l;
	Stanza biblioteca;
	Stanza DS1;

	@Before
	public void setUp() {
		l = Labirinto.newBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("martello", 3)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.getLabirinto();
		
		biblioteca = new Stanza("Biblioteca");
		DS1 = new Stanza("DS1");
		
	}


	@Test
	public void testGetStanzaVincente() {
		assertEquals("Biblioteca", l.getStanzaFinale().getNome());
	}


	@Test
	public void testSetStanzaCorrente() {
		l.setStanzaAttuale(DS1);
		assertEquals(DS1, l.getStanzaAttuale());
	}
	@Test
	public void testGetStanzaCorrente() {
		assertEquals("Atrio", l.getStanzaAttuale().getNome());
	}

}
