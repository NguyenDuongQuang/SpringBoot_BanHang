package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DonHang")
public class DonHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "diaChi")
    private String diaChi;

    @Column(name = "PhuongThucTT")
    private Integer phuongThucTT;

    @Column(name = "ngayTao")
    private Date ngayTao;

    @Column(name = "gia")
    private Float gia;

    @Column(name = "tenNguoiNhan")
    private String tenNguoiNhan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdAdmin",referencedColumnName = "id")
    private Admins admins;





}
