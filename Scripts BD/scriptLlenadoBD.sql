INSERT INTO PAIS (K_IDPAIS,N_NOMBRE) VALUES (1,'Colombia');

INSERT INTO REGION (K_IDREGION, K_IDPAIS, N_NOMBRE) VALUES (1,1,'Caribe');
INSERT INTO REGION (K_IDREGION, K_IDPAIS, N_NOMBRE) VALUES (2,1,'Pacifica');
INSERT INTO REGION (K_IDREGION, K_IDPAIS, N_NOMBRE) VALUES (3,1,'Andina');
INSERT INTO REGION (K_IDREGION, K_IDPAIS, N_NOMBRE) VALUES (4,1,'Llanos Orientales');
INSERT INTO REGION (K_IDREGION, K_IDPAIS, N_NOMBRE) VALUES (5,1,'Amazonia');

INSERT INTO CATEGORIA (K_IDCATEGORIA, N_NOMBRE) VALUES (1,'Cuidado personal');
INSERT INTO CATEGORIA (K_IDCATEGORIA, N_NOMBRE) VALUES (2,'Nutricion');
INSERT INTO CATEGORIA (K_IDCATEGORIA, N_NOMBRE) VALUES (3,'Belleza');
INSERT INTO CATEGORIA (K_IDCATEGORIA, N_NOMBRE) VALUES (4,'Hogar');

INSERT INTO CATEGORIA (K_IDCATEGORIA, K_IDSUBCATEGORIA, N_NOMBRE) VALUES (5,4,'Lavanderia');
INSERT INTO CATEGORIA (K_IDCATEGORIA, K_IDSUBCATEGORIA, N_NOMBRE) VALUES (6,4,'Limpieza de pisos');
INSERT INTO CATEGORIA (K_IDCATEGORIA, K_IDSUBCATEGORIA, N_NOMBRE) VALUES (7,4,'Desinfectantes');

INSERT INTO PRODUCTO (K_IDPRODUCTO, K_IDCATEGORIA, N_NOMBRE, N_URLIMAGEN) VALUES (1,3,'Base De Maquillaje', 'https://res.cloudinary.com/dn1k0drir/image/upload/v1680046116/Imagenes/1_cvaq9v.png');
INSERT INTO PRODUCTO (K_IDPRODUCTO, K_IDCATEGORIA, N_NOMBRE, N_URLIMAGEN) VALUES (2,3,'Balsamo Labial', 'https://res.cloudinary.com/dn1k0drir/image/upload/v1680046116/Imagenes/2_daiwxs.png');
INSERT INTO PRODUCTO (K_IDPRODUCTO, K_IDCATEGORIA, N_NOMBRE, N_URLIMAGEN) VALUES (3,3,'Lapiz Labial', 'https://res.cloudinary.com/dn1k0drir/image/upload/v1680046117/Imagenes/3_mwcadu.png');
INSERT INTO PRODUCTO (K_IDPRODUCTO, K_IDCATEGORIA, N_NOMBRE, N_URLIMAGEN) VALUES (4,1,'Jabon Exfoliante', 'https://res.cloudinary.com/dn1k0drir/image/upload/v1680046117/Imagenes/4_cirptp.png');
INSERT INTO PRODUCTO (K_IDPRODUCTO, K_IDCATEGORIA, N_NOMBRE, N_URLIMAGEN) VALUES (5,1,'Mascarilla De Arcilla', 'https://res.cloudinary.com/dn1k0drir/image/upload/v1680046118/Imagenes/5_hidpuh.png');
INSERT INTO PRODUCTO (K_IDPRODUCTO, K_IDCATEGORIA, N_NOMBRE, N_URLIMAGEN) VALUES (6,1,'Shampoo Solido', 'https://res.cloudinary.com/dn1k0drir/image/upload/v1680046117/Imagenes/6_kpwzpb.png');
INSERT INTO PRODUCTO (K_IDPRODUCTO, K_IDCATEGORIA, N_NOMBRE, N_URLIMAGEN) VALUES (7,2,'Cereal Fiesta', 'https://res.cloudinary.com/dn1k0drir/image/upload/v1680046118/Imagenes/7_t6oqbx.png');
INSERT INTO PRODUCTO (K_IDPRODUCTO, K_IDCATEGORIA, N_NOMBRE, N_URLIMAGEN) VALUES (8,2,'Galletas De Arroz', 'https://res.cloudinary.com/dn1k0drir/image/upload/v1680046117/Imagenes/8_asxiit.png');
INSERT INTO PRODUCTO (K_IDPRODUCTO, K_IDCATEGORIA, N_NOMBRE, N_URLIMAGEN) VALUES (9,2,'Crema De Mani Natural', 'https://res.cloudinary.com/dn1k0drir/image/upload/v1680046117/Imagenes/9_kicr7i.png');
INSERT INTO PRODUCTO (K_IDPRODUCTO, K_IDCATEGORIA, N_NOMBRE, N_URLIMAGEN) VALUES (10,6,'Limpiador De Pisos Ecologico', 'https://res.cloudinary.com/dn1k0drir/image/upload/v1680046115/Imagenes/10_lipykl.png');
INSERT INTO PRODUCTO (K_IDPRODUCTO, K_IDCATEGORIA, N_NOMBRE, N_URLIMAGEN) VALUES (11,6,'Escoba Task Ecologica', 'https://res.cloudinary.com/dn1k0drir/image/upload/v1680046116/Imagenes/11_mup2er.png');
INSERT INTO PRODUCTO (K_IDPRODUCTO, K_IDCATEGORIA, N_NOMBRE, N_URLIMAGEN) VALUES (12,6,'Trapero Microfibras Ecologico', 'https://res.cloudinary.com/dn1k0drir/image/upload/v1680046116/Imagenes/12_dnq2ng.png');
INSERT INTO PRODUCTO (K_IDPRODUCTO, K_IDCATEGORIA, N_NOMBRE, N_URLIMAGEN) VALUES (13,5,'Detergente Ecologico', 'https://res.cloudinary.com/dn1k0drir/image/upload/v1680046115/Imagenes/13_r6jrt4.png');
INSERT INTO PRODUCTO (K_IDPRODUCTO, K_IDCATEGORIA, N_NOMBRE, N_URLIMAGEN) VALUES (14,5,'Detergente En Polvo Ropa Color', 'https://res.cloudinary.com/dn1k0drir/image/upload/v1680046116/Imagenes/14_wrxjpx.png');
INSERT INTO PRODUCTO (K_IDPRODUCTO, K_IDCATEGORIA, N_NOMBRE, N_URLIMAGEN) VALUES (15,5,'Soapnuts en cascara', 'https://res.cloudinary.com/dn1k0drir/image/upload/v1680046116/Imagenes/15_dpuehh.png');
INSERT INTO PRODUCTO (K_IDPRODUCTO, K_IDCATEGORIA, N_NOMBRE, N_URLIMAGEN) VALUES (16,7,'Desinfectante Natural', 'https://res.cloudinary.com/dn1k0drir/image/upload/v1680046116/Imagenes/16_r0sfzu.png');
INSERT INTO PRODUCTO (K_IDPRODUCTO, K_IDCATEGORIA, N_NOMBRE, N_URLIMAGEN) VALUES (17,7,'Gel Antibacterial', 'https://res.cloudinary.com/dn1k0drir/image/upload/v1680046116/Imagenes/17_ysmbrs.png');
INSERT INTO PRODUCTO (K_IDPRODUCTO, K_IDCATEGORIA, N_NOMBRE, N_URLIMAGEN) VALUES (18,7,'Ambientador Noche', 'https://res.cloudinary.com/dn1k0drir/image/upload/v1680046116/Imagenes/18_gzsvku.png');

