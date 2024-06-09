package com.joblisting.repository;

import com.joblisting.entity.Post;

import java.util.ArrayList;
import java.util.List;

public interface SearchRepository {

    List<Post> findByText(String text);

}
