package com.burakenesdemir.cms.data.entity;

import com.burakenesdemir.cms.model.enums.PostType;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity(name = "CmsPost")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "id")
    private String identifier;

    @Column(name = "title")
    private String title;

    @Column(name = "name")
    private String name;

    @Column(name = "author")
    private String author;

    @Lob
    @Column(name = "content")
    private String content;

    @Lob
    @Column(name = "excerpt")
    private String excerpt;

    @Column(name = "is_header")
    private Boolean isHeader;

    @Column(name = "is_footer")
    private Boolean isFooter;

    @Column(name = "deletable")
    private Boolean deletable;

    @Column(name = "editable")
    private Boolean editable;

    @Enumerated(EnumType.STRING)
    @Column(name = "post_type")
    private PostType postType;

    @Column(name = "banner_image")
    private String bannerImage;

    @ManyToOne(optional = true, fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST,CascadeType.MERGE })
    @JoinColumn(name = "slider_id", referencedColumnName = "id")
    private Slider slider;
}
