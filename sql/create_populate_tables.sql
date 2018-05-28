/*
	CREACION DE LA TABLA PARA GUARDAR LOS USUARIOS
*/
CREATE TABLE usuario (
	id_usuario SERIAL PRIMARY KEY,
	fullname_usuario VARCHAR(50) NOT NULL,
	username_usuario VARCHAR(50) NOT NULL,
	password_usuario VARCHAR(200) NOT NULL
);

/*
	INSERTAR DATOS EN LA TABLA USUARIOS
*/
-- Juan Perez jperez juanperez123456
INSERT INTO usuarios (fullname_usuario, username_usuario, password_usuario) VALUES ('Juan Perez', 'jperez', 'bmg2NXFHNZOLK3JwF99x7Q==');
-- Camilo Veloza camiveloza camilo1986 
INSERT INTO usuarios (fullname_usuario, username_usuario, password_usuario) VALUES ('Camilo Veloza', 'camiveloza', 'DJnodzVtXcOSHHWvXPPWMg==');
-- Hugo Sanchez hugoschz 19hugo63sanchez 
INSERT INTO usuarios (fullname_usuario, username_usuario, password_usuario) VALUES ('Hugo Sanchez', 'hugoschz', 'vFC1J2ZJegOny/0n2LuLPg==');

/*
	QUERY LOGIN (CONSULTA SI UN USERNAME y PASSWORD COINCIDEN)
*/
SELECT * FROM usuarios WHERE username_usuario = 'jperez' AND password_usuario = 'bmg2NXFHNZOLK3JwF99x7Q==';

/*
	QUERY REGISTRAR USUARIO SI NO EXISTE
*/
INSERT INTO example_table (username_usuario)
SELECT 'jperez' WHERE NOT EXISTS (SELECT username_usuario FROM usuarios WHERE username_usuario = 'jperez');

/*
	CREACION DE LA TABLA PARA GUARDAR LOS ALOJAMIENTOS
*/
CREATE TABLE alojamientos (
	id_alojamiento SERIAL PRIMARY KEY,
	nombre_alojamiento VARCHAR(10),
	tipo_alojamiento BOOLEAN,
	cantidad_personas_alojamiento VARCHAR(10),
	cantidad_habitaciones_alojamiento VARCHAR(10),
	cantidad_banos_alojamiento VARCHAR(10),
	calefaccion_alojamiento BOOLEAN,
	aire_acondicionado_alojamiento BOOLEAN,
	mascotas_alojamiento BOOLEAN,
	direccion_alojamiento VARCHAR(50),
	ciudad_alojamiento VARCHAR(50),
	barrio_alojamiento VARCHAR(50),
	descripcion_alojamiento VARCHAR(200),
	precio_alojamiento VARCHAR(200)
);

/*
	INSERTAR DATOS EN LA TABLA ALOJAMIENTOS
*/
INSERT INTO alojamientos (nombre_alojamiento, tipo_alojamiento, cantidad_personas_alojamiento, 
cantidad_habitaciones_alojamiento, cantidad_banos_alojamiento, calefaccion_alojamiento, 
aire_acondicionado_alojamiento, mascotas_alojamiento, direccion_alojamiento, ciudad_alojamiento,
barrio_alojamiento, descripcion_alojamiento, precio_alojamiento) 
VALUES ('Cerezos', FALSE, '5', '5', '3', FALSE, FALSE, FALSE, 'TV 52b # 45-16', 'Ibagué', 'Urbanización', 'Descripcion del alojamiento', '500000');

INSERT INTO alojamientos (nombre_alojamiento, tipo_alojamiento, cantidad_personas_alojamiento, 
cantidad_habitaciones_alojamiento, cantidad_banos_alojamiento, calefaccion_alojamiento, 
aire_acondicionado_alojamiento, mascotas_alojamiento, direccion_alojamiento, ciudad_alojamiento,
barrio_alojamiento, descripcion_alojamiento, precio_alojamiento) 
VALUES ('Libertad', TRUE, '12', '10', '5', FALSE, TRUE, TRUE, 'Diagonal 22 # 05-17', 'Neiva', 'Galan', 'Descripcion del alojamiento', '1200000');

