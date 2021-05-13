package com.example.BlackHammerTestTask.repo;

import com.example.BlackHammerTestTask.models.Planets;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface PlanetRepository extends CrudRepository<Planets, Long> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE planets SET lord_id= ?1 WHERE id=?2", nativeQuery = true)
     void setLordToPlanet(@Param("name")Long lord_id, @Param("id")Long id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM planets WHERE id=?1", nativeQuery = true)
    void deletePlanetById( @Param("id")Long id);
}
