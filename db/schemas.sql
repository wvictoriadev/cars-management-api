-- -----------------------------------------------------
-- Tabla "USUARIOS"
-- -----------------------------------------------------
CREATE TABLE USUARIOS (
  "id_usuario" SERIAL NOT NULL,
  "email" VARCHAR(100) NOT NULL,
  "username" VARCHAR(10) NOT NULL,
  "password" VARCHAR NOT NULL,
  "rol" VARCHAR NOT NULL,
  PRIMARY KEY ("id_usuario"));

-- -----------------------------------------------------
-- Tabla "EMPLEADOS"
-- -----------------------------------------------------
CREATE TABLE EMPLEADOS (
  "id_empleado" SERIAL NOT NULL,
  "nombre" VARCHAR(50) NOT NULL,
  "matricula" VARCHAR(10) NOT NULL,
  PRIMARY KEY ("id_empleado"));

-- -----------------------------------------------------
-- Tabla "CARROS"
-- -----------------------------------------------------
CREATE TABLE CARROS (
  "id_carro" SERIAL NOT NULL,
  "modelo" VARCHAR(10) NOT NULL,
  "marca" VARCHAR(50) NOT NULL,
  "fecha_fabricacion" TIMESTAMP NOT NULL,
  PRIMARY KEY ("id_carro"));
  
-- -----------------------------------------------------
-- Tabla "VIAJES"
-- -----------------------------------------------------
CREATE TABLE VIAJES (
  "id_viaje" SERIAL NOT NULL,
  "id_empleado" INT NOT NULL,
  "id_carro" INT NOT NULL,
  "fecha_retiro" TIMESTAMP NOT NULL,
  "fecha_entrega" TIMESTAMP NOT NULL,
  PRIMARY KEY ("id_viaje"),
  CONSTRAINT "fk_VIAJES_EMPLEADOS"
    FOREIGN KEY ("id_empleado")
    REFERENCES EMPLEADOS ("id_empleado")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT "fk_VIAJES_CARROS"
    FOREIGN KEY ("id_carro")
    REFERENCES CARROS ("id_carro")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);