--Region Andina
INSERT INTO INVENTARIO (K_IDPRODUCTO,K_IDREGION,Q_STOCK,V_PRECIOPRODUCTO) VALUES (1,3,50,50000);
INSERT INTO INVENTARIO (K_IDPRODUCTO,K_IDREGION,Q_STOCK,V_PRECIOPRODUCTO) VALUES (2,3,55,12000);
INSERT INTO INVENTARIO (K_IDPRODUCTO,K_IDREGION,Q_STOCK,V_PRECIOPRODUCTO) VALUES (3,3,57,8000);
INSERT INTO INVENTARIO (K_IDPRODUCTO,K_IDREGION,Q_STOCK,V_PRECIOPRODUCTO) VALUES (4,3,30,4000);
INSERT INTO INVENTARIO (K_IDPRODUCTO,K_IDREGION,Q_STOCK,V_PRECIOPRODUCTO) VALUES (5,3,20,15000);
INSERT INTO INVENTARIO (K_IDPRODUCTO,K_IDREGION,Q_STOCK,V_PRECIOPRODUCTO) VALUES (6,3,54,20000);
INSERT INTO INVENTARIO (K_IDPRODUCTO,K_IDREGION,Q_STOCK,V_PRECIOPRODUCTO) VALUES (7,3,80,35000);
INSERT INTO INVENTARIO (K_IDPRODUCTO,K_IDREGION,Q_STOCK,V_PRECIOPRODUCTO) VALUES (8,3,10,25000);
INSERT INTO INVENTARIO (K_IDPRODUCTO,K_IDREGION,Q_STOCK,V_PRECIOPRODUCTO) VALUES (9,3,90,40000);
INSERT INTO INVENTARIO (K_IDPRODUCTO,K_IDREGION,Q_STOCK,V_PRECIOPRODUCTO) VALUES (10,3,20,55000);
INSERT INTO INVENTARIO (K_IDPRODUCTO,K_IDREGION,Q_STOCK,V_PRECIOPRODUCTO) VALUES (11,3,30,13000);
INSERT INTO INVENTARIO (K_IDPRODUCTO,K_IDREGION,Q_STOCK,V_PRECIOPRODUCTO) VALUES (12,3,40,6000);
INSERT INTO INVENTARIO (K_IDPRODUCTO,K_IDREGION,Q_STOCK,V_PRECIOPRODUCTO) VALUES (13,3,32,28000);
INSERT INTO INVENTARIO (K_IDPRODUCTO,K_IDREGION,Q_STOCK,V_PRECIOPRODUCTO) VALUES (14,3,53,47000);
INSERT INTO INVENTARIO (K_IDPRODUCTO,K_IDREGION,Q_STOCK,V_PRECIOPRODUCTO) VALUES (15,3,51,39000);
INSERT INTO INVENTARIO (K_IDPRODUCTO,K_IDREGION,Q_STOCK,V_PRECIOPRODUCTO) VALUES (16,3,10,42000);
INSERT INTO INVENTARIO (K_IDPRODUCTO,K_IDREGION,Q_STOCK,V_PRECIOPRODUCTO) VALUES (17,3,20,31000);
INSERT INTO INVENTARIO (K_IDPRODUCTO,K_IDREGION,Q_STOCK,V_PRECIOPRODUCTO) VALUES (18,3,36,29000);

--Region caribe
INSERT INTO INVENTARIO (K_IDPRODUCTO,K_IDREGION,Q_STOCK,V_PRECIOPRODUCTO) VALUES (1,1,30,50000);
INSERT INTO INVENTARIO (K_IDPRODUCTO,K_IDREGION,Q_STOCK,V_PRECIOPRODUCTO) VALUES (4,1,80,4000);
INSERT INTO INVENTARIO (K_IDPRODUCTO,K_IDREGION,Q_STOCK,V_PRECIOPRODUCTO) VALUES (5,1,70,15000);
INSERT INTO INVENTARIO (K_IDPRODUCTO,K_IDREGION,Q_STOCK,V_PRECIOPRODUCTO) VALUES (6,1,95,20000);
INSERT INTO INVENTARIO (K_IDPRODUCTO,K_IDREGION,Q_STOCK,V_PRECIOPRODUCTO) VALUES (7,1,80,35000);
INSERT INTO INVENTARIO (K_IDPRODUCTO,K_IDREGION,Q_STOCK,V_PRECIOPRODUCTO) VALUES (11,1,30,13000);
INSERT INTO INVENTARIO (K_IDPRODUCTO,K_IDREGION,Q_STOCK,V_PRECIOPRODUCTO) VALUES (12,1,40,6000);
INSERT INTO INVENTARIO (K_IDPRODUCTO,K_IDREGION,Q_STOCK,V_PRECIOPRODUCTO) VALUES (15,1,51,39000);
INSERT INTO INVENTARIO (K_IDPRODUCTO,K_IDREGION,Q_STOCK,V_PRECIOPRODUCTO) VALUES (18,1,36,29000);

