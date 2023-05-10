insert into role values (1, 'ADMIN'), (2,'ENTRENADOR' ), (3,'ATLETA' );
insert into usuario (id,altura,apellido1,apellido2,email,fecha_nacim,
                     nombre,password,peso,sexo,active, idrole, username, avatar)
values (1, 1.65,'Pere','Manzana','admin@admin','1990-01-01','pepe','admin', 80,  1 ,true,1,'admin','/assets/img/avatars/avatar1.png'),
       (2, 1.8,'Jorqueran','Perez','entrenador@entrenador','1990-01-07','juan','entrenador', 120,  1 , true,2,'entrenador','/assets/img/avatars/avatar2.jpeg'),
       (3, 1.73,'Martosa','Perez','atleta@1','1990-11-01','maria','pass', 75,  0, true,3,'atleta1','/assets/img/avatars/avatar3.jpeg'),
       (4, 1.73,'Maresca','Perez','atleta@2','1995-01-01','marco','pass2', 55,  1, true,3,'atleta2','/assets/img/avatars/avatar4.jpeg'),
       (5, 1.68, 'López', 'Sánchez', 'lopez@example.com', '1993-09-12', 'Ana', 'password123', 65, 2, true, 3, 'anal', '/assets/img/avatars/avatar5.jpeg'),
       (6, 1.75, 'Rodríguez', 'Martínez', 'rodriguez@example.com', '1988-06-25', 'Carlos', 'securepass', 75, 1, true, 3, 'carlosr', '/assets/img/avatars/avatar13.jpg'),
       (7, 1.72, 'Fernández', 'González', 'fernandez@example.com', '1991-04-18', 'Laura', 'pass1234', 55, 2, true, 3, 'lauraf', '/assets/img/avatars/avatar6.jpg'),
       (8, 1.80, 'Torres', 'Ramírez', 'torres@example.com', '1987-02-09', 'Roberto', '12345pass', 90, 1, true, 3, 'robertot', '/assets/img/avatars/avatar7.jpg'),
       (9, 1.62, 'Vargas', 'Hernández', 'vargas@example.com', '1994-11-27', 'Sofía', 'sofia123', 58, 2, true, 3, 'sofiav', '/assets/img/avatars/avatar8.jpg'),
       (10, 1.79, 'Pérez', 'Gómez', 'perez@example.com', '1986-08-14', 'Javier', 'password1', 70, 1, true, 3, 'javierp', '/assets/img/avatars/avatar9.jpg'),
       (11, 1.70, 'Gutiérrez', 'Santos', 'gutierrez@example.com', '1990-03-07', 'Elena', 'qwerty123', 63, 2, true, 3, 'elenag', '/assets/img/avatars/avatar10.jpg'),
       (12, 1.66, 'Martín', 'Ortega', 'martin@example.com', '1989-10-30', 'Pedro', 'pass123', 75, 1, true, 3, 'pedrom', '/assets/img/avatars/avatar11.jpg'),
       (13, 1.73, 'González', 'Castillo', 'gonzalez@example.com', '1992-07-03', 'Carmen', 'abc123', 62, 2, true, 3, 'carmeng', '/assets/img/avatars/avatar12.jpg'),
       (14, 1.68, 'Silva', 'Vega', 'silva@example.com', '1987-04-26', 'Andrés', 'pass321', 80, 1, true, 3, 'andress', '/assets/img/avatars/avatar13.jpg'),
       (15, 1.75, 'Hernández', 'Navarro', 'hernandez@example.com', '1993-11-19', 'Marta', 'mypass', 65, 2, true, 3, 'martahn', '/assets/img/avatars/avatar14.jpg'),
       (16, 1.70, 'López', 'García', 'lopez@example.com', '1995-02-12', 'David', 'david123', 70, 1, true, 3, 'davidl', '/assets/img/avatars/avatar15.jpg'),
       (17, 1.68, 'González', 'Fernández', 'gonzalez@example.com', '1994-06-27', 'Sara', 'sara456', 60, 2, true, 3, 'saras', '/assets/img/avatars/avatar6.jpg'),
       (18, 1.75, 'Martínez', 'Torres', 'martinez@example.com', '1991-08-18', 'Jorge', 'pass123', 75, 1, true, 3, 'jorgem', '/assets/img/avatars/avatar7.jpg'),
       (19, 1.72, 'Ramírez', 'Vargas', 'ramirez@example.com', '1988-10-09', 'María', 'mypass123', 55, 2, true, 3, 'mariar', '/assets/img/avatars/avatar8.jpg'),
       (20, 1.79, 'Hernández', 'Pérez', 'hernandez@example.com', '1986-12-27', 'Carlos', 'password1', 80, 1, true, 3, 'carlosh', '/assets/img/avatars/avatar9.jpg'),
       (21, 1.70, 'Gómez', 'Gutiérrez', 'gomez@example.com', '1990-04-07', 'Laura', 'qwerty123', 63, 2, true, 3, 'laurag', '/assets/img/avatars/avatar10.jpg'),
       (22, 1.66, 'Ortega', 'Martín', 'ortega@example.com', '1989-11-30', 'Pedro', 'pass123', 75, 1, true, 3, 'pedroo', '/assets/img/avatars/avatar12.jpg'),
       (23, 1.73, 'Castillo', 'González', 'castillo@example.com', '1992-08-03', 'Carmen', 'abc123', 62, 2, true, 3, 'carmenc', '/assets/img/avatars/avatar2.jpeg'),
       (24, 1.68, 'Vega', 'Silva', 'vega@example.com', '1987-05-26', 'Andrés', 'pass321', 80, 1, true, 3, 'andresv', '/assets/img/avatars/avatar3.jpeg'),
       (25, 1.75, 'Navarro', 'Hernández', 'navarro@example.com', '1993-12-19', 'Marta', 'mypass', 65, 2, true, 3, 'martan', '/assets/img/avatars/avatar4.jpeg'),
       (26, 1.70, 'García', 'López', 'garcia@example.com', '1995-03-12', 'David', 'david123', 70, 1, true, 3, 'davidg', '/assets/img/avatars/avatar5.jpeg');

