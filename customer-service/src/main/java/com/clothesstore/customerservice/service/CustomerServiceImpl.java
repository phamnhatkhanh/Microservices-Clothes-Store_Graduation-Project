package com.clothesstore.customerservice.service;

import com.clothesstore.customerservice.dto.AddressRequest;
import com.clothesstore.customerservice.dto.CustomerRespone;
import com.clothesstore.customerservice.dto.CustomerRequest;
import com.clothesstore.customerservice.model.Address;
import com.clothesstore.customerservice.model.Customer;
import com.clothesstore.customerservice.repository.CustomerRepository;
import com.clothesstore.customerservice.utils.CustomerUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerUtils customerUtils;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CustomerRespone findById(Long id){
        Optional<Customer> resultFound = customerRepository.findById(id);
        if(resultFound.isPresent()){
            CustomerRespone responeCustomer = modelMapper.map(resultFound.get(),CustomerRespone.class);
            return modelMapper.map(responeCustomer,CustomerRespone.class);
        }else{
            CustomerRespone responeCustomer = modelMapper.map(resultFound,CustomerRespone.class);
            responeCustomer.setErrorMessage("Not found item");
            return responeCustomer;
        }
    }

    @Override
    public List<CustomerRespone> findAllById(List<Long> ids) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // Convert the list to a JSON string
            String json = objectMapper.writeValueAsString(ids);

            // Print the JSON string
            System.out.println(json);
        } catch (JsonProcessingException e) {
            // Handle the exception (e.g., log it or take appropriate action)
            e.printStackTrace();
        }

        return customerRepository.findAllById(ids)
                .stream().map(customer -> modelMapper.map(customer,CustomerRespone.class))
                .collect(Collectors.toList());
    }
    @Override
    public List<CustomerRespone> all(){
        return customerRepository.findAll()
                .stream()
                .map(customer -> modelMapper.map(customer, CustomerRespone.class))
                .collect(Collectors.toList());
    }



    @Override
    public CustomerRespone save(CustomerRequest customerRequest){

        Customer newCustomer = modelMapper.map(customerRequest,Customer.class);

        List<Address> addressList = new ArrayList<>();
        List<Customer> customerList = new ArrayList<>();
        customerList.add(newCustomer);

        for (AddressRequest addressRequest : customerRequest.getAddressRequest()) {
            Address address = modelMapper.map(addressRequest,Address.class);
            address.setCustomers(customerList);
            addressList.add(address);
        }

        newCustomer.setAddresses(addressList);
        Customer createdCustomer =  customerRepository.save(newCustomer);

        return modelMapper.map(createdCustomer,CustomerRespone.class);

    }

    public CustomerRespone update(Long id, CustomerRequest customerRequest){
        Optional<Customer> resultFoundCustomer = customerRepository.findById(id);
        List<Customer> customerList = new ArrayList<>();

        if(resultFoundCustomer.isPresent()){
            Customer prepateDataCustomer = customerUtils.mapModel(customerRequest, resultFoundCustomer.get()); // call function
            customerList.add(prepateDataCustomer);
            List<Address> addresses = prepateDataCustomer.getAddresses().stream()
                    .map(address -> modelMapper.map(address,Address.class))
                    .peek(address -> address.setCustomers(customerList))
                    .collect(Collectors.toList());
//            addressRepository.saveAll(addresses);
            prepateDataCustomer.setAddresses(addresses);
            Customer updatedCustomer = customerRepository.save(prepateDataCustomer);
            return modelMapper.map(updatedCustomer,CustomerRespone.class);
        }else{

            Customer prepateDataCustomer = customerUtils.mapModel(customerRequest, new Customer()); // call function
            prepateDataCustomer.setId(id);
            customerList.add(prepateDataCustomer);
            List<Address> addresses = prepateDataCustomer.getAddresses().stream()
                    .map(address -> modelMapper.map(address,Address.class))
                    .peek(address -> address.setCustomers(customerList))
                    .collect(Collectors.toList());

            prepateDataCustomer.setAddresses(addresses);

            Customer updatedCustomer = customerRepository.save(prepateDataCustomer);
            return modelMapper.map(updatedCustomer,CustomerRespone.class);
        }


    }

    @Override
    public void deleteById(Long id){
        Optional<Customer> resultFound = customerRepository.findById(id);
        if(resultFound.isPresent()){
            Customer dataCustomer = resultFound.get();
//            List<Address> address = dataCustomer.getAddresses();
//            dataCustomer.setAddresses(address);
            customerRepository.delete(dataCustomer);
        }
    }
}
