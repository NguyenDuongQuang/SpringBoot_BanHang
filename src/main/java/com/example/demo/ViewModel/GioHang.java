package com.example.demo.ViewModel;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GioHang {
    private Long id;

    private String ten;

    private String anh;

    private Integer soLuong;

    private Float gia;

    private Integer giamGia;
}
