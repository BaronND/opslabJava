/*---业务日志表---*/
CREATE TABLE tbl_hbm_operation_log (
  ID bigint(20) NOT NULL AUTO_INCREMENT,
  USERNAME varchar(255) DEFAULT NULL,
  ADDRESS varchar(255) DEFAULT NULL,
  START_TIME datetime DEFAULT NULL,
  END_TIME datetime DEFAULT NULL,
  URI varchar(1200) DEFAULT NULL,
  OPERATION_TYPE varchar(255) DEFAULT NULL,
  OPERATION_NAME varchar(255) DEFAULT NULL,
  OPERATION_PARAM varchar(400) DEFAULT NULL,
  RESULT varchar(100) DEFAULT NULL,
  MSG varchar(2000) DEFAULT NULL,
  PRIMARY KEY (ID)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*---权限表---*/
CREATE TABLE tbl_hbm_rigths (
  rightsId int(11) NOT NULL AUTO_INCREMENT,
  rigths_name varchar(255) NOT NULL,
  rigths_code bigint(20) NOT NULL,
  rigths_group int(11) NOT NULL,
  is_branch varchar(4) NOT NULL,
  address varchar(255) DEFAULT NULL,
  rigths_desc varchar(255) DEFAULT NULL,
  group_id varchar(255) DEFAULT NULL,
  root_id varchar(255) DEFAULT NULL,
  is_valid varchar(4) DEFAULT NULL,
  is_public varchar(4) DEFAULT NULL,
  PRIMARY KEY (rightsId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*---定时业务日志---*/
CREATE TABLE tbl_hbm_tasklog (
  ID bigint(20) NOT NULL AUTO_INCREMENT,
  TASKNAME varchar(255) DEFAULT NULL,
  TASKTYPE varchar(255) DEFAULT NULL,
  STARTTIME datetime DEFAULT NULL,
  CODEId varchar(255) DEFAULT NULL,
  PARAMS varchar(255) DEFAULT NULL,
  RESULT varchar(255) DEFAULT NULL,
  MSG varchar(255) DEFAULT NULL,
  PRIMARY KEY (ID)
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=utf8;


/*---常用编码树---*/
CREATE TABLE tbl_hbm_tree (
  ID int(11) NOT NULL AUTO_INCREMENT,
  TREE_ID varchar(255) DEFAULT NULL,
  TREE_NAME varchar(255) DEFAULT NULL,
  PARENT_ID varchar(255) DEFAULT NULL,
  TREETYPE_ID varchar(255) DEFAULT NULL,
  TREETYPE_NAME varchar(255) DEFAULT NULL,
  ROOT_ID varchar(255) DEFAULT NULL,
  ROOT_NAME varchar(255) DEFAULT NULL,
  IS_LEAF varchar(4) DEFAULT NULL,
  IS_VALID varchar(4) DEFAULT NULL,
  all_name varchar(255) DEFAULT NULL,
  PRIMARY KEY (ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*---用户信息表---*/
CREATE TABLE tbl_hbm_user (
  userid int(11) NOT NULL AUTO_INCREMENT,
  username varchar(255) NOT NULL,
  email varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  PRIMARY KEY (userid)
) ENGINE=InnoDB AUTO_INCREMENT=223 DEFAULT CHARSET=utf8;

/*---常用的字典---*/
CREATE TABLE TBL_HBM_GENERALCODE (
  id int(11) NOT NULL AUTO_INCREMENT,
  code_Id varchar(255) NOT NULL,
  code_Name varchar(255) NOT NULL,
  code_Type varchar(255) NOT NULL,
  order_Id int(4),
  create_Time datetime,
  valid    varchar(4),
  memo     varchar(400),
  primary key(id)
) ENGINE=InnoDB AUTO_INCREMENT=223 DEFAULT CHARSET=utf8;