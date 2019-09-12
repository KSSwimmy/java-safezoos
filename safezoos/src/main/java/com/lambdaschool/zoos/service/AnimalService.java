package com.lambdaschool.zoos.service;

import com.lambdaschool.zoos.model.Animal;
import com.lambdaschool.zoos.view.CountAnimalsInZoo;

import java.util.ArrayList;
import java.util.List;

public interface AnimalService {
    ArrayList<Animal> findAll();

    Animal findAnimalByType(String type);

    // define getCountAnimalsInZoo method
    // which will be overridden by our AnimalServiceImpl
    List<CountAnimalsInZoo> getCountAnimalsInZoo();
}
