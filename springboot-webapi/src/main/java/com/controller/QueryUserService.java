package com.controller;

import com.bean.Man;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QueryUserService {
    public List<Man> query(){
        Man man1 = new Man("mickjoust","1","111111");
        Man man2 = new Man("mia","1","6666666");
        Man man3 = new Man("max","1","33333333");
        List<Man> manList = new ArrayList<>();
        manList.add(man1);
        manList.add(man2);
        manList.add(man3);
        return manList;
    }
}