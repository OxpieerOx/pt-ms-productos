package com.intech.msproducto.repositories;
import com.intech.msproducto.models.ProductoModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends CrudRepository<ProductoModel, Long>  {
}
