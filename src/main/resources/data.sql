-- =========================
-- USUARIOS
-- =========================
INSERT INTO usuario (nombre, email, direccion, telefono, password_hash, prestador) VALUES
                                                                                       ('Juan Pérez', 'juan@correo.cl', 'Av. Providencia 123', '+56911111111', 'hash123', true),
                                                                                       ('María González', 'maria@correo.cl', 'Las Condes 456', '+56922222222', 'hash456', true),
                                                                                       ('Pedro Soto', 'pedro@correo.cl', 'Ñuñoa 789', '+56933333333', 'hash789', false),
                                                                                       ('Camila Rojas', 'camila@correo.cl', 'Maipú 321', '+56944444444', 'hash321', false);

-- =========================
-- SERVICIOS
-- =========================
INSERT INTO servicio (id_usuario, nombre, descripcion, precio, modalidad) VALUES
                                                                              (1, 'Clases de Programación Java', 'Clases personalizadas de Java y Spring Boot', 25000, 2),
                                                                              (1, 'Soporte Técnico PC', 'Formateo, limpieza y optimización de computadores', 20000, 1),
                                                                              (2, 'Diseño Web', 'Diseño de páginas web modernas y responsivas', 30000, 3);

-- =========================
-- DISPONIBILIDAD DE SERVICIOS
-- =========================
INSERT INTO servicio_disponibilidad (id_servicio, dia_semana, hora_inicio, hora_fin) VALUES
                                                                                         (1, 1, '09:00:00', '12:00:00'),
                                                                                         (1, 3, '14:00:00', '18:00:00'),
                                                                                         (2, 6, '10:00:00', '14:00:00'),
                                                                                         (3, 2, '15:00:00', '19:00:00');

-- =========================
-- IMÁGENES DE SERVICIOS
-- =========================
INSERT INTO servicio_imagen (id_servicio, imagen_url, orden) VALUES
                                                                 (1, 'https://picsum.photos/seed/java/600/400', 1),
                                                                 (1, 'https://picsum.photos/seed/spring/600/400', 2),
                                                                 (2, 'https://picsum.photos/seed/pc/600/400', 1),
                                                                 (3, 'https://picsum.photos/seed/web/600/400', 1);

-- =========================
-- CONTRATACIONES
-- =========================
INSERT INTO contratacion (id_usuario, id_servicio, fecha, descripcion, estado) VALUES
                                                                                   (3, 1, '2025-01-10', 'Necesito reforzar Java para la U', 'REALIZADO'),
                                                                                   (4, 3, '2025-01-15', 'Página web para emprendimiento', 'PENDIENTE');

-- =========================
-- RESEÑAS
-- =========================
INSERT INTO resena (id_contratacion, calificacion, comentario) VALUES
    (1, 5, 'Excelente servicio, muy claro y paciente.');
