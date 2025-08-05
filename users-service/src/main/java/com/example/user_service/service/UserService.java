package com.example.user_service.service;

import com.example.user_service.entities.inputentities.reqinputentity;
import com.example.user_service.models.Usermodel;
import com.example.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;

    }

    public Usermodel save(Usermodel Usermodel){
        Usermodel.setPassword(this.bCryptPasswordEncoder.encode(Usermodel.getPassword()));
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

    public Usermodel getUserbyemail(String email) {
        return this.userRepository.getUserbyemail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        System.out.println("Loading user by username: " + username);
        try {
            Usermodel user = this.getUserbyemail(username);
            System.out.println("Found user: " + user.getEmail() + ", Password: " + user.getPassword());
            return new UserPrinciple(user);
        } catch (Exception e) {
            System.out.println("User not found.");
            throw new UsernameNotFoundException("User not found with email: " + username);
        }
    }


}
