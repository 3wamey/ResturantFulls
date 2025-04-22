package com.spring.resturantfull.service.Impl;

import com.spring.resturantfull.Dtos.categoryDto;
import com.spring.resturantfull.controller.vm.ProductResponseVM;
import com.spring.resturantfull.mapper.CategoryMapper;
import com.spring.resturantfull.mapper.ProductMapper;
import com.spring.resturantfull.model.Category;
import com.spring.resturantfull.model.Product;
import com.spring.resturantfull.repository.CategoryRepo;
import com.spring.resturantfull.repository.ProductRepo;
import com.spring.resturantfull.Dtos.productDto;
import com.spring.resturantfull.service.categoryService;
import com.spring.resturantfull.service.proudectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.spring.resturantfull.mapper.ProductMapper.PRODUCT_MAPPER;

@Service
public class productServiceImpl implements proudectService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
     private categoryService categoryService;

    @Autowired
    private CategoryRepo categoryRepo;


    @Override
    public ProductResponseVM getProductsByCategoryId(Long categoryId, Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Product> productPage = productRepo.findAllByCategoryId(categoryId, pageable);

        return new ProductResponseVM(
                ProductMapper.PRODUCT_MAPPER.toDtoList(productPage.getContent()),
                productPage.getTotalElements()
        );
    }


    @Override
    public ProductResponseVM getProductByLetters(String letter, Integer pageNo, Integer pageSize) { //
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Product> productPage = productRepo.getProductByLetters(letter, pageable);
        List<Product> products = productPage.getContent();

        if (products.isEmpty()) {
            throw new RuntimeException("error.noSuchLetter");
        }
        return new ProductResponseVM(
                ProductMapper.PRODUCT_MAPPER.toDtoList(products),
                productPage.getTotalElements()
        );
    }

    @Override
    public ProductResponseVM getProducts(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<Product> productPage = productRepo.findAll(pageable);

        return new ProductResponseVM(
                ProductMapper.PRODUCT_MAPPER.toDtoList(productPage.getContent()),
                productPage.getTotalElements()
        );
    }

    @Override
    public List<productDto> findProductsByIds(List<Long> porductIds) {
        List <Product> products = productRepo.findAllById(porductIds);
        return ProductMapper.PRODUCT_MAPPER.toDtoList(products);
    }

    @Override
    public productDto addProduct(productDto productDto) {
        Product product = PRODUCT_MAPPER.toEntity(productDto);
        categoryDto categoryDto = categoryService.findByName(productDto.getName());

        product.setCategory(CategoryMapper.CATEGORY_MAPPER.toEntity(categoryDto));

        return PRODUCT_MAPPER.toDto(productRepo.save(product));
    }


    @Override
    public productDto updateProduct(productDto productDto) {
        // 1. Find the existing product by ID
        Product existingProduct = productRepo.findById(productDto.getId())
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + productDto.getId()));

        // 2. Update product fields
        existingProduct.setName(productDto.getName());
        existingProduct.setDescription(productDto.getDescription());
        existingProduct.setPrice(productDto.getPrice());
        existingProduct.setLogoPath(productDto.getLogoPath());

        // 3. Set category if categoryId is provided
        if (productDto.getCategoryId() != null) {
            Category category = categoryRepo.findById(productDto.getCategoryId())
                    .orElseThrow(() -> new RuntimeException("Category not found with id: " + productDto.getCategoryId()));
            existingProduct.setCategory(category);
        }

        // 4. Save and return the updated product
        Product updatedProduct = productRepo.save(existingProduct);
        return PRODUCT_MAPPER.toDto(existingProduct);
    }





    @Override
    public productDto deleteProduct(productDto productDto) {
        Long productId = productDto.getId();
        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));

        productRepo.delete(product);
        return PRODUCT_MAPPER.toDto(product);
    }


}