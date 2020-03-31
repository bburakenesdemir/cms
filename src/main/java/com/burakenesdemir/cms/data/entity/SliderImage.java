package com.burakenesdemir.cms.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity(name = "SliderImage")
@Table
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SliderImage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "id")
    private String identifier;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "redirection_url")
    private String redirectionUrl;

    @Column(name = "is_external")
    private Boolean isExternal;

    @NotNull
    @Column(name = "file_path")
    private String  filePath;

    @Column(name = "order_number")
    private String orderNumber;
}
