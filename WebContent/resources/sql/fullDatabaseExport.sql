--------------------------------------------------------
--  DDL for Table CLIENT
--------------------------------------------------------

  CREATE TABLE "HR"."CLIENT" 
   (	"CLIENT_ID" NUMBER(*,0), 
	"FIRST_NAME" VARCHAR2(35 BYTE), 
	"LAST_NAME" VARCHAR2(35 BYTE), 
	"CITY" VARCHAR2(35 BYTE), 
	"POINTS" NUMBER, 
	"LAST_LOGIN_DATE" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table REGIONS
--------------------------------------------------------

  CREATE TABLE "HR"."REGIONS" 
   (	"REGION_ID" NUMBER, 
	"REGION_NAME" VARCHAR2(25 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Sequence CLIENT_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "HR"."CLIENT_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 47 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence LOCATIONS_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "HR"."LOCATIONS_SEQ"  MINVALUE 1 MAXVALUE 9900 INCREMENT BY 100 START WITH 3300 NOCACHE  NOORDER  NOCYCLE ;
REM INSERTING into HR.CLIENT
SET DEFINE OFF;
Insert into HR.CLIENT (CLIENT_ID,FIRST_NAME,LAST_NAME,CITY,POINTS,LAST_LOGIN_DATE) values (1,'Fidel','Castro','Hawana',99,to_date('01-DEC-17','DD-MON-RR'));
Insert into HR.CLIENT (CLIENT_ID,FIRST_NAME,LAST_NAME,CITY,POINTS,LAST_LOGIN_DATE) values (2,'Jan','Doe','Warszawa',5,to_date('31-DEC-17','DD-MON-RR'));
Insert into HR.CLIENT (CLIENT_ID,FIRST_NAME,LAST_NAME,CITY,POINTS,LAST_LOGIN_DATE) values (3,'Chris','Fast','Warszawa',null,null);
Insert into HR.CLIENT (CLIENT_ID,FIRST_NAME,LAST_NAME,CITY,POINTS,LAST_LOGIN_DATE) values (4,'Elvis','Presley','Memphis',10,to_date('10-OCT-17','DD-MON-RR'));
Insert into HR.CLIENT (CLIENT_ID,FIRST_NAME,LAST_NAME,CITY,POINTS,LAST_LOGIN_DATE) values (5,'Jan','Mex','New York',null,null);
Insert into HR.CLIENT (CLIENT_ID,FIRST_NAME,LAST_NAME,CITY,POINTS,LAST_LOGIN_DATE) values (6,'Daniel','Craig','Moscow',22,to_date('20-MAR-17','DD-MON-RR'));
Insert into HR.CLIENT (CLIENT_ID,FIRST_NAME,LAST_NAME,CITY,POINTS,LAST_LOGIN_DATE) values (7,'Tom','Hardy','Dublin',40,to_date('26-SEP-17','DD-MON-RR'));
Insert into HR.CLIENT (CLIENT_ID,FIRST_NAME,LAST_NAME,CITY,POINTS,LAST_LOGIN_DATE) values (8,'Fidel','Castro','Hawana',null,to_date('01-DEC-17','DD-MON-RR'));
Insert into HR.CLIENT (CLIENT_ID,FIRST_NAME,LAST_NAME,CITY,POINTS,LAST_LOGIN_DATE) values (9,'Best','Doe','Warszawa',5,to_date('31-DEC-17','DD-MON-RR'));
Insert into HR.CLIENT (CLIENT_ID,FIRST_NAME,LAST_NAME,CITY,POINTS,LAST_LOGIN_DATE) values (10,'White','Fast','Warszawa',40,to_date('01-MAY-18','DD-MON-RR'));
Insert into HR.CLIENT (CLIENT_ID,FIRST_NAME,LAST_NAME,CITY,POINTS,LAST_LOGIN_DATE) values (36,'Victor','Ortiz','Los Angeles',null,null);
Insert into HR.CLIENT (CLIENT_ID,FIRST_NAME,LAST_NAME,CITY,POINTS,LAST_LOGIN_DATE) values (11,'James','Bond','London',100,to_date('01-JAN-00','DD-MON-RR'));
Insert into HR.CLIENT (CLIENT_ID,FIRST_NAME,LAST_NAME,CITY,POINTS,LAST_LOGIN_DATE) values (39,'Mike','Tyson','Las Vegas',null,null);
Insert into HR.CLIENT (CLIENT_ID,FIRST_NAME,LAST_NAME,CITY,POINTS,LAST_LOGIN_DATE) values (40,'Etienne','Robinson','New York',null,null);
Insert into HR.CLIENT (CLIENT_ID,FIRST_NAME,LAST_NAME,CITY,POINTS,LAST_LOGIN_DATE) values (42,'Jim','Beam','New York',null,null);
Insert into HR.CLIENT (CLIENT_ID,FIRST_NAME,LAST_NAME,CITY,POINTS,LAST_LOGIN_DATE) values (12,'Tom','Lee','Toronto',99,to_date('01-DEC-17','DD-MON-RR'));
Insert into HR.CLIENT (CLIENT_ID,FIRST_NAME,LAST_NAME,CITY,POINTS,LAST_LOGIN_DATE) values (13,'Bob','Johnson','Toronto',99,to_date('08-DEC-17','DD-MON-RR'));
Insert into HR.CLIENT (CLIENT_ID,FIRST_NAME,LAST_NAME,CITY,POINTS,LAST_LOGIN_DATE) values (32,'Ryan','Garcia','Victorville',99,to_date('15-JAN-18','DD-MON-RR'));
REM INSERTING into HR.REGIONS
SET DEFINE OFF;
Insert into HR.REGIONS (REGION_ID,REGION_NAME) values (1,'Europe');
Insert into HR.REGIONS (REGION_ID,REGION_NAME) values (2,'Americas');
Insert into HR.REGIONS (REGION_ID,REGION_NAME) values (3,'Asia');
Insert into HR.REGIONS (REGION_ID,REGION_NAME) values (4,'Middle East and Africa');
--------------------------------------------------------
--  DDL for Index CLIENTID
--------------------------------------------------------

  CREATE UNIQUE INDEX "HR"."CLIENTID" ON "HR"."CLIENT" ("CLIENT_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index LOC_ID_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "HR"."LOC_ID_PK" ON "HR"."LOCATIONS" ("LOCATION_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index REG_ID_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "HR"."REG_ID_PK" ON "HR"."REGIONS" ("REGION_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Trigger CLIENT_INS_ID
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "HR"."CLIENT_INS_ID" 
  BEFORE INSERT ON client
  FOR EACH ROW
BEGIN
  SELECT client_seq.nextval
    INTO :new.client_id
    FROM dual;
END;
/
ALTER TRIGGER "HR"."CLIENT_INS_ID" ENABLE;
--------------------------------------------------------
--  DDL for Procedure ADD_JOB_HISTORY
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "HR"."ADD_JOB_HISTORY" 
  (  p_emp_id          job_history.employee_id%type
   , p_start_date      job_history.start_date%type
   , p_end_date        job_history.end_date%type
   , p_job_id          job_history.job_id%type
   , p_department_id   job_history.department_id%type
   )
IS
BEGIN
  INSERT INTO job_history (employee_id, start_date, end_date,
                           job_id, department_id)
    VALUES(p_emp_id, p_start_date, p_end_date, p_job_id, p_department_id);
END add_job_history;

/
--------------------------------------------------------
--  DDL for Procedure SECURE_DML
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "HR"."SECURE_DML" 
IS
BEGIN
  IF TO_CHAR (SYSDATE, 'HH24:MI') NOT BETWEEN '08:00' AND '18:00'
        OR TO_CHAR (SYSDATE, 'DY') IN ('SAT', 'SUN') THEN
	RAISE_APPLICATION_ERROR (-20205,
		'You may only make changes during normal office hours');
  END IF;
END secure_dml;

/
--------------------------------------------------------
--  DDL for Procedure TESTPROCEDURE_1
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "HR"."TESTPROCEDURE_1" IS
begin
null;
end;

/
--------------------------------------------------------
--  Constraints for Table CLIENT
--------------------------------------------------------

  ALTER TABLE "HR"."CLIENT" ADD CONSTRAINT "CLIENTID" PRIMARY KEY ("CLIENT_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table REGIONS
--------------------------------------------------------

  ALTER TABLE "HR"."REGIONS" ADD CONSTRAINT "REG_ID_PK" PRIMARY KEY ("REGION_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "HR"."REGIONS" MODIFY ("REGION_ID" CONSTRAINT "REGION_ID_NN" NOT NULL ENABLE);
