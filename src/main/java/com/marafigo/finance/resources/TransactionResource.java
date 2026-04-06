package com.marafigo.finance.resources;

import com.marafigo.finance.entities.Transaction;
import com.marafigo.finance.entities.User;
import com.marafigo.finance.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/transactions")
public class TransactionResource {
    @Autowired
    private TransactionService service;

    @GetMapping
    public ResponseEntity<List<Transaction>>findAll(){
        List<Transaction> list= service.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Transaction>findById(@PathVariable Long id){
        Transaction obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @PostMapping
    public ResponseEntity<Transaction> insert(@RequestBody Transaction obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(obj.getId())
                .toUri();
        return ResponseEntity.created(uri).body(obj);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void>delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Transaction>update (@PathVariable Long id, @RequestBody Transaction obj){
        obj= service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }


}
