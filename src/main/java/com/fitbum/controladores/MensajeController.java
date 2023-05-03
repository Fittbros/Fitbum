package com.fitbum.controladores;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@Log4j2
@RequestMapping("/chat")

public class MensajeController {
    @GetMapping(value = {"/",""})
    public String indexchat(){
        return "/chat/index";}

    @GetMapping(value = {"/entrenador"})
    public String chatentrenador(){
        return "/chat/chatEntrenador";}

    @GetMapping(value = {"/atletas"})
    public String chatatletas(){
        return "/chat/chatAtletas";}

}
