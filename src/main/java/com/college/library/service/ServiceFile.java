package com.college.library.service;

import com.college.library.entity.Library;
import com.college.library.repository.RepositoryFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceFile {

    @Autowired
    RepositoryFile rf;

    //create
    public void forInsert(Library l)
    {
        rf.save(l);
    }
    //get single row
    public Library getIdf(int id)
    {
        //throw Run time Exception if row dosenot exist
        return rf.findById(id).orElseThrow(()->new RuntimeException("NOT FOUND "));
    }

    //get all the rows
    public List<Library> getAll()
    {
        return rf.findAll();
    }

    //delete single rows
    public void deleteRow(int id)
    {
        rf.deleteById(id);
    }
    //save update the existing row if it is not create
    public Library update(Library l)
    {
        return rf.save(l);
    }
}
