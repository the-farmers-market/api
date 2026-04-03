package in.farmersmarket.catalog.service;

import in.farmersmarket.catalog.entity.Product;
import in.farmersmarket.catalog.entity.ProductStatus;
import in.farmersmarket.catalog.repository.ProductRepository;
import in.farmersmarket.common.exception.ResourceNotFoundException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class ProductService {

    @Inject ProductRepository productRepository;

    public List<Product> listApproved() {
        return productRepository.findApproved();
    }

    public List<Product> listBySeller(UUID sellerId) {
        return productRepository.findBySellerId(sellerId);
    }

    public List<Product> listPending() {
        return productRepository.findByStatus(ProductStatus.PENDING);
    }

    public Product getById(UUID id) {
        return productRepository.findByIdOptional(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    @Transactional
    public Product create(Product product) {
        product.setStatus(ProductStatus.PENDING);
        productRepository.persist(product);
        return product;
    }

    @Transactional
    public Product approve(UUID productId, UUID adminId) {
        Product product = getById(productId);
        product.setStatus(ProductStatus.APPROVED);
        return product;
    }

    @Transactional
    public Product reject(UUID productId) {
        Product product = getById(productId);
        product.setStatus(ProductStatus.REJECTED);
        return product;
    }
}