insert into suscripcion values (1,'aa','1990-01-01','1990-01-01',50,1),(2,'bb','1990-01-01','1990-01-01',60,1),(3,'cc','1990-01-01','1990-01-01',45,2);

insert into relaciones values (1,'2025-01-01','1990-12-01',3,2),(2,'2023-01-01','2001-06-01',4,2);

insert into ejercicios values (1,'tocarse','Brazo','+1 R +1 P','Ejercicio 1'),
                              (2,'saltar','pierna','+2 R','Jump'),
                              (3, 'flexiones', 'Pecho', '+2R +3P', 'Ejercicio 3'),
                              (4, 'correr', 'Pierna', '+5R +1P', 'Running'),
                              (5, 'levantamiento de pesas', 'Espalda', '+4R +5P', 'Ejercicio 5'),
                              (6, 'abdominales', 'Abdomen', '+2R +0P', 'Abs workout'),
                              (7, 'sentadillas', 'Pierna', '+3R +2P', 'Squats'),
                              (8, 'burpees', 'Cuerpo completo', '+5R +4P', 'Burpees workout'),
                              (9, 'curl de bíceps', 'Brazo', '+1R +3P', 'Bicep curls'),
                              (10, 'zancadas', 'Pierna', '+4R +2P', 'Lunges'),
                              (11, 'plancha', 'Abdomen', '+3R +1P', 'Plank'),
                              (12, 'press de banca', 'Pecho', '+2R +4P', 'Bench press'),
                              (13, 'remo', 'Espalda', '+1R +2P', 'Rowing'),
                              (14, 'sentadillas con salto', 'Pierna', '+4R +3P', 'Jumping squats'),
                              (15, 'dominadas', 'Espalda', '+3R +5P', 'Pull-ups'),
                              (16, 'escalador', 'Cuerpo completo', '+5R +0P', 'Mountain climbers'),
                              (17, 'curl de tríceps', 'Brazo', '+2R +1P', 'Tricep curls'),
                              (18, 'step-ups', 'Pierna', '+1R +5P', 'Step-ups'),
                              (19, 'superman', 'Espalda', '+3R +3P', 'Superman exercise'),
                              (20, 'giros rusos', 'Abdomen', '+0R +4P', 'Russian twists');

insert into content_tutorial values (1,'tocarse fuerte','Ejercicio 1','https://www.youtube.com/watch?v=Jv4O_XeHPyA&pp=ygUjY2FiYWxsbyBob21vc2V4dWFsIGRlIGxhcyBtb250YcOxYXM%3D'),(2,'saltar muy alto','jump','https://www.youtube.com/watch?v=Jv4O_XeHPyA&pp=ygUjY2FiYWxsbyBob21vc2V4dWFsIGRlIGxhcyBtb250YcOxYXM%3D');
delete from menu;
insert into menu (id,orden,nombre,url,activo,icon,padre,hijos,eshijo)
values (9999,9999,'base','/',0,'fas fa-tachometer-alt', null,0,0),
       ( 1, 1, 'Inicio', '/home',1,'fas fa-tachometer-alt',9999,0,0),
       (2, 20, 'Entrenar', '/programa',1,'fas fas fa-dumbbell',9999,0,0),
       (3, 30, 'Mis rutinas', '/misrutinas',1,'fas fa-table',9999,0,0),
       (4, 40, 'Chats', '/chat',1,'far fa-comment-alt',9999,1,0),
       (5, 35, 'Entrenador', '/chat/entrenador',1,'far fa-comment-alt',4,0,1),
       (6, 48, 'Atletas', '/chat/atletas',1,'far fa-comment-alt',4,0,1),
       (7,50,'Entrenadores','/entrenadores',1,'fas fa-users',9999,0,0),
       (8,55,'Atletas','/atletas',1,'fas fa-users',9999,0,0),
       (9,60,'Logros','/logros',1,'fas fa-trophy',9999,0,0),
       (10,70,'Tutoriales','/tutoriales',1,'fas fa-window-maximize',9999,0,0),
       (11,80,'Ajustes de Página','/ajustes',1,'fas fa-wrench',9999,0,0);



