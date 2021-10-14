package com.service.controller;

import com.service.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.service.service.impl.IProductService;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping()
    public ModelAndView showAll() {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Product> products = productService.getAll();
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("/create")
    public String createProduct(Product product) {
        product.setId((int) (Math.random() * 10000));
        productService.save(product);
        return "redirect:/product";
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEditForm(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("product", productService.findProductById(id));
        return modelAndView;
    }

    @PostMapping("/edit")
    public String editProduct(Product product) {
        productService.update(product.getId(), product);
        return "redirect:/product";
    }

    @GetMapping("/{id}/delete")
    public String deleteProduct(@PathVariable("id") int id) {
        productService.delete(id);
        return "redirect:/product";
    }

    @GetMapping("/{id}/view")
    public ModelAndView viewProduct(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("view");
        modelAndView.addObject("product", productService.findProductById(id));
        return modelAndView;
    }
}
