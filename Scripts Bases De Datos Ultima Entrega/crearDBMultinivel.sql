/* ---------------------------------------------------- */
/*  Generated by Enterprise Architect Version 13.5 		*/
/*  Created On : 23-may.-2023 21:17:21 				*/
/*  DBMS       : Oracle 						*/
/* ---------------------------------------------------- */

/* Drop Tables */

begin
	EXECUTE IMMEDIATE 'DROP TABLE   "AUDITORIA" CASCADE CONSTRAINTS';
	EXCEPTION WHEN OTHERS THEN NULL;
end;  
/

begin
	EXECUTE IMMEDIATE 'DROP TABLE   "CATEGORIA" CASCADE CONSTRAINTS';
	EXCEPTION WHEN OTHERS THEN NULL;
end;  
/

begin
	EXECUTE IMMEDIATE 'DROP TABLE   "CLIENTE" CASCADE CONSTRAINTS';
	EXCEPTION WHEN OTHERS THEN NULL;
end;  
/

begin
	EXECUTE IMMEDIATE 'DROP TABLE   "INVENTARIO" CASCADE CONSTRAINTS';
	EXCEPTION WHEN OTHERS THEN NULL;
end;  
/

begin
	EXECUTE IMMEDIATE 'DROP TABLE   "ORDEN" CASCADE CONSTRAINTS';
	EXCEPTION WHEN OTHERS THEN NULL;
end;  
/

begin
	EXECUTE IMMEDIATE 'DROP TABLE   "PAIS" CASCADE CONSTRAINTS';
	EXCEPTION WHEN OTHERS THEN NULL;
end;  
/

begin
	EXECUTE IMMEDIATE 'DROP TABLE   "PERIODO" CASCADE CONSTRAINTS';
	EXCEPTION WHEN OTHERS THEN NULL;
end;  
/

begin
	EXECUTE IMMEDIATE 'DROP TABLE   "PERSONA" CASCADE CONSTRAINTS';
	EXCEPTION WHEN OTHERS THEN NULL;
end;  
/

begin
	EXECUTE IMMEDIATE 'DROP TABLE   "PRODUCTO" CASCADE CONSTRAINTS';
	EXCEPTION WHEN OTHERS THEN NULL;
end;  
/

begin
	EXECUTE IMMEDIATE 'DROP TABLE   "REGION" CASCADE CONSTRAINTS';
	EXCEPTION WHEN OTHERS THEN NULL;
end;  
/

begin
	EXECUTE IMMEDIATE 'DROP TABLE   "REPRESENTANTE_VENTAS" CASCADE CONSTRAINTS';
	EXCEPTION WHEN OTHERS THEN NULL;
end;  
/

/* Create Tables */

CREATE TABLE  "AUDITORIA"
(
	"K_ID" NUMBER(2) NOT NULL,    -- Id de la tabla de auditoria
	"N_TABLA" VARCHAR(50) NOT NULL,    -- Nombre de la tabla que se modifico
	"Q_CALIFICACION" NUMBER(1) NULL,    -- Calificacion del representante
	"K_IDORDEN" NUMBER(10) NULL,    -- Id de la orden
	"K_IDPRODUCTO" NUMBER(5) NULL,    -- Id del producto de la orden
	"K_IDREGION" NUMBER(5) NULL,    -- Id de region del inventario
	"K_NUMERO_ID_REP" NUMBER(15) NULL,    -- N�merode id del representante involucrado
	"K_TIPO_ID_REP" VARCHAR(3) NULL    -- Tipo de id del representante involucrado
)
;

CREATE TABLE  "CATEGORIA"
(
	"K_IDCATEGORIA" NUMBER(5) NOT NULL,    -- Identificador de la categoria
	"K_IDSUBCATEGORIA" NUMBER(5) NULL,    -- Identificador de una subcategoria de una categoria padre
	"N_NOMBRE" VARCHAR(50) NOT NULL,    -- Nombre por el cual est� asociada a una categoria en el registro de cada categoria nueva.
	"Q_IVA" NUMBER(4,2) NOT NULL
)
;

CREATE TABLE  "CLIENTE"
(
	"K_TIPO_ID" VARCHAR(3) NOT NULL,    -- Tipo de identificaci�n del cliente.
	"K_NUMERO_ID" NUMBER(15) NOT NULL,    -- Numero de identificaci�n del cliente.
	"Q_CUENTA" NUMBER(15) NOT NULL,    -- Numero de cuenta del cliente.
	"I_TIPO_ID_REP" VARCHAR(3) NOT NULL,    -- Tipo de identificacion del representante actual del cliente.
	"Q_NUMERO_ID_REP" NUMBER(15) NOT NULL    -- Numero de identificacion del representante actual del cliente.
)
;