INSERT INTO alojamientos (nombre_alojamiento, tipo_alojamiento, cantidad_personas_alojamiento, 
cantidad_habitaciones_alojamiento, cantidad_banos_alojamiento, calefaccion_alojamiento, 
aire_acondicionado_alojamiento, mascotas_alojamiento, direccion_alojamiento, ciudad_alojamiento,
barrio_alojamiento, descripcion_alojamiento, precio_alojamiento) 
VALUES ('Cristal', FALSE, '5', '4', '2', TRUE, TRUE, FALSE, 'Calle 22 # 105-17', 'Tunja', 'La Luz', 'Descripcion del alojamiento', '980000');

/*
	CREACION TABLA RESERVACIONES 
*/
CREATE TABLE reservaciones (
	id_reservacion SERIAL PRIMARY KEY,
	reservacion_nombre_completo_usuario VARCHAR(100),
	reservacion_num_identificacion_usuario VARCHAR(100),
	reservacion_direccion_usuario VARCHAR(100),
	reservacion_telefono_usuario VARCHAR(100),
	reservacion_celular_usuario VARCHAR(100),
	reservacion_numero_tarjeta_usuario VARCHAR(100),
	reservacion_fecha_exp_tarjeta_usuario VARCHAR(100),
	reservacion_nombre_tarjeta_usuario VARCHAR(100),
	reservacion_precio_total VARCHAR(100),
	reservacion_fecha_inicial VARCHAR(100),
	reservacion_fecha_final VARCHAR(100),
	id_alojamiento_reservado_fk SERIAL REFERENCES alojamientos (id_alojamiento),
	id_usuario_fk SERIAL REFERENCES usuarios (id_usuario)
);

/*
	INSERTAR DATOS EN LA TABLA DE RESERVACIONES
*/
INSERT INTO reservaciones (reservacion_nombre_completo_usuario, reservacion_num_identificacion_usuario,
reservacion_direccion_usuario, reservacion_telefono_usuario, reservacion_celular_usuario, 
reservacion_numero_tarjeta_usuario, reservacion_fecha_exp_tarjeta_usuario, reservacion_nombre_tarjeta_usuario,
reservacion_precio_total, reservacion_fecha_inicial, reservacion_fecha_final, id_alojamiento_reservado_fk, id_usuario_fk) 
VALUES ('Juan Perez', '1223344', 'TV 52 C # 45 - 17', '5651218', '3002267890', '1234567891011', '02-12-2030',
'Pedro Alberto Rodriguez', '3400000', '2018-06-06', '2018-06-26', 1, 1);

/*
	BUSCAR ALOJAMIENTOS POR FECHA
*/
SELECT DISTINCT id_alojamiento, nombre_alojamiento, tipo_alojamiento, cantidad_personas_alojamiento,
cantidad_habitaciones_alojamiento, cantidad_banos_alojamiento, calefaccion_alojamiento, aire_acondicionado_alojamiento, 
mascotas_alojamiento, direccion_alojamiento, ciudad_alojamiento, barrio_alojamiento, descripcion_alojamiento, precio_alojamiento
FROM alojamientos
INNER JOIN reservaciones ON 
(alojamientos.id_alojamiento = reservaciones.id_alojamiento_reservado_fk) 
WHERE reservaciones.reservacion_fecha_inicial <> '2018-06-06' 
AND reservaciones.reservacion_fecha_final <> '2018-06-26';

/*
 	BUSCAR LAS RESERVACIONES DE UN USUARIO
*/
SELECT * FROM reservaciones WHERE id_usuario_fk = 1;
