package mx.isban.scc;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Servlet para arrancar SpringBuilder
 * @author GlobalHitss
 *
 */
public class ServletInitializer extends SpringBootServletInitializer {

	/**
	* Configuracion para el servlet
	*/
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SccApplication.class);
	}

}
