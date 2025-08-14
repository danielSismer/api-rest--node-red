package com.example.apirest.service;

import com.example.apirest.model.Produto;
import com.example.apirest.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;
    
    public List<Produto> buscarTodos() {
        return produtoRepository.findAll();
    }
    
    public Optional<Produto> buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }
    
    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }
    
    public void deletarPorId(Long id) {
        produtoRepository.deleteById(id);
    }
    
    public List<Produto> buscarPorNome(String nome) {
        return produtoRepository.findByNomeContainingIgnoreCase(nome);
    }
    
    public List<Produto> buscarPorPrecoMenorQue(Double preco) {
        return produtoRepository.findByPrecoLessThan(preco);
    }
    
    public List<Produto> buscarComEstoqueDisponivel(Integer quantidadeMinima) {
        return produtoRepository.findByQuantidadeEstoqueGreaterThan(quantidadeMinima);
    }
    
    public List<Produto> buscarPorFaixaPreco(Double precoMin, Double precoMax) {
        return produtoRepository.buscarPorFaixaPreco(precoMin, precoMax);
    }
    
    public Produto atualizarEstoque(Long id, Integer novaQuantidade) {
        Optional<Produto> produtoOpt = produtoRepository.findById(id);
        if (produtoOpt.isPresent()) {
            Produto produto = produtoOpt.get();
            produto.setQuantidadeEstoque(novaQuantidade);
            return produtoRepository.save(produto);
        }
        throw new RuntimeException("Produto não encontrado com ID: " + id);
    }
    
    public boolean produtoExiste(Long id) {
        return produtoRepository.existsById(id);
    }
}
