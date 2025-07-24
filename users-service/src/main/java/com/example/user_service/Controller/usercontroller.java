package com.example.user_service.Controller;

import com.example.user_service.adapters.requpdateadapter;
import com.example.user_service.adapters.useradapter;
import com.example.user_service.entities.inputentities.inputentity;
import com.example.user_service.entities.inputentities.reqinputentity;
import com.example.user_service.exceptions.ResourceNotFoundException;
import com.example.user_service.models.Usermodel;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class usercontroller {

    private final useradapter adapter;

    private final requpdateadapter reqadapter;

    @Autowired
    public usercontroller(useradapter adapter, requpdateadapter reqadapter){
        this.adapter=adapter;
        this.reqadapter= reqadapter;
    }

    @PostMapping("/saveuser")
    public ResponseEntity<?> addUser(@Valid @RequestBody inputentity inputentity) {
        return new ResponseEntity<>(
                this.adapter.save(inputentity),
                HttpStatus.CREATED);
    }

    @GetMapping("/getuserbyId")
    public ResponseEntity<?> getuserbyID(@Valid @RequestParam long id){
        try {
            return new ResponseEntity<>(this.adapter.getById(id), HttpStatus.OK);
        }
        catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getallusers")
    public ResponseEntity<?> getall(){
        return new ResponseEntity<>(this.adapter.getAll(), HttpStatus.OK);
    }

    @PutMapping("/updateuser")
    public ResponseEntity<?> update(@Valid @RequestBody inputentity inputentity){
        try {
            return new ResponseEntity<>(
                    this.adapter.update(inputentity),
                    HttpStatus.OK
            );
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/addallusers")
    public ResponseEntity<?> addall(@Valid @RequestBody List<inputentity> inputentity){
        try {
            List<Usermodel> saved = this.adapter.saveAll(inputentity);
            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Unexpected error: " + e.getMessage()));
        }
    }

    @PatchMapping("/requpdate/{id}")
    public ResponseEntity<?> requpdate(@PathVariable("id") Long id,
                                       @RequestBody reqinputentity input){
        Usermodel updated = reqadapter.requpdate(id, input);
        return ResponseEntity.ok(Map.of("message", "User updated", "updatedUser", updated));
    }

    @DeleteMapping("/deleteuser")
    public ResponseEntity<?> delete(@Valid @RequestParam long id){
        this.adapter.delete(id); // performs deletion
        return ResponseEntity.ok(Map.of("message", "User deleted successfully"));
    }



}
