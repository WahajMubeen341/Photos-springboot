package com.spring.project.g.photo.clone;

import com.spring.project.g.photo.clone.Modal.Photo;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.*;

@RestController
public class ImagesController {


    private final PhotozService photozService;

    public ImagesController(PhotozService photozService){
        this.photozService = photozService;
    }

//    private List<Photo> db = List.of(new Photo("1", "hello.jpg"));
    @GetMapping("/")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/photoz")
    public Collection<Photo> getPhoto(){
        return photozService.get();
    }

    @DeleteMapping("/photoz/{id}")
    public void deletePhoto(@PathVariable String id){
        Photo photo = photozService.remove(id);
        if(photo ==  null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

    }
    @GetMapping("/photoz/{id}")
    public Photo getPhoto(@PathVariable String id){
        Photo photo = photozService.get(id);
        if(photo ==  null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photozService.get(id);
    }


//    @PostMapping("/photoz")
//    public Photo createPhoto(@RequestBody @Valid Photo photo){
//        photo.setId(UUID.randomUUID().toString());
//        db.put(photo.getId(), photo);
//        return photo;
//    }

    @PostMapping("/photoz")
    public Photo createPhoto(@RequestPart("data") MultipartFile file) throws IOException {
//        Photo photo = new Photo();
//        photo.setId(UUID.randomUUID().toString());
//        photo.setFileName(file.getOriginalFilename());
//        photo.setData(file.getBytes());
            return   photozService.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());


    }
}
