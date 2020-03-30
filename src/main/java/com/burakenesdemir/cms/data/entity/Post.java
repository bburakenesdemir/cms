package com.burakenesdemir.cms.data.entity;

import com.burakenesdemir.cms.model.enums.PostType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "CmsPost")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CmsPost")
public class Post {

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

    private String name;

    private String author;

    @Lob
    private String content;

    @Lob
    private String excerpt;

    private Boolean isHeader;

    private Boolean isFooter;

    private Boolean deletable;

    private Boolean editable;

    @Enumerated(EnumType.STRING)
    private PostType postType;

    private String bannerImage;

    @ManyToOne(optional = true, fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST,CascadeType.MERGE })
    @JoinColumn(name = "slider_id", referencedColumnName = "id")
    private Slider slider;
}
