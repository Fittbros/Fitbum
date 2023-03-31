delete from usuario;
delete from detalle_usuario;
delete from rol;
delete from suscripcion;
insert into usuario values ( 1, 1, 1, 1), (2, 1, 2, 2), (3, 1, 3, 3),(4,1,4,3);
insert into detalle_usuario values ( 1,1.65,'Pepe','Manzana','Mad@rid','1990-01-01','pepe','1234', 80,  1 ), ( 2,1.8,'Juan','Perez','Mad@rid','1990-01-01','juan','1234', 120,  1 ),( 3,1.73,'Maria','Perez','Mad@rid','1990-01-01','maria','1234', 55,  1);
insert into rol values (1, 'ROLE_ADMIN'), (2,'ROLE_GUEST' ), (3,'ROLE_USER' );
insert into suscripcion values (1,'aa','1990-01-01','1990-01-01',1,50),(2,'bb','1990-01-01','1990-01-01',1,60),(3,'cc','1990-01-01','1990-01-01',1,45);

