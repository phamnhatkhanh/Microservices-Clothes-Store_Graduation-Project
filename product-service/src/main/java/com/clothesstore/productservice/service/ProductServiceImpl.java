package com.clothesstore.productservice.service;


import com.clothesstore.productservice.model.Product;
import com.clothesstore.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

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

    @Override
    public Product save(Product productRequest){

        Product newProduct = modelMapper.map(productRequest,Product.class);

        Product createdProduct =  productRepository.save(newProduct);

        return modelMapper.map(createdProduct,Product.class);

    }

}
