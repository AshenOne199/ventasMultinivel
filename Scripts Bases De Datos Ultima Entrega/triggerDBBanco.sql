--Secuencia para autoincremento
CREATE SEQUENCE seq_movimiento START WITH 10 INCREMENT BY 1;

--Trigger para autoincremento
CREATE OR REPLACE TRIGGER tg_nuevo_movimiento BEFORE
    INSERT ON movimiento
    FOR EACH ROW
BEGIN
    SELECT
        seq_movimiento.NEXTVAL
    INTO :new.k_id_movimiento
    FROM
        dual;
END;

--Trigger para actualizar columna de saldo en tabla Cuenta de acuerdo al id
CREATE OR REPLACE TRIGGER tg_efectuar_pago AFTER
    INSERT ON movimiento
    FOR EACH ROW
BEGIN
    UPDATE cuenta
    SET
        q_saldo = ( q_saldo - :new.q_movimiento )
    WHERE
        k_numero_cuenta = :new.q_numero_cuenta;
END;

--Directorio donde se crearan los archivos de las facturas
CREATE OR REPLACE DIRECTORY CTEST AS 'C:\app\jackl\product\18.0.0\facturas';

--Es necesario otorgar permisos
GRANT READ, WRITE ON DIRECTORY CTEST TO PUBLIC;

--Trigger para crear archivos de facturas
CREATE OR REPLACE TRIGGER tg_generar_factura AFTER
    INSERT ON movimiento
    FOR EACH ROW
DECLARE
    out_file    utl_file.file_type;
    v_namefile  VARCHAR2(100);
BEGIN
    v_namefile:='factura '||:new.k_id_movimiento||' '||TO_CHAR(SYSDATE,'YYYYMMDD')||'.txt';
    out_file := utl_file.fopen('CTEST', v_namefile, 'W');
    utl_file.put_line(out_file,  'Cuenta: '|| :new.q_numero_cuenta);
    utl_file.put_line(out_file,  'Tipo Cuenta: '|| :new.i_tipo_cuenta);
    utl_file.put_line(out_file,  'Movimiento n#: '|| :new.k_id_movimiento);
    utl_file.put_line(out_file,  'Monto debitado: '|| :new.Q_MOVIMIENTO);
    utl_file.put_line(out_file,  'Fecha: '|| TO_CHAR(SYSDATE,'YYYYMMDD'));
    utl_file.fclose(out_file);
END;

INSERT INTO MOVIMIENTO (Q_NUMERO_CUENTA, I_TIPO_CUENTA, Q_MOVIMIENTO) VALUES (123123, 'DEBITO', 5000);