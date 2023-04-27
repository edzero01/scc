package mx.isban.scc;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

class SccApplicationTest {


	@Test
	void test() {
		SccApplication app = new SccApplication();

		assertNotNull(app.restTemplate());

	}

}
