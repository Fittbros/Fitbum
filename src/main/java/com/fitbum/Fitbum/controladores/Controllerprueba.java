package com.fitbum.Fitbum.controladores;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j2
@RequiredArgsConstructor
//@RequestMapping("/prueba")
public class Controllerprueba {

    @GetMapping("/prueba")
    public String prueba(){
        return "pruebadocker";



    }
    @GetMapping("/prueba2")
    public String prueba2(){
        return "index";}
    /*
    @Autowired
    private  final DetalllesRepositorio detalllesRepositorio;

    @PostMapping("/adduser")
    public String addCustomer(@Valid Customer customer, BindingResult result, Model model){
        if(result.hasErrors()){
            return "add-customer";
        }
        customerRepository.save(customer);
        return "redirect:/customer/index";
    }

    @GetMapping("/signup")
    public String showSignUpForm(DetalleUsuario usuario) {
        return "adduser";
    }

    @GetMapping("/index")
    public String showUserList(Model model) {
        model.addAttribute("customers", customerRepository.findAll());
        return "index";
    }
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid customer Id:" + id));
        model.addAttribute("customer", customer);
        return "update-customer";
    }



    @PostMapping("/update/{id}")
    public String updateCustomer(@PathVariable("id") Integer id, @Valid Customer customer, BindingResult result, Model model) {
        if (result.hasErrors()) {
            customer.setId(id);
            return "update-customer";
        }
        customerRepository.save(customer);
        return "redirect:/customer/index";
    }



    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") Integer id, Model model) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid customer Id:" + id));
        customerRepository.delete(customer);
        return "redirect:/customer/index";
    }

    @GetMapping("/signup")
    public String showSignUpForm(Customer customer) {
        return "add-customer";
    }*/
    }


