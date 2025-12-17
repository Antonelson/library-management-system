package com.college.library.repository;
import java.util.Optional;
import com.college.library.entity.Userd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<Userd,Integer> {
    Optional<Userd> findByEmail(String email);
}
