package com.example.wms.controller;

import com.example.wms.model.Product;
import com.example.wms.model.Supplier;
import com.example.wms.model.Inventory;
import com.example.wms.model.Order;
import com.example.wms.model.User;
import com.example.wms.service.ProductService;
import com.example.wms.service.SupplierService;
import com.example.wms.service.InventoryService;
import com.example.wms.service.OrderService;
import com.example.wms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class WebController {
    @Autowired
    private ProductService productService;
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private InventoryService inventoryService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/products")
    public String products(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/products/add")
    public String addProductForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("suppliers", supplierService.getAllSuppliers());
        return "product_form";
    }

    @PostMapping("/products/add")
    public String addProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        if (product.getSupplier() != null && product.getSupplier().getId() != null) {
            Supplier supplier = supplierService.getSupplierById(product.getSupplier().getId()).orElse(null);
            product.setSupplier(supplier);
        }
        productService.saveProduct(product);
        redirectAttributes.addFlashAttribute("message", "Product added successfully!");
        return "redirect:/products";
    }

    @GetMapping("/products/edit/{id}")
    public String editProductForm(@PathVariable Long id, Model model) {
        Product product = productService.getProductById(id).orElse(new Product());
        model.addAttribute("product", product);
        model.addAttribute("suppliers", supplierService.getAllSuppliers());
        return "product_form";
    }

    @PostMapping("/products/edit/{id}")
    public String editProduct(@PathVariable Long id, @ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        product.setId(id);
        if (product.getSupplier() != null && product.getSupplier().getId() != null) {
            Supplier supplier = supplierService.getSupplierById(product.getSupplier().getId()).orElse(null);
            product.setSupplier(supplier);
        }
        productService.saveProduct(product);
        redirectAttributes.addFlashAttribute("message", "Product updated successfully!");
        return "redirect:/products";
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        productService.deleteProduct(id);
        redirectAttributes.addFlashAttribute("message", "Product deleted successfully!");
        return "redirect:/products";
    }

    @GetMapping("/suppliers")
    public String suppliers(Model model) {
        List<Supplier> suppliers = supplierService.getAllSuppliers();
        model.addAttribute("suppliers", suppliers);
        return "suppliers";
    }

    @GetMapping("/inventory")
    public String inventory(Model model) {
        List<Inventory> inventory = inventoryService.getAllInventory();
        model.addAttribute("inventory", inventory);
        return "inventory";
    }

    @GetMapping("/orders")
    public String orders(Model model) {
        List<Order> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);
        return "orders";
    }

    @GetMapping("/users")
    public String users(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // SUPPLIER CRUD
    @GetMapping("/suppliers/add")
    public String addSupplierForm(Model model) {
        model.addAttribute("supplier", new Supplier());
        return "supplier_form";
    }

    @PostMapping("/suppliers/add")
    public String addSupplier(@ModelAttribute Supplier supplier, RedirectAttributes redirectAttributes) {
        supplierService.saveSupplier(supplier);
        redirectAttributes.addFlashAttribute("message", "Supplier added successfully!");
        return "redirect:/suppliers";
    }

    @GetMapping("/suppliers/edit/{id}")
    public String editSupplierForm(@PathVariable Long id, Model model) {
        Supplier supplier = supplierService.getSupplierById(id).orElse(new Supplier());
        model.addAttribute("supplier", supplier);
        return "supplier_form";
    }

    @PostMapping("/suppliers/edit/{id}")
    public String editSupplier(@PathVariable Long id, @ModelAttribute Supplier supplier, RedirectAttributes redirectAttributes) {
        supplier.setId(id);
        supplierService.saveSupplier(supplier);
        redirectAttributes.addFlashAttribute("message", "Supplier updated successfully!");
        return "redirect:/suppliers";
    }

    @GetMapping("/suppliers/delete/{id}")
    public String deleteSupplier(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        supplierService.deleteSupplier(id);
        redirectAttributes.addFlashAttribute("message", "Supplier deleted successfully!");
        return "redirect:/suppliers";
    }

    // INVENTORY CRUD
    @GetMapping("/inventory/add")
    public String addInventoryForm(Model model) {
        model.addAttribute("inventory", new Inventory());
        model.addAttribute("products", productService.getAllProducts());
        return "inventory_form";
    }

    @PostMapping("/inventory/add")
    public String addInventory(@ModelAttribute Inventory inventory, RedirectAttributes redirectAttributes) {
        if (inventory.getProduct() != null && inventory.getProduct().getId() != null) {
            Product product = productService.getProductById(inventory.getProduct().getId()).orElse(null);
            inventory.setProduct(product);
        }
        inventoryService.saveInventory(inventory);
        redirectAttributes.addFlashAttribute("message", "Inventory added successfully!");
        return "redirect:/inventory";
    }

    @GetMapping("/inventory/edit/{id}")
    public String editInventoryForm(@PathVariable Long id, Model model) {
        Inventory inventory = inventoryService.getInventoryById(id).orElse(new Inventory());
        model.addAttribute("inventory", inventory);
        model.addAttribute("products", productService.getAllProducts());
        return "inventory_form";
    }

    @PostMapping("/inventory/edit/{id}")
    public String editInventory(@PathVariable Long id, @ModelAttribute Inventory inventory, RedirectAttributes redirectAttributes) {
        inventory.setId(id);
        if (inventory.getProduct() != null && inventory.getProduct().getId() != null) {
            Product product = productService.getProductById(inventory.getProduct().getId()).orElse(null);
            inventory.setProduct(product);
        }
        inventoryService.saveInventory(inventory);
        redirectAttributes.addFlashAttribute("message", "Inventory updated successfully!");
        return "redirect:/inventory";
    }

    @GetMapping("/inventory/delete/{id}")
    public String deleteInventory(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        inventoryService.deleteInventory(id);
        redirectAttributes.addFlashAttribute("message", "Inventory deleted successfully!");
        return "redirect:/inventory";
    }

    // ORDER CRUD
    @GetMapping("/orders/add")
    public String addOrderForm(Model model) {
        model.addAttribute("order", new Order());
        model.addAttribute("products", productService.getAllProducts());
        return "order_form";
    }

    @PostMapping("/orders/add")
    public String addOrder(@ModelAttribute Order order, RedirectAttributes redirectAttributes) {
        if (order.getProduct() != null && order.getProduct().getId() != null) {
            Product product = productService.getProductById(order.getProduct().getId()).orElse(null);
            order.setProduct(product);
        }
        orderService.saveOrder(order);
        redirectAttributes.addFlashAttribute("message", "Order added successfully!");
        return "redirect:/orders";
    }

    @GetMapping("/orders/edit/{id}")
    public String editOrderForm(@PathVariable Long id, Model model) {
        Order order = orderService.getOrderById(id).orElse(new Order());
        model.addAttribute("order", order);
        model.addAttribute("products", productService.getAllProducts());
        return "order_form";
    }

    @PostMapping("/orders/edit/{id}")
    public String editOrder(@PathVariable Long id, @ModelAttribute Order order, RedirectAttributes redirectAttributes) {
        order.setId(id);
        if (order.getProduct() != null && order.getProduct().getId() != null) {
            Product product = productService.getProductById(order.getProduct().getId()).orElse(null);
            order.setProduct(product);
        }
        orderService.saveOrder(order);
        redirectAttributes.addFlashAttribute("message", "Order updated successfully!");
        return "redirect:/orders";
    }

    @GetMapping("/orders/delete/{id}")
    public String deleteOrder(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        orderService.deleteOrder(id);
        redirectAttributes.addFlashAttribute("message", "Order deleted successfully!");
        return "redirect:/orders";
    }

    // USER CRUD
    @GetMapping("/users/add")
    public String addUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user_form";
    }

    @PostMapping("/users/add")
    public String addUser(@ModelAttribute User user, RedirectAttributes redirectAttributes) {
        userService.saveUser(user);
        redirectAttributes.addFlashAttribute("message", "User added successfully!");
        return "redirect:/users";
    }

    @GetMapping("/users/edit/{id}")
    public String editUserForm(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id).orElse(new User());
        model.addAttribute("user", user);
        return "user_form";
    }

    @PostMapping("/users/edit/{id}")
    public String editUser(@PathVariable Long id, @ModelAttribute User user, RedirectAttributes redirectAttributes) {
        user.setId(id);
        userService.saveUser(user);
        redirectAttributes.addFlashAttribute("message", "User updated successfully!");
        return "redirect:/users";
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        userService.deleteUser(id);
        redirectAttributes.addFlashAttribute("message", "User deleted successfully!");
        return "redirect:/users";
    }
} 