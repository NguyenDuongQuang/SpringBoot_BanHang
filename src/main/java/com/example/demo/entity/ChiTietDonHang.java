package com.example.demo.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ChiTietDonHang")
public class ChiTietDonHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "soLuong")
    private Integer soLuong;

    @Column(name = "gia")
    private Float gia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdDonHang",referencedColumnName = "id")
    private DonHang donHang;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdSanPham",referencedColumnName = "id")
    private SanPham sanPham;


}
