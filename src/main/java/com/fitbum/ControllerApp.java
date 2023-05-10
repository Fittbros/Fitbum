package com.fitbum;

import com.fitbum.controladores.AbstractController;
import com.fitbum.entidades.usuarios.Usuario;
import com.fitbum.servicios.MenuServicio;
import com.fitbum.servicios.usuarios.UsuarioServicio;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j2
//@RequestMapping("/prueba")
public class ControllerApp //extends AbstractController<Usuario>
         {
    @Autowired
    private UsuarioServicio usuarioServicio;
    @Autowired
    private MenuServicio menuServicio;

//    protected ControllerApp(MenuServicio menuService) {
//        super(menuService);
//    }

    @GetMapping("/index")
    public String inicio(){
        return "index";}
    @GetMapping("/home")
    public String home(Model model
    ) {
        model.addAttribute("usuario", usuarioServicio);
        model.addAttribute("dataObject", menuServicio.findAll());
        return "home";}
    @GetMapping("/publico")
    public String publico(){
        return "publico";}



    @GetMapping("/programa")
    public String indexentreno(Model model
    ) {
        model.addAttribute("usuario", usuarioServicio);

        model.addAttribute("dataObject", menuServicio.findAll());
        return "/programa/index";}

    @GetMapping("/misrutinas")
    public String indexrutinas(Model model
    ) {
        model.addAttribute("usuario", usuarioServicio);

        model.addAttribute("dataObject", menuServicio.findAll());
        return "/mis_rutinas/index";}


    @GetMapping("/logros")
    public String indexlogros(Model model
    ) {
        model.addAttribute("usuario", usuarioServicio);

        model.addAttribute("dataObject", menuServicio.findAll());
        return "/logros/index";}

    @GetMapping("/tutoriales")
    public String indextutoriales(Model model
    ) {
        model.addAttribute("usuario", usuarioServicio);

        model.addAttribute("dataObject", menuServicio.findAll());
        return "/tutoriales/index";}

    @GetMapping("/ajustes")
    public String indexerror(Model model
    ) {
        model.addAttribute("usuario", usuarioServicio);

        model.addAttribute("dataObject", menuServicio.findAll());
        return "/ajustes/index";}


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


