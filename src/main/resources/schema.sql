-- =========================
-- TABLA USUARIO
-- =========================
CREATE TABLE usuario (
                         id_usuario INT AUTO_INCREMENT PRIMARY KEY,
                         nombre VARCHAR(100) NOT NULL,
                         email VARCHAR(150) NOT NULL UNIQUE,
                         direccion VARCHAR(100) NOT NULL,
                         telefono VARCHAR(100) NOT NULL,
                         password_hash VARCHAR(255) NOT NULL,
                         prestador BOOLEAN,
                         fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- =========================
-- TABLA SERVICIO
-- =========================
CREATE TABLE servicio (
                          id_servicio INT AUTO_INCREMENT PRIMARY KEY,
                          id_usuario INT NOT NULL,
                          nombre VARCHAR(150) NOT NULL,
                          descripcion TEXT NOT NULL,
                          precio DECIMAL(10,2) NOT NULL,
                          modalidad TINYINT NOT NULL,
                          fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          CONSTRAINT fk_servicio_usuario
                              FOREIGN KEY (id_usuario)
                                  REFERENCES usuario(id_usuario)
                                  ON DELETE CASCADE
);

-- =========================
-- DISPONIBILIDAD DE SERVICIO
-- =========================
CREATE TABLE servicio_disponibilidad (
                                         id_disponibilidad INT AUTO_INCREMENT PRIMARY KEY,
                                         id_servicio INT NOT NULL,
                                         dia_semana TINYINT NOT NULL,
                                         hora_inicio TIME NOT NULL,
                                         hora_fin TIME NOT NULL,
                                         CONSTRAINT fk_disponibilidad_servicio
                                             FOREIGN KEY (id_servicio)
                                                 REFERENCES servicio(id_servicio)
                                                 ON DELETE CASCADE,
                                         CONSTRAINT chk_horario CHECK (hora_inicio < hora_fin),
                                         UNIQUE (id_servicio, dia_semana, hora_inicio, hora_fin)
);

-- =========================
-- IMÁGENES DEL SERVICIO
-- =========================
CREATE TABLE servicio_imagen (
                                 id_imagen INT AUTO_INCREMENT PRIMARY KEY,
                                 id_servicio INT NOT NULL,
                                 imagen_url VARCHAR(255) NOT NULL,
                                 orden INT NOT NULL,
                                 CONSTRAINT fk_imagen_servicio
                                     FOREIGN KEY (id_servicio)
                                         REFERENCES servicio(id_servicio)
                                         ON DELETE CASCADE,
                                 UNIQUE (id_servicio, orden)
);

-- =========================
-- CONTRATACIÓN
-- =========================
CREATE TABLE contratacion (
                              id_contratacion INT AUTO_INCREMENT PRIMARY KEY,
                              id_usuario INT NOT NULL,
                              id_servicio INT NOT NULL,
                              fecha DATE NOT NULL,
                              descripcion TEXT,
                              estado VARCHAR(20) NOT NULL,
                              CONSTRAINT fk_contratacion_usuario
                                  FOREIGN KEY (id_usuario)
                                      REFERENCES usuario(id_usuario),
                              CONSTRAINT fk_contratacion_servicio
                                  FOREIGN KEY (id_servicio)
                                      REFERENCES servicio(id_servicio),
                              UNIQUE (id_usuario, id_servicio, fecha)
);

-- =========================
-- RESEÑA
-- =========================
CREATE TABLE resena (
                        id_resena INT AUTO_INCREMENT PRIMARY KEY,
                        id_contratacion INT NOT NULL UNIQUE,
                        calificacion TINYINT NOT NULL,
                        comentario TEXT,
                        fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        CONSTRAINT chk_calificacion CHECK (calificacion BETWEEN 1 AND 5),
                        CONSTRAINT fk_resena_contratacion
                            FOREIGN KEY (id_contratacion)
                                REFERENCES contratacion(id_contratacion)
                                ON DELETE CASCADE
);
