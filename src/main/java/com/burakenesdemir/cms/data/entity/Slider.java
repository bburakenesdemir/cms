package com.burakenesdemir.cms.data.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity(name = "Slider")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Slider", uniqueConstraints = {@UniqueConstraint(columnNames = {"name","code"})})
public class Slider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @JsonProperty("createdTime")
    protected Date created;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @JsonProperty("updatedTime")
    protected Date updated;

    @Column(name = "name")
    private String name;

    @Column(name= "code")
    private String code;

    @OneToMany(cascade = CascadeType.ALL)
    List<SliderImage> sliderImageList;

    private Boolean deletable;

    private Boolean editable;
}
