package com.example.apirest.repository;

import com.example.apirest.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
    List<Produto> findByNomeContainingIgnoreCase(String nome);
    
    List<Produto> findByPrecoLessThan(Double preco);
    
    List<Produto> findByQuantidadeEstoqueGreaterThan(Integer quantidade);
    
    @Query("SELECT p FROM Produto p WHERE LOWER(p.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
    List<Produto> buscarPorNome(@Param("nome") String nome);
    
    @Query("SELECT p FROM Produto p WHERE p.preco BETWEEN :precoMin AND :precoMax")
    List<Produto> buscarPorFaixaPreco(@Param("precoMin") Double precoMin, @Param("precoMax") Double precoMax);
}