CREATE TABLE  "INVENTARIO"
(
	"K_IDPRODUCTO" NUMBER(5) NOT NULL,
	"K_IDREGION" NUMBER(5) NOT NULL,    -- Identificador de la region donde se encuentra el producto
	"Q_STOCK" NUMBER(5) NOT NULL,    -- Cantidad en stock del producto
	"V_PRECIOPRODUCTO" NUMBER(10,2) NOT NULL    -- Valor establecido para un producto seg�n en el inventario que se encuentre registrado
)
;

CREATE TABLE  "ORDEN"
(
	"K_IDORDEN" NUMBER(10) NOT NULL,    -- Atributo que identifica el numero de orden de manera unica
	"K_IDPRODUCTO" NUMBER(5) NOT NULL,    -- Id que identifica al producto dentro de la orden
	"K_IDREGION" NUMBER(5) NOT NULL,
	"K_IDPERIODO" VARCHAR(30) NOT NULL,    -- Periodo donde se realiza la orden
	"F_FECHAREGISTRO" DATE NOT NULL,    -- Fecha en la que se realiza la orden
	"I_ESTADO" VARCHAR(20) NOT NULL,    -- Estado actual de la orden.
	"K_TIPO_ID" VARCHAR(3) NOT NULL,    -- Tipo de identificacion del cliente que relaiza la orden
	"K_NUMERO_ID" NUMBER(15) NOT NULL,    -- Numero de id del cliente que realiza la orden
	"K_TIPO_ID_CALIF" VARCHAR(3) NULL,    -- Tipo de identificacion del cliente que califica el servicio prestado por el representante de ventas
	"K_NUMERO_ID_CALIF" NUMBER(15) NULL,    -- Numero de identificacion del cliente que califica el servicio prestado por el representante de ventas
	"Q_CALIFICACION" NUMBER(1) NULL,
	"Q_CANTIDAD" NUMBER(5) NOT NULL,    -- Cantidad del producto que se quiere ordenar
	"I_TIPO_ID_REP" VARCHAR(3) NULL,    -- Tipo de identificacion del representante asociado al cliente de la orden
	"Q_NUMERO_ID_REP" NUMBER(15) NULL    -- Numero de identificacion del representante asociado al cliente de la orden
)
;

CREATE TABLE  "PAIS"
(
	"K_IDPAIS" NUMBER(5) NOT NULL,    -- Identificador del pais
	"N_NOMBRE" VARCHAR(50) NOT NULL    -- Nombre del pais
)
;

CREATE TABLE  "PERIODO"
(
	"K_IDPERIODO" VARCHAR(50) NOT NULL,    -- Identificador del periodo
	"F_FECHAINICIO" DATE NOT NULL,    -- Fecha en la que inicia el periodo.
	"F_FECHAFIN" DATE NOT NULL,    -- Fecha en la que finaliza el periodo.
	"Q_COMISION" NUMBER(4,2) NOT NULL    -- Porcentaje de comisi�n para el periodo
)
;

CREATE TABLE  "PERSONA"
(
	"K_TIPO_ID" VARCHAR(3) NOT NULL,    -- Tipo de identificaci�n del cliente. 
	"K_NUMERO_ID" NUMBER(15) NOT NULL,    -- N�mero de identificaci�n del cliente. 
	"I_TIPO_ID" VARCHAR(3)  NULL,    -- Tipo de identificaci�n de la persona que inscribio a la persona al sistema por primera vez.
	"Q_NUMERO_ID" NUMBER(15)  NULL,    -- N�mero de identificaci�n de la persona que inscribio a la persona al sistema por primera vez.
	"N_NOMBRECOMPLETO" VARCHAR(150) NOT NULL,    -- Nombre completo de la persona.
	"N_APELLIDOCOMPLETO" VARCHAR(150) NOT NULL,    -- Apellido completo de la persona.
	"O_EMAIL" VARCHAR(150) NOT NULL,    -- Email de la persona.
	"Q_TELEFONO" NUMBER(15) NOT NULL,    -- N�mero de telefono de la persona.
	"F_FECHACREACION" DATE NOT NULL,    -- Fecha de inscripcci�n al sistema.
	"N_CIUDAD" VARCHAR(100) NOT NULL,    -- Ciudad de residencia de la persona.
	"I_GENERO" VARCHAR(3) NOT NULL,    -- Genero de la persona.
	"F_NACIMIENTO" DATE NOT NULL,    -- Fecha de nacimiento de la persona.
	"O_DIRECCION" VARCHAR(150) NOT NULL    -- Direcci�n de residencia de la persona.
)
;

