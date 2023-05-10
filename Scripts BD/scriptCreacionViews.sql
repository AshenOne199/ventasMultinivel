DROP VIEW VISTAUSERS;
CREATE VIEW VISTAUSERS AS
SELECT RV.N_USERNAME, RV.O_PASSWORD, RV.I_ESTADO,'REPRESENTANTE MASTER' AS ROL 
FROM REPRESENTANTE_VENTAS RV
WHERE RV.I_TIPO = 'MASTER'
UNION
SELECT RV.N_USERNAME, RV.O_PASSWORD, RV.I_ESTADO,'REPRESENTANTE' AS ROL 
FROM REPRESENTANTE_VENTAS RV
WHERE RV.I_TIPO IN ('SENIOR', 'JUNIOR', 'BEGINNER')
UNION
SELECT C.N_USERNAME, C.O_PASSWORD, 'ACTIVO' AS I_ESTADO, 'CLIENTE' AS ROL
FROM CLIENTE C;

DROP VIEW VISTATOPPRODUCTO;
CREATE VIEW VISTATOPPRODUCTO AS
SELECT P.N_NOMBRE AS PRODUCTO, SUM(O.Q_CANTIDAD) AS VENDIDO, P.K_IDPERIODO
FROM ORDEN O
JOIN INVENTARIO I ON O.K_IDPRODUCTO = I.K_IDPRODUCTO AND O.K_IDREGION = I.K_IDREGION
JOIN PRODUCTO P ON O.K_IDPRODUCTO = P.K_IDPRODUCTO
INNER JOIN PERIODO P ON O.K_IDPERIODO = P.K_IDPERIODO
WHERE O.I_ESTADO = 'COMPLETADO'
GROUP BY P.N_NOMBRE, P.K_IDPERIODO
ORDER BY VENDIDO DESC;

DROP VIEW VISTATOPREGION;
CREATE VIEW VISTATOPREGION AS
SELECT R.N_NOMBRE AS REGION, SUM(O.Q_CANTIDAD * I.V_PRECIOPRODUCTO) AS VENTAS, P.K_IDPERIODO
FROM ORDEN O
INNER JOIN INVENTARIO I ON O.K_IDPRODUCTO = I.K_IDPRODUCTO AND O.K_IDREGION = I.K_IDREGION
INNER JOIN REGION R ON O.K_IDREGION = R.K_IDREGION
INNER JOIN PERIODO P ON O.K_IDPERIODO = P.K_IDPERIODO
WHERE O.I_ESTADO = 'COMPLETADO'
GROUP BY R.N_NOMBRE, P.K_IDPERIODO
ORDER BY VENTAS DESC;

DROP VIEW VISTATOPRV;
CREATE VIEW VISTATOPRV AS
SELECT RV.N_NOMBRECOMPLETO || ' ' ||RV.N_APELLIDOCOMPLETO AS "Representante De Ventas", SUM(O.Q_CANTIDAD) AS "Producto Vendido", P.K_IDPERIODO
FROM REPRESENTANTE_VENTAS RV
INNER JOIN ORDEN O ON RV.K_TIPO_ID = O.I_TIPO_ID_REP AND RV.K_NUMERO_ID = O.Q_NUMERO_ID_REP
INNER JOIN PERIODO P ON O.K_IDPERIODO = P.K_IDPERIODO
WHERE O.I_ESTADO = 'COMPLETADO'
GROUP BY RV.N_NOMBRECOMPLETO || ' ' ||RV.N_APELLIDOCOMPLETO, P.K_IDPERIODO
ORDER BY "Producto Vendido" DESC;

DROP VIEW VISTACALIFICACION;
CREATE VIEW VISTACALIFICACION AS
SELECT 
  CLIENTE.N_NOMBRECOMPLETO ||' '|| CLIENTE.N_APELLIDOCOMPLETO AS CLIENTE, 
  ORDEN.Q_CALIFICACION AS CALIFICACION, 
  ORDEN.F_FECHAREGISTRO AS FECHA, 
  ORDEN.I_TIPO_ID_REP, 
  ORDEN.Q_NUMERO_ID_REP
FROM 
  ORDEN
  LEFT JOIN CLIENTE ON ORDEN.K_TIPO_ID = CLIENTE.K_TIPO_ID AND ORDEN.K_NUMERO_ID = CLIENTE.K_NUMERO_ID
WHERE 
  ORDEN.I_ESTADO = 'COMPLETADO' AND ORDEN.Q_CALIFICACION IS NOT NULL;
  
DROP VIEW VISTARVFROMCLIENTE;
CREATE VIEW VISTARVFROMCLIENTE AS
SELECT R.N_NOMBRECOMPLETO AS NOMBRE, R.N_APELLIDOCOMPLETO AS APELLIDO, R.I_TIPO AS CARGO, R.N_REGION, C.K_TIPO_ID, C.K_NUMERO_ID
FROM REPRESENTANTE_VENTAS R
INNER JOIN CLIENTE C ON R.K_TIPO_ID = C.K_TIPO_ID_REP AND R.K_NUMERO_ID = C.K_ID_NUMERO_REP;

DROP VIEW VISTANOMINA;
CREATE VIEW VISTANOMINA AS
SELECT 
  R.N_NOMBRECOMPLETO AS NOMBRE, 
  R.N_APELLIDOCOMPLETO AS APELLIDO, 
  R.I_TIPO AS CARGO, 
  COALESCE(SUM(O.Q_CANTIDAD), 0) AS NUM_VENTAS, 
  COALESCE(ROUND(AVG(O.Q_CALIFICACION), 2),0) AS CALIFICACION, 
  ROUND(COALESCE(SUM(CASE 
                WHEN R.I_TIPO = 'BEGINNER' THEN O.Q_CALIFICACION * I.V_PRECIOPRODUCTO * 0.05
                WHEN R.I_TIPO = 'JUNIOR' THEN O.Q_CALIFICACION * I.V_PRECIOPRODUCTO * 0.1
                WHEN R.I_TIPO = 'SENIOR' THEN O.Q_CALIFICACION * I.V_PRECIOPRODUCTO * 0.15
                ELSE O.Q_CALIFICACION * I.V_PRECIOPRODUCTO * 0.2
             END), 0), 2) AS COMISION_TOTAL,
     
  CASE 
    WHEN COALESCE(SUM(O.Q_CANTIDAD), 0) <= 5 THEN 'BAJA'
    WHEN COALESCE(SUM(O.Q_CANTIDAD), 0) >= 6 AND COALESCE(SUM(O.Q_CANTIDAD), 0) <= 10 THEN 'IGUAL'
    ELSE 'SUBE'
  END AS ESTADO
FROM REPRESENTANTE_VENTAS R
LEFT JOIN ORDEN O ON R.K_TIPO_ID = O.I_TIPO_ID_REP AND R.K_NUMERO_ID = O.Q_NUMERO_ID_REP AND O.K_IDPERIODO = '2023-1' AND O.I_ESTADO = 'COMPLETADO' AND O.Q_CALIFICACION IS NOT NULL
LEFT JOIN INVENTARIO I ON O.K_IDPRODUCTO = I.K_IDPRODUCTO AND O.K_IDREGION = I.K_IDREGION
GROUP BY R.N_NOMBRECOMPLETO, R.N_APELLIDOCOMPLETO, R.I_TIPO
ORDER BY R.N_NOMBRECOMPLETO, R.N_APELLIDOCOMPLETO;



