insert into role values (1, 'ADMIN'), (2,'ENTRENADOR' ), (3,'ATLETA' );
delete from usuario;
insert into usuario (id,altura,apellido1,apellido2,email,fecha_nacim,
                     nombre,password,peso,sexo,active, idrole, username, avatar)
values (1, 165,'admin','admin','admin@admin','1990-01-01','admin','$2a$10$Dzy3yCynw2wtS8nHTCh7Bug7gyLlekoKT3WkY11zUTVd.6ZKd6O5W', 80,  1 ,true,1,'admin','/assets/img/avatars/avatar1.png'),
       (2, 180,'Jorqueran','Perez','entrenador@entrenador','1990-01-07','Juan','$2a$10$.saUfYzrQPKSDqrikuH24Ob93pHGc2yEdZsN0N13WVwSBX/bPAUAm', 120,  1 , true,2,'entrenador','/assets/img/avatars/avatar2.jpeg'),
       (3, 173,'Martosa','Perez','atleta@1','1990-11-01','María','$2a$10$ptqIq6r28m9vTpin86WyIO.xh10ozOm9mKKc2GdslQFIId/gqZf2O', 75,  0, true,3,'atleta1','/assets/img/avatars/avatar3.jpeg'),
       (4, 173,'Maresca','Perez','atleta@2','1995-01-01','Marco','$2a$10$ptqIq6r28m9vTpin86WyIO.xh10ozOm9mKKc2GdslQFIId/gqZf2O', 55,  1, true,3,'atleta2','/assets/img/avatars/avatar4.jpeg'),
       (5, 168, 'López', 'Sánchez', 'lopez@example.com', '1993-09-12', 'Ana', '$2a$10$ptqIq6r28m9vTpin86WyIO.xh10ozOm9mKKc2GdslQFIId/gqZf2O', 65, 2, true, 3, 'anal', '/assets/img/avatars/avatar5.jpeg'),
       (6, 175, 'Rodríguez', 'Martínez', 'rodriguez@example.com', '1988-06-25', 'Carlos', '$2a$10$ptqIq6r28m9vTpin86WyIO.xh10ozOm9mKKc2GdslQFIId/gqZf2O', 75, 1, true, 3, 'carlosr', '/assets/img/avatars/avatar13.jpg'),
       (7, 172, 'Fernández', 'González', 'fernandez@example.com', '1991-04-18', 'Laura', '$2a$10$ptqIq6r28m9vTpin86WyIO.xh10ozOm9mKKc2GdslQFIId/gqZf2O', 55, 2, true, 3, 'lauraf', '/assets/img/avatars/avatar6.jpg'),
       (8, 180, 'Torres', 'Ramírez', 'torres@example.com', '1987-02-09', 'Roberto', '$2a$10$ptqIq6r28m9vTpin86WyIO.xh10ozOm9mKKc2GdslQFIId/gqZf2O', 90, 1, true, 3, 'robertot', '/assets/img/avatars/avatar7.jpg'),
       (9, 162, 'Vargas', 'García', 'vargas@example.com', '1994-11-27', 'Sofía', '$2a$10$ptqIq6r28m9vTpin86WyIO.xh10ozOm9mKKc2GdslQFIId/gqZf2O', 58, 2, true, 3, 'sofiav', '/assets/img/avatars/avatar8.jpg'),
       (10, 179, 'Pérez', 'Gómez', 'perez@example.com', '1986-08-14', 'Javier', '$2a$10$ptqIq6r28m9vTpin86WyIO.xh10ozOm9mKKc2GdslQFIId/gqZf2O', 70, 1, true, 3, 'javierp', '/assets/img/avatars/avatar9.jpg'),
       (11, 170, 'Gutiérrez', 'Santos', 'gutierrez@example.com', '1990-03-07', 'Elena', '$2a$10$ptqIq6r28m9vTpin86WyIO.xh10ozOm9mKKc2GdslQFIId/gqZf2O', 63, 2, true, 3, 'elenag', '/assets/img/avatars/avatar10.jpg'),
       (12, 166, 'Martín', 'Ortega', 'martin@example.com', '1989-10-30', 'Pedro', '$2a$10$ptqIq6r28m9vTpin86WyIO.xh10ozOm9mKKc2GdslQFIId/gqZf2O', 75, 1, true, 3, 'pedrom', '/assets/img/avatars/avatar11.jpg'),
       (13, 173, 'González', 'Castillo', 'gonzalez@example.com', '1992-07-03', 'Carmen', '$2a$10$ptqIq6r28m9vTpin86WyIO.xh10ozOm9mKKc2GdslQFIId/gqZf2O', 62, 2, true, 3, 'carmeng', '/assets/img/avatars/avatar12.jpg'),
       (14, 168, 'Silva', 'Vega', 'silva@example.com', '1987-04-26', 'Andrés', '$2a$10$ptqIq6r28m9vTpin86WyIO.xh10ozOm9mKKc2GdslQFIId/gqZf2O', 80, 1, true, 3, 'andress', '/assets/img/avatars/avatar13.jpg'),
       (15, 175, 'Hernández', 'Navarro', 'hernandez@example.com', '1993-11-19', 'Marta', '$2a$10$ptqIq6r28m9vTpin86WyIO.xh10ozOm9mKKc2GdslQFIId/gqZf2O', 65, 2, true, 3, 'martahn', '/assets/img/avatars/avatar14.jpg'),
       (16, 170, 'López', 'García', 'lopez@example.com', '1995-02-12', 'David', '$2a$10$ptqIq6r28m9vTpin86WyIO.xh10ozOm9mKKc2GdslQFIId/gqZf2O', 70, 1, true, 3, 'davidl', '/assets/img/avatars/avatar15.jpg'),
       (17, 168, 'González', 'Fernández', 'gonzalez@example.com', '1994-06-27', 'Sara', '$2a$10$ptqIq6r28m9vTpin86WyIO.xh10ozOm9mKKc2GdslQFIId/gqZf2O', 60, 2, true, 3, 'saras', '/assets/img/avatars/avatar6.jpg'),
       (18, 175, 'Martínez', 'Torres', 'martinez@example.com', '1991-08-18', 'Jorge', '$2a$10$ptqIq6r28m9vTpin86WyIO.xh10ozOm9mKKc2GdslQFIId/gqZf2O', 75, 1, true, 3, 'jorgem', '/assets/img/avatars/avatar7.jpg'),
       (19, 172, 'Ramírez', 'Vargas', 'ramirez@example.com', '1988-10-09', 'Fátima', '$2a$10$ptqIq6r28m9vTpin86WyIO.xh10ozOm9mKKc2GdslQFIId/gqZf2O', 55, 2, true, 3, 'mariar', '/assets/img/avatars/avatar8.jpg'),
       (20, 179, 'Hernández', 'Pérez', 'hernandez@example.com', '1986-12-27', 'Carlos', '$2a$10$ptqIq6r28m9vTpin86WyIO.xh10ozOm9mKKc2GdslQFIId/gqZf2O', 80, 1, true, 3, 'carlosh', '/assets/img/avatars/avatar9.jpg'),
       (21, 170, 'Gómez', 'Gutiérrez', 'gomez@example.com', '1990-04-07', 'Laura', '$2a$10$ptqIq6r28m9vTpin86WyIO.xh10ozOm9mKKc2GdslQFIId/gqZf2O', 63, 2, true, 3, 'laurag', '/assets/img/avatars/avatar10.jpg'),
       (22, 166, 'Ortega', 'Martín', 'ortega@example.com', '1989-11-30', 'Pedro', '$2a$10$ptqIq6r28m9vTpin86WyIO.xh10ozOm9mKKc2GdslQFIId/gqZf2O', 75, 1, true, 3, 'pedroo', '/assets/img/avatars/avatar12.jpg'),
       (23, 173, 'Castillo', 'González', 'castillo@example.com', '1992-08-03', 'Carmen', '$2a$10$ptqIq6r28m9vTpin86WyIO.xh10ozOm9mKKc2GdslQFIId/gqZf2O', 62, 2, true, 3, 'carmenc', '/assets/img/avatars/avatar2.jpeg'),
       (24, 168, 'Vega', 'Silva', 'vega@example.com', '1987-05-26', 'Andrés', '$2a$10$ptqIq6r28m9vTpin86WyIO.xh10ozOm9mKKc2GdslQFIId/gqZf2O', 80, 1, true, 3, 'andresv', '/assets/img/avatars/avatar3.jpeg'),
       (25, 175, 'García', 'Hernández', 'navarro@example.com', '1993-12-19', 'Anabel', '$2a$10$ptqIq6r28m9vTpin86WyIO.xh10ozOm9mKKc2GdslQFIId/gqZf2O', 65, 2, true, 3, 'martan', '/assets/img/avatars/avatar4.jpeg'),
       (26, 170, 'García', 'López', 'garcia@example.com', '1995-03-12', 'David', '$2a$10$ptqIq6r28m9vTpin86WyIO.xh10ozOm9mKKc2GdslQFIId/gqZf2O', 70, 1, true, 3, 'davidg', '/assets/img/avatars/avatar5.jpeg');

