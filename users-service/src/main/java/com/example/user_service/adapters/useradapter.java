package com.example.user_service.adapters;

import com.example.user_service.commonadapter.usercommonadapter;
import com.example.user_service.entities.inputentities.inputentity;
import com.example.user_service.mappers.inputmapper.inputmapper;
import com.example.user_service.models.Usermodel;
import com.example.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class useradapter implements usercommonadapter<inputentity, Usermodel> {

    private final inputmapper inputmapper;
    private final UserService userService;

    @Autowired
    public useradapter(inputmapper inputmapper,UserService userService){
        this.inputmapper=inputmapper;
        this.userService=userService;
    }


    @Override
    public Usermodel save(inputentity inputentity) {
        return this.userService.save(this.inputmapper.IEtomodel(inputentity));
    }

    @Override
    public Usermodel getById(long ID) {
        return this.userService.getByID(ID);
    }

    @Override
    public List<Usermodel> getAll() {
        return this.userService.getAll();
    }

    @Override
    public Usermodel update(inputentity inputentity) {
        return this.userService.update(this.inputmapper.IEtomodel(inputentity));
    }

    @Override
    public List<Usermodel> saveAll(List<inputentity> inputentity) {
        List<Usermodel> usermodelList = new ArrayList<>();
        for (inputentity inputentity1 : inputentity) {
            Usermodel Usermodel = inputmapper.IEtomodel(inputentity1);
            usermodelList.add(Usermodel);
        }
        return this.userService.saveAll(usermodelList);
    }

    @Override
    public void delete(Long Id) {
        this.userService.delete(Id);
    }
}
