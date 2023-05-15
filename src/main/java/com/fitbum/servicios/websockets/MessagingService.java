package com.fitbum.servicios.websockets;

import com.fitbum.entidades.websockets.Notificacion;
import com.fitbum.repositorios.NotificacionRepositorio;
import com.fitbum.entidades.websockets.PrivateMessage;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


// 1.- Crear un objeto notificación en Base de datos
// 2.- Obtener el ID De la notificación para adjuntarlo al mensaje
// 3.- Al recibir el mensaje, procesaremos el contenido y obtendremos el ID
// 4.- En el metodo callback de la recepción, enviaremos el ID Del mensaje para indicar que se ha recibido.
// 5.- Desde el servidor, al recibir la confirmación de dicho mensaje, marcaremos la notificación a recibida.

@Service
@Log4j2
public class MessagingService {

    @Autowired
    private NotificacionRepositorio notificacionRepositorio;

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    public void EnviarMensajeSTOMPDeNotificacion(PrivateMessage message, Notificacion notificacion)
    {
        simpMessagingTemplate.convertAndSendToUser(
                message.getTo(),
                "/specific",
                message,
                createHeaders(message.getTo(),
                        String.valueOf(notificacion.getId()))
        );
        log.info("Mensaje enviado a: " + message.getTo());
    }


    public Notificacion crearNotificacion(String userTo, String userFrom, String mensaje)  {

        Notificacion notificacion = new Notificacion();
        notificacion.setEstado("Pendiente");
        notificacion.setFecha(LocalDateTime.now());
        notificacion.setUserTo(userTo);
        notificacion.setUserFrom(userFrom);
        notificacion.setText(mensaje);
        notificacionRepositorio.save(notificacion);
        return notificacion;

    }

    public void crearMensajeYNotificacionTrainerYEnviar(String queOcurre, String aQuienLeOcurre) {
        // Primero creamos la notificación de algo que ocurre en el sistema
        Notificacion notificacion = crearNotificacion(aQuienLeOcurre,"ENTRENADOR", queOcurre);

        // Después preparamos el objeto mensaje que será enviado por la cola de mensajes STOMP en base a la
        // notificación de que ha ocurrido algo
        // El mensaje toma el ID de la notificación que hemos creado en BD para controlar su recepción cuando un
        // cliente conectado lo recibe.
        PrivateMessage privateMessage = new PrivateMessage(
                notificacion.getId(),
                notificacion.getText(),
                notificacion.getUserTo(),
                notificacion.getUserFrom()
        );

        enviarMensajePrivado(privateMessage);
    }




    /**
     * Envía un mensaje privado a través de la cola de mensajes STOMP.
     *
     * @param privateMessage El mensaje privado a enviar.
     */
    public void enviarMensajePrivado(PrivateMessage privateMessage) {
        simpMessagingTemplate.convertAndSendToUser(
                privateMessage.getTo(),
                "/specific",
                privateMessage,
                createHeaders(privateMessage.getTo(), String.valueOf(privateMessage.getNotificationID()))
        );
        log.info("Mensaje enviado a: " + privateMessage.getTo());
    }


    /**
     * Crea los encabezados del mensaje con el destinatario y el ID de notificación.
     *
     * @param recipient     El destinatario del mensaje.
     * @param notificationID El ID de la notificación.
     * @return Los encabezados del mensaje.
     */
    public MessageHeaders createHeaders(String recipient, String notificationID) {
        SimpMessageHeaderAccessor headerAccessor = SimpMessageHeaderAccessor.create(SimpMessageType.MESSAGE);
        headerAccessor.addNativeHeader("notificationID", notificationID);
        return headerAccessor.getMessageHeaders();
    }




}


