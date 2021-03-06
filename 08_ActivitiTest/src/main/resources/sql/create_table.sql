CREATE TABLE TBL_HBM_GENERALCODE (
  ID INTEGER NOT NULL AUTO_INCREMENT,
  code_Id VARCHAR (120),
  code_Name VARCHAR (200),
  code_Type VARCHAR (10),
  order_Id INT(2),
  create_Time VARCHAR (19),
  valid CHAR (1),
  memo VARCHAR (400),
  PRIMARY KEY (ID)
);
CREATE TABLE TBL_HBM_RIGTHS (
  rightsId INTEGER NOT NULL AUTO_INCREMENT,
  rigths_name VARCHAR (200) NOT NULL,
  rigths_code BIGINT NOT NULL,
  rigths_group INTEGER NOT NULL,
  is_branch BOOLEAN NOT NULL,
  address VARCHAR (400),
  rigths_desc VARCHAR (400),
  group_id INT(4),
  root_id INTEGER,
  is_valid CHAR (1),
  is_public CHAR (1),
  PRIMARY KEY (rightsId)
);
CREATE TABLE TBL_HBM_TASKLOG (
  ID VARCHAR (32) NOT NULL,
  TASKNAME VARCHAR (255),
  TASKTYPE VARCHAR (255),
  STARTTIME DATETIME,
  CODEId VARCHAR (255),
  PARAMS VARCHAR (255),
  RESULT VARCHAR (255),
  MSG VARCHAR (1000),
  PRIMARY KEY (ID)
);
CREATE TABLE TBL_HBM_TREE (
  ID INTEGER NOT NULL AUTO_INCREMENT,
  TREE_ID VARCHAR (255),
  TREE_NAME VARCHAR (255),
  PARENT_ID VARCHAR (255),
  TREETYPE_ID VARCHAR (255),
  TREETYPE_NAME VARCHAR (255),
  ROOT_ID VARCHAR (255),
  ROOT_NAME VARCHAR (255),
  IS_LEAF BOOLEAN,
  IS_VALID BOOLEAN,
  all_name VARCHAR (255),
  PRIMARY KEY (ID)
);
CREATE TABLE TBL_OPERATION_LOG (
  ID VARCHAR (32) NOT NULL,
  USERNAME VARCHAR (255),
  START_TIME DATETIME,
  END_TIME DATETIME,
  URI VARCHAR (1200),
  OPERATION_TYPE VARCHAR (255),
  BUSINESS_NAME VARCHAR (255),
  OPERATION_NAME VARCHAR (255),
  OPERATION_PARAM VARCHAR (400),
  RESULT VARCHAR (100),
  MSG VARCHAR (2000),
  PRIMARY KEY (ID)
) ;
CREATE TABLE tbl_hbm_deptments (
  ID VARCHAR (32) NOT NULL,
  deptId VARCHAR (32),
  detpName VARCHAR (200),
  valid CHAR (1),
  parentId VARCHAR (32),
  PRIMARY KEY (ID)
);
CREATE TABLE tbl_hbm_userinfo (
  ID VARCHAR (32) NOT NULL,
  userCode VARCHAR (10),
  userName VARCHAR (20),
  deptId VARCHAR (32),
  PASSWORD VARCHAR (32),
  valid CHAR (1),
  createTime VARCHAR (19),
  PRIMARY KEY (ID)
) ;