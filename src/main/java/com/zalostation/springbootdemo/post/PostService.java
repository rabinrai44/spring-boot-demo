package com.zalostation.springbootdemo.post;

import com.zalostation.springbootdemo.jsonplaceholder.JSONPlaceHolderClient;
import com.zalostation.springbootdemo.jsonplaceholder.Post;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostService {
    @Autowired
    private JSONPlaceHolderClient jsonPlaceHolderClient;


    public List<Post> getAllPosts() {
        return jsonPlaceHolderClient.getPosts();
    }

    public Post getPostById(Integer postId) {
        return jsonPlaceHolderClient.getPost(postId);
    }
}
