package org.example.resources;

import org.example.entities.Worker;
import org.example.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

    @Autowired
    private WorkerRepository repository;

    @GetMapping("")
    public ResponseEntity<List<Worker>> findAll(){
        List<Worker> result = repository.findAll();
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id){
        Worker result = repository.findById(id).get();
        return ResponseEntity.ok().body(result);
    }
}
