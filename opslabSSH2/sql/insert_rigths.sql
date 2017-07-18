/*
-- Query: SELECT * FROM test.tbl_hbm_rigths
LIMIT 0, 1000

-- Date: 2015-06-15 15:15
*/
INSERT INTO tbl_hbm_rigths (rightsId,rigths_name,rigths_code,rigths_group,is_branch,address,rigths_desc,group_id,root_id,is_valid,is_public) VALUES (0,'权限管理',1,0,'1',NULL,'权限管理','1','0','1','1');
INSERT INTO tbl_hbm_rigths (rightsId,rigths_name,rigths_code,rigths_group,is_branch,address,rigths_desc,group_id,root_id,is_valid,is_public) VALUES (2,'日志管理',2,0,'1','','系统日志顶级菜单','0','2','1','1');
INSERT INTO tbl_hbm_rigths (rightsId,rigths_name,rigths_code,rigths_group,is_branch,address,rigths_desc,group_id,root_id,is_valid,is_public) VALUES (5,'权限控制',4,0,'1','','系统权限控制','0','4','1','1');
INSERT INTO tbl_hbm_rigths (rightsId,rigths_name,rigths_code,rigths_group,is_branch,address,rigths_desc,group_id,root_id,is_valid,is_public) VALUES (6,'添加权限',8,0,'0','rights_list.action','添加系统权限','4','4','1','0');
INSERT INTO tbl_hbm_rigths (rightsId,rigths_name,rigths_code,rigths_group,is_branch,address,rigths_desc,group_id,root_id,is_valid,is_public) VALUES (7,'业务日志',16,0,'0','log_list.action','业务日志','2','2','1','0');
INSERT INTO tbl_hbm_rigths (rightsId,rigths_name,rigths_code,rigths_group,is_branch,address,rigths_desc,group_id,root_id,is_valid,is_public) VALUES (8,'定时日志',32,0,'0','task_list.action','定时任务日志','2','2','1','0');
INSERT INTO tbl_hbm_rigths (rightsId,rigths_name,rigths_code,rigths_group,is_branch,address,rigths_desc,group_id,root_id,is_valid,is_public) VALUES (9,'添加菜单',64,0,'0','rights_list.action','添加系统菜单','5','4','1','0');
INSERT INTO tbl_hbm_rigths (rightsId,rigths_name,rigths_code,rigths_group,is_branch,address,rigths_desc,group_id,root_id,is_valid,is_public) VALUES (10,'三级菜单',128,0,'1','','三级菜单','5','4','1','0');
INSERT INTO tbl_hbm_rigths (rightsId,rigths_name,rigths_code,rigths_group,is_branch,address,rigths_desc,group_id,root_id,is_valid,is_public) VALUES (11,'三级菜单测试',256,0,'0','http://www.baidu.com','1111111111','10','4','1','0');
INSERT INTO tbl_hbm_rigths (rightsId,rigths_name,rigths_code,rigths_group,is_branch,address,rigths_desc,group_id,root_id,is_valid,is_public) VALUES (12,'三级菜单测试2',512,0,'0','www.toutiao.io','www.toutiao.io','10','4','1','0');
INSERT INTO tbl_hbm_rigths (rightsId,rigths_name,rigths_code,rigths_group,is_branch,address,rigths_desc,group_id,root_id,is_valid,is_public) VALUES (13,'三级菜单测试3',1024,0,'0','https://github.com','https://github.com','10','4','1','0');
