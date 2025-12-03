package com.college.library.controller;

import com.college.library.service.ServiceFile;
import com.college.library.entity.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//Controller Class (Presentation Layer)
@RestController
@RequestMapping("/library/api")
public class ControllerClass {

    @Autowired
    ServiceFile s1;

    //For Inserting
    @PostMapping("/create")
    String create(@RequestBody Library l)
    {
        return s1.forInsert(l);
    }

    //For Getting result by id using get reference function
    @GetMapping("/getr/{id}")
    ResponseEntity<Library> getir(@PathVariable int id)
    {
            return new ResponseEntity<>(s1.getIdr(id),HttpStatus.FOUND);
    }

    //getting result by id using find function
    @GetMapping("/get/{id}")
    ResponseEntity<Library> geti(@PathVariable int id)
    {
        try{
            Library l= s1.getIdf(id);
            return new ResponseEntity<>(l,HttpStatus.FOUND);
        }
        catch(RuntimeException e)
        {
            return new ResponseEntity<>((HttpHeaders) null,HttpStatus.NOT_FOUND);
        }
    }

    //get all
    @GetMapping("/get")
    ResponseEntity<List<Library>> geta()
    {
        return new ResponseEntity<>(s1.getAll(),HttpStatus.FOUND);
    }

    //get all with Pageination

    //For page we need to give the number of the page and size of each page(number of rows)
    @GetMapping("/page")
    ResponseEntity<Page<Library>> allByPage(@RequestParam int p,@RequestParam int s)
    {
        return new ResponseEntity<>(s1.getPage(p,s),HttpStatus.FOUND);
    }

    //delete by id
    @DeleteMapping("/delete")
    String delete(@RequestParam int id)
    {
        return s1.deleteRow(id);
    }

//    update by id
    @PutMapping("/update")
    ResponseEntity<Library> update(@RequestBody Library rb)
    {
        return new ResponseEntity<>(s1.update(rb),HttpStatus.ACCEPTED);
    }


}
