package com.burakenesdemir.cms.service;

import com.burakenesdemir.cms.data.entity.Post;
import com.burakenesdemir.cms.data.entity.Slider;
import com.burakenesdemir.cms.data.repository.PostRepository;
import com.burakenesdemir.cms.data.repository.SliderRepository;
import com.burakenesdemir.cms.mapper.PostMapper;
import com.burakenesdemir.cms.model.dto.PostDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    SliderRepository sliderRepository;

    @Autowired
    PostMapper postMapper;

    public Post create(PostDto postDto) {
        Post entity = postMapper.toEntity(postDto);

        if (postDto.getSliderId() != null) {
            Slider slider = sliderRepository.getOne(postDto.getSliderId());
            if (slider == null) {
                //throw
            }
            entity.setSlider(slider);
        } else {
            entity.setSlider(null);
        }

        return postRepository.save(entity);
    }

    public Post delete(String id) {
        Post post = postRepository.getOne(id);

        if (post == null) {
            log.error("Object could not found by id: {}", id);
            //throw
        } else {
            if (post.getDeletable() == true) {
                postRepository.delete(post);
            } else {
                //throw
            }
        }

        return post;
    }

    public Post update(Post post) {
        Post postToUpdate = postRepository.getOne(post.getIdentifier());
        if (postToUpdate == null) {
            log.error("Object could not found by id: {}", post.getIdentifier());
        } else {
            if (post.getEditable() == true) {
                postToUpdate = post;
                postRepository.save(postToUpdate);
            } else {
                //throw
            }
        }

        return postToUpdate;
    }

    public List<Post> getAll() {
        List<Post> posts = postRepository.findAll();

        if (posts.isEmpty()) {
            //throw
        }

        return posts;
    }
}
