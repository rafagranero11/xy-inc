package com.zup.xy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zup.xy.model.Poi;

public interface PoiRepository extends JpaRepository<Poi,Long>{
	
	@Query("select p from Poi p where SQRT(POW(p.coordenadaX - :coordenadaX,2) + POW(p.coordenadaY - :coordenadaY,2)) <= :metros")
	List<Poi> localizarPorCorrdenadas(@Param("coordenadaX")Integer coordenadaX, 
			@Param("coordenadaY") Integer coordenadaY, 
			@Param("metros") Double metros);
	
}
