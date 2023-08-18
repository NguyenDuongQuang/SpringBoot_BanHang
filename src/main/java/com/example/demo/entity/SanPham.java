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
@Table(name = "SanPham")
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "ngayTao")
    private Date ngayTao;

    @Column(name = "giamGia")
    private Integer giamGia;

    @Column(name = "Anh")
    private String anh;

    @Column(name = "soLuong")
    private Integer soLuong;

    @Column(name = "gia")
    private Float gia;

    @Column(name = "trangThai")
    private Integer trangThai;

    @Column(name = "moTa")
    private String moTa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdHang",referencedColumnName = "id")
    private Hang hang;
}
