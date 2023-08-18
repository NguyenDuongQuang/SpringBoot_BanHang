package com.example.demo.repository;

import com.example.demo.entity.Admins;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface AdminRepository extends JpaRepository<Admins,Long> {
    Admins deleteById(long id);
    Admins findById(long id);
    Admins findByEmail(String email);
    Admins findAdminsByUsername(String username);
    List<Admins>findAllById(long id);
    Page<Admins>findByUsernameLike(String keywords, Pageable pageable);
}
