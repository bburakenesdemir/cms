package com.burakenesdemir.cms.mapper;

import com.burakenesdemir.cms.data.entity.Post;
import com.burakenesdemir.cms.model.dto.PostDto;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface PostMapper {

    Post toEntity(PostDto postDto);
}
