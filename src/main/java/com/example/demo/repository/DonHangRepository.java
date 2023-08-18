package com.example.demo.repository;

import com.example.demo.entity.DonHang;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface DonHangRepository extends JpaRepository<DonHang,Long> {
    List<DonHang> findAllByAdmins_Id(long id);
    List<DonHang> findAllById(long id);

    @Query(value = "Select sum(gia)  from DonHang where  Year(ngayTao) like '2023' ",nativeQuery = true)
    Float selectTotals();
    @Query(value = "Select sum(gia)  from DonHang where  Month(ngayTao) =5 ",nativeQuery = true)
    Float selectTotalsMonth();
}
