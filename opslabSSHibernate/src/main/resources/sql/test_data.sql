--随机插入一些测试数据到角色用户关联表中
insert into ops_re_roleuser  select '3b6ad27b515911e68b70524f970a68ec',t.userid from ops_re_userinfo t where t.usercode % 3 =0;