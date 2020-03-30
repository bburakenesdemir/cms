package com.burakenesdemir.cms.controller;

import com.burakenesdemir.cms.data.entity.Communication;
import com.burakenesdemir.cms.service.CommunicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/communication")
public class CommunicationController {

    @Autowired
    CommunicationService communicationService;

    @PostMapping
    public ResponseEntity<Communication> create(@RequestBody Communication communication) {
        communicationService.create(communication);

        return new ResponseEntity<Communication>(communication, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Communication> update(@RequestBody Communication communication) {
        communicationService.update(communication);

        return new ResponseEntity<Communication>(communication, HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Communication> delete(@PathVariable("id") Long id) {
        Communication communication = communicationService.delete(id);

        return new ResponseEntity<Communication>(communication, HttpStatus.OK);
    }


    @GetMapping("/all")
    public ResponseEntity<List<Communication>> getAll() {
        return ResponseEntity.ok().body(communicationService.getAll());

    }
}
