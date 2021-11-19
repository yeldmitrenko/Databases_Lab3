package com.dmitrenko.controller;

import com.dmitrenko.mapper.AbstractMapper;
import com.dmitrenko.service.AbstractService;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractController<T, DTO, ID> {
    protected abstract AbstractService<T, ID> getService();
    protected abstract AbstractMapper<T, DTO> getMapper();

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<List<DTO>> getAll() {
        List<T> objects = getService().getAll();
        List<DTO> objectsDTO = new ArrayList<>();
        for (T object : objects) {
            objectsDTO.add(getMapper().mapObjectToDTO(object));
        }
        return new ResponseEntity<>(objectsDTO, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public @ResponseBody ResponseEntity<DTO> getById(@PathVariable ID id) {
        T object = getService().getById(id);
        if (object != null) {
            return new ResponseEntity<>(getMapper().mapObjectToDTO(object), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody ResponseEntity<Void> create(@RequestBody T newObject) {
        getService().create(newObject);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody ResponseEntity<T> update(@PathVariable ID id, @RequestBody T object) {
        object = getService().getById(id);
        if (object != null) {
            getService().update(id, object);
            return new ResponseEntity<>(getService().update(id, object), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<DTO> delete(@PathVariable ID id) {
        if(getService().getById(id) != null) {
            getService().delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