--Region del pacifico
INSERT INTO INVENTARIO (K_IDPRODUCTO,K_IDREGION,Q_STOCK,V_PRECIOPRODUCTO) VALUES (2,2,55,12000);
INSERT INTO INVENTARIO (K_IDPRODUCTO,K_IDREGION,Q_STOCK,V_PRECIOPRODUCTO) VALUES (3,2,57,8000);
INSERT INTO INVENTARIO (K_IDPRODUCTO,K_IDREGION,Q_STOCK,V_PRECIOPRODUCTO) VALUES (5,2,20,15000);
INSERT INTO INVENTARIO (K_IDPRODUCTO,K_IDREGION,Q_STOCK,V_PRECIOPRODUCTO) VALUES (7,2,80,35000);
INSERT INTO INVENTARIO (K_IDPRODUCTO,K_IDREGION,Q_STOCK,V_PRECIOPRODUCTO) VALUES (9,2,90,40000);
INSERT INTO INVENTARIO (K_IDPRODUCTO,K_IDREGION,Q_STOCK,V_PRECIOPRODUCTO) VALUES (10,2,20,55000);
INSERT INTO INVENTARIO (K_IDPRODUCTO,K_IDREGION,Q_STOCK,V_PRECIOPRODUCTO) VALUES (11,2,30,13000);
INSERT INTO INVENTARIO (K_IDPRODUCTO,K_IDREGION,Q_STOCK,V_PRECIOPRODUCTO) VALUES (13,2,32,28000);
INSERT INTO INVENTARIO (K_IDPRODUCTO,K_IDREGION,Q_STOCK,V_PRECIOPRODUCTO) VALUES (15,2,51,39000);
INSERT INTO INVENTARIO (K_IDPRODUCTO,K_IDREGION,Q_STOCK,V_PRECIOPRODUCTO) VALUES (18,2,36,29000);

--Region del llano
INSERT INTO INVENTARIO (K_IDPRODUCTO,K_IDREGION,Q_STOCK,V_PRECIOPRODUCTO) VALUES (1,4,50,50000);
INSERT INTO INVENTARIO (K_IDPRODUCTO,K_IDREGION,Q_STOCK,V_PRECIOPRODUCTO) VALUES (2,4,55,12000);
INSERT INTO INVENTARIO (K_IDPRODUCTO,K_IDREGION,Q_STOCK,V_PRECIOPRODUCTO) VALUES (3,4,57,8000);
INSERT INTO INVENTARIO (K_IDPRODUCTO,K_IDREGION,Q_STOCK,V_PRECIOPRODUCTO) VALUES (4,4,30,4000);
INSERT INTO INVENTARIO (K_IDPRODUCTO,K_IDREGION,Q_STOCK,V_PRECIOPRODUCTO) VALUES (7,4,80,35000);
INSERT INTO INVENTARIO (K_IDPRODUCTO,K_IDREGION,Q_STOCK,V_PRECIOPRODUCTO) VALUES (8,4,10,25000);
INSERT INTO INVENTARIO (K_IDPRODUCTO,K_IDREGION,Q_STOCK,V_PRECIOPRODUCTO) VALUES (10,4,20,55000);
INSERT INTO INVENTARIO (K_IDPRODUCTO,K_IDREGION,Q_STOCK,V_PRECIOPRODUCTO) VALUES (12,4,40,6000);
INSERT INTO INVENTARIO (K_IDPRODUCTO,K_IDREGION,Q_STOCK,V_PRECIOPRODUCTO) VALUES (13,4,32,28000);
INSERT INTO INVENTARIO (K_IDPRODUCTO,K_IDREGION,Q_STOCK,V_PRECIOPRODUCTO) VALUES (14,4,53,47000);
INSERT INTO INVENTARIO (K_IDPRODUCTO,K_IDREGION,Q_STOCK,V_PRECIOPRODUCTO) VALUES (16,4,10,42000);

--Region amazonas
INSERT INTO INVENTARIO (K_IDPRODUCTO,K_IDREGION,Q_STOCK,V_PRECIOPRODUCTO) VALUES (1,5,50,50000);
INSERT INTO INVENTARIO (K_IDPRODUCTO,K_IDREGION,Q_STOCK,V_PRECIOPRODUCTO) VALUES (4,5,30,4000);
INSERT INTO INVENTARIO (K_IDPRODUCTO,K_IDREGION,Q_STOCK,V_PRECIOPRODUCTO) VALUES (7,5,80,35000);
INSERT INTO INVENTARIO (K_IDPRODUCTO,K_IDREGION,Q_STOCK,V_PRECIOPRODUCTO) VALUES (10,5,20,55000);
INSERT INTO INVENTARIO (K_IDPRODUCTO,K_IDREGION,Q_STOCK,V_PRECIOPRODUCTO) VALUES (13,5,32,28000);
INSERT INTO INVENTARIO (K_IDPRODUCTO,K_IDREGION,Q_STOCK,V_PRECIOPRODUCTO) VALUES (16,5,10,42000);

INSERT INTO PERIODO (K_IDPERIODO, F_FECHAINICIO,F_FECHAFIN) VALUES ('2022-2',TO_DATE('01/06/2022','DD/MM/YYYY'),TO_DATE('31/12/2022','DD/MM/YYYY'));
INSERT INTO PERIODO (K_IDPERIODO, F_FECHAINICIO,F_FECHAFIN) VALUES ('2023-1',TO_DATE('01/01/2023','DD/MM/YYYY'),TO_DATE('30/06/2023','DD/MM/YYYY'));