CREATE TABLE  "PRODUCTO"
(
	"K_IDPRODUCTO" NUMBER(5) NOT NULL,
	"K_IDCATEGORIA" NUMBER(5) NOT NULL,    -- Identificador de la categoria que pertenece el producto
	"N_NOMBRE" VARCHAR(80) NOT NULL,    -- Nombre del producto
	"N_URLIMAGEN" VARCHAR(200) NOT NULL    -- Imagen del producto
)
;

CREATE TABLE  "REGION"
(
	"K_IDREGION" NUMBER(5) NOT NULL,    -- Identificador de la region
	"K_IDPAIS" NUMBER(5) NOT NULL,    -- Pais al que pertenece la region
	"N_NOMBRE" VARCHAR(50) NOT NULL    -- Atributo asociado al nombre perteneciente a una regi�n
)
;

CREATE TABLE  "REPRESENTANTE_VENTAS"
(
	"K_TIPO_ID" VARCHAR(3) NOT NULL,    -- Tipo de identificacion del representante de ventas
	"K_NUMERO_ID" NUMBER(15) NOT NULL,    -- Numero de identificacion del representante de ventas,
	"K_TIPO_ID_JEFE" VARCHAR(3) NULL,    -- Tipo de identificacion del representante de ventas jefe
	"K_NUMERO_ID_JEFE" NUMBER(15) NULL,    -- Numero de identificacion del representante de ventas jefe
	"I_TIPO" VARCHAR(15) NOT NULL,    -- Tipo de cargo del representante de ventas 
	"I_ESTADO" VARCHAR(15) NOT NULL    -- Estado del representante de ventas.
)
;

/* Create Comments, Sequences and Triggers for Autonumber Columns */

COMMENT ON TABLE  "AUDITORIA" IS 'Tabla de auditoria del sistema'
;

COMMENT ON COLUMN  "AUDITORIA"."K_ID" IS 'Id de la tabla de auditoria'
;

COMMENT ON COLUMN  "AUDITORIA"."N_TABLA" IS 'Nombre de la tabla que se modifico'
;

COMMENT ON COLUMN  "AUDITORIA"."Q_CALIFICACION" IS 'Calificacion del representante'
;

COMMENT ON COLUMN  "AUDITORIA"."K_IDORDEN" IS 'Id de la orden'
;

COMMENT ON COLUMN  "AUDITORIA"."K_IDPRODUCTO" IS 'Id del producto de la orden'
;

COMMENT ON COLUMN  "AUDITORIA"."K_IDREGION" IS 'Id de region del inventario'
;

COMMENT ON COLUMN  "AUDITORIA"."K_NUMERO_ID_REP" IS 'N�merode id del representante involucrado'
;

COMMENT ON COLUMN  "AUDITORIA"."K_TIPO_ID_REP" IS 'Tipo de id del representante involucrado'
;

COMMENT ON TABLE  "CATEGORIA" IS 'Categorias de los productos que se ofrecen'
;

COMMENT ON COLUMN  "CATEGORIA"."K_IDCATEGORIA" IS 'Identificador de la categoria'
;

COMMENT ON COLUMN  "CATEGORIA"."K_IDSUBCATEGORIA" IS 'Identificador de una subcategoria de una categoria padre'
;

COMMENT ON COLUMN  "CATEGORIA"."N_NOMBRE" IS 'Nombre por el cual est� asociada a una categoria en el registro de cada categoria nueva.'
;

COMMENT ON TABLE  "CLIENTE" IS 'Tabla con atributos de los clientes del sistema'
;

COMMENT ON COLUMN  "CLIENTE"."K_TIPO_ID" IS 'Tipo de identificaci�n del cliente.'
;

COMMENT ON COLUMN  "CLIENTE"."K_NUMERO_ID" IS 'Numero de identificaci�n del cliente.'
;

COMMENT ON COLUMN  "CLIENTE"."Q_CUENTA" IS 'Numero de cuenta del cliente.'
;

COMMENT ON COLUMN  "CLIENTE"."I_TIPO_ID_REP" IS 'Tipo de identificacion del representante actual del cliente.'
;

