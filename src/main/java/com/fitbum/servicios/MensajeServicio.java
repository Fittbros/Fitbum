package com.fitbum.servicios;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Log4j2


public class MensajeServicio {




    public void sendchat(String recipientEmail, String link, String mensaje)
    {
        log.info("HEMOS ENVIADO EL MAIL PERO NJO FUNCIONA EL ENVIO!!");
    }
}
