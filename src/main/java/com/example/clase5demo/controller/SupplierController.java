package com.example.clase5demo.controller;

import com.example.clase5demo.repository.ShipperRepository;
import com.example.clase5demo.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    SupplierRepository supplierRepository;




}
