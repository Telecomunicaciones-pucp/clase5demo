package com.example.clase5demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.clase5demo.entity.Product;
import com.example.clase5demo.repository.CategoryRepository;
import com.example.clase5demo.repository.ProductRepository;
import com.example.clase5demo.repository.SupplierRepository;

import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.math.BigDecimal;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    SupplierRepository supplierRepository;

    @GetMapping(value = {"", "/"})
    public String listaProductos(Model model) {
        model.addAttribute("listaProductos", productRepository.findAll());
        return "product/list";
    }

    @GetMapping("/new")
    public String nuevoProductoFrm(Model model, @ModelAttribute("product") Product product) {
        model.addAttribute("listaCategorias", categoryRepository.findAll());
        model.addAttribute("listaProveedores", supplierRepository.findAll());
        return "product/editFrm";
    }

    @PostMapping("/save")
    public String guardarProducto(@ModelAttribute("product") @Valid Product product, BindingResult bindingResult,
                                  RedirectAttributes attr, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("listaCategorias", categoryRepository.findAll());
            model.addAttribute("listaProveedores", supplierRepository.findAll());
            return "product/editFrm";
        } else {

            if (product.getId() == 0) {
                attr.addFlashAttribute("msg", "Producto creado exitosamente");
            } else {
                attr.addFlashAttribute("msg", "Producto actualizado exitosamente");
            }
            productRepository.save(product);
            return "redirect:/product";
        }
    }

    @GetMapping("/edit")
    public String editarTransportista(Model model, @RequestParam("id") int id,
                                      @ModelAttribute("product") Product product) {

        Optional<Product> optProduct = productRepository.findById(id);

        if (optProduct.isPresent()) {
            product = optProduct.get();
            model.addAttribute("product", product);
            model.addAttribute("listaCategorias", categoryRepository.findAll());
            model.addAttribute("listaProveedores", supplierRepository.findAll());
            return "product/editFrm";
        } else {
            return "redirect:/product";
        }
    }

    @GetMapping("/delete")
    public String borrarTransportista(Model model,
                                      @RequestParam("id") int id,
                                      RedirectAttributes attr) {

        Optional<Product> optProduct = productRepository.findById(id);

        if (optProduct.isPresent()) {
            productRepository.deleteById(id);
            attr.addFlashAttribute("msg", "Producto borrado exitosamente");
        }
        return "redirect:/product";

    }
/*
    @InitBinder("product")
    public void validador(WebDataBinder binder) {

        PropertyEditorSupport validacionEntero = new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                try {
                    int entero = Integer.parseInt(text);
                    this.setValue(entero > 10 && entero < 51 ? entero : 10);
                } catch (NumberFormatException e) {
                    this.setValue(0);
                }
            }
        };

        PropertyEditorSupport validacionBigDecimal = new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                try {
                    this.setValue(new BigDecimal(text));
                } catch (NumberFormatException e) {
                    this.setValue(0);
                }
            }
        };

        binder.registerCustomEditor(Integer.class, "unitsinstock", validacionEntero);
        binder.registerCustomEditor(Integer.class, "unitsonorder", validacionEntero);
        binder.registerCustomEditor(BigDecimal.class, "unitprice", validacionBigDecimal);

    }
*/
}
