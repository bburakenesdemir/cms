package com.burakenesdemir.cms.controller;

import com.burakenesdemir.cms.data.entity.Slider;
import com.burakenesdemir.cms.service.SliderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/slider")
public class SliderController {

    @Autowired
    SliderService sliderService;

    @PostMapping
    public ResponseEntity<Slider> create(@RequestBody Slider slider) {
        sliderService.create(slider);

        return new ResponseEntity<Slider>(slider, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Slider> update(@RequestBody Slider slider) {
        sliderService.update(slider);

        return new ResponseEntity<Slider>(slider, HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Slider> delete(@PathVariable("id") String id) {
        Slider slider = sliderService.delete(id);

        return new ResponseEntity<Slider>(slider, HttpStatus.OK);
    }


    @GetMapping("/all")
    public ResponseEntity<List<Slider>> getAll() {
        return ResponseEntity.ok().body(sliderService.getAll());

    }

}