insert into suscripcion values (1,'aa','1990-01-01','1990-01-01',50,1),(2,'bb','1990-01-01','1990-01-01',60,1),(3,'cc','1990-01-01','1990-01-01',45,2);

insert into relaciones values (1,'2025-01-01','1990-12-01',3,2),(2,'2023-01-01','2001-06-01',4,2);

insert into ejercicios values (1,'tocarse','Brazo','+1 R +1 P','Ejercicio 1','https://www.youtube.com/watch?v=dQw4w9WgXcQ'),
                              (2,'saltar','pierna','+2 R','Jump','https://www.youtube.com/watch?v=dQw4w9WgXcQ'),
                              (3, 'flexiones', 'Pecho', '+2R +3P', 'Ejercicio 3','https://www.youtube.com/watch?v=dQw4w9WgXcQ'),
                              (4, 'correr', 'Pierna', '+5R +1P', 'Running','https://www.youtube.com/watch?v=dQw4w9WgXcQ'),
                              (5, 'levantamiento de pesas', 'Espalda', '+4R +5P', 'Ejercicio 5','https://www.youtube.com/watch?v=dQw4w9WgXcQ'),
                              (6, 'abdominales', 'Abdomen', '+2R +0P', 'Abs workout','https://www.youtube.com/watch?v=dQw4w9WgXcQ'),
                              (7, 'sentadillas', 'Pierna', '+3R +2P', 'Squats','https://www.youtube.com/watch?v=dQw4w9WgXcQ'),
                              (8, 'burpees', 'Cuerpo completo', '+5R +4P', 'Burpees workout','https://www.youtube.com/watch?v=dQw4w9WgXcQ'),
                              (9, 'curl de bíceps', 'Brazo', '+1R +3P', 'Bicep curls','https://www.youtube.com/watch?v=dQw4w9WgXcQ'),
                              (10, 'zancadas', 'Pierna', '+4R +2P', 'Lunges','https://www.youtube.com/watch?v=dQw4w9WgXcQ'),
                              (11, 'plancha', 'Abdomen', '+3R +1P', 'Plank','https://www.youtube.com/watch?v=dQw4w9WgXcQ'),
                              (12, 'press de banca', 'Pecho', '+2R +4P', 'Bench press','https://www.youtube.com/watch?v=dQw4w9WgXcQ'),
                              (13, 'remo', 'Espalda', '+1R +2P', 'Rowing','https://www.youtube.com/watch?v=dQw4w9WgXcQ'),
                              (14, 'sentadillas con salto', 'Pierna', '+4R +3P', 'Jumping squats','https://www.youtube.com/watch?v=dQw4w9WgXcQ'),
                              (15, 'dominadas', 'Espalda', '+3R +5P', 'Pull-ups','https://www.youtube.com/watch?v=dQw4w9WgXcQ'),
                              (16, 'escalador', 'Cuerpo completo', '+5R +0P', 'Mountain climbers','https://www.youtube.com/watch?v=dQw4w9WgXcQ'),
                              (17, 'curl de tríceps', 'Brazo', '+2R +1P', 'Tricep curls','https://www.youtube.com/watch?v=dQw4w9WgXcQ'),
                              (18, 'step-ups', 'Pierna', '+1R +5P', 'Step-ups','https://www.youtube.com/watch?v=dQw4w9WgXcQ'),
                              (19, 'superman', 'Espalda', '+3R +3P', 'Superman exercise','https://www.youtube.com/watch?v=dQw4w9WgXcQ'),
                              (20, 'giros rusos', 'Abdomen', '+0R +4P', 'Russian twists','https://www.youtube.com/watch?v=dQw4w9WgXcQ');

