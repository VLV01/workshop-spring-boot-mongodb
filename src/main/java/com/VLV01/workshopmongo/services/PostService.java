package com.VLV01.workshopmongo.services;

import com.VLV01.workshopmongo.domain.Post;
import com.VLV01.workshopmongo.domain.User;
import com.VLV01.workshopmongo.dto.UserDTO;
import com.VLV01.workshopmongo.repository.PostRepository;
import com.VLV01.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;


    public Post findById(String id) {
        Post user = repo.findById(id).orElse(null);
        if (user == null) {
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
        return user;
    }


}
