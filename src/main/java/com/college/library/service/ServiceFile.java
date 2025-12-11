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

    public void forInsert(Library l)
    {
        rf.save(l);
    }

    public Library getIdr(int id)
    {
        return rf.getReferenceById(id);
    }
    public Library getIdf(int id)
    {
        //throw Run time Exception if row dosenot exist
        return rf.findById(id).orElseThrow(()->new RuntimeException("NOT FOUND "));
    }

    //we create PAgeable by page and size and give it to page request which is get the data by that page
    public Page<Library> getPage(int page , int size)
    {
        Pageable pa= PageRequest.of(page,size);
        return rf.findAll(pa);
    }
    public List<Library> getAll()
    {
        return rf.findAll();
    }

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
