package com.spring.project.g.photo.clone;

import com.spring.project.g.photo.clone.Modal.Photo;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

//@Component
@Service
public class PhotozService {
    private Map<String, Photo> db  = new HashMap() {{
        put("1", new Photo("1", "hello.jpg"));
        put("2", new Photo("2", "hello2.jpg"));
        put("3", new Photo("3", "hello3.jpg"));
        put("4", new Photo("4", "hello4.jpg"));
        put("5", new Photo("5", "hello5.jpg"));
        put("6", new Photo("6", "hello6.jpg"));
    }};

    public Collection<Photo> get() {
        return db.values();
    }

    public Photo get(String id) {
        return db.get(id);
    }

    public Photo remove(String id) {
        return db.remove(id);
    }

    public Photo save(String fileName, String contentType, byte[] data) {
        Photo photo = new Photo();
        photo.setContentType(contentType);
        photo.setId(UUID.randomUUID().toString());
        photo.setFileName(fileName);
        photo.setData(data);
        db.put(photo.getId(), photo);
        return photo;
    }
}
