package com.college.library.controller;

import com.college.library.service.ServiceFile;
import com.college.library.entity.Library;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


//Controller Class (Presentation Layer)
@RestController
@RequestMapping("/library/api")
public class ControllerClass {

    @Autowired
    ServiceFile s1;

    //For Inserting(create)
    @PostMapping("/create")
    ResponseEntity<Map> create(@Valid @RequestBody Library l)
    {
        s1.forInsert(l);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("message", "Successfully Created"));

    }

    //getting result by id using find function
    @GetMapping("/get/{id}")
    ResponseEntity<?> geti(@PathVariable int id)
    {
        try{
            Library l= s1.getIdf(id);
            return new ResponseEntity<>(l,HttpStatus.OK);
        }
        catch(RuntimeException e)
        {
            return new ResponseEntity<>( "user not found ",HttpStatus.NOT_FOUND);
        }
    }
    //get all
    @GetMapping("/get")
    ResponseEntity<List<Library>> geta()
    {
        return new ResponseEntity<>(s1.getAll(),HttpStatus.OK);
    }

    //delete by id(deletion)
    @DeleteMapping("/delete")
    ResponseEntity<String> delete(@RequestParam int id)
    {
        Library l1;
        ResponseEntity<String> re;
        try{
            l1=s1.getIdf(id);
            re=new ResponseEntity<>("deleted",HttpStatus.OK);
        }
        catch(RuntimeException e)
        {
            re=new ResponseEntity<>("NOTFOUND",HttpStatus.NOT_FOUND);
        }
        return re;
    }
//    update by id(updation)
    @PutMapping("/update")
    ResponseEntity<Library> update(@RequestBody Library rb)
    {
        return new ResponseEntity<>(s1.update(rb),HttpStatus.ACCEPTED);
    }
}
