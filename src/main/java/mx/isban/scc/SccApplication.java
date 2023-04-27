package mx.isban.scc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.client.RestTemplate;

import mx.isban.scc.utilerias.ScheduleConfig;

/**
 * 
 * Simulador de Credito al Consumo para Santander Clase principal para la
 * ejecución del sistema que además configura los valores
 * de caché manager y scheduler
 * 
 * @author Fabrica de Software GlobalHitss Equipo: Gabriel Dolores Lorena Baruch
 *         Christopher Espina Alexis Cedillo Octavio Cruz
 * 
 *
 */
@SpringBootApplication
@EnableCaching
@EnableScheduling
public class SccApplication {

	/**
	 * Propiedad para acceder al caché manager de spring
	 * que está siendo configurado para usar REDIS
	 */
	@Autowired
	private CacheManager cacheManager;

	/**
	 * Variable para acceder a la configuración del tiempo que se debe 
	 * ejecutar el vaciado del caché
	 */
	@Autowired
	private ScheduleConfig config;

	/**
	 * Poool de schedulers que almacenara las tareas repetitivas del sistema
	 * y que sirve para limpiar el caché
	 */
	@Autowired
	private ThreadPoolTaskScheduler pool;

	/**
	 * Metodo principal del sistema que inicia toda la plataforma
	 * mediante SpringApplication.run(SccApplication.class, args);
	 * 
	 * @param args argumentos
	 */
	public static void main(String[] args) {
		System.setProperty("oracle.net.wallet_location", "Wallet_simulador");
		System.setProperty("oracle.net.tns_admin", "Wallet_simulador");
		SpringApplication.run(SccApplication.class, args);
	}

	/**
	 * Inicializa el pool de schedulers que usará el sistema 
	 * para tareas programadas que en especifico se terata
	 * de la tarea para eliminar el cache de la aplicacióón
	 * 
	 * @return ThreadPoolTaskScheduler con el pool de tareas
	 */
	@Bean
	public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
		ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
		threadPoolTaskScheduler.setPoolSize(config.getPoolSize());
		threadPoolTaskScheduler.setThreadNamePrefix("SccThreadPoolTaskScheduler");
		return threadPoolTaskScheduler;
	}

	/**
	 * Obtiene la tarea programada para ejecutar el vaciado del caché  usando un
	 * tiempo indicado en los parametros de configuración
	 * del server config en el servidor
	 * 
	 * @return TaskScheduler con la tarea programada para el vaciado del caché
	 */
	@Bean
	public TaskScheduler taskScheduler() {
		long periodo = 60000L * config.getIntervalo();
		pool.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				cacheManager.getCacheNames().stream().forEach(cacheName -> cacheManager.getCache(cacheName).clear());

			}
		}, periodo);
		return pool;
	}
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
}
