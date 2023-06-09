package com.fitbum.filemanagement.controladores;
import com.fitbum.dto.RoleDTO;
import com.fitbum.dto.UsuarioDtoPsw;
import com.fitbum.entidades.tutoriales.Ejercicios;
import com.fitbum.entidades.usuarios.Usuario;
import com.fitbum.filemanagement.entidades.FileDB;
import com.fitbum.filemanagement.models.FileInfo;
import com.fitbum.filemanagement.servicios.DBFileStorageService;
import com.fitbum.filemanagement.servicios.FileSystemStorageService;
import com.fitbum.servicios.MenuServicio;
import com.fitbum.servicios.mapper.UsuarioMapper;
import com.fitbum.servicios.usuarios.RoleService;
import com.fitbum.servicios.usuarios.UsuarioServicio;
import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.beans.XMLDecoder;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;


/**
 * Controlador encargado de manejar la carga de archivos.
 * La clase utiliza las anotaciones @Controller y @CrossOrigin para definir que es un controlador de Spring y
 * permitir solicitudes CORS desde el servidor web localhost en el puerto 8080.
 * La clase utiliza la inyección de dependencias (@Autowired) para acceder a los servicios necesarios para la carga
 * y almacenamiento de archivos, así como para el acceso a la base de datos de archivos.
 */
@Controller
@Log4j2
@CrossOrigin("http://localhost:8080")
public class FileController {

    /**
     * Servicio de almacenamiento de archivos en FileSystem local utilizado por el controlador.
     */
    @Autowired
    private FileSystemStorageService fileSystemStorageService;

    /**
     * Servicio de almacenamiento de archivos en la base de datos utilizado por el controlador.
     */
    @Autowired
    private MenuServicio menuServicio;
    @Autowired
    private DBFileStorageService dbFileStorageService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UsuarioMapper usuarioMapper;

    /**
     * Servicio de usuario utilizado por el controlador.
     */
    @Autowired
    private UsuarioServicio usuarioServicio;

    /**
     * Constructor de la clase que recibe el servicio de almacenamiento de archivos como parámetro.
     * La anotación @Autowired se utiliza para inyectar automáticamente el servicio necesario al crear una instancia de la clase.
     *
     * @param fileSystemStorageService el servicio de almacenamiento de archivos a utilizar
     */
    @Autowired
    public FileController(FileSystemStorageService fileSystemStorageService) {
        this.fileSystemStorageService = fileSystemStorageService;
    }


    /**
     * Método que se encarga de listar los archivos que han sido subidos al servidor.
     *
     * @param model el modelo que se va a utilizar para pasar los datos a la vista
     * @return el nombre de la vista a la que se va a redirigir
     * @throws IOException si ocurre un error al cargar los archivos
     */
    @GetMapping("/files")
    public  String listAllUploadedFiles(Model model,Authentication authentication) throws IOException {
        String username = authentication.getName();
        Optional<Usuario> usuariomenu = Optional.ofNullable(usuarioServicio.getRepo().findUsuarioByUsername(username));
        if(usuariomenu.isPresent()){
            model.addAttribute("logeduser",usuariomenu.get());}
        else{
            return "error";
        }
        model.addAttribute("dataObject", menuServicio.getMenuForUsername(username));
        model.addAttribute("usuario", usuarioServicio);


        //Obtenemos el nombre de usuario del objeto de autenticacion
        // Buscamos al usuario correspondiente al nombre de usuario obtenido anteriormente.
        Usuario usuario = usuarioServicio.getRepo().findUsuarioByUsername(username);


        // Obtenemos todos los archivos almacenados en el servicio de almacenamiento predeterminado.
        // Para cada archivo, generamos una URL que permita descargar el archivo desde el servidor.
        List<FileInfo> files = fileSystemStorageService.loadAll();

        // Obtenemos todos los archivos almacenados en el servicio de almacenamiento de la base de datos.
        // Para cada archivo, generamos una URL que permita descargar el archivo desde el servidor.
        List<FileInfo> dbFiles = dbFileStorageService.getAllFileInfos();

        List<FileInfo> userFiles = fileSystemStorageService.loadAllFromUser(usuario.getId());


        // Obtenemos todos los archivos asociados al usuario y almacenados en la base de datos
        // Para cada archivo, generamos una URL que permita descargar el archivo desde el servidor.
        List<FileInfo> dbUserFiles = dbFileStorageService.getUserFileInfos(usuario);

        // Agregamos las URLs de los archivos del servicio de almacenamiento predeterminado al modelo.
        model.addAttribute("files", files);

        // Agregamos los objetos FileInfo del servicio de almacenamiento de la base de datos al modelo.
        model.addAttribute("DBfiles", dbFiles);
        model.addAttribute("userFiles", userFiles);
        model.addAttribute("dbUserFiles", dbUserFiles);



        // Devolvemos el nombre de la vista a la que se va a redirigir.
        return "listFicheros";
    }



