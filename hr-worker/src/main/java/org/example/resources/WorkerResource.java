package org.example.resources;

import org.example.entities.Worker;
import org.example.repositories.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

    private static Logger LOGGER = LoggerFactory.getLogger(WorkerResource.class);

    @Value("${test.config}")
    private String tstCfg;

    @Autowired
    private Environment env;

    @Autowired
    private WorkerRepository repository;

    @GetMapping("")
    public ResponseEntity<List<Worker>> findAll(){
        List<Worker> result = repository.findAll();
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id){

        LOGGER.info("SERVERPORT: " + env.getProperty("local.server.port"));

        Worker result = repository.findById(id).get();
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/configs")
    public ResponseEntity<Void> findConfig(){

        LOGGER.info("CONFIG: " + tstCfg);
        return ResponseEntity.noContent().build();
    }
}