--Inserci�n de R.V
--R.v que manejan el inventario de llanos 
INSERT INTO REPRESENTANTE_VENTAS (K_TIPO_ID,K_NUMERO_ID,K_TIPO_ID_JEFE,K_NUMERO_ID_JEFE,N_NOMBRECOMPLETO,I_TIPO_ID_REP,Q_NUMERO_ID_REP,N_APELLIDOCOMPLETO,F_FECHACREACION,O_EMAIL,Q_TELEFONO,N_REGION,I_GENERO,O_PASSWORD,F_NACIMIENTO,O_DIRECCION,I_TIPO,F_FECHACONTRATO,N_USERNAME,I_ESTADO)
VALUES ('CC',3213213, NULL,NULL,'Abraham', NULL, NULL,'Van Helsing', TO_DATE('03/02/2019', 'DD-MM-YYYY'),'ajoslover@helsing.com.ne',1212121,'Llanos Orientales', 'M','estaca', TO_DATE('13/06/1950', 'DD-MM-YYYY'),'Cl. 23 #22-72','MASTER', TO_DATE('06/09/2021', 'DD-MM-YYYY'),'masterLlanos' , 'ACTIVO');

INSERT INTO REPRESENTANTE_VENTAS (K_TIPO_ID,K_NUMERO_ID,K_TIPO_ID_JEFE,K_NUMERO_ID_JEFE,N_NOMBRECOMPLETO,I_TIPO_ID_REP,Q_NUMERO_ID_REP,N_APELLIDOCOMPLETO,F_FECHACREACION,O_EMAIL,Q_TELEFONO,N_REGION,I_GENERO,O_PASSWORD,F_NACIMIENTO,O_DIRECCION,I_TIPO,F_FECHACONTRATO,N_USERNAME,I_ESTADO)
VALUES ('CC',987654321, 'CC' ,3213213,'Howard Phillips','CC', 3213213,'Lovecraft', TO_DATE('23/06/2020', 'DD-MM-YYYY'),'chtulhu@exterior.com',21247748,'Llanos Orientales', 'M','desconocido', TO_DATE('20/10/1090', 'DD-MM-YYYY'),'Cra. 33a #18-2','SENIOR', TO_DATE('12/11/2021', 'DD-MM-YYYY'),'seniorLlanos' , 'ACTIVO');

INSERT INTO REPRESENTANTE_VENTAS (K_TIPO_ID,K_NUMERO_ID,K_TIPO_ID_JEFE,K_NUMERO_ID_JEFE,N_NOMBRECOMPLETO,I_TIPO_ID_REP,Q_NUMERO_ID_REP,N_APELLIDOCOMPLETO,F_FECHACREACION,O_EMAIL,Q_TELEFONO,N_REGION,I_GENERO,O_PASSWORD,F_NACIMIENTO,O_DIRECCION,I_TIPO,F_FECHACONTRATO,N_USERNAME,I_ESTADO)
VALUES ('CC',5555559, 'CC' ,987654321,'Stephen Edwin','CC', 3213213,'King', TO_DATE('23/06/2020', 'DD-MM-YYYY'),'nose@blabla.com',9999996,'Llanos Orientales', 'M','lacosa', TO_DATE('27/09/1947', 'DD-MM-YYYY'),'Cra. 36 #23-121','JUNIOR', TO_DATE('23/12/2021', 'DD-MM-YYYY'),'juniorLlanos' , 'ACTIVO');

INSERT INTO REPRESENTANTE_VENTAS (K_TIPO_ID,K_NUMERO_ID,K_TIPO_ID_JEFE,K_NUMERO_ID_JEFE,N_NOMBRECOMPLETO,I_TIPO_ID_REP,Q_NUMERO_ID_REP,N_APELLIDOCOMPLETO,F_FECHACREACION,O_EMAIL,Q_TELEFONO,N_REGION,I_GENERO,O_PASSWORD,F_NACIMIENTO,O_DIRECCION,I_TIPO,F_FECHACONTRATO,N_USERNAME,I_ESTADO)
VALUES ('CE',123456789, 'CC' ,5555559,'Juan Perez','CC', 3213213,'Garc�a', TO_DATE('01/01/2022', 'DD-MM-YYYY'),'juan.perez@email.com',3057379187,'Llanos Orientales', 'M','mypassword', TO_DATE('01/01/1990', 'DD-MM-YYYY'),'Calle 123 # 45-67','BEGINNER', TO_DATE('16/03/2022', 'DD-MM-YYYY'),'beginnerLlanos' , 'ACTIVO');

--R.V de amazonia
INSERT INTO REPRESENTANTE_VENTAS (K_TIPO_ID,K_NUMERO_ID,K_TIPO_ID_JEFE,K_NUMERO_ID_JEFE,N_NOMBRECOMPLETO,I_TIPO_ID_REP,Q_NUMERO_ID_REP,N_APELLIDOCOMPLETO,F_FECHACREACION,O_EMAIL,Q_TELEFONO,N_REGION,I_GENERO,O_PASSWORD,F_NACIMIENTO,O_DIRECCION,I_TIPO,F_FECHACONTRATO,N_USERNAME,I_ESTADO)
VALUES ('CC',9999969, NULL,NULL,'Vlad',NULL,NULL,'Tepes', TO_DATE('03/02/2019', 'DD-MM-YYYY'),'soydracula@valaquia.com.ro',6262626,'Amazonia', 'M','adivina', TO_DATE('26/06/1931', 'DD-MM-YYYY'),'Cra. 11 #9-43','MASTER', TO_DATE('05/09/2021', 'DD-MM-YYYY'),'masterAmazonas' , 'ACTIVO');

INSERT INTO REPRESENTANTE_VENTAS (K_TIPO_ID,K_NUMERO_ID,K_TIPO_ID_JEFE,K_NUMERO_ID_JEFE,N_NOMBRECOMPLETO,I_TIPO_ID_REP,Q_NUMERO_ID_REP,N_APELLIDOCOMPLETO,F_FECHACREACION,O_EMAIL,Q_TELEFONO,N_REGION,I_GENERO,O_PASSWORD,F_NACIMIENTO,O_DIRECCION,I_TIPO,F_FECHACONTRATO,N_USERNAME,I_ESTADO)
VALUES ('CC',123098763, 'CC',9999969,'Daniel','CC',9999969,'Pardo', TO_DATE('03/02/2022', 'DD-MM-YYYY'),'daniel.pardo@email.com',3112759504,'Amazonia', 'M','mypassword', TO_DATE('24/06/1990', 'DD-MM-YYYY'),'Calle 26 # 23-7','SENIOR', TO_DATE('05/09/2022', 'DD-MM-YYYY'),'seniorAmazonas' , 'ACTIVO');

