package com.clothesstore.customerservice.service;

import com.clothesstore.customerservice.dto.AddressRequest;
import com.clothesstore.customerservice.dto.CustomerRespone;
import com.clothesstore.customerservice.dto.CustomerRequest;
import com.clothesstore.customerservice.model.Address;
import com.clothesstore.customerservice.model.Customer;
import com.clothesstore.customerservice.repository.CustomerRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
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

        Optional<Customer> resultFound = customerRepository.findById(id);
        if(resultFound.isPresent()){
            CustomerRespone responeCustomer = modelMapper.map(resultFound.get(),CustomerRespone.class);
//            log.info("Object after map:");
//            log.info(resultFound.toString());
//            log.info(resultFound.get().getPhone());
//            log.info(responeCustomer.toString());
//            log.info(responeCustomer.getEmail());

            return modelMapper.map(responeCustomer,CustomerRespone.class);
        }else{
            CustomerRespone responeCustomer = modelMapper.map(resultFound,CustomerRespone.class);
            responeCustomer.setErrorMessage("Not found item");
            return responeCustomer;
        }


//        return
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


        List<CustomerRespone> customerResponeList  = customerRepository.findAllById(ids)
                .stream().map(customer -> modelMapper.map(customer,CustomerRespone.class))
                .collect(Collectors.toList());
        return customerResponeList;
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
    public CustomerRespone save(CustomerRequest customerRequest){
//        log.info(customerResquest.toString());
//        log.info(customerResquest.getAdressResquest().toString());
        Customer newCustomer = modelMapper.map(customerRequest,Customer.class);

        LocalDateTime currentDateTime = LocalDateTime.now();
        newCustomer.setCreatedAt(currentDateTime);
//        newCustomer.setLastName(customerResquest.getLastName());
//        newCustomer.setEmail(customerResquest.getEmailAddress());
        List<Address> addressList = new ArrayList<>();
        List<Customer> customerList = new ArrayList<>();
        customerList.add(newCustomer);

        for (AddressRequest addressRequest : customerRequest.getAddressRequest()) {
            Address address = modelMapper.map(addressRequest,Address.class);
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
    public CustomerRespone update(Long id, CustomerRequest customerRequest){

        // convert request to data.




        Customer dataCustomer = modelMapper.map(customerRequest,Customer.class);
        log.info("data custoemr");
        log.info(dataCustomer.toString());
        Field itemOldCustomer;
        Optional<Customer> resultFound = customerRepository.findById(id);
        if(resultFound.isPresent()){
            Customer oldCustomer = resultFound.get();
            log.info("Get data");
            log.info(oldCustomer.toString());
            Field[] allFieldDataCustomer = customerRequest.getClass().getDeclaredFields();

            log.info("Prepare handel data");
            try{
                log.info("update model: handel data");
                for (Field dataItem : allFieldDataCustomer) {
                    // Allow access to private fields if necessary
                    dataItem.setAccessible(true);
                    if (dataItem.get(dataCustomer) != null) {
                        String fieldName = dataItem.getName();
                        log.info("field model: "+fieldName);
                        itemOldCustomer = oldCustomer.getClass().getDeclaredField(fieldName);
                        itemOldCustomer.setAccessible(true);
                        itemOldCustomer.set(oldCustomer, dataItem.get(dataCustomer));
                    }
                }
            }catch (NoSuchFieldException e) {

//                itemOldCustomer= null;
            }catch (IllegalAccessException a){
//                itemOldCustomer= null;
            }
            log.info("Object after map:");
            log.info(oldCustomer.toString());



            oldCustomer.setUpdatedAt(LocalDateTime.now());
            Customer updatedCustomer = customerRepository.save(oldCustomer);
            return modelMapper.map(updatedCustomer, CustomerRespone.class);

        }else{
            Customer newCustomer = modelMapper.map(customerRequest, Customer.class);
            newCustomer.setId(id);
            Customer updatedCustomer = customerRepository.save(newCustomer);
            return modelMapper.map(updatedCustomer, CustomerRespone.class);
        }


    }
    public CustomerRespone updateTest(Long id, CustomerRequest customerRequest){

        // map data
        // between model
        // check typ array -> update.
        // name
        // convert -> list
        // set list


        Customer updateCustomer = new Customer();

        log.info("Get data request");
        log.info(customerRequest.toString());
        Field[] allFieldDataCustomer = customerRequest.getClass().getDeclaredFields();

        Field itemOldCustomer;
        log.info("Prepare handel data");

            log.info("update model: handel data");
            for (Field dataItem : allFieldDataCustomer) {
                dataItem.setAccessible(true);
                try {
                    if (dataItem.get(customerRequest) != null) {
                        if (dataItem.getType() == List.class) { // check field is List?
                            String fieldName = dataItem.getName();
                            log.info("=============================================" + dataItem.getType());
                            log.info("get class model: " + customerRequest.getClass());
                            log.info("field model: " + fieldName);

                            Type genericType = dataItem.getGenericType();

                            if (genericType instanceof ParameterizedType) { // get name model in list
                                ParameterizedType parameterizedType = (ParameterizedType) genericType;
                                Type[] typeArguments = parameterizedType.getActualTypeArguments();

                                if (typeArguments.length > 0) { // ensure list not null
                                    Type typeArgument = typeArguments[0];
                                    if (typeArgument instanceof Class) {
                                        Class<?> modelClassRequest = (Class<?>) typeArgument;
                                        String nameClassRequest = modelClassRequest.getSimpleName();
                                        log.info("get model in list: " + nameClassRequest);
                                        String nameModelClass = nameClassRequest.substring(0, nameClassRequest.indexOf("Request"));

                                        try {
                                            // Use reflection to create an instance of the class based on modelName
                                            Object modelInstance = Class.forName(environment.getProperty("spring.path.model") +"."+nameModelClass).getDeclaredConstructor().newInstance();

                                            log.info("get model in list: " + nameModelClass);
                                            log.info("Modal analy " + modelInstance.getClass() );
                                            // Now, you have an instance of the "Address" class (assuming it exists).

                                            // You can work with the modelInstance as needed.
                                            // For example, you can set properties or invoke methods on it.
                                        } catch (Exception e) {
                                            // Handle exceptions, such as ClassNotFoundException or
                                            // NoSuchMethodException if the class or constructor is not found.
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            }
                            log.info("=============================================");

                        } else {
                            try {
                                String fieldName = dataItem.getName();

                                log.info("field model: " + fieldName);
                                itemOldCustomer = updateCustomer.getClass().getDeclaredField(fieldName);
                                itemOldCustomer.setAccessible(true);
                                itemOldCustomer.set(updateCustomer, dataItem.get(customerRequest));
                            } catch (NoSuchFieldException e) {}

                        }
                    }

                } catch (IllegalAccessException a) {}
            }

//                itemOldCustomer= null;

        log.info("Object after map:");
        log.info(updateCustomer.toString());

        return new CustomerRespone();


    }
    @Override
    public void deleteById(Long id){
         customerRepository.deleteById(id);
    }

    


}
