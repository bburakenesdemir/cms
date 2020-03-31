package com.burakenesdemir.cms.data.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "Slider")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Slider", uniqueConstraints = {@UniqueConstraint(columnNames = {"name","code"})})
public class Slider {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "id")
    private String identifier;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @OneToMany(cascade = CascadeType.ALL)
    List<SliderImage> sliderImageList;

    @Column(name = "deletable")
    private Boolean deletable;

    @Column(name = "editable")
    private Boolean editable;
}
