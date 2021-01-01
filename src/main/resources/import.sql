INSERT INTO producto (nombre, precio) VALUES('Panasonic', 800);
INSERT INTO producto (nombre, precio) VALUES('Sony', 700);
INSERT INTO producto (nombre, precio) VALUES('Apple MacBook', 900);
INSERT INTO producto (nombre, precio) VALUES('Hewlett Packard', 500);

INSERT INTO cliente (nombre, apellido, dni, telefono, email) VALUES('Jose', 'Linares', '70255836', '4521724', 'jce_la@hotmail.com');

INSERT INTO usuario (nombre, nombre_usuario, email, password) VALUES('Jose', 'jose', 'jclinares905@gmail.com', '$2y$12$O934BGOhR42xKKHVtCx.M.QIOJ1FlAG723krNGkVB2DwLrXEqF8tS');

INSERT INTO rol (rol_nombre) VALUES('ROLE_ADMIN');
INSERT INTO rol (rol_nombre) VALUES('ROLE_USER');

INSERT INTO usuario_rol (usuario_id, rol_id) VALUES(1,1);
INSERT INTO usuario_rol (usuario_id, rol_id) VALUES(1,2);