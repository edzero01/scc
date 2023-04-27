package mx.isban.scc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.isban.scc.model.SccMxMaeSimuladorDroJpa;

/**
 * Interfaz para guardado de datos de la tabla simulador dro
 * @author Hitss
 *
 */
public interface ISccMxMaeSimuladorDroRepository extends JpaRepository<SccMxMaeSimuladorDroJpa, Long>{

}
