package mx.isban.scc.utilerias;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Clase para obtener los valores provenientes del config server relacionados
 * con el el cache de la aplicaci´pn para incrementar el performance
 * 
 * @author Gabriel Dolores García Septiembre 2019
 *
 */
@Component
public class ScheduleConfig {

	/**
	 * El Intervalo de refresh de tareas programadas en minutos
	 */
	@Value("${schedule.cache.intervalo}")
	private int intervalo;

	@Value("${schedule.poolsize}")
	private int poolSize;

	/**
	 * Obtiene el valor del intervalo que se usará para la tarea programada que
	 * vacía el caché
	 * 
	 * @return int con el intervalo de ejecución
	 */
	public int getIntervalo() {
		return intervalo;
	}

	/**
	 * Inicializa el valor del intervalo que se usará para la tarea programada que
	 * vacía el caché
	 * 
	 * @param intervalo int con el intervalo de ejecución
	 */
	public void setIntervalo(int intervalo) {
		this.intervalo = intervalo;
	}

	/**
	 * Obtiene el valor del pool que usará la aplicación para tareas programadas
	 * 
	 * @return int con el valor del pool que usará la aplicación para tareas
	 *         programadas
	 */
	public int getPoolSize() {
		return poolSize;
	}

	/**
	 * Inicializa el valor del pool que usará la aplicación para tareas programadas
	 * 
	 * @param poolSize int con el valor del pool que usará la aplicación para tareas
	 *                 programadas
	 */
	public void setPoolSize(int poolSize) {
		this.poolSize = poolSize;
	}

}
