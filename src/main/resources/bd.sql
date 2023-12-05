CREATE DATABASE IF NOT EXISTS PruebaBackend;
USE PruebaBackend;

-- Crear tabla Usuarios
CREATE TABLE usuarios (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre_usuario VARCHAR(50) NOT NULL,
    contrasena VARCHAR(255) NOT NULL,
    usuario_steam VARCHAR(50),
    UNIQUE KEY unique_nombre_usuario (nombre_usuario)
);

-- Crear tabla Videojuegos
CREATE TABLE videojuegos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre_videojuego VARCHAR(100) NOT NULL
);

-- Crear tabla Partidas
CREATE TABLE partidas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_creador INT NOT NULL,
    id_videojuego INT NOT NULL,
    nombre_partida VARCHAR(100) NOT NULL,
    FOREIGN KEY (id_creador) REFERENCES usuarios(id),
    FOREIGN KEY (id_videojuego) REFERENCES videojuegos(id)
);

-- Crear tabla Usuarios_Partidas
CREATE TABLE usuarios_partidas (
    id_usuario INT,
    id_partida INT,
    PRIMARY KEY (id_usuario, id_partida),
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id),
    FOREIGN KEY (id_partida) REFERENCES partidas(id)
);

-- Crear tabla Mensajes
CREATE TABLE mensajes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_partida INT NOT NULL,
    id_usuario INT NOT NULL,
    contenido TEXT NOT NULL,
    fecha_envio TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_partida) REFERENCES partidas(id),
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
);

-- Inserción de datos de ejemplo
-- Usuarios
INSERT INTO usuarios (nombre_usuario, contrasena, usuario_steam) VALUES
('usuario1', 'password1', 'steam_user1'),
('usuario2', 'password2', 'steam_user2'),
('usuario3', 'password3', 'steam_user3'),
('usuario4', 'password4', 'steam_user4'),
('usuario5', 'password5', 'steam_user5');

-- Videojuegos
INSERT INTO videojuegos (nombre_videojuego) VALUES
('Fortnite'),
('Minecraft'),
('Among Us'),
('League of Legends'),
('Overwatch');

-- Partidas
INSERT INTO partidas (id_creador, id_videojuego, nombre_partida) VALUES
(1, 1, 'Partida1'),
(2, 2, 'Partida2'),
(3, 3, 'Partida3'),
(4, 4, 'Partida4'),
(5, 5, 'Partida5');

-- Usuarios_Partidas
INSERT INTO usuarios_partidas (id_usuario, id_partida) VALUES
(1, 1),
(2, 1),
(3, 2),
(4, 3),
(5, 4);

-- Mensajes
INSERT INTO mensajes (id_partida, id_usuario, contenido) VALUES
(1, 1, '¡Hola a todos!'),
(1, 2, '¿Listos para jugar Fortnite?'),
(2, 3, 'Buscamos más jugadores para Minecraft'),
(3, 4, '¿Alguien se une a una partida de Among Us?'),
(4, 5, '¡Vamos a dominar en League of Legends!');
