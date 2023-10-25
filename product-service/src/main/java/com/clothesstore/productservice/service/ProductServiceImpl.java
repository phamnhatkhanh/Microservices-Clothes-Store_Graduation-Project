package com.clothesstore.productservice.service;

import com.clothesstore.productservice.dto.ProductRequest;
import com.clothesstore.productservice.dto.ProductRespone;
import com.clothesstore.productservice.model.Product;
import com.clothesstore.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Product findById(Long id){
        Optional<Product> resultFound = productRepository.findById(id);
        return resultFound.get();

    }

    @Override
    public List<Product>  findProductsInCollection(Long collectionId) {
        return productRepository.findProductsInCollection(collectionId);
    }


//
//    @Override
//    public List<ProductRespone> findAllById(List<Long> ids) {
//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
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



    @Override
    public Product save(Product productRequest){

        Product newProduct = modelMapper.map(productRequest,Product.class);

        Product createdProduct =  productRepository.save(newProduct);

        return modelMapper.map(createdProduct,Product.class);

    }

//    public ProductRespone update(Long id, ProductRequest customerRequest){
//        Optional<Product> resultFoundProduct = customerRepository.findById(id);
//        List<Product> customerList = new ArrayList<>();
//
//        if(resultFoundProduct.isPresent()){
//            Product prepateDataProduct = customerUtils.mapModel(customerRequest, resultFoundProduct.get()); // call function
//            customerList.add(prepateDataProduct);
//            List<Address> productes = prepateDataProduct.getAddresses().stream()
//                    .map(product -> modelMapper.map(product,Address.class))
//                    .peek(product -> product.setProducts(customerList))
//                    .collect(Collectors.toList());
////            productRepository.saveAll(productes);
//            prepateDataProduct.setAddresses(productes);
//            Product updatedProduct = customerRepository.save(prepateDataProduct);
//            return modelMapper.map(updatedProduct,ProductRespone.class);
//        }else{
//
//            Product prepateDataProduct = customerUtils.mapModel(customerRequest, new Product()); // call function
//            prepateDataProduct.setId(id);
//            customerList.add(prepateDataProduct);
//            List<Address> productes = prepateDataProduct.getAddresses().stream()
//                    .map(product -> modelMapper.map(product,Address.class))
//                    .peek(product -> product.setProducts(customerList))
//                    .collect(Collectors.toList());
//
//            prepateDataProduct.setAddresses(productes);
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
////            List<Address> product = dataProduct.getAddresses();
////            dataProduct.setAddresses(product);
//            customerRepository.delete(dataProduct);
//        }
//    }
}