INSERT INTO REPRESENTANTE_VENTAS (K_TIPO_ID,K_NUMERO_ID,K_TIPO_ID_JEFE,K_NUMERO_ID_JEFE,N_NOMBRECOMPLETO,I_TIPO_ID_REP,Q_NUMERO_ID_REP,N_APELLIDOCOMPLETO,F_FECHACREACION,O_EMAIL,Q_TELEFONO,N_REGION,I_GENERO,O_PASSWORD,F_NACIMIENTO,O_DIRECCION,I_TIPO,F_FECHACONTRATO,N_USERNAME,I_ESTADO)
VALUES ('CC',83088903, 'CC',123098763,'Nelson','CC',9999969,'Jimenez', TO_DATE('03/03/2022', 'DD-MM-YYYY'),'nelson.jimenez@email.com',1010060672,'Amazonia', 'M','mypassword', TO_DATE('27/07/1990', 'DD-MM-YYYY'),'Calle 26 # 24-7','JUNIOR', TO_DATE('05/10/2022', 'DD-MM-YYYY'),'juniorAmazonas' , 'ACTIVO');

INSERT INTO REPRESENTANTE_VENTAS (K_TIPO_ID,K_NUMERO_ID,K_TIPO_ID_JEFE,K_NUMERO_ID_JEFE,N_NOMBRECOMPLETO,I_TIPO_ID_REP,Q_NUMERO_ID_REP,N_APELLIDOCOMPLETO,F_FECHACREACION,O_EMAIL,Q_TELEFONO,N_REGION,I_GENERO,O_PASSWORD,F_NACIMIENTO,O_DIRECCION,I_TIPO,F_FECHACONTRATO,N_USERNAME,I_ESTADO)
VALUES ('CC',530551232, 'CC',83088903,'Claudia','CC',9999969,'Rodriguez', TO_DATE('03/08/2022', 'DD-MM-YYYY'),'claudia.avila@email.com',3112759504,'Amazonia', 'F','mypassword', TO_DATE('31/12/1990', 'DD-MM-YYYY'),'Carrera 12 #43-12','BEGINNER', TO_DATE('05/12/2022', 'DD-MM-YYYY'),'begginerAmazonas' , 'ACTIVO');

--R.V DEL CARIBE

INSERT INTO REPRESENTANTE_VENTAS (K_TIPO_ID,K_NUMERO_ID,K_TIPO_ID_JEFE,K_NUMERO_ID_JEFE,N_NOMBRECOMPLETO,I_TIPO_ID_REP,Q_NUMERO_ID_REP,N_APELLIDOCOMPLETO,F_FECHACREACION,O_EMAIL,Q_TELEFONO,N_REGION,I_GENERO,O_PASSWORD,F_NACIMIENTO,O_DIRECCION,I_TIPO,F_FECHACONTRATO,N_USERNAME,I_ESTADO)
VALUES ('CC',753753, NULL,NULL,'Ritcher',NULL,NULL,'Belmont', TO_DATE('09/02/2019', 'DD-MM-YYYY'),'latigoslover@belmont.com.ro',987987,'Caribe', 'M','latigo', TO_DATE('13/06/1973', 'DD-MM-YYYY'),'Cra. 44 #30a-91','MASTER', TO_DATE('08/09/2021', 'DD-MM-YYYY'),'masterCaribe' , 'ACTIVO');

INSERT INTO REPRESENTANTE_VENTAS (K_TIPO_ID,K_NUMERO_ID,K_TIPO_ID_JEFE,K_NUMERO_ID_JEFE,N_NOMBRECOMPLETO,I_TIPO_ID_REP,Q_NUMERO_ID_REP,N_APELLIDOCOMPLETO,F_FECHACREACION,O_EMAIL,Q_TELEFONO,N_REGION,I_GENERO,O_PASSWORD,F_NACIMIENTO,O_DIRECCION,I_TIPO,F_FECHACONTRATO,N_USERNAME,I_ESTADO)
VALUES ('CE',1233906543, 'CC',753753,'Andres','CC',753753,'Sanabria Arias', TO_DATE('09/02/2022', 'DD-MM-YYYY'),'andres@gmail.com',3152294643,'Caribe', 'M','contra123', TO_DATE('13/06/1999', 'DD-MM-YYYY'),'Cra. 62 #30-21','SENIOR', TO_DATE('08/10/2021', 'DD-MM-YYYY'),'seniorCaribe' , 'ACTIVO');

INSERT INTO REPRESENTANTE_VENTAS (K_TIPO_ID,K_NUMERO_ID,K_TIPO_ID_JEFE,K_NUMERO_ID_JEFE,N_NOMBRECOMPLETO,I_TIPO_ID_REP,Q_NUMERO_ID_REP,N_APELLIDOCOMPLETO,F_FECHACREACION,O_EMAIL,Q_TELEFONO,N_REGION,I_GENERO,O_PASSWORD,F_NACIMIENTO,O_DIRECCION,I_TIPO,F_FECHACONTRATO,N_USERNAME,I_ESTADO)
VALUES ('CC',5239545, 'CE',1233906543,'Diana','CC',753753,'Hernandez', TO_DATE('19/06/2022', 'DD-MM-YYYY'),'diana@gmail.com',3152294743,'Caribe', 'F','contras123', TO_DATE('13/06/1989', 'DD-MM-YYYY'),'Cra. 122 #30-21','JUNIOR', TO_DATE('28/10/2021', 'DD-MM-YYYY'),'juniorCaribe' , 'ACTIVO');

