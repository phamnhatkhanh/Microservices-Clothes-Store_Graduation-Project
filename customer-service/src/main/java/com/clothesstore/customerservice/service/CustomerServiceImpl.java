package com.clothesstore.customerservice.service;

import com.clothesstore.customerservice.dto.AdressResquest;
import com.clothesstore.customerservice.dto.CustomerRespone;
import com.clothesstore.customerservice.dto.CustomerResquest;
import com.clothesstore.customerservice.model.Address;
import com.clothesstore.customerservice.model.Customer;
import com.clothesstore.customerservice.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public CustomerRespone findById(Long id){
        Customer customer = customerRepository.findById(id).orElseThrow();
        return modelMapper.map(customer,CustomerRespone.class);
//        return
    }
    @Override
    public List<CustomerRespone> all(){
        List<CustomerRespone> customerList = customerRepository.findAll()
                .stream()
                .map(customer -> modelMapper.map(customer, CustomerRespone.class))
                .collect(Collectors.toList());
        return  customerList;
    }

    @Override
    public CustomerRespone save(CustomerResquest customerResquest){
//        log.info(customerResquest.toString());
//        log.info(customerResquest.getAdressResquest().toString());
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
            address.setCustomers(customerList);
            address.setCreatedAt(currentDateTime);
//            log.info(address.toString());
//            address.setFirstName(adressResquest.getFirstName());
//            log.info(adressResquest.getLastName());
//            address.setLastName(adressResquest.getLastName());
//            address.setCustomers(customerList);
            addressList.add(address);

//            log.info(address.toString());
        }

//        log.info(addressList.toString());
        log.info(newCustomer.getEmail());
//        log.info(newCustomer.getAddresses().toString() == null?"null":newCustomer.getAddresses().toString());
        newCustomer.setAddresses(addressList);
        newCustomer =  customerRepository.save(newCustomer);
//        log.info(newCustomer.toString());
//        log.info(newCustomer.getAddresses().toString());
        CustomerRespone customerRespone = modelMapper.map(newCustomer,CustomerRespone.class);

//        for (Address address  : customerRespone.getAddresses()) {
//
//            log.info(address.getAddress1());
////            address.setFirstName(adressResquest.getFirstName());
////            log.info(adressResquest.getLastName());
////            address.setLastName(adressResquest.getLastName());
////
//
////            log.info(address.toString());
//        }
//        log.info(customerRespone.toString());
//        log.info(customerRespone.getAddresses().get(0).toString());
        return customerRespone;
    }

    @Override
    public CustomerRespone update(Long id, CustomerResquest customerResquest){
        Customer dataCustomer = modelMapper.map(customerResquest,Customer.class);
        log.info("data custoemr");
        log.info(dataCustomer.toString());



        try{
            Customer oldCustomer = customerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Model not found with id: " + id));
            log.info("Get data");
            log.info(oldCustomer.toString());
            Field[] allFieldDataCustomer = dataCustomer.getClass().getDeclaredFields();
            String string ="string_replace_test";
            Field itemOldCustomer;
            try{
                for (Field dataItem : allFieldDataCustomer) {
                    // Allow access to private fields if necessary

                    dataItem.setAccessible(true);
                    if (dataItem.get(dataCustomer) != null) {
                        String fieldName = dataItem.getName();
                        itemOldCustomer = oldCustomer.getClass().getDeclaredField(fieldName);
                        itemOldCustomer.setAccessible(true);
                        itemOldCustomer.set(oldCustomer, dataItem.get(dataCustomer));

                    }
                }
            }catch (NoSuchFieldException e) {
                itemOldCustomer= null;
            }catch (IllegalAccessException a){
                itemOldCustomer= null;
            }
            log.info("Object after map:");
            log.info(oldCustomer.toString());



            oldCustomer.setUpdatedAt(LocalDateTime.now());
            Customer updatedCustomer = customerRepository.save(oldCustomer);
            return modelMapper.map(updatedCustomer, CustomerRespone.class);
        }catch (EntityNotFoundException e){
            Customer newCustomer = modelMapper.map(customerResquest, Customer.class);
            newCustomer.setId(id);
            Customer updatedCustomer = customerRepository.save(newCustomer);
            return modelMapper.map(updatedCustomer, CustomerRespone.class);
        }



//        Customer resultCustomer =  customerRepository.findById(id)
//                .map(customer -> {
//
//                    customer.setFirstName(newCustomer.getFirstName());
//                    customer.setLastName(newCustomer.getLastName());
//
//                    return customerRepository.save(customer);
//                })
//                .orElseGet(() -> {
//                    Customer newCustomer = new Customer();
//                    newCustomer.setId(id);
//
//
//                    return customerRepository.save(newCustomer);
//                });

//        return modelMapper.map(updatedCustomer, CustomerRespone.class);
//        return new CustomerRespone();
    }
    @Override
    public void deleteById(Long id){
         customerRepository.deleteById(id);
    }

    


}
