package com.capitoleconsulting.ecommerce.app.repository;

import com.capitoleconsulting.ecommerce.app.model.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PriceRepository extends JpaRepository<PriceEntity, Long> {


    List<PriceEntity> findByBrandIdAndProductIdOrderByPriorityDesc(Long brandId, Long productId);


}
