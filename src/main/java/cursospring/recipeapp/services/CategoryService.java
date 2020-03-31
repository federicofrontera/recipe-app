package cursospring.recipeapp.services;

import cursospring.recipeapp.model.Category;

import java.util.Set;

public interface CategoryService {
    Set<Category> findAll();
}
