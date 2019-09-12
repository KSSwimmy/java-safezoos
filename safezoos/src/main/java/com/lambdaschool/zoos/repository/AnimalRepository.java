package com.lambdaschool.zoos.repository;

import com.lambdaschool.zoos.model.Animal;
import com.lambdaschool.zoos.view.CountAnimalsInZoo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnimalRepository extends CrudRepository<Animal, Long> {
    Animal findByAnimaltype(String type);


    // This is will query the database in raw sql, and return
    // the animal count in zoos
    @Query(value = "SELECT animaltype as animalname, count(zooid) as zoocount FROM animal JOIN zooanimals ON animal.animalid = zooanimals.animalid GROUP BY animaltype ORDER BY zoocount DESC", nativeQuery = true)
    List<CountAnimalsInZoo> queryCountAnimalsInZoo();
}