insert into content_tutorial
values (1,'tocarse fuerte','Ejercicio 1','https://www.youtube.com/watch?v=Jv4O_XeHPyA&pp=ygUjY2FiYWxsbyBob21vc2V4dWFsIGRlIGxhcyBtb250YcOxYXM%3D'),
       (2,'saltar muy alto','jump','https://www.youtube.com/watch?v=Jv4O_XeHPyA&pp=ygUjY2FiYWxsbyBob21vc2V4dWFsIGRlIGxhcyBtb250YcOxYXM%3D');
delete from menu;
insert into menu (id,orden,nombre,url,activo,icon,padre,hijos,eshijo)
values (9999,9999,'base','/',0,'fas fa-tachometer-alt', null,0,0),
       ( 1, 1, 'Inicio', '/home',1,'fas fa-tachometer-alt',9999,0,0),
       (2, 20, 'Entrenar', '/programa',1,'fas fas fa-dumbbell',9999,0,0),
       (3, 30, 'Mis rutinas', '/misrutinas',1,'fas fa-table',9999,0,0),
       (4, 40, 'Chats', '/chat',1,'far fa-comment-alt',9999,1,0),
       (5, 41, 'Entrenador', '/chat/entrenador',1,'far fa-comment-alt',4,0,1),
       (6, 42, 'Atletas', '/chat/atletas',1,'far fa-comment-alt',4,0,1),
       (7,51,'Entrenadores','/entrenadores',1,'fas fa-users',9999,0,0),
       (8,55,'Atletas','/atletas',1,'fas fa-users',9999,0,0),
       (9,60,'Logros','/logros',1,'fas fa-trophy',9999,0,0),
       (10,70,'Tutoriales','/tutoriales',1,'fas fa-window-maximize',9999,0,0),
       (11,80,'Ajustes de Página','/ajustes',1,'fas fa-wrench',9999,0,0),
       (12,32,'Plantillas','/plantillas',1,'fas fa-table',9999,0,0),
       (13,50,'Usuarios','/usuarios',1,'fas fa-users',9999,0,0),
       (14,59,'Menus','/menu',1,'fas fa-wrench',9999,0,0);
