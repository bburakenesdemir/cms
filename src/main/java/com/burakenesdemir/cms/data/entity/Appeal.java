package com.burakenesdemir.cms.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity(name = "Appeal")
@Table
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Appeal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "id")
    private String identifier;

    @Column(name = "corparate_title")
    private String corporateTitle;

    @Column(name = "authorized_person")
    private String authorizedPerson;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "appeal_type")
    private Boolean appealType;

    @Column(name = "number_of_employees")
    private Integer numberOfEmployees;
}
