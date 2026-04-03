package in.farmersmarket.catalog.repository;

import in.farmersmarket.catalog.entity.Category;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class CategoryRepository implements PanacheRepositoryBase<Category, UUID> {

    public Optional<Category> findBySlug(String slug) {
        return find("slug", slug).firstResultOptional();
    }

    public List<Category> findRootCategories() {
        return list("parent IS NULL AND isActive = true");
    }
}