delete from menu_roles;
insert into menu_roles(menu_id,roles_id)
values
    (1,1),(2,1),(3,1),(4,1),(5,1),(6,1),(7,1),(8,1),(9,1),(10,1),(11,1),(12,1),(13,1),(14,1),
    (1,2),(2,2),(3,2),(4,2),(5,2),(6,2),(7,2),(8,2),(9,2),(10,2),(11,2),(12,2),(13,2),(14,2),
    (1,3),(2,3),(3,3),(4,3),(5,3),(7,3),(9,3),(10,3),(11,3);
delete from plantilla_mesociclo;
INSERT INTO plantilla_mesociclo (orden,descanso_acces, descanso_bas, descripcion, fecha_fin, fecha_inicio, fr_entre_semana, id_mesociclos, long_microciclo, num_microciclos, id_usuario)
VALUES
    (1,'2 min','4 min', 'Introducción', '2023-01-01', '2023-01-15', 4, 1, 4, 5, 1),
    (2,'2 min','4 min', 'Enfoque técnico', '2023-02-01', '2023-02-15', 4, 1, 4, 4, 1),
    (3,'2 min', '4 min', 'Intensificación I', '2023-03-01', '2023-03-15', 4, 2, 4, 4, 2),
    (4,'2 min', '4 min', 'Intensificación II', '2023-04-01', '2023-04-15', 5, 2, 5, 4, 2),
    (5,'2 min', '4 min', 'Intensificación III', '2023-02-01', '2023-02-15', 5, 1, 5, 4, 1),
    (6,'2 min', '4 min', 'Power: Fase Desarrollo', '2023-02-01', '2023-02-15', 4, 1, 4, 4, 1),
    (7,'2 min', '4 min', 'Power: Peaking', '2023-02-01', '2023-02-15', 4, 1, 4, 3, 1),
    (8,'1,5 min','4 min', 'Hipertrofia Descarga', '2023-05-01', '2023-05-15', 3, 4, 3, 4, 2);
