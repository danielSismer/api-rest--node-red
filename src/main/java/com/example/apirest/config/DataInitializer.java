package com.example.apirest.config;

import com.example.apirest.model.Produto;
import com.example.apirest.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    
    @Autowired
    private ProdutoRepository produtoRepository;
    
    @Override
    public void run(String... args) throws Exception {
        produtoRepository.deleteAll();
        
        Produto produto1 = new Produto("Smartphone Samsung Galaxy", "Smartphone Android com câmera de 48MP", 1299.99, 50);
        Produto produto2 = new Produto("Notebook Dell Inspiron", "Notebook com processador Intel i5 e 8GB RAM", 2499.99, 25);
        Produto produto3 = new Produto("Mouse Gamer Logitech", "Mouse com sensor óptico de alta precisão", 89.99, 100);
        Produto produto4 = new Produto("Teclado Mecânico Corsair", "Teclado mecânico com switches Cherry MX", 299.99, 30);
        Produto produto5 = new Produto("Monitor LG 24\"", "Monitor Full HD com painel IPS", 599.99, 40);
        
        produtoRepository.save(produto1);
        produtoRepository.save(produto2);
        produtoRepository.save(produto3);
        produtoRepository.save(produto4);
        produtoRepository.save(produto5);
        
        System.out.println("=== Dados de exemplo carregados com sucesso! ===");
        System.out.println("Total de produtos: " + produtoRepository.count());
    }
}
