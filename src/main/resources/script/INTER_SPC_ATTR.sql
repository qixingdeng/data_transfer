SET DEFINE OFF;
Insert into APPROVAL_DEV.INTER_SPC_ATTR
   (ID, PARENT_ID, LEVEL_ID, SERVICE_ID, SYSTEM_ID, 
    CREATE_DATE, DONE_DATE, EXTENSION, REMARK)
 Values
   ('1', '0', '1', 'P0102', '1001', 
    TO_DATE('06/25/2015 10:13:49', 'MM/DD/YYYY HH24:MI:SS'), TO_DATE('06/25/2015 10:13:53', 'MM/DD/YYYY HH24:MI:SS'), NULL, 'OrdShipParamInfo');
Insert into APPROVAL_DEV.INTER_SPC_ATTR
   (ID, PARENT_ID, LEVEL_ID, SERVICE_ID, SYSTEM_ID, 
    CREATE_DATE, DONE_DATE, EXTENSION, REMARK)
 Values
   ('2', '0', '1', 'P0102', '1001', 
    TO_DATE('06/26/2015 15:40:20', 'MM/DD/YYYY HH24:MI:SS'), TO_DATE('06/26/2015 15:40:25', 'MM/DD/YYYY HH24:MI:SS'), NULL, 'ord_work_order');
Insert into APPROVAL_DEV.INTER_SPC_ATTR
   (ID, PARENT_ID, LEVEL_ID, SERVICE_ID, SYSTEM_ID, 
    CREATE_DATE, DONE_DATE, EXTENSION, REMARK)
 Values
   ('3', '0', '1', 'P0102', '1001', 
    TO_DATE('06/25/2015 10:44:29', 'MM/DD/YYYY HH24:MI:SS'), TO_DATE('06/25/2015 10:44:32', 'MM/DD/YYYY HH24:MI:SS'), NULL, 'OrdShipManagerInfo');
Insert into APPROVAL_DEV.INTER_SPC_ATTR
   (ID, PARENT_ID, LEVEL_ID, SERVICE_ID, SYSTEM_ID, 
    CREATE_DATE, DONE_DATE, EXTENSION, REMARK)
 Values
   ('4', '0', '1', 'P0102', '1001', 
    TO_DATE('06/25/2015 11:01:32', 'MM/DD/YYYY HH24:MI:SS'), TO_DATE('06/25/2015 11:01:37', 'MM/DD/YYYY HH24:MI:SS'), NULL, 'CCS_CODE SmParamDetail');
Insert into APPROVAL_DEV.INTER_SPC_ATTR
   (ID, PARENT_ID, LEVEL_ID, SERVICE_ID, SYSTEM_ID, 
    CREATE_DATE, DONE_DATE, EXTENSION, REMARK)
 Values
   ('5', '0', '1', 'P0102', '1001', 
    TO_DATE('06/25/2015 16:07:42', 'MM/DD/YYYY HH24:MI:SS'), TO_DATE('06/25/2015 16:07:45', 'MM/DD/YYYY HH24:MI:SS'), NULL, 'BUILD_PLACE SmParamDetail');
Insert into APPROVAL_DEV.INTER_SPC_ATTR
   (ID, PARENT_ID, LEVEL_ID, SERVICE_ID, SYSTEM_ID, 
    CREATE_DATE, DONE_DATE, EXTENSION, REMARK)
 Values
   ('6', '2', '2', 'P0102', '1001', 
    TO_DATE('06/25/2015 15:37:35', 'MM/DD/YYYY HH24:MI:SS'), TO_DATE('06/25/2015 15:37:40', 'MM/DD/YYYY HH24:MI:SS'), NULL, 'CfgCertiBusiRela');
Insert into APPROVAL_DEV.INTER_SPC_ATTR
   (ID, PARENT_ID, LEVEL_ID, SERVICE_ID, SYSTEM_ID, 
    CREATE_DATE, DONE_DATE, EXTENSION, REMARK)
 Values
   ('7', '6', '1', 'P0102', '1001', 
    TO_DATE('06/25/2015 10:27:57', 'MM/DD/YYYY HH24:MI:SS'), TO_DATE('06/25/2015 10:28:01', 'MM/DD/YYYY HH24:MI:SS'), '1', 'ord_certificate');
Insert into APPROVAL_DEV.INTER_SPC_ATTR
   (ID, PARENT_ID, LEVEL_ID, SERVICE_ID, SYSTEM_ID, 
    CREATE_DATE, DONE_DATE, EXTENSION, REMARK)
 Values
   ('8', '7', '2', 'P0102', '1001', 
    TO_DATE('06/29/2015 13:43:05', 'MM/DD/YYYY HH24:MI:SS'), TO_DATE('06/29/2015 13:43:10', 'MM/DD/YYYY HH24:MI:SS'), '1', 'ord_certi_ship');
Insert into APPROVAL_DEV.INTER_SPC_ATTR
   (ID, PARENT_ID, LEVEL_ID, SERVICE_ID, SYSTEM_ID, 
    CREATE_DATE, DONE_DATE, EXTENSION, REMARK)
 Values
   ('90', '0', '1', 'P0101', '1001', 
    TO_DATE('06/29/2015 14:12:02', 'MM/DD/YYYY HH24:MI:SS'), TO_DATE('06/29/2015 14:12:06', 'MM/DD/YYYY HH24:MI:SS'), NULL, 'ECON_TYPE');
COMMIT;
