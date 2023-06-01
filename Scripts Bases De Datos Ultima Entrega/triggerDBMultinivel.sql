CREATE SEQUENCE auditoria_seq
  START WITH 1
  INCREMENT BY 1
  NOMAXVALUE
  NOCYCLE;

/* Create Triggers */
CREATE OR REPLACE TRIGGER TG_ACTUALIZAR_ORDEN_COMPLETA
BEFORE INSERT OR UPDATE OF I_ESTADO ON ORDEN
FOR EACH ROW
BEGIN

    IF :NEW.I_ESTADO = 'COMPLETADO' THEN
        SELECT C.I_TIPO_ID_REP INTO :NEW.I_TIPO_ID_REP FROM CLIENTE C WHERE C.K_TIPO_ID = :NEW.K_TIPO_ID AND C.K_NUMERO_ID = :NEW.K_NUMERO_ID;
        SELECT C.Q_NUMERO_ID_REP INTO :NEW.Q_NUMERO_ID_REP FROM CLIENTE C WHERE C.K_TIPO_ID = :NEW.K_TIPO_ID AND C.K_NUMERO_ID = :NEW.K_NUMERO_ID;
        
        UPDATE INVENTARIO I
        SET I.Q_STOCK = I.Q_STOCK - :NEW.Q_CANTIDAD
        WHERE (I.K_IDPRODUCTO = :NEW.K_IDPRODUCTO AND I.K_IDREGION = :NEW.K_IDREGION);
        
    END IF;

END;
/

CREATE SEQUENCE auditoria_seq
  START WITH 1
  INCREMENT BY 1
  NOMAXVALUE
  NOCYCLE;

create or replace TRIGGER TG_AUDITORIA
AFTER INSERT OR UPDATE ON ORDEN
FOR EACH ROW
BEGIN
  INSERT INTO AUDITORIA (K_ID, N_TABLA, Q_CALIFICACION, K_IDORDEN, K_IDPRODUCTO, K_IDREGION, K_NUMERO_ID_REP, K_TIPO_ID_REP)
  VALUES (auditoria_seq.NEXTVAL, 'ORDEN', :NEW.Q_CALIFICACION, :NEW.K_IDORDEN, :NEW.K_IDPRODUCTO, :NEW.K_IDREGION, :NEW.Q_NUMERO_ID_REP, :NEW.I_TIPO_ID_REP);
END;
