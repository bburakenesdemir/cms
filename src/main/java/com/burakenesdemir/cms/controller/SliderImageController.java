package com.burakenesdemir.cms.controller;

import com.burakenesdemir.cms.data.entity.SliderImage;
import com.burakenesdemir.cms.service.SliderImageService;
import com.burakenesdemir.cms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/slider-image")
public class SliderImageController {

    @Autowired
    SliderImageService sliderImageService;


    @PostMapping
    public ResponseEntity<SliderImage> create(@RequestBody SliderImage sliderImage) {
        sliderImageService.create(sliderImage);

        return new ResponseEntity<SliderImage>(sliderImage, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<SliderImage> update(@RequestBody SliderImage sliderImage) {
        sliderImageService.update(sliderImage);

        return new ResponseEntity<SliderImage>(sliderImage, HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<SliderImage> delete(@PathVariable("id") String id) {
        SliderImage sliderImage = sliderImageService.delete(id);

        return new ResponseEntity<SliderImage>(sliderImage, HttpStatus.OK);
    }


    @GetMapping("/all")
    public ResponseEntity<List<SliderImage>> getAll() {
        return ResponseEntity.ok().body(sliderImageService.getAll());

    }
}