COMMENT ON COLUMN  "CLIENTE"."Q_NUMERO_ID_REP" IS 'Numero de identificacion del representante actual del cliente.'
;

COMMENT ON TABLE  "INVENTARIO" IS 'Tabla de rompimiento generada por la relaci�n entre Region y Producto, donde contendr� el almacenamiento especifico de productos por regiones'
;

COMMENT ON COLUMN  "INVENTARIO"."K_IDREGION" IS 'Identificador de la region donde se encuentra el producto'
;

COMMENT ON COLUMN  "INVENTARIO"."Q_STOCK" IS 'Cantidad en stock del producto'
;

COMMENT ON COLUMN  "INVENTARIO"."V_PRECIOPRODUCTO" IS 'Valor establecido para un producto seg�n en el inventario que se encuentre registrado'
;

COMMENT ON TABLE  "ORDEN" IS 'Tabla con las ordenes que se quieran gestionar'
;

COMMENT ON COLUMN  "ORDEN"."K_IDORDEN" IS 'Atributo que identifica el numero de orden de manera unica'
;

COMMENT ON COLUMN  "ORDEN"."K_IDPRODUCTO" IS 'Id que identifica al producto dentro de la orden'
;

COMMENT ON COLUMN  "ORDEN"."K_IDPERIODO" IS 'Periodo donde se realiza la orden'
;

COMMENT ON COLUMN  "ORDEN"."F_FECHAREGISTRO" IS 'Fecha en la que se realiza la orden'
;

COMMENT ON COLUMN  "ORDEN"."I_ESTADO" IS 'Estado actual de la orden.'
;

COMMENT ON COLUMN  "ORDEN"."K_TIPO_ID" IS 'Tipo de identificacion del cliente que relaiza la orden'
;

COMMENT ON COLUMN  "ORDEN"."K_NUMERO_ID" IS 'Numero de id del cliente que realiza la orden'
;

COMMENT ON COLUMN  "ORDEN"."K_TIPO_ID_CALIF" IS 'Tipo de identificacion del cliente que califica el servicio prestado por el representante de ventas'
;

COMMENT ON COLUMN  "ORDEN"."K_NUMERO_ID_CALIF" IS 'Numero de identificacion del cliente que califica el servicio prestado por el representante de ventas'
;

COMMENT ON COLUMN  "ORDEN"."Q_CANTIDAD" IS 'Cantidad del producto que se quiere ordenar'
;

COMMENT ON COLUMN  "ORDEN"."I_TIPO_ID_REP" IS 'Tipo de identificacion del representante asociado al cliente de la orden'
;

COMMENT ON COLUMN  "ORDEN"."Q_NUMERO_ID_REP" IS 'Numero de identificacion del representante asociado al cliente de la orden'
;

COMMENT ON TABLE  "PAIS" IS 'Paises que donde se presta el servicio'
;

COMMENT ON COLUMN  "PAIS"."K_IDPAIS" IS 'Identificador del pais'
;

COMMENT ON COLUMN  "PAIS"."N_NOMBRE" IS 'Nombre del pais'
;

COMMENT ON TABLE  "PERIODO" IS 'Tabla que identifica el periodo actual y las condiciones de este'
;

COMMENT ON COLUMN  "PERIODO"."K_IDPERIODO" IS 'Identificador del periodo'
;

COMMENT ON COLUMN  "PERIODO"."F_FECHAINICIO" IS 'Fecha en la que inicia el periodo.'
;

COMMENT ON COLUMN  "PERIODO"."F_FECHAFIN" IS 'Fecha en la que finaliza el periodo.'
;

COMMENT ON COLUMN  "PERIODO"."Q_COMISION" IS 'Porcentaje de comisi�n para el periodo'
;

COMMENT ON TABLE  "PERSONA" IS 'Tabla generalizaci�n con los datos primordiales de cualquier persona del sistema.'
;

COMMENT ON COLUMN  "PERSONA"."K_TIPO_ID" IS 'Tipo de identificaci�n del cliente. '
;

COMMENT ON COLUMN  "PERSONA"."K_NUMERO_ID" IS 'N�mero de identificaci�n del cliente. '
;

COMMENT ON COLUMN  "PERSONA"."I_TIPO_ID" IS 'Tipo de identificaci�n de la persona que inscribio a la persona al sistema por primera vez.'
;

COMMENT ON COLUMN  "PERSONA"."Q_NUMERO_ID" IS 'N�mero de identificaci�n de la persona que inscribio a la persona al sistema por primera vez.'
;

