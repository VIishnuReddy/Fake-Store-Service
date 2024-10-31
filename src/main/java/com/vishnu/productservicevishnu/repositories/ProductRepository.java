package com.vishnu.productservicevishnu.repositories;


import com.vishnu.productservicevishnu.models.Product;

import com.vishnu.productservicevishnu.projections.projectionWithIdAndTitle;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

   List<Product> findByIdGreaterThan(double price);

   List<Product> findAllByOrderByIdDesc();

   Optional<Product> findById(Long id);

   List<Product> findAll(Sort sort);

   @Query("select p.title, p.id from Product p")
   List<projectionWithIdAndTitle> randomSearch();


}
