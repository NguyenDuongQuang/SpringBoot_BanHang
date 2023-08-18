package com.example.demo.repository;

import com.example.demo.entity.SanPham;
import javax.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Transactional
public interface SanPhamRepository extends JpaRepository<SanPham,Long> {
    List<SanPham> findAllByHang_Id(long id);
    SanPham findById(long id);
    SanPham deleteById(long id);
    SanPham findAllById(long id);
    //       @Query("SELECT o FROM SanPham o WHERE o.Ten LIKE ?1")
    Page<SanPham> findByTenLike(String keywords, Pageable pageable);
    Page<SanPham> findByHang_Id(long keywords, Pageable pageable);
    Page<SanPham> findByGiaBetween(double a ,double b, Pageable pageable);
}
