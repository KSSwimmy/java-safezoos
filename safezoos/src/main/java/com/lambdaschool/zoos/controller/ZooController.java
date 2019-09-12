package com.lambdaschool.zoos.controller;

import com.lambdaschool.zoos.service.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("hasRole('ADMIN') or hasRole('ZOODATA') or hasRole('MGR')")
@RequestMapping(value = "/zoos")
public class ZooController {
    @Autowired
    private ZooService zooService;

    // GET: localhost:2019/zoos/zoos
    @GetMapping(value = "/zoos", produces = {"application/json"})
    public ResponseEntity<?> listAllZoos() {
        return new ResponseEntity<>(zooService.findAll(), HttpStatus.OK);
    }

    // GET: localhost:2019/zoos/zoos/1
    // Get zoo by parameter id
    @GetMapping(value = "/zoos/{id}", produces = {"application/json"})
    public ResponseEntity<?> findZooById(@PathVariable int id) {
        return new ResponseEntity<>(zooService.findZooById(id), HttpStatus.OK);
    }

    // GET: localhost:2019/zoos/zoos/name
    @GetMapping(value = "/{name}", produces = {"application/json"})
    public ResponseEntity<?> findZooByName(@PathVariable String name) {
        return new ResponseEntity<>(zooService.findZooByName(name), HttpStatus.OK);
    }
}
