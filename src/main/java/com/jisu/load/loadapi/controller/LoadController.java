package com.jisu.load.loadapi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jisu.load.loadapi.playload.LoadDto;
import com.jisu.load.loadapi.service.LoadService;

@RestController
@RequestMapping("/load")
public class LoadController {

    @Autowired
    private LoadService service;

    @PostMapping
    public ResponseEntity<String> postLoad(@RequestBody LoadDto dto) {
        if (this.service.saveLoad(dto) != null) {
            return new ResponseEntity<>("Load details added successfully", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Something Went wrong ", HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ResponseEntity<List<LoadDto>> getAllLoadByShipperId(
            @RequestParam(value = "shipperId", required = false) UUID shipperId) {

        List<LoadDto> res;

        if (shipperId == null) {
            res = this.service.getAllLoad();
        } else {
            res = this.service.getByShipId(shipperId);
        }

        return ResponseEntity.ok(res);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoadDto> getSingleLoad(@PathVariable Integer id) {

        return new ResponseEntity<>(this.service.getLoadById(id), HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LoadDto> upadateLoad(@PathVariable Integer id, @RequestBody LoadDto dto) {

        return new ResponseEntity<>(this.service.updateLoad(id, dto), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LoadDto> deleteLoad(@PathVariable Integer id) {
        return new ResponseEntity<>(this.service.deleteLoad(id), HttpStatus.ACCEPTED);
    }

}
