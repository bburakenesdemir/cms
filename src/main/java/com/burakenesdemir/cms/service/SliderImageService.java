package com.burakenesdemir.cms.service;

import com.burakenesdemir.cms.data.entity.SliderImage;
import com.burakenesdemir.cms.data.repository.SliderImageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SliderImageService {

    @Autowired
    SliderImageRepository sliderImageRepository;

    public SliderImage create(SliderImage sliderImage) {

        return sliderImageRepository.save(sliderImage);
    }

    public SliderImage delete(String id) {
        SliderImage sliderImage = sliderImageRepository.getOne(id);

        if (sliderImage == null) {
            log.error("Object could not found by id: {}", id);
            //throw
        } else {
            sliderImageRepository.delete(sliderImage);
        }

        return sliderImage;
    }

    public SliderImage update(SliderImage sliderImage) {
        SliderImage sliderImageToUpdate = sliderImageRepository.getOne(sliderImage.getIdentifier());
        if (sliderImageToUpdate == null) {
            log.error("Object could not found by id: {}", sliderImage.getIdentifier());
        } else {
            sliderImageToUpdate = sliderImage;
            sliderImageRepository.save(sliderImageToUpdate);
        }

        return sliderImageToUpdate;
    }

    public List<SliderImage> getAll() {
        List<SliderImage> sliderImages = sliderImageRepository.findAll();

        if (sliderImages.isEmpty()) {
            //throw
        }

        return sliderImages;
    }
}