INSERT INTO REPRESENTANTE_VENTAS (K_TIPO_ID,K_NUMERO_ID,K_TIPO_ID_JEFE,K_NUMERO_ID_JEFE,N_NOMBRECOMPLETO,I_TIPO_ID_REP,Q_NUMERO_ID_REP,N_APELLIDOCOMPLETO,F_FECHACREACION,O_EMAIL,Q_TELEFONO,N_REGION,I_GENERO,O_PASSWORD,F_NACIMIENTO,O_DIRECCION,I_TIPO,F_FECHACONTRATO,N_USERNAME,I_ESTADO)
VALUES ('CC',809993423, 'CC',5239545,'Lyda','CC',753753,'Rico', TO_DATE('19/07/2022', 'DD-MM-YYYY'),'lyda@gmail.com',3152223743,'Caribe', 'F','contras1234', TO_DATE('12/06/1979', 'DD-MM-YYYY'),'Cra. 2 #30-21','BEGINNER', TO_DATE('28/11/2021', 'DD-MM-YYYY'),'begginerCaribe' , 'ACTIVO');


--R.V DEL PACIFICO

INSERT INTO REPRESENTANTE_VENTAS (K_TIPO_ID,K_NUMERO_ID,K_TIPO_ID_JEFE,K_NUMERO_ID_JEFE,N_NOMBRECOMPLETO,I_TIPO_ID_REP,Q_NUMERO_ID_REP,N_APELLIDOCOMPLETO,F_FECHACREACION,O_EMAIL,Q_TELEFONO,N_REGION,I_GENERO,O_PASSWORD,F_NACIMIENTO,O_DIRECCION,I_TIPO,F_FECHACONTRATO,N_USERNAME,I_ESTADO)
VALUES ('CC',11111111, NULL,NULL,'Cereza',NULL,NULL,'Bayonetta', TO_DATE('06/02/2019', 'DD-MM-YYYY'),'magia@kamiya.com.jp',15554225,'Pacafica', 'F','tiempo', TO_DATE('19/12/1981', 'DD-MM-YYYY'),'Cra. 1 #26a-1','MASTER', TO_DATE('13/09/2021', 'DD-MM-YYYY'),'masterPacifico' , 'ACTIVO');

INSERT INTO REPRESENTANTE_VENTAS (K_TIPO_ID,K_NUMERO_ID,K_TIPO_ID_JEFE,K_NUMERO_ID_JEFE,N_NOMBRECOMPLETO,I_TIPO_ID_REP,Q_NUMERO_ID_REP,N_APELLIDOCOMPLETO,F_FECHACREACION,O_EMAIL,Q_TELEFONO,N_REGION,I_GENERO,O_PASSWORD,F_NACIMIENTO,O_DIRECCION,I_TIPO,F_FECHACONTRATO,N_USERNAME,I_ESTADO)
VALUES ('CC',67584392, 'CC',11111111,'Java','CC',11111111,'Script', TO_DATE('06/08/2019', 'DD-MM-YYYY'),'js@kamiya.com',314225432,'Pacafica', 'M','luzcontra', TO_DATE('19/12/1995', 'DD-MM-YYYY'),'Cra. 31 #26a-1','SENIOR', TO_DATE('29/09/2021', 'DD-MM-YYYY'),'seniorPacifico' , 'ACTIVO');

INSERT INTO REPRESENTANTE_VENTAS (K_TIPO_ID,K_NUMERO_ID,K_TIPO_ID_JEFE,K_NUMERO_ID_JEFE,N_NOMBRECOMPLETO,I_TIPO_ID_REP,Q_NUMERO_ID_REP,N_APELLIDOCOMPLETO,F_FECHACREACION,O_EMAIL,Q_TELEFONO,N_REGION,I_GENERO,O_PASSWORD,F_NACIMIENTO,O_DIRECCION,I_TIPO,F_FECHACONTRATO,N_USERNAME,I_ESTADO)
VALUES ('CC',12312356, 'CC',67584392,'Swcith','CC',11111111,'Esteroide', TO_DATE('26/08/2019', 'DD-MM-YYYY'),'swa@gmail.com',3142225432,'Pacafica', 'F','porgrama', TO_DATE('19/02/1995', 'DD-MM-YYYY'),'Cra. 51 #26a-1','JUNIOR', TO_DATE('12/10/2021', 'DD-MM-YYYY'),'juniorPacifico' , 'ACTIVO');

INSERT INTO REPRESENTANTE_VENTAS (K_TIPO_ID,K_NUMERO_ID,K_TIPO_ID_JEFE,K_NUMERO_ID_JEFE,N_NOMBRECOMPLETO,I_TIPO_ID_REP,Q_NUMERO_ID_REP,N_APELLIDOCOMPLETO,F_FECHACREACION,O_EMAIL,Q_TELEFONO,N_REGION,I_GENERO,O_PASSWORD,F_NACIMIENTO,O_DIRECCION,I_TIPO,F_FECHACONTRATO,N_USERNAME,I_ESTADO)
VALUES ('CC',121312321, 'CC',12312356,'Luis','CC',11111111,'Ferreri', TO_DATE('26/09/2019', 'DD-MM-YYYY'),'VR@gmail.com',3141125432,'Pacafica', 'M','nocas', TO_DATE('19/03/1995', 'DD-MM-YYYY'),'Cra. 81 #26a-1','BEGINNER', TO_DATE('12/11/2021', 'DD-MM-YYYY'),'begginerPacifico' , 'ACTIVO');


---R.V DE LA REGION ANDINA
INSERT INTO REPRESENTANTE_VENTAS (K_TIPO_ID,K_NUMERO_ID,K_TIPO_ID_JEFE,K_NUMERO_ID_JEFE,N_NOMBRECOMPLETO,I_TIPO_ID_REP,Q_NUMERO_ID_REP,N_APELLIDOCOMPLETO,F_FECHACREACION,O_EMAIL,Q_TELEFONO,N_REGION,I_GENERO,O_PASSWORD,F_NACIMIENTO,O_DIRECCION,I_TIPO,F_FECHACONTRATO,N_USERNAME,I_ESTADO)
VALUES ('CC',123456789, NULL,NULL,'Edgar Allan',NULL,NULL,'Poe', TO_DATE('23/06/2020', 'DD-MM-YYYY'),'crow@usherhouse.com.ro',1651516516,'Andina', 'M','nuncamas', TO_DATE('19/01/1979', 'DD-MM-YYYY'),'Calle 133 #118-24','MASTER', TO_DATE('05/09/2021', 'DD-MM-YYYY'),'masterAndina' , 'ACTIVO');

