# 组织结构管理
* 部门管理(RequestMapping: /admin/dept)
    * 获取部门信息列表(list)
    * 新增部门(add)
    * 修改部门(edit)
    * 停用部门(delete)
    * 获取部门信息(info)
    * 获取部门员工信息(userlist)
* 用户管理    
    * 新增用户
    * 修改用户信息
    * 停用用户
    * 用户与角色关联
* 角色管理
    * 增加角色
    * 修改角色
    * 角色权限管理
    * 角色与用户关联
    
# 菜单管理
菜单管理模块需要如下功能：
* 树形菜单管理
    * 增加菜单
    * 停用菜单
    * 修改菜单
    * 与角色关联


# 编码管理
编码管理模块需要的功能如下:
* 编码分类管理(RequestMapping: /admin/code)
    * 增加编码分类 (typeadd)
    * 停用编码分类 (typedelete)
    * 启用编码分类 (typeactivate)
    * 获取编码分类信息(typeinfo)
    * 获取全部的编码分类信息(typelist)
    * 获取编码分类的所有编码值(typecodelist)
    * 修改编码分类信息(typeeidt)
* 编码值管理(RequestMapping: /admin/code)
    * 增加编码值(codeadd)
    * 停用编码值(codedelete)
    * 启用编码值(codeactivate)
    * 获取编码值信息(codeinfo)
    * 修改编码值信息(codeeidt)