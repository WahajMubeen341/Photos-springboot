package com.spring.project.g.photo.clone;

import com.spring.project.g.photo.clone.Modal.Photo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ImagesController {

    private Map<String, Photo> db  = new HashMap() {{
        put("1", new Photo("1", "hello.jpg"));
        put("2", new Photo("2", "hello2.jpg"));
        put("3", new Photo("3", "hello3.jpg"));
        put("4", new Photo("4", "hello4.jpg"));
    }};
//    private List<Photo> db = List.of(new Photo("1", "hello.jpg"));
    @GetMapping("/")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/photoz")
    public Collection<Photo> getPhoto(){
        return db.values();
    }

    @DeleteMapping("/photoz/{id}")
    public void deletePhoto(@PathVariable String id){
        Photo photo = db.remove(id);
        if(photo ==  null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

    }
    @GetMapping("/photoz/{id}")
    public Photo getPhoto(@PathVariable String id){
        Photo photo = db.get(id);
        if(photo ==  null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return db.get(id);
    }
}
