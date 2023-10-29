package com.clothesstore.productservice.service;

import com.clothesstore.productservice.dto.ProductRequest;
import com.clothesstore.productservice.dto.ProductRespone;
import com.clothesstore.productservice.model.Product;
import com.clothesstore.productservice.repository.CollectionRepository;
import com.clothesstore.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CollectionServiceImpl implements CollectionService {
    @Autowired
    private CollectionRepository collectionRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ProductRespone>  findById(Long id){
        List<ProductRespone> resultFound = new ArrayList<>();
//        List<ProductRespone> resultFound = collectionRepository.getProductsFromCollection(id);
//        if(resultFound.isPresent()){
//            List<ProductRespone>  responeProduct = modelMapper.map(resultFound.get(),ProductRespone.class);
//            return modelMapper.map(responeProduct,ProductRespone.class);
//        }else{
//            List<ProductRespone>  responeProduct = modelMapper.map(resultFound,ProductRespone.class);
//            responeProduct.setErrorMessage("Not found item");
//            return resultFound;
//        }

        return resultFound;
    }
//
//    @Override
//    public List<ProductRespone> findAllById(List<Long> ids) {
//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
//
//            // Convert the list to a JSON string
//            String json = objectMapper.writeValueAsString(ids);
//
//            // Print the JSON string
//            System.out.println(json);
//        } catch (JsonProcessingException e) {
//            // Handle the exception (e.g., log it or take appropriate action)
//            e.printStackTrace();
//        }
//
//        return customerRepository.findAllById(ids)
//                .stream().map(customer -> modelMapper.map(customer,ProductRespone.class))
//                .collect(Collectors.toList());
//    }
//    @Override
//    public List<ProductRespone> all(){
//        return customerRepository.findAll()
//                .stream()
//                .map(customer -> modelMapper.map(customer, ProductRespone.class))
//                .collect(Collectors.toList());
//    }



//    @Override
//    public ProductRespone save(ProductRequest customerRequest){
//
//        Product newProduct = modelMapper.map(customerRequest,Product.class);
//
//        Product createdProduct =  productRepository.save(newProduct);
//
//        return modelMapper.map(createdProduct,ProductRespone.class);
//
//    }

//    public ProductRespone update(Long id, ProductRequest customerRequest){
//        Optional<Product> resultFoundProduct = customerRepository.findById(id);
//        List<Product> customerList = new ArrayList<>();
//
//        if(resultFoundProduct.isPresent()){prepateDataProduct.getAddresses().stream()
////                    .map(address -> modelMapper.map(address,Address.class))
////                    .peek(address -> address.setProducts(customerList))
////                    .collect(Collectors.toList());
//            Product prepateDataProduct = customerUtils.mapModel(customerRequest, resultFoundProduct.get()); // call function
//            customerList.add(prepateDataProduct);
//            List<Address> addresses =
////            addressRepository.saveAll(addresses);
//            prepateDataProduct.setAddresses(addresses);
//            Product updatedProduct = customerRepository.save(prepateDataProduct);
//            return modelMapper.map(updatedProduct,ProductRespone.class);
//        }else{
//
//            Product prepateDataProduct = customerUtils.mapModel(customerRequest, new Product()); // call function
//            prepateDataProduct.setId(id);
//            customerList.add(prepateDataProduct);
//            List<Address> addresses = prepateDataProduct.getAddresses().stream()
//                    .map(address -> modelMapper.map(address,Address.class))
//                    .peek(address -> address.setProducts(customerList))
//                    .collect(Collectors.toList());
//
//            prepateDataProduct.setAddresses(addresses);
//
//            Product updatedProduct = customerRepository.save(prepateDataProduct);
//            return modelMapper.map(updatedProduct,ProductRespone.class);
//        }
//
//
//    }

//    @Override
//    public void deleteById(Long id){
//        Optional<Product> resultFound = customerRepository.findById(id);
//        if(resultFound.isPresent()){
//            Product dataProduct = resultFound.get();
////            List<Address> address = dataProduct.getAddresses();
////            dataProduct.setAddresses(address);
//            customerRepository.delete(dataProduct);
//        }
//    }
}