    /**
     * Método que se encarga de descargar un archivo desde el servidor.
     *
     * @param filename el nombre del archivo que se va a descargar
     * @return una respuesta HTTP con el archivo a descargar en el cuerpo de la respuesta '@GetMapping("/files/{filename:.+}")' es una anotación utilizada en un método dentro de un controlador de Spring MVC que indica que el método manejará solicitudes GET para una URL que incluya una variable de ruta {filename}. El . + en la variable de ruta indica que la variable puede contener un punto y cualquier otro carácter después de él. Esto es necesario porque algunos nombres de archivo pueden contener puntos en su nombre y la expresión regular predeterminada utilizada por Spring no permitiría estos caracteres. Por ejemplo, si la URL solicitada es /files/myfile.txt, la variable de ruta {filename} será igual a myfile.txt. Si la URL solicitada es /files/myfile.pdf, la variable de ruta {filename} también será igual a myfile.pdf.
     */
    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        // Cargamos el archivo como un recurso a través del servicio de almacenamiento predeterminado.
        Resource file = fileSystemStorageService.loadAsResource(filename);

        // Construimos una respuesta HTTP con el archivo a descargar en el cuerpo de la respuesta.
        // También establecemos el encabezado "Content-Disposition" con el nombre de archivo para indicar que se debe descargar.
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }


    /**
     * Método que se encarga de manejar la subida de un archivo al servidor.
     *
     * @param file               el archivo que se va a subir
     * @param redirectAttributes los atributos que se van a utilizar para pasar información entre solicitudes
     * @return el nombre de la vista a la que se va a redirigir
     */
    @PostMapping("/uploadToFileSystem")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        // Guardamos el archivo en el servicio de almacenamiento predeterminado.
        fileSystemStorageService.save(file);

        // Agregamos un mensaje de éxito a los atributos de redirección.
        redirectAttributes.addFlashAttribute("message",
                "¡Se ha subido " + file.getOriginalFilename() + " correctamente!");

        // Redirigimos al usuario a la vista que lista los archivos subidos al servidor.
        return "redirect:/files";
    }


    /**
     * Método que recibe una solicitud POST para cargar un archivo a la base de datos.
     *
     * @param file               el archivo cargado en el formulario
     * @param redirectAttributes objeto utilizado para agregar atributos a la redirección
     * @param authentication     objeto que representa la información de autenticación del usuario que realiza la solicitud
     * @return una cadena de texto con la vista redirigida
     */
    @PostMapping("/uploadToDatabase")
    public String uploadFile(@RequestParam("file") MultipartFile file,
                             RedirectAttributes redirectAttributes,
                             Authentication authentication) {

        String message = "";
        try {
            // Almacenar el archivo en la base de datos
            dbFileStorageService.store(file);

            // Agregar mensaje a los atributos de la redirección
            redirectAttributes.addFlashAttribute("message",
                    "¡Archivo " + file.getOriginalFilename() + " cargado exitosamente a la base de datos!");

            // Redirigir a la lista de archivos
            return "redirect:/files";

        } catch (Exception e) {
            // Agregar mensaje de error a los atributos de la redirección
            redirectAttributes.addFlashAttribute("errorMsg", e.getLocalizedMessage());

            // Redirigir a la página de error
            return "error";
        }
    }


    @PostMapping("/uploadUserFileToDatabaseStoreInFileSystem")
    public String uploadUserFileToDatabaseStoreInFileSystem(@RequestParam("file") MultipartFile file,
                                                            RedirectAttributes redirectAttributes,
                                                            Authentication authentication) {
        String message = "";
        try {
            //Obtenemos el nombre de usuario del objeto de autenticacion
            String username = authentication.getName();
            // Buscamos al usuario correspondiente al nombre de usuario obtenido anteriormente.
            Usuario usuario = usuarioServicio.getRepo().findUsuarioByEmail(username);
            // Almacenamos el archivo del usuario en la base de datos pero sin guardar sus datos
            dbFileStorageService.storeUserFileWithoutData(file,usuario);
            // Guardamos el fichero en el filesystem
            fileSystemStorageService.saveUserFile(file, Long.valueOf(usuario.getId()));
            // Agregar mensaje a los atributos de la redirección
            redirectAttributes.addFlashAttribute("message",
                    "¡Archivo " + file.getOriginalFilename() + " cargado exitosamente a la base de datos!");

            // Redirigir a la lista de archivos
            return "redirect:/files";

        } catch (Exception e) {

            log.error("ERROR EN LA APLICACION", e);
            // Agregar mensaje de error a los atributos de la redirección
            redirectAttributes.addFlashAttribute("errorMsg", e.getLocalizedMessage());

            // Redirigir a la página de error
            return "error";
        }
    }




    /**
     * Método que recibe una solicitud POST para cargar un archivo propio de un usuario a la base de datos.
     *
     * @param file               el archivo cargado en el formulario
     * @param redirectAttributes objeto utilizado para agregar atributos a la redirección
     * @param authentication     objeto que representa la información de autenticación del usuario que realiza la solicitud
     * @return una cadena de texto con la vista redirigida
     */
    @PostMapping("/uploadUserFileToDatabase")
    public String uploadUserFileToDatabase(@RequestParam("file") MultipartFile file,
                                           RedirectAttributes redirectAttributes,
                                           Authentication authentication) {

        String message = "";
        try {
            //Obtenemos el nombre de usuario del objeto de autenticacion
            String username = authentication.getName();
            // Buscamos al usuario correspondiente al nombre de usuario obtenido anteriormente.
            Usuario usuario = usuarioServicio.getRepo().findUsuarioByEmail(username);

            // Almacenamos el archivo del usuario en la base de datos
            dbFileStorageService.storeUserFile(file,usuario);

            // Agregar mensaje a los atributos de la redirección
            redirectAttributes.addFlashAttribute("message",
                    "¡Archivo " + file.getOriginalFilename() + " cargado exitosamente a la base de datos!");

            // Redirigir a la lista de archivos
            return "redirect:/files";

        } catch (Exception e) {
            // Agregar mensaje de error a los atributos de la redirección
            redirectAttributes.addFlashAttribute("errorMsg", e.getLocalizedMessage());

            // Redirigir a la página de error
            return "error";
        }
    }



    /**
     * Método que se encarga de manejar la subida de un archivo de usuario al servidor.
     *
     * @param file               el archivo que se va a subir
     * @param redirectAttributes los atributos que se van a utilizar para pasar información entre solicitudes
     * @param authentication     la información de autenticación del usuario que está realizando la solicitud
     * @return el nombre de la vista a la que se va a redirigir
     */
    @PostMapping("/uploadUserFileToFileSystem")
    public String handleUserFileUpload(@RequestParam("file") MultipartFile file,
                                       RedirectAttributes redirectAttributes,
                                       Authentication authentication) {

        // Obtenemos el nombre de usuario del usuario autenticado.
        String username = authentication.getName();

        // Buscamos al usuario correspondiente al nombre de usuario obtenido anteriormente.
        Usuario usuario = usuarioServicio.getRepo().findUsuarioByUsername(username);

        // Obtenemos el ID del usuario.
        Integer userId = usuario.getId();

        // Guardamos el archivo en el servicio de almacenamiento de archivos de usuario.
        fileSystemStorageService.saveUserFile(file, Long.valueOf(userId));

        // Agregamos un mensaje de éxito a los atributos de redirección.
        redirectAttributes.addFlashAttribute("message",
                "¡Se ha subido correctamente el archivo de usuario " + file.getOriginalFilename() + "!");

        // Redirigimos al usuario a la vista que lista los archivos subidos al servidor.
        return "redirect:/files";
    }


    /**
     * Método que se encarga de obtener el archivo de la base de datos con el id proporcionado.
     *
     * @param id El id del archivo a obtener de la base de datos.
     * @return ResponseEntity con el archivo obtenido y las cabeceras necesarias para la descarga del archivo.
     */
    @GetMapping("/databasefiles/{id}")
    public ResponseEntity<byte[]> getDatabaseFile(@PathVariable String id) {
        // Obtiene el archivo de la base de datos utilizando el servicio correspondiente.
        FileDB fileDB = dbFileStorageService.getFile(id);

        // Retorna un ResponseEntity con el archivo obtenido y las cabeceras necesarias para la descarga del archivo.
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getFileName() + "\"")
                .body(fileDB.getData());
    }


    /**
     * Método que elimina un archivo de la base de datos a través de su identificador.
     *
     * @param id El identificador del archivo a eliminar.
     * @return La página de archivos después de eliminar el archivo.
     */
    @GetMapping("/databasefiles/delete/{id}")
    public String deleteFileDB(@PathVariable String id) {
        dbFileStorageService.deleteFile(id);
        return "redirect:/files";
    }


    @GetMapping("/files/delete/{fileName}")
    public String deleteFileFromFileSystem(@PathVariable String fileName) {
        fileSystemStorageService.deleteFile(fileName);
        return "redirect:/files";
    }

    @GetMapping("/databasefiles/desasociarUserFile/{id}")
    public String deleteFileFromFileSystem(@PathVariable String id, Authentication authentication) {
        // Obtenemos el nombre de usuario del usuario autenticado.
        String username = authentication.getName();
        // Buscamos al usuario correspondiente al nombre de usuario obtenido anteriormente.
        Usuario usuario = usuarioServicio.getRepo().findUsuarioByUsername(username);

        dbFileStorageService.desasociarUserFile(id, usuario);
        return "redirect:/files";
    }

    /**
     * Controlador de excepción para la excepción FileNotFoundException.
     * Retorna una respuesta con un estado HTTP 404 (no encontrado).
     *
     * @param exc la excepción FileNotFoundException que se ha producido
     * @return ResponseEntity con un estado HTTP 404 (no encontrado)
     */
    @ExceptionHandler(FileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(FileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/prueba")
    public String pruebaindex(Model model,Authentication authentication){
        model.addAttribute("usuario", usuarioServicio);
        model.addAttribute("dataObject", menuServicio.findAll());
        String username = authentication.getName();
        System.out.println(username);
        Usuario usuario = usuarioServicio.getRepo().findUsuarioByUsername(username);
        System.out.println(usuario.getAvatar());
        model.addAttribute("logeduser",usuario);

        return "prueba";
    }
    @PostMapping("prueba/save")
    public String savePerfil(Usuario usuario, Model model) {
        model.addAttribute("dataObject", menuServicio.findAll());
        model.addAttribute("usuario", usuarioServicio);
        usuarioServicio.getRepo().save(usuario);

        return "redirect:/usuarios";
    }
    @GetMapping("/prueba/{id}")
    public String pruebaId(@PathVariable("id") Integer id,
                           Model model,Authentication authentication
    ){
        model.addAttribute("usuario", usuarioServicio);
        model.addAttribute("dataObject", menuServicio.findAll());
        String username = authentication.getName();
        System.out.println(username);
        Optional<Usuario> usuario = usuarioServicio.getRepo().findById(id);
        if(usuario.isPresent()){
        System.out.println(usuario.get());
        model.addAttribute("logeduser",usuario.get());}
        else{
            return "error";
        }
        List<FileInfo> files = fileSystemStorageService.loadAll();
        model.addAttribute("files", files);


        return "prueba";
    }
//    @GetMapping("/prueba/{id}")
//    public String pruebaId(@PathVariable("id") Integer id,
//                           Model model,Authentication authentication
//
//    ) {
//        model.addAttribute("usuario", usuarioServicio);
//        model.addAttribute("dataObject", menuServicio.findAll());
//
//        UsuarioDtoPsw usuarioDtoPsw = new UsuarioDtoPsw();
//        Optional<Usuario> user = usuarioServicio.getRepo().findById(id);
//
//        if(user.isPresent()){
//            usuarioDtoPsw= usuarioMapper.mapToUserDtoPsw(user.get());
//            //interfazConPantalla
//                    model.addAttribute("datosUsuario",usuarioDtoPsw);
//        }
//        else{
//            return "error";
//        }
//
//        String username = authentication.getName();
//        Usuario usuario = usuarioServicio.getRepo().findUsuarioByUsername(username);
//
//        List<FileInfo> files = fileSystemStorageService.loadAll();
//        List<FileInfo> dbFiles = dbFileStorageService.getAllFileInfos();
//        List<FileInfo> userFiles = fileSystemStorageService.loadAllFromUser(usuario.getId());
//        List<FileInfo> dbUserFiles = dbFileStorageService.getUserFileInfos(usuario);
//
//        model.addAttribute("files", files);
//        model.addAttribute("DBfiles", dbFiles);
//        model.addAttribute("userFiles", userFiles);
//        model.addAttribute("dbUserFiles", dbUserFiles);

//        return "prueba";}


}