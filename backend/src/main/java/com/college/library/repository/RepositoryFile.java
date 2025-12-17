package com.college.library.repository;

import com.college.library.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RepositoryFile extends JpaRepository<Library,Integer> {
}