DELETE FROM plantilla_microciclo;

INSERT INTO plantilla_microciclo (orden,intensidad_estandar, volumen_estandar, id_plantilla_mesociclo)
VALUES
    (1,'5,5','3' , 1),
        (2,'6', '3', 1),
        (3,'6', '3', 1),
        (4,'6,25', '3', 1),
        (5,'6,5', '3', 1),
    (1,'5,5','3' , 2),
        (2,'6', '3', 2),
        (3,'6,25', '3', 2),
        (4,'6,5', '3', 2),
    (1,'5,5','3' , 3),
        (2,'6', '3', 3),
        (3,'6,25', '3', 3),
        (4,'6,5', '3', 3),
    (1,'5,5','3' , 4),
        (2,'6', '3', 4),
        (3,'6,25', '3', 4),
        (4,'6,5', '3', 4),
    (1,'5,5','3' , 5),
        (2,'6', '3', 5),
        (3,'6,25', '3', 5),
        (4,'6,5', '3', 5),
   (1,'5,5','3' , 6),
        (2,'6', '3', 6),
        (3,'6,25', '3', 6),
        (4,'6,5', '3', 6),
   (1,'6','3' , 7),
        (2,'6,5', '3', 7),
        (3,'7', '3', 7),
   (1,'5,5','3' , 8),
        (2,'6', '3', 8),
        (3,'6,25', '3', 8),
        (4,'6,5', '3', 8);

DELETE FROM plantilla_sesion;

INSERT INTO plantilla_sesion (orden,num_sesion,variante, id_plantilla_microciclo)
VALUES
    (1,1,'Torso 1', 1),
        (2,2,'Pierna 1', 1),
        (3,3,'Accesorios', 1),
        (4,4,'Torso 2', 1),
        (5,5,'Pierna 2', 1),
    (1,6,'Torso 1', 2),
        (2,7,'Pierna 1', 2),
        (3,8,'Accesorios', 2),
        (4,9,'Torso 2', 2),
        (5,10,'Pierna 2', 2),
    (1,11,'Torso 1', 3),
        (2,12,'Pierna 1', 3),
        (3,13,'Accesorios', 3),
        (4,14,'Torso 2', 3),
        (5,15,'Pierna 2', 3),
    (1,16,'Torso 1', 4),
        (2,17,'Pierna 1', 4),
        (3,18,'Accesorios', 4),
        (4,19,'Torso 2', 4),
        (5,20,'Pierna 2', 4),
    (1,21,'Torso 1', 5),
        (2,22,'Pierna 1', 5),
        (3,23,'Accesorios', 5),
        (4,24,'Torso 2', 5),
        (5,25,'Pierna 2', 5);

DELETE FROM plantilla_ejercicio_formulado;

INSERT INTO plantilla_ejercicio_formulado (descanso_esp, descripcion, id_ejercicio, modific_periodizacion, nombre_ej, id_plantilla_sesion)
VALUES
    (1, 'Descripción 1', 1, 'Modificación 1', 'Ejercicio 1', 1),
    (2, 'Descripción 2', 2, 'Modificación 2', 'Ejercicio 2', 1),
    (3, 'Descripción 3', 3, 'Modificación 3', 'Ejercicio 3', 2),
    (4, 'Descripción 4', 4, 'Modificación 4', 'Ejercicio 4', 2),
    (5, 'Descripción 5', 5, 'Modificación 5', 'Ejercicio 5', 3);

DELETE FROM plantilla_serie;

INSERT INTO plantilla_serie (carga, modif_interna, modif_vis, repes, id_plantilla_ejercicio_formulado)
VALUES
    (50.0, 1, 0, 10, 1),
    (60.0, 1, 1, 12, 1),
    (45.0, 2, 1, 8, 2),
    (55.0, 0, 0, 15, 2),
    (40.0, 1, 0, 10, 3);