COMMENT ON COLUMN  "PERSONA"."N_NOMBRECOMPLETO" IS 'Nombre completo de la persona.'
;

COMMENT ON COLUMN  "PERSONA"."N_APELLIDOCOMPLETO" IS 'Apellido completo de la persona.'
;

COMMENT ON COLUMN  "PERSONA"."O_EMAIL" IS 'Email de la persona.'
;

COMMENT ON COLUMN  "PERSONA"."Q_TELEFONO" IS 'N�mero de telefono de la persona.'
;

COMMENT ON COLUMN  "PERSONA"."F_FECHACREACION" IS 'Fecha de inscripcci�n al sistema.'
;

COMMENT ON COLUMN  "PERSONA"."N_CIUDAD" IS 'Ciudad de residencia de la persona.'
;

COMMENT ON COLUMN  "PERSONA"."I_GENERO" IS 'Genero de la persona.'
;

COMMENT ON COLUMN  "PERSONA"."F_NACIMIENTO" IS 'Fecha de nacimiento de la persona.'
;

COMMENT ON COLUMN  "PERSONA"."O_DIRECCION" IS 'Direcci�n de residencia de la persona.'
;

COMMENT ON TABLE  "PRODUCTO" IS 'Productos que se ofrecen por la empresa'
;

COMMENT ON COLUMN  "PRODUCTO"."K_IDCATEGORIA" IS 'Identificador de la categoria que pertenece el producto'
;

COMMENT ON COLUMN  "PRODUCTO"."N_NOMBRE" IS 'Nombre del producto'
;

COMMENT ON COLUMN  "PRODUCTO"."N_URLIMAGEN" IS 'Imagen del producto'
;

COMMENT ON TABLE  "REGION" IS 'Regiones donde se presta el servicio'
;

COMMENT ON COLUMN  "REGION"."K_IDREGION" IS 'Identificador de la region'
;

COMMENT ON COLUMN  "REGION"."K_IDPAIS" IS 'Pais al que pertenece la region'
;

COMMENT ON COLUMN  "REGION"."N_NOMBRE" IS 'Atributo asociado al nombre perteneciente a una regi�n'
;

COMMENT ON TABLE  "REPRESENTANTE_VENTAS" IS 'Tabla con los atributos de los representantes de ventas.'
;

COMMENT ON COLUMN  "REPRESENTANTE_VENTAS"."K_TIPO_ID" IS 'Tipo de identificacion del representante de ventas'
;

COMMENT ON COLUMN  "REPRESENTANTE_VENTAS"."K_NUMERO_ID" IS 'Numero de identificacion del representante de ventas,'
;

COMMENT ON COLUMN  "REPRESENTANTE_VENTAS"."K_TIPO_ID_JEFE" IS 'Tipo de identificacion del representante de ventas jefe'
;

COMMENT ON COLUMN  "REPRESENTANTE_VENTAS"."K_NUMERO_ID_JEFE" IS 'Numero de identificacion del representante de ventas jefe'
;

COMMENT ON COLUMN  "REPRESENTANTE_VENTAS"."I_TIPO" IS 'Tipo de cargo del representante de ventas '
;

COMMENT ON COLUMN  "REPRESENTANTE_VENTAS"."I_ESTADO" IS 'Estado del representante de ventas.'
;

/* Create Primary Keys, Indexes, Uniques, Checks, Triggers */

ALTER TABLE  "AUDITORIA" 
 ADD CONSTRAINT "PK_K_ID"
	PRIMARY KEY ("K_ID") 
 USING INDEX
;

ALTER TABLE  "CATEGORIA" 
 ADD CONSTRAINT "PK_CATEGORIA"
	PRIMARY KEY ("K_IDCATEGORIA") 
 USING INDEX
;

ALTER TABLE  "CATEGORIA" 
 ADD CONSTRAINT "CK_Q_IVA" CHECK (Q_IVA > 0)
;

CREATE INDEX "IXFK_CATEGORIA_CATEGORIA"   
 ON  "CATEGORIA" ("K_IDSUBCATEGORIA") 
;

ALTER TABLE  "CLIENTE" 
 ADD CONSTRAINT "PK_CLIENTE"
	PRIMARY KEY ("K_TIPO_ID","K_NUMERO_ID") 
 USING INDEX
;

