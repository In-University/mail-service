package com.mail_service.controller;
import com.mail_service.entity.Category;
import com.mail_service.entity.Product;
import com.mail_service.service.CategoryService;
import com.mail_service.service.ProductService;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.List;

// Võ Minh Khoa
// MSSV: 22110355
@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final ProductService productService;

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}/products")
    public List<Product> getProductsByCategory(@PathVariable("id") Long categoryId) {
        return productService.getProductsByCategoryId(categoryId);
    }
}
