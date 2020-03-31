package com.burakenesdemir.cms.data.repository;

import com.burakenesdemir.cms.data.entity.Slider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SliderRepository extends JpaRepository<Slider,String> {
}
