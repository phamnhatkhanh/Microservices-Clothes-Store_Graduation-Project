package com.clothesstore.adminservice.service;

import com.clothesstore.adminservice.dto.respone.AdminRespone;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface AdminService {
    AdminRespone findById(Long id);

//    List<CustomerRespone> all();
//
//    List<CustomerRespone> findAllById(@RequestParam List<Long> ids);
//
//    AdminRespone save(AdminRespone adminRespone);
//
//    CustomerRespone update(Long id, CustomerRequest customerRequest);
//
//    void deleteById(Long id);


}

