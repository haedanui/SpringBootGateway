package com.nhnacademy.edu.gateway.adaptor;

import com.nhnacademy.edu.gateway.domain.Tag;

import java.util.List;

public interface TagAdaptor {
    List<Tag> getTags();

    Tag getTag(String tagName);

    void createTag(Tag tag);
}
