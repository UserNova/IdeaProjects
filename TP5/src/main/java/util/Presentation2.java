package util;

import dao.IDao;
import entities.Category;
import entities.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import util.HibernateConfig;

public class Presentation2 {
    private static IDao<Product> IDao;

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);

        IDao<Product> productDao = (IDao<Product>) context.getBean("productDaoImpl");
        IDao<Category> CategoryDao = (IDao<Category>) context.getBean("categoryDaoImpl");

        Category category = new Category();
        category.setName("Category 1");

        CategoryDao.create(category);

        Product product = new Product();
        product.setName("Produit 1");
        product.setPrice(100.0);

        productDao.create(product);



        System.out.println("Produit sauvegardé : " + product.getName());
        System.out.println("Category  sauvegardé : " + category.getName());

    }
}