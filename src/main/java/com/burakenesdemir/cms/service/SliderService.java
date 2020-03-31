package com.burakenesdemir.cms.service;

import com.burakenesdemir.cms.data.entity.Slider;
import com.burakenesdemir.cms.data.repository.SliderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SliderService {

    @Autowired
    SliderRepository sliderRepository;

    public Slider create(Slider slider) {

        return sliderRepository.save(slider);
    }

    public Slider delete(String id) {
        Slider slider = sliderRepository.getOne(id);

        if (slider == null) {
            log.error("Object could not found by id: {}", id);
            //throw
        } else {
            if (slider.getDeletable() == true) {
                sliderRepository.delete(slider);
            } else {
                //throw
            }
        }

        return slider;
    }

    public Slider update(Slider slider) {
        Slider sliderToUpdate = sliderRepository.getOne(slider.getIdentifier());
        if (sliderToUpdate == null) {
            log.error("Object could not found by id: {}", slider.getIdentifier());
        } else {
            if (slider.getEditable() == true) {
                sliderToUpdate = slider;
                sliderRepository.save(sliderToUpdate);
            } else {
                //throw
            }
        }

        return sliderToUpdate;
    }

    public List<Slider> getAll() {
        List<Slider> sliders = sliderRepository.findAll();

        if (sliders.isEmpty()) {
            //throw
        }

        return sliders;
    }

}