ALTER TABLE  "CLIENTE" 
 ADD CONSTRAINT "CK_K_TIPO_ID" CHECK (K_TIPO_ID IN ('TI', 'CC', 'NIT', 'CE', 'PAP'))
;

ALTER TABLE  "CLIENTE" 
 ADD CONSTRAINT "CK_Q_CUENTA" CHECK (Q_CUENTA > 0)
;

ALTER TABLE  "CLIENTE" 
 ADD CONSTRAINT "CK_K_NUMERO_ID" CHECK (K_NUMERO_ID > 0)
;

ALTER TABLE  "CLIENTE" 
 ADD CONSTRAINT "CK_Q_NUMERO_ID" CHECK (Q_NUMERO_ID_REP > 0)
;

ALTER TABLE  "CLIENTE" 
 ADD CONSTRAINT "CK_I_TIPO_ID_REP" CHECK (I_TIPO_ID_REP IN ('TI', 'CC', 'NIT', 'CE', 'PAP'))
;

CREATE INDEX "IXFK_CLIENTE_REPRESENTANT01"   
 ON  "CLIENTE" ("I_TIPO_ID_REP","Q_NUMERO_ID_REP") 
;

ALTER TABLE  "INVENTARIO" 
 ADD CONSTRAINT "PK_INVENTARIO"
	PRIMARY KEY ("K_IDPRODUCTO","K_IDREGION") 
 USING INDEX
;

ALTER TABLE  "INVENTARIO" 
 ADD CONSTRAINT "CK_Q_STOCK" CHECK (Q_STOCK >= 0)
;

ALTER TABLE  "INVENTARIO" 
 ADD CONSTRAINT "CK_V_PRECIOPRODUCTO" CHECK (V_PRECIOPRODUCTO > 0)
;

CREATE INDEX "IXFK_INVENTARIO_PRODUCTO"   
 ON  "INVENTARIO" ("K_IDPRODUCTO") 
;

CREATE INDEX "IXFK_INVENTARIO_REGION"   
 ON  "INVENTARIO" ("K_IDREGION") 
;

ALTER TABLE  "ORDEN" 
 ADD CONSTRAINT "PK_ORDEN"
	PRIMARY KEY ("K_IDORDEN","K_IDPRODUCTO","K_IDREGION","K_TIPO_ID","K_NUMERO_ID") 
 USING INDEX
;

ALTER TABLE  "ORDEN" 
 ADD CONSTRAINT "CK_IDORDEN" CHECK (K_IDORDEN > 0)
;

ALTER TABLE  "ORDEN" 
 ADD CONSTRAINT "CK_IDPRODUCTO" CHECK (K_IDPRODUCTO > 0)
;

ALTER TABLE  "ORDEN" 
 ADD CONSTRAINT "CK_IDREGION" CHECK (K_IDREGION > 0)
;

ALTER TABLE  "ORDEN" 
 ADD CONSTRAINT "CK_ESTADO" CHECK (I_ESTADO IN ('EN PROCESO', 'COMPLETADO', 'CANCELADO'))
;

ALTER TABLE  "ORDEN" 
 ADD CONSTRAINT "CK_TIPO_ID" CHECK (K_TIPO_ID IN ('TI', 'CC', 'NIT', 'CE', 'PAP'))
;

ALTER TABLE  "ORDEN" 
 ADD CONSTRAINT "CK_NUMERO_ID" CHECK (K_NUMERO_ID > 0)
;

ALTER TABLE  "ORDEN" 
 ADD CONSTRAINT "CK_TIPO_CALF" CHECK (K_TIPO_ID_CALIF IN ('TI', 'CC', 'NIT', 'CE', 'PAP'))
;

ALTER TABLE  "ORDEN" 
 ADD CONSTRAINT "CK_NUMERO_ID_CALF" CHECK (K_NUMERO_ID_CALIF > 0)
;

ALTER TABLE  "ORDEN" 
 ADD CONSTRAINT "CK_CANTIDAD" CHECK (Q_CANTIDAD > 0)
;

ALTER TABLE  "ORDEN" 
 ADD CONSTRAINT "CK_TIPO_ID_REP" CHECK (I_TIPO_ID_REP IN ('TI', 'CC', 'NIT', 'CE', 'PAP'))
;

ALTER TABLE  "ORDEN" 
 ADD CONSTRAINT "CK_NUMERO_ID_REP" CHECK (Q_NUMERO_ID_REP > 0)
;

ALTER TABLE  "ORDEN" 
 ADD CONSTRAINT "CK_CALIFICACION" CHECK (Q_CALIFICACION BETWEEN 1 AND 5 )
