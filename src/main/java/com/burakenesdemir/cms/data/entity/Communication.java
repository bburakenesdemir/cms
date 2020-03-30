package com.burakenesdemir.cms.data.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Data
@Entity(name = "Communication")
@Table
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Communication {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "id")
    private Integer identifier;

    @Column(name = "name_surname")
    @Length(max = 30)
    private String nameSurname;

    @Column(name = "email")
    @Length(max = 30)
    private String email;

    @Column(name = "phone")
    @Length(max = 30)
    private String phone;

    @Column(name = "message")
    @Length(max = 100)
    private String message;
}
