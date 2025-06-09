package com.example.recipekit.Controller;

import com.example.recipekit.Entities.input.putinputentity;
import com.example.recipekit.Entities.input.recipesinputentity;
import com.example.recipekit.Exceptions.ResourceNotFoundException;
import com.example.recipekit.adapter.putadapter;
import com.example.recipekit.adapter.recipeadapter;
import com.example.recipekit.commons.recipeadaptercommon;
import jakarta.validation.Valid;
import com.example.recipekit.model.recipemodel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/recipe")
public class recipecontroller {

    private final recipeadapter adapter;

    private final putadapter putadapter;

    @Autowired
    public recipecontroller(recipeadapter adapter, putadapter putadapter){
        this.adapter=adapter;
        this.putadapter= putadapter;
    }

    @PostMapping("/addrecipe")
    public ResponseEntity<?> addRecipe(@Valid @RequestBody recipesinputentity recipesinputentity) {
        return new ResponseEntity<>(
                this.adapter.save(recipesinputentity),
                HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllRecipes() {
        return new ResponseEntity<>(this.adapter.getAll(), HttpStatus.OK);
    }

    @GetMapping("/getby/{id}")
    public ResponseEntity<?> getById(@Valid @PathVariable("id") long Id) {
        try {
            return new ResponseEntity<>(this.adapter.getById(Id), HttpStatus.OK);
        }
        catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateBook(@Valid @RequestBody recipesinputentity recipesinputentity) {
        try {
            return new ResponseEntity<>(
                    this.adapter.update(recipesinputentity),
                    HttpStatus.OK
            );
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/addall")
    public ResponseEntity<?> addAllRecipes(@Valid @RequestBody List<recipesinputentity> inputList) {
        List<recipemodel> savedList = this.adapter.addAll(inputList);
        return new ResponseEntity<>(savedList, HttpStatus.CREATED);
    }

    @PatchMapping("/requpdate/{id}")
    public ResponseEntity<?> updatePartially(@PathVariable("id") Long id,
                                             @RequestBody putinputentity input) {
        recipemodel updated = putadapter.requpdate(id, input);
        return ResponseEntity.ok(Map.of("message", "Recipe updated", "updatedRecipe", updated));
    }


    @DeleteMapping("/deleterecipe/{id}")
    public ResponseEntity<?> delete(@Valid @PathVariable("id") long id) {
        this.adapter.delete(id); // performs deletion
        return ResponseEntity.ok(Map.of("message", "Recipe deleted successfully"));
    }

    @GetMapping("getbetween")
    public ResponseEntity<?> getbetween(@Valid @RequestParam Double start, @RequestParam Double end) {
        return new ResponseEntity<>(this.adapter.getbetween(start,end), HttpStatus.OK);
    }



}
