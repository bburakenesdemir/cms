package com.burakenesdemir.cms.controller;

import com.burakenesdemir.cms.data.entity.Appeal;
import com.burakenesdemir.cms.service.AppealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appeal")
public class AppealController {

    @Autowired
    AppealService appealService;

    @PostMapping
    public ResponseEntity<Appeal> create(@RequestBody Appeal appeal) {
        appealService.create(appeal);

        return new ResponseEntity<Appeal>(appeal, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Appeal> update(@RequestBody Appeal appeal) {
        appealService.update(appeal);

        return new ResponseEntity<Appeal>(appeal, HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Appeal> delete(@PathVariable("id") String id) {
        Appeal appeal = appealService.delete(id);

        return new ResponseEntity<Appeal>(appeal, HttpStatus.OK);
    }


    @GetMapping("/all")
    public ResponseEntity<List<Appeal>> getAll() {
        return ResponseEntity.ok().body(appealService.getAll());

    }


}
