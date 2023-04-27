package mx.isban.scc.utilerias;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

class CaratulaPlantillaDefTest {
  
	@Test
	void testPrivateConstructor() throws Exception {
		Constructor<CaratulaPlantillaDef> constructor = CaratulaPlantillaDef.class.getDeclaredConstructor();
		assertTrue("Constructor is not private", Modifier.isPrivate(constructor.getModifiers()));

		constructor.setAccessible(true);
		assertThrows(InvocationTargetException.class, () -> {
	        constructor.newInstance();
	    });
		
	}

}
