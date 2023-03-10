package com.VLV01.workshopmongo.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VLV01.workshopmongo.domain.Post;
import com.VLV01.workshopmongo.repository.PostRepository;
import com.VLV01.workshopmongo.services.exception.ObjectNotFoundException;

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

    public List<Post> findByTitle(String text) {
        return repo.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate){
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 60 * 1000); //24 horas em millisegundos
        return repo.fullSearch(text, minDate, maxDate);
    }


}
