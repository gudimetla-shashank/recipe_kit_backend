package com.example.user_service.repository;

import com.example.user_service.entities.inputentities.reqinputentity;
import com.example.user_service.entities.outputentities.outputentity;
import com.example.user_service.exceptions.ResourceNotFoundException;
import com.example.user_service.mappers.outputmapper.outputmapper;
import com.example.user_service.models.Usermodel;
import com.example.user_service.repository.JPA.JPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserRepository {

    private final outputmapper outputmapper;
    private final JPARepository JPARepository;

    @Autowired
    public UserRepository(outputmapper outputmapper, JPARepository JPARepository){
        this.outputmapper=outputmapper;
        this.JPARepository=JPARepository;
    }

    public Usermodel save(Usermodel Usermodel){
        if (JPARepository.existsByEmail(Usermodel.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }

        // Check for existing phone number
        if (JPARepository.existsByPhonenumber(Usermodel.getPhoneNumber())) {
            throw new IllegalArgumentException("Phone number already exists");
        }
        //model to OE
        outputentity outputentity1 = outputmapper.modeltoOE(Usermodel);
        //OE to db
        outputentity savedoutput = this.JPARepository.save(outputentity1);
        //returning into the model
        return this.outputmapper.OEtomodel(savedoutput);
    }

    public Usermodel getByID(long ID){
        outputentity finddata = this.JPARepository.findById((ID))
                .orElseThrow(() -> new ResourceNotFoundException("User with ID " + ID + " not found"));

        return this.outputmapper.OEtomodel(finddata);
    }

    public List<Usermodel> getAll(){
        return this.JPARepository.findAll().stream()
                .map(outputmapper::OEtomodel)
                .toList();
    }

    public Usermodel update(Usermodel Usermodel){
        Usermodel existingUsermodel = this.getByID(Usermodel.getID());
        return this.save(Usermodel);
    }

    public List<Usermodel> saveall(List<Usermodel> Usermodels){
        List<Usermodel> result = new ArrayList<>();
        for(Usermodel Usermodel : Usermodels){
            result.add(this.save(Usermodel));
        }
        return result;
    }

    public void delete(long Id){
        if (!this.JPARepository.existsById(Id)) {
            throw new ResourceNotFoundException("No user found with ID: " + Id);
        }
        this.JPARepository.deleteById(Id);
    }

    public Usermodel requpdate(Long Id, reqinputentity reqinputentity){
        if (JPARepository.existsByEmail(reqinputentity.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }

        // Check for existing phone number
        if (JPARepository.existsByPhonenumber(reqinputentity.getPhoneNumber())) {
            throw new IllegalArgumentException("Phone number already exists");
        }
        Usermodel data = Optional.ofNullable(this.getByID(Id))
                .orElseThrow(()->new ResourceNotFoundException("the data with id"+ Id+ "not found"));

        if (reqinputentity.getFirstName() != null)  data.setFirstName(reqinputentity.getFirstName());
        if (reqinputentity.getLastName() != null)  data.setLastName(reqinputentity.getLastName());
        if (reqinputentity.getEmail() != null)  data.setEmail(reqinputentity.getEmail());
        if (reqinputentity.getPhoneNumber() != null)  data.setPhoneNumber(reqinputentity.getPhoneNumber());
        if (reqinputentity.getPassword() != null)  data.setPassword(reqinputentity.getPassword());

        return this.save(data);
    }


}
