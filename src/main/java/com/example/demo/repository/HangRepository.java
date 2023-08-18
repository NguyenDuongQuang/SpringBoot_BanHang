package com.example.demo.repository;

import com.example.demo.entity.Hang;
import javax.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface HangRepository extends JpaRepository<Hang,Long> {
    Hang findById(long id);
    Page<Hang> findByTenLike(String keywords, Pageable pageable);
    Hang deleteById(long id);
}
