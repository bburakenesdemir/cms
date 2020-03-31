package com.burakenesdemir.cms.data.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Data
@Entity(name = "Appeal")
@Table
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Appeal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String identifier;

    @Column(name = "corporate_name")
    @Length(max = 30)
    private String corporateTitle;

    @Column(name = "authorized_person")
    @Length(max = 30)
    private String authorizedPerson;

    @Column(name = "phone")
    @Length(max = 11)
    private String phone;

    @Column(name = "email")
    @Length(max = 30)
    private String email;

    @Column(name = "communication_type")
    private Boolean appealType;

    @Column(name = "number_of_employees")
    private Integer numberOfEmployees;
}
