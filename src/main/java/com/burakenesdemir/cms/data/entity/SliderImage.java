package com.burakenesdemir.cms.data.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

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
    private Long oid;

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

    private String title;

    private String description;

    private String redirectionUrl;

    private Boolean isExternal;

    @NotNull
    private String  filePath;

    private String orderNumber;
}
