package com.codegym.controller;

import com.codegym.model.Cart;
import com.codegym.model.Product;
import com.codegym.model.ProductForm;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Controller
@SessionAttributes("cart")
@PropertySource("classpath:upload_file.properties")
public class ProductController {

    @Value("${file-upload}")
    private String fileUpload;

    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("productForm", new ProductForm());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveProduct(@ModelAttribute ProductForm productForm) {
        MultipartFile multipartFile = productForm.getImage();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(productForm.getImage().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Product product = new Product(productForm.getId(), productForm.getName(),productForm.getPrice(),productForm.getOld(), productForm.getCard(), productForm.getDescription(), fileName);
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("productForm", productForm);
        modelAndView.addObject("message", "Created new product successfully !");
        return modelAndView;
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        if (action.equals("show")) {
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }
    @GetMapping("/remove/{id}")
    public String removeFromCart(@PathVariable Long id, @ModelAttribute Cart cart) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        cart.removeProduct(productOptional.get());
        return "redirect:/shopping-cart";
    }
    @GetMapping("/delete/{id}")
    public String deleteFromCart(@PathVariable Long id, @ModelAttribute Cart cart) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        cart.deleteProduct(productOptional.get());
        return "redirect:/shopping-cart";
    }
    @GetMapping("/detail/{id}")
    public ModelAndView showDetailForm(@PathVariable Long id) {
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/detail");
            modelAndView.addObject("product", product.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }
}
