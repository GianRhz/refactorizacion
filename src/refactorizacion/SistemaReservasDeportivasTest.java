package refactorizacion;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SistemaReservasDeportivasTest {
static SistemaReservasDeportivas sistemasReservasDeportivas;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		sistemasReservasDeportivas = new SistemaReservasDeportivas();
	}

	@Test
	void testReservarPista() {
		LocalDateTime fecha = LocalDateTime.now();
		
		
	}

	@Test
	void testCancelarReserva() {
		fail("Not yet implemented");
	}

	@Test
	void testActivarIluminacion() {
		fail("Not yet implemented");
	}

	@Test
	void testDesactivarIluminacion() {
		fail("Not yet implemented");
	}

	@Test
	void testVerificarDisponibilidad() {
		fail("Not yet implemented");
	}

}