INSERT INTO REPRESENTANTE_VENTAS (K_TIPO_ID,K_NUMERO_ID,K_TIPO_ID_JEFE,K_NUMERO_ID_JEFE,N_NOMBRECOMPLETO,I_TIPO_ID_REP,Q_NUMERO_ID_REP,N_APELLIDOCOMPLETO,F_FECHACREACION,O_EMAIL,Q_TELEFONO,N_REGION,I_GENERO,O_PASSWORD,F_NACIMIENTO,O_DIRECCION,I_TIPO,F_FECHACONTRATO,N_USERNAME,I_ESTADO)
VALUES ('CC',3431123, 'CC',123456789,'William','CC',123456789,'Ruiz', TO_DATE('13/07/2020', 'DD-MM-YYYY'),'distrital@gmail.com',312294654,'Andina', 'M','masnunca', TO_DATE('19/02/1999', 'DD-MM-YYYY'),'Calle 33 #18-24','SENIOR', TO_DATE('05/10/2021', 'DD-MM-YYYY'),'seniorAndina' , 'ACTIVO');

INSERT INTO REPRESENTANTE_VENTAS (K_TIPO_ID,K_NUMERO_ID,K_TIPO_ID_JEFE,K_NUMERO_ID_JEFE,N_NOMBRECOMPLETO,I_TIPO_ID_REP,Q_NUMERO_ID_REP,N_APELLIDOCOMPLETO,F_FECHACREACION,O_EMAIL,Q_TELEFONO,N_REGION,I_GENERO,O_PASSWORD,F_NACIMIENTO,O_DIRECCION,I_TIPO,F_FECHACONTRATO,N_USERNAME,I_ESTADO)
VALUES ('CC',24513211, 'CC',3431123,'Laura','CC',123456789,'Pedraza', TO_DATE('15/07/2020', 'DD-MM-YYYY'),'lau@gmail.com',314229542,'Andina', 'F','ingeniera', TO_DATE('19/02/2000', 'DD-MM-YYYY'),'Calle 36 #18-24','JUNIOR', TO_DATE('25/10/2021', 'DD-MM-YYYY'),'juniorAndina' , 'ACTIVO');

INSERT INTO REPRESENTANTE_VENTAS (K_TIPO_ID,K_NUMERO_ID,K_TIPO_ID_JEFE,K_NUMERO_ID_JEFE,N_NOMBRECOMPLETO,I_TIPO_ID_REP,Q_NUMERO_ID_REP,N_APELLIDOCOMPLETO,F_FECHACREACION,O_EMAIL,Q_TELEFONO,N_REGION,I_GENERO,O_PASSWORD,F_NACIMIENTO,O_DIRECCION,I_TIPO,F_FECHACONTRATO,N_USERNAME,I_ESTADO)
VALUES ('CC',123123421, 'CC',24513211,'Jack','CC',123456789,'Sol', TO_DATE('25/08/2020', 'DD-MM-YYYY'),'luna@gmail.com',3142295542,'Andina', 'M','ingeniero', TO_DATE('19/02/2000', 'DD-MM-YYYY'),'Carrera 80 #18-24','BEGINNER', TO_DATE('30/10/2021', 'DD-MM-YYYY'),'begginerAndina' , 'ACTIVO');

--INSERSCIOON CLIENTE

INSERT INTO CLIENTE (K_TIPO_ID,K_NUMERO_ID,K_TIPO_ID_REP,K_ID_NUMERO_REP,I_TIPO_ID_REP,Q_NUMERO_ID_REP,N_NOMBRECOMPLETO,N_APELLIDOCOMPLETO,F_FECHACREACION,O_EMAIL,Q_TELEFONO,N_CIUDAD,I_GENERO,O_PASSWORD,F_NACIMIENTO,O_DIRECCION,N_USERNAME)
VALUES('CC',78787878, 'CE', 123456789, 'CE', 123456789,'Olga','Kurylenko', TO_DATE('09/10/2020', 'DD-MM-YYYY'),'aaaa@aaaa.com',56656566,'Villavicencio','F','uoiea',TO_DATE('14/11/1979', 'DD-MM-YYYY'),'Cra. 56 #23-121','clienteLlanos');

INSERT INTO CLIENTE (K_TIPO_ID,K_NUMERO_ID,K_TIPO_ID_REP,K_ID_NUMERO_REP,I_TIPO_ID_REP,Q_NUMERO_ID_REP,N_NOMBRECOMPLETO,N_APELLIDOCOMPLETO,F_FECHACREACION,O_EMAIL,Q_TELEFONO,N_CIUDAD,I_GENERO,O_PASSWORD,F_NACIMIENTO,O_DIRECCION,N_USERNAME)
VALUES('CC',852963, 'CC', 530551232, 'CC', 530551232,'Ana','De Armas', TO_DATE('08/10/2020', 'DD-MM-YYYY'),'sue�o@blabla.com',87985653,'Leticia','F','aeiou',TO_DATE('10/04/1988', 'DD-MM-YYYY'),'Cra. 26 #3-121','clienteAmazonas');

INSERT INTO CLIENTE (K_TIPO_ID,K_NUMERO_ID,K_TIPO_ID_REP,K_ID_NUMERO_REP,I_TIPO_ID_REP,Q_NUMERO_ID_REP,N_NOMBRECOMPLETO,N_APELLIDOCOMPLETO,F_FECHACREACION,O_EMAIL,Q_TELEFONO,N_CIUDAD,I_GENERO,O_PASSWORD,F_NACIMIENTO,O_DIRECCION,N_USERNAME)
VALUES('CC',987654321, 'CC', 809993423, 'CC', 809993423,'Ana Maria','Garc�a', TO_DATE('02/01/2022', 'DD-MM-YYYY'),'ana.garcia@gmail.com',3129876543,'Barranquilla','F','password456',TO_DATE('10/12/1985', 'DD-MM-YYYY'),'Carrera 78 # 34 - 56','clienteCaribe');

