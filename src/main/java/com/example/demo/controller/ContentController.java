package com.example.demo.controller;

import com.example.demo.model.Content;
import com.example.demo.model.Status;
import com.example.demo.repository.ContentRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/content")
public class ContentController {
    private final ContentRepository repository;


    @Autowired // auto-wired constructor -> get the repository bean automatically
    public ContentController(ContentRepository repository) {
        this.repository = repository;
    }

    // create
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Content create(@Valid @RequestBody Content content) {
        return repository.save(content);
    }


    // read
    @GetMapping("")
    public List<Content> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Content not found"
                ));
    }

    // update
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public Content update(@PathVariable Integer id, @RequestBody Content content) {
        Content existingContent = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Content not found"
                ));

        return repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }

    @GetMapping("/filter/{keyword}")
    public List<Content> findByTitle(@PathVariable String keyword) {
        return repository.findAllByTitleContains(keyword);
    }

    @GetMapping("/filter/status/{status}")
    public List<Content> findByStatus(@PathVariable String status) {
        return repository.listByStatus(Status.valueOf(status));
    }
}
