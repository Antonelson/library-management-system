package com.college.library.service;

import com.college.library.entity.Userd;
import com.college.library.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo ur;

    public Userd createUser(Userd l)
    {
        return ur.save(l);
    }
    
    public Userd getIdf(int id)
    {
        return ur.findById(id).orElseThrow(()->new RuntimeException("NOT FOUND "));
    }
    
}