;

CREATE INDEX "IXFK_ORDEN_CLIEN02"   
 ON  "ORDEN" ("K_TIPO_ID","K_NUMERO_ID") 
;

CREATE INDEX "IXFK_ORDEN_CLIENTE02"   
 ON  "ORDEN" ("K_TIPO_ID_CALIF","K_NUMERO_ID_CALIF") 
;

CREATE INDEX "IXFK_ORDEN_INVENTARIO"   
 ON  "ORDEN" ("K_IDPRODUCTO","K_IDREGION") 
;

CREATE INDEX "IXFK_ORDEN_PERIODO"   
 ON  "ORDEN" ("K_IDPERIODO") 
;

ALTER TABLE  "PAIS" 
 ADD CONSTRAINT "PK_PAIS"
	PRIMARY KEY ("K_IDPAIS") 
 USING INDEX
;

ALTER TABLE  "PERIODO" 
 ADD CONSTRAINT "PK_PERIODO"
	PRIMARY KEY ("K_IDPERIODO") 
 USING INDEX
;

ALTER TABLE  "PERIODO" 
 ADD CONSTRAINT "CK_COMISION" CHECK (Q_COMISION > 0)
;

ALTER TABLE  "PERSONA" 
 ADD CONSTRAINT "PK_PERSONA"
	PRIMARY KEY ("K_TIPO_ID","K_NUMERO_ID") 
 USING INDEX
;

ALTER TABLE  "PERSONA" 
 ADD CONSTRAINT "CK_P_TIPO_ID" CHECK (K_TIPO_ID IN ('TI', 'CC', 'NIT', 'CE', 'PAP'))
;

ALTER TABLE  "PERSONA" 
 ADD CONSTRAINT "CK_I_TIPO_ID" CHECK (I_TIPO_ID IN ('TI', 'CC', 'NIT', 'CE', 'PAP'))
;

ALTER TABLE  "PERSONA" 
 ADD CONSTRAINT "CK_P_NUMERO_ID" CHECK (K_NUMERO_ID > 0)
;

ALTER TABLE  "PERSONA" 
 ADD CONSTRAINT "CK_QP_NUMERO_ID" CHECK (Q_NUMERO_ID > 0)
;

ALTER TABLE  "PERSONA" 
 ADD CONSTRAINT "CK_Q_TELEFONO" CHECK (Q_TELEFONO > 0)
;

ALTER TABLE  "PRODUCTO" 
 ADD CONSTRAINT "PK_PRODUCTO"
	PRIMARY KEY ("K_IDPRODUCTO") 
 USING INDEX
;

CREATE INDEX "IXFK_PRODUCTO_CATEGORIA"   
 ON  "PRODUCTO" ("K_IDCATEGORIA") 
;

ALTER TABLE  "REGION" 
 ADD CONSTRAINT "PK_REGION"
	PRIMARY KEY ("K_IDREGION") 
 USING INDEX
;

CREATE INDEX "IXFK_REGION_PAIS"   
 ON  "REGION" ("K_IDPAIS") 
;

ALTER TABLE  "REPRESENTANTE_VENTAS" 
 ADD CONSTRAINT "PK_REP_VENTAS"
	PRIMARY KEY ("K_TIPO_ID","K_NUMERO_ID") 
 USING INDEX
;

ALTER TABLE  "REPRESENTANTE_VENTAS" 
 ADD CONSTRAINT "CK_KR_TIPO_ID" CHECK (K_TIPO_ID IN ('TI', 'CC', 'NIT', 'CE', 'PAP'))
;

ALTER TABLE  "REPRESENTANTE_VENTAS" 
 ADD CONSTRAINT "CK_TIPO_ID_JEFE" CHECK (K_TIPO_ID_JEFE IN ('TI', 'CC', 'NIT', 'CE', 'PAP'))
;

ALTER TABLE  "REPRESENTANTE_VENTAS" 
 ADD CONSTRAINT "CK_KR_NUMERO_ID" CHECK (K_NUMERO_ID > 0)
;

ALTER TABLE  "REPRESENTANTE_VENTAS" 
 ADD CONSTRAINT "CK_NUMERO_ID_JEFE" CHECK (K_NUMERO_ID_JEFE > 0)
;

ALTER TABLE  "REPRESENTANTE_VENTAS" 
 ADD CONSTRAINT "CK_TIPO" CHECK (I_TIPO IN ('BEGINNER', 'JUNIOR', 'SENIOR', 'MASTER'))
