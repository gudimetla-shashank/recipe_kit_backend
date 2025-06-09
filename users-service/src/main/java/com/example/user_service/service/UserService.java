package com.example.user_service.service;

import com.example.user_service.entities.inputentities.reqinputentity;
import com.example.user_service.models.Usermodel;
import com.example.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public Usermodel save(Usermodel Usermodel){
        return this.userRepository.save(Usermodel);
    }

    public Usermodel getByID(Long Id){
        return this.userRepository.getByID(Id);
    }

    public List<Usermodel> getAll(){
        return this.userRepository.getAll();
    }

   public Usermodel update(Usermodel Usermodel){
        return this.userRepository.update(Usermodel);
   }

   public List<Usermodel> saveAll(List<Usermodel> Usermodel){
        return this.userRepository.saveall(Usermodel);
   }

   public Usermodel requpdate(Long Id, reqinputentity reqinputentity){
        return this.userRepository.requpdate(Id, reqinputentity);
   }

    public void delete(long ID){
        this.userRepository.delete(ID);
    }
}
