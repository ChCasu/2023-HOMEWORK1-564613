package Test;
import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;



public class BorsaTest {

	Borsa borsa = new Borsa();
	Attrezzo manganello;
	Attrezzo cuscino;
	
	@Before
	public void setUp() {
		manganello = new Attrezzo("manganello", 3);
		cuscino = new Attrezzo("cuscino", 1);
	}

	@Test
	public void testAddAttrezzoPesoMinoreDiDieci() {
		assertTrue(borsa.addAttrezzo(manganello));

	}
	
	@Test
	public void testGetPeso() {
		borsa.addAttrezzo(manganello);
		assertEquals(3, borsa.getPeso());

	}
}
