package com.tjn.produtosapi.repository;

import com.tjn.produtosapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,String > {

}
