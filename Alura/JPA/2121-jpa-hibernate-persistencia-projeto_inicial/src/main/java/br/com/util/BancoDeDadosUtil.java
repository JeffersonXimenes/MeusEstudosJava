package br.com.util;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.dao.CategoriaDAO;
import br.com.dao.ClienteDAO;
import br.com.dao.ProdutoDAO;
import br.com.entity.CategoriaEntity;
import br.com.entity.ClienteEntity;
import br.com.entity.ProdutoEntity;

public class BancoDeDadosUtil {
	
	private static EntityManager em = JPAUtil.getEntityManager();
	private static CategoriaDAO categoriaDAO = new CategoriaDAO(em);
	private static ProdutoDAO produtoDAO = new ProdutoDAO(em);
	private static ClienteDAO clienteDAO = new ClienteDAO(em);
	
	public static void popularBancoDeDados() {
		em.getTransaction().begin();

		popularCategorias();
		popularClientes();

		CategoriaEntity categoria = categoriaDAO.buscarPorId(1L);
		popularProduto(categoria);
		
		em.getTransaction().commit();
		em.close();
	}	
	
	private static void popularCategorias() {
		CategoriaEntity celular = new CategoriaEntity("Celular");
		CategoriaEntity eletrodomestico = new CategoriaEntity("Eletrodomestico");
		CategoriaEntity cozinha = new CategoriaEntity("Cozinha");
		
		List<CategoriaEntity> categorias = Arrays
				.asList(celular, eletrodomestico, cozinha);

		categorias.forEach(categoria -> categoriaDAO.cadastrar(categoria) );
	}
	
	private static void popularClientes() {
		ClienteEntity cliente1 = new ClienteEntity("Jefferson", "123456");
		ClienteEntity cliente2 = new ClienteEntity("Roberto", "707070");
		ClienteEntity cliente3 = new ClienteEntity("Malakoi", "654321");
		
		List<ClienteEntity> categorias = Arrays
				.asList(cliente1, cliente2, cliente3);

		categorias.forEach(cliente -> clienteDAO.cadastrar(cliente) );
	}
	
	private static void popularProduto(CategoriaEntity categoria) {
		ProdutoEntity celular1 = new ProdutoEntity("Samsung S10 Plus", "Belissímo celular com sua ampla velocidade", new BigDecimal("800"), categoria);
		ProdutoEntity celular2 = new ProdutoEntity("Iphone X", "Excelente celular!", new BigDecimal("1800"), categoria);

		List<ProdutoEntity> produtos = Arrays
				.asList(celular1, celular2);

		produtos.forEach(produto -> produtoDAO.cadastrar(produto) );
	}
}
