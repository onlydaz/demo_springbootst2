package vn.iotstar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.iotstar.enity.Category;
import vn.iotstar.service.CategoryService;

import java.util.List;

@Controller
@RequestMapping("/categories") // Không có "/admin"
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String listCategories(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "category/list"; // Đường dẫn tới tệp list.html
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("category", new Category());
        return "category/add"; // Đường dẫn tới tệp add.html
    }

    @PostMapping("/add")
    public String addCategory(@ModelAttribute Category category) {
        categoryService.save(category);
        return "redirect:/categories"; // Quay lại danh sách danh mục
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Category category = categoryService.findById(id).orElse(null);
        model.addAttribute("category", category);
        return "category/edit"; // Đường dẫn tới tệp edit.html
    }

    @PostMapping("/edit")
    public String editCategory(@ModelAttribute Category category) {
        categoryService.save(category);
        return "redirect:/categories"; // Quay lại danh sách danh mục
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Long id) {
        categoryService.deleteById(id);
        return "redirect:/categories"; // Quay lại danh sách danh mục
    }
}