;

ALTER TABLE  "REPRESENTANTE_VENTAS" 
 ADD CONSTRAINT "CK_ESTADO_REP" CHECK (I_ESTADO IN ('ACTIVO', 'INACTIVO'))
;

CREATE INDEX "IXFK_REPRESENTANT_REPRESE01"   
 ON  "REPRESENTANTE_VENTAS" ("K_TIPO_ID_JEFE","K_NUMERO_ID_JEFE") 
;

/* Create Foreign Key Constraints */

ALTER TABLE  "CATEGORIA" 
 ADD CONSTRAINT "FK_CATEGORIA_CATEGORIA"
	FOREIGN KEY ("K_IDSUBCATEGORIA") REFERENCES  "CATEGORIA" ("K_IDCATEGORIA")
;

ALTER TABLE  "CLIENTE" 
 ADD CONSTRAINT "FK_CLIENTE_PERSONA"
	FOREIGN KEY ("K_TIPO_ID","K_NUMERO_ID") REFERENCES  "PERSONA" ("K_TIPO_ID","K_NUMERO_ID")
;

ALTER TABLE  "CLIENTE" 
 ADD CONSTRAINT "FK_CLIENTE_REPRESENTANTE_VE_01"
	FOREIGN KEY ("I_TIPO_ID_REP","Q_NUMERO_ID_REP") REFERENCES  "REPRESENTANTE_VENTAS" ("K_TIPO_ID","K_NUMERO_ID")
;

ALTER TABLE  "INVENTARIO" 
 ADD CONSTRAINT "FK_INVENTARIO_PRODUCTO"
	FOREIGN KEY ("K_IDPRODUCTO") REFERENCES  "PRODUCTO" ("K_IDPRODUCTO")
;

ALTER TABLE  "INVENTARIO" 
 ADD CONSTRAINT "FK_INVENTARIO_REGION"
	FOREIGN KEY ("K_IDREGION") REFERENCES  "REGION" ("K_IDREGION")
;

ALTER TABLE  "ORDEN" 
 ADD CONSTRAINT "FK_ORDEN_CLIENTE"
	FOREIGN KEY ("K_TIPO_ID","K_NUMERO_ID") REFERENCES  "CLIENTE" ("K_TIPO_ID","K_NUMERO_ID")
;

ALTER TABLE  "ORDEN" 
 ADD CONSTRAINT "FK_ORDEN_CLIENTE02"
	FOREIGN KEY ("K_TIPO_ID_CALIF","K_NUMERO_ID_CALIF") REFERENCES  "CLIENTE" ("K_TIPO_ID","K_NUMERO_ID")
;

ALTER TABLE  "ORDEN" 
 ADD CONSTRAINT "FK_ORDEN_INVENTARIO"
	FOREIGN KEY ("K_IDPRODUCTO","K_IDREGION") REFERENCES  "INVENTARIO" ("K_IDPRODUCTO","K_IDREGION")
;

ALTER TABLE  "ORDEN" 
 ADD CONSTRAINT "FK_ORDEN_PERIODO"
	FOREIGN KEY ("K_IDPERIODO") REFERENCES  "PERIODO" ("K_IDPERIODO")
;

ALTER TABLE  "PRODUCTO" 
 ADD CONSTRAINT "FK_PRODUCTO_CATEGORIA"
	FOREIGN KEY ("K_IDCATEGORIA") REFERENCES  "CATEGORIA" ("K_IDCATEGORIA")
;

ALTER TABLE  "REGION" 
 ADD CONSTRAINT "FK_REGION_PAIS"
	FOREIGN KEY ("K_IDPAIS") REFERENCES  "PAIS" ("K_IDPAIS")
;

ALTER TABLE  "REPRESENTANTE_VENTAS" 
 ADD CONSTRAINT "FK_REPRESENTANT_REPRESENTAN_01"
	FOREIGN KEY ("K_TIPO_ID_JEFE","K_NUMERO_ID_JEFE") REFERENCES  "REPRESENTANTE_VENTAS" ("K_TIPO_ID","K_NUMERO_ID")
;

ALTER TABLE  "REPRESENTANTE_VENTAS" 
 ADD CONSTRAINT "FK_REPRESENTANTE_VE_PERSONA_01"
	FOREIGN KEY ("K_TIPO_ID","K_NUMERO_ID") REFERENCES  "PERSONA" ("K_TIPO_ID","K_NUMERO_ID")
;