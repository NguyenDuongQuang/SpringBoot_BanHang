package com.example.demo.service;

import com.example.demo.ViewModel.GioHang;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Service
@SessionScope
public class ShoppingServiceImpl implements ShoppingService {
    private Map<Long, GioHang> map = new HashMap<Long,GioHang>();

    @Override
    public void add(GioHang item){
        GioHang existed = map.get(item.getId());
        if(existed!=null){
            existed.setSoLuong(item.getSoLuong()+1);
        }else
            map.put((Long) item.getId(),item);
    }

    @Override
    public void remove(int id){
        map.remove(id);
    }
    @Override
    public Collection<GioHang> getCartItems(){
        return map.values();
    }
    @Override
    public void clear(){
        map.clear();
    }
    @Override
    public void update(int id, int quantity){
        GioHang item = map.get(id);
        item.setSoLuong(quantity);
        if(item.getSoLuong()<=0){
            map.remove(id);
        }
    }
    @Override
    public double getAmount() {
        return map.values().stream().mapToDouble(item->item.getGia()*item.getSoLuong()*((100-item.getGiamGia())*0.01)).sum();
        //  map.values().stream().mapToDouble(item->item.getQuantity() * item.getPrice()).sum();
    }
    @Override
    public int getCount(){
//        if(map.isEmpty()){
//            return 0;
//        }
        return map.values().size();
    }
}
