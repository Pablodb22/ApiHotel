INSERT INTO Hotel (nombre, descripcion, categoria, piscina, localidad) VALUES('HotelSol', 'Un hotel con vistas al mar', 4, TRUE, 'Barcelona');
INSERT INTO Hotel (nombre, descripcion, categoria, piscina, localidad) VALUES('HotelLuna', 'Un hotel con vistas al rio', 3, FALSE, 'Sevilla');
INSERT INTO Hotel (nombre, descripcion, categoria, piscina, localidad) VALUES('HotelMarea', 'Un hotel con vistas a la montaña', 4, TRUE, 'Madrid');

INSERT INTO Habitacion (hotel_id, tamano, capacidad, precio_noche, incluye_desayuno, ocupada) VALUES(1, 25, 2, 120, TRUE, FALSE);
INSERT INTO Habitacion (hotel_id, tamano, capacidad, precio_noche, incluye_desayuno, ocupada) VALUES(3, 20, 1, 100, TRUE, FALSE);
INSERT INTO Habitacion (hotel_id, tamano, capacidad, precio_noche, incluye_desayuno, ocupada) VALUES(2, 35, 2, 200, TRUE, FALSE);
INSERT INTO Habitacion (hotel_id, tamano, capacidad, precio_noche, incluye_desayuno, ocupada) VALUES(1, 29, 3, 186, FALSE, TRUE);

