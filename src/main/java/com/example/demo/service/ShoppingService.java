package com.example.demo.service;

import com.example.demo.ViewModel.GioHang;

import java.util.Collection;

public interface ShoppingService {

    void add(GioHang item);

    void remove(int id);

    Collection<GioHang> getCartItems();

    void clear();

    void update(int id, int quantity);

    double getAmount();

    int getCount();
}