INSERT INTO CLIENTE (K_TIPO_ID,K_NUMERO_ID,K_TIPO_ID_REP,K_ID_NUMERO_REP,I_TIPO_ID_REP,Q_NUMERO_ID_REP,N_NOMBRECOMPLETO,N_APELLIDOCOMPLETO,F_FECHACREACION,O_EMAIL,Q_TELEFONO,N_CIUDAD,I_GENERO,O_PASSWORD,F_NACIMIENTO,O_DIRECCION,N_USERNAME)
VALUES('CC',9876543210, 'CC', 121312321, 'CC', 121312321,'Carlos Torres','Gomez', TO_DATE('03/01/2022', 'DD-MM-YYYY'),'carlos.torres@gmail.com',3009876543,'Tado','M','password789',TO_DATE('23/12/1995', 'DD-MM-YYYY'),'Calle 10 # 20 - 30','clientePacifico');

INSERT INTO CLIENTE (K_TIPO_ID,K_NUMERO_ID,K_TIPO_ID_REP,K_ID_NUMERO_REP,I_TIPO_ID_REP,Q_NUMERO_ID_REP,N_NOMBRECOMPLETO,N_APELLIDOCOMPLETO,F_FECHACREACION,O_EMAIL,Q_TELEFONO,N_CIUDAD,I_GENERO,O_PASSWORD,F_NACIMIENTO,O_DIRECCION,N_USERNAME)
VALUES('CC',111111111, 'CC', 123123421, 'CC', 123123421,'Luisa Rodriguez','Perez', TO_DATE('04/01/2022', 'DD-MM-YYYY'),'luisa.rodriguez@gmail.com',3151111111,'Bogota','F','password101',TO_DATE('23/12/1998', 'DD-MM-YYYY'),'Carrera 50 # 30 - 10','clienteAndina');

INSERT INTO CLIENTE (K_TIPO_ID,K_NUMERO_ID,K_TIPO_ID_REP,K_ID_NUMERO_REP,I_TIPO_ID_REP,Q_NUMERO_ID_REP,N_NOMBRECOMPLETO,N_APELLIDOCOMPLETO,F_FECHACREACION,O_EMAIL,Q_TELEFONO,N_CIUDAD,I_GENERO,O_PASSWORD,F_NACIMIENTO,O_DIRECCION,N_USERNAME)
VALUES('CC',9876543211, 'CC', 123123421, 'CC', 123123421,'Andres Torres','Lopez', TO_DATE('05/01/2022', 'DD-MM-YYYY'),'andres.torres@gmail.com',3129876543,'Bogota','M','password111',TO_DATE('23/12/1993', 'DD-MM-YYYY'),'Calle 67 # 12 - 34','clienteAndino');

--INSERT ORDEN

-- Insertar registro
INSERT INTO ORDEN (K_IDORDEN,K_IDPRODUCTO,K_IDREGION,K_IDPERIODO,F_FECHAREGISTRO,I_ESTADO,K_TIPO_ID,K_NUMERO_ID,K_TIPO_ID_CALIF,K_NUMERO_ID_CALIF,Q_CALIFICACION,Q_CANTIDAD,I_TIPO_ID_REP,Q_NUMERO_ID_REP)
VALUES (1,1,3,'2023-1',TO_DATE('2023-03-16', 'YYYY-MM-DD'),'COMPLETADO','CC',111111111,'CC',111111111,4,4,'CC',123123421);

INSERT INTO ORDEN (K_IDORDEN,K_IDPRODUCTO,K_IDREGION,K_IDPERIODO,F_FECHAREGISTRO,I_ESTADO,K_TIPO_ID,K_NUMERO_ID,K_TIPO_ID_CALIF,K_NUMERO_ID_CALIF,Q_CALIFICACION,Q_CANTIDAD,I_TIPO_ID_REP,Q_NUMERO_ID_REP)
VALUES (2,7,2,'2023-1',TO_DATE('2023-03-24', 'YYYY-MM-DD'),'COMPLETADO','CC',9876543210,'CC',9876543210,5,10,'CC',121312321);

INSERT INTO ORDEN (K_IDORDEN,K_IDPRODUCTO,K_IDREGION,K_IDPERIODO,F_FECHAREGISTRO,I_ESTADO,K_TIPO_ID,K_NUMERO_ID,K_TIPO_ID_CALIF,K_NUMERO_ID_CALIF,Q_CALIFICACION,Q_CANTIDAD,I_TIPO_ID_REP,Q_NUMERO_ID_REP)
VALUES (3,12,1,'2023-1',TO_DATE('2023-03-25', 'YYYY-MM-DD'),'COMPLETADO','CC',987654321,'CC',987654321,3,5,'CC',809993423);

INSERT INTO ORDEN (K_IDORDEN,K_IDPRODUCTO,K_IDREGION,K_IDPERIODO,F_FECHAREGISTRO,I_ESTADO,K_TIPO_ID,K_NUMERO_ID,K_TIPO_ID_CALIF,K_NUMERO_ID_CALIF,Q_CALIFICACION,Q_CANTIDAD,I_TIPO_ID_REP,Q_NUMERO_ID_REP)
VALUES (4,16,5,'2023-1',TO_DATE('2023-03-26', 'YYYY-MM-DD'),'COMPLETADO','CC',852963,'CC',852963,2,2,'CC',530551232);

INSERT INTO ORDEN (K_IDORDEN,K_IDPRODUCTO,K_IDREGION,K_IDPERIODO,F_FECHAREGISTRO,I_ESTADO,K_TIPO_ID,K_NUMERO_ID,K_TIPO_ID_CALIF,K_NUMERO_ID_CALIF,Q_CALIFICACION,Q_CANTIDAD,I_TIPO_ID_REP,Q_NUMERO_ID_REP)
VALUES (5,13,4,'2023-1',TO_DATE('2023-03-27', 'YYYY-MM-DD'),'COMPLETADO','CC',78787878,'CC',78787878,4,6,'CC',123456789);

