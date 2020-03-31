package com.burakenesdemir.cms.data.repository;

import com.burakenesdemir.cms.data.entity.Slider;
import com.burakenesdemir.cms.data.entity.SliderImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SliderImageRepository extends JpaRepository<SliderImage,String> {
}
