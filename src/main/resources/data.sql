insert into role values (1, 'ADMIN'), (2,'ENTRENADOR' ), (3,'ATLETA' );
insert into usuario values ( 1, 1, 1), (2, 1, 2), (3, 1,  3),(4,1,3);

insert into detalle_usuario values (1, 1.65,'Pere','Manzana','Mad@rid','1990-01-01','pepe','1234', 80,  1 ),
                                   (2, 1.8,'Jorqueran','Perez','pepe@1','1990-01-07','juan','1234', 120,  1 ),
                                   (3, 1.73,'Martosa','Perez','pepe@2','1990-11-01','maria','1234', 75,  0),
                                   (4, 1.73,'Maresca','Perez','pepe@3','1995-01-01','marco','1234', 55,  1);

insert into suscripcion values (1,'aa','1990-01-01','1990-01-01',50,1),(2,'bb','1990-01-01','1990-01-01',60,1),(3,'cc','1990-01-01','1990-01-01',45,2);

insert into relaciones values (1,'2025-01-01','1990-12-01',3,2),(2,'2023-01-01','2001-06-01',4,2);

insert into ejercicios values (1,'tocarse','Brazo','+1 rep +1 peso','Ejercicio 1'),(2,'saltar','pierna','+2 rep','Jump');

insert into content_tutorial values (1,'tocarse fuerte','Ejercicio 1','https://www.youtube.com/watch?v=Jv4O_XeHPyA&pp=ygUjY2FiYWxsbyBob21vc2V4dWFsIGRlIGxhcyBtb250YcOxYXM%3D'),(2,'saltar muy alto','jump','https://www.youtube.com/watch?v=Jv4O_XeHPyA&pp=ygUjY2FiYWxsbyBob21vc2V4dWFsIGRlIGxhcyBtb250YcOxYXM%3D');
delete from menu;
insert into menu (id_menu,orden,nombre,url,activo,icon,padre) values ( 1, 1, 'Inicio', '/index',1,'fas fa-tachometer-alt',9999),
                                                               (2, 20,  'Entrenar', '/programa',1,'fas fas fa-dumbbell',9999),
                                                               (3, 30,  'Mis rutinas', '/misrutinas',1,'fas fa-table',9999),
                                                               (4, 40,  'Chats', '/chat',1,'far fa-comment-alt',9999),
                                                               (5, 35,  'Entrenador', '/chat/entrenador',1,'far fa-comment-alt',4),
                                                               (6, 48,  'Cliente', '/chat/cliente',1,'far fa-comment-alt',4);




