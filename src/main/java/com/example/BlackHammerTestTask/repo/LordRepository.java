package com.example.BlackHammerTestTask.repo;

import com.example.BlackHammerTestTask.models.Lords;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



public interface LordRepository extends CrudRepository<Lords, Long> {

    @Query(value = "SELECT * FROM lords ORDER BY age LIMIT 10", nativeQuery = true)
     Iterable<Lords> getTop10YangLords();


    @Query(value = "SELECT * FROM lords AS L LEFT JOIN planets AS P ON P.lord_id = L.id WHERE P.lord_id IS NULL",
            nativeQuery = true)
    Iterable<Lords> lordsWithoutPlanets();

}
