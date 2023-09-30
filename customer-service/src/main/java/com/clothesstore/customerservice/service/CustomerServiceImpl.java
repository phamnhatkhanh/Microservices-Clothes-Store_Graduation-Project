package com.clothesstore.customerservice.service;

import com.clothesstore.customerservice.dto.AdressResquest;
import com.clothesstore.customerservice.dto.CustomerRespone;
import com.clothesstore.customerservice.dto.CustomerResquest;
import com.clothesstore.customerservice.model.Address;
import com.clothesstore.customerservice.model.Customer;
import com.clothesstore.customerservice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private final CustomerRepository customerRepository;
    @Autowired
    private Environment environment;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Customer findById(Long id){
        return customerRepository.findById(id).orElseThrow();
    }
    @Override
    public List<Customer> all(){
        return customerRepository.findAll();
    }

    @Override
    public CustomerRespone save(CustomerResquest customerResquest){
        log.info(customerResquest.toString());
        log.info(customerResquest.getAdressResquest().toString());
        Customer newCustomer = modelMapper.map(customerResquest,Customer.class);
        LocalDateTime currentDateTime = LocalDateTime.now();
        newCustomer.setCreatedAt(currentDateTime);
//        newCustomer.setLastName(customerResquest.getLastName());
//        newCustomer.setEmail(customerResquest.getEmailAddress());
        List<Address> addressList = new ArrayList<>();
        List<Customer> customerList = new ArrayList<>();
        customerList.add(newCustomer);

        for (AdressResquest adressResquest  : customerResquest.getAdressResquest()) {
            Address address = modelMapper.map(adressResquest,Address.class);

//            log.info(adressResquest.getFirstName());
//            address.setFirstName(adressResquest.getFirstName());
//            log.info(adressResquest.getLastName());
//            address.setLastName(adressResquest.getLastName());
//            address.setCustomers(customerList);
            addressList.add(address);
//            log.info(address.toString());
        }

//        log.info(addressList.toString());

        newCustomer.setAddresses(addressList);
        newCustomer =  customerRepository.save(newCustomer);
        CustomerRespone customerRespone = modelMapper.map(newCustomer,CustomerRespone.class);
        return customerRespone;
    }

    @Override
    public Customer update(Long id, Customer newCustomer){
        return customerRepository.findById(id)
                .map(customer -> {
                    customer.setFirstName(newCustomer.getFirstName());
                    customer.setLastName(newCustomer.getLastName());
           
                    return customerRepository.save(customer);
                })
                .orElseGet(() -> {
                    newCustomer.setId(id);
                    return customerRepository.save(newCustomer);
                });
    }
    @Override
    public void deleteById(Long id){
         customerRepository.deleteById(id);
    }

    


}
