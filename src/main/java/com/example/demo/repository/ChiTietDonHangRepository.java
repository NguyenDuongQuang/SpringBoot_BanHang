package com.example.demo.repository;

import com.example.demo.entity.ChiTietDonHang;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ChiTietDonHangRepository extends JpaRepository<ChiTietDonHang,Long> {
    List<ChiTietDonHang> findAllByDonHang_Id(long id);
}
