<#-- 内建函数以?形式提供变量的不同形式或者其他信息。使用内建函数的语法和访问哈希表子变量的语法很像，
 除了使用?号来代替点，其他的都一样。 -->

<#--将用户名大写-->
${username?upper_case}


<#--将内容转换为html实体-->
${product.url?html}

<#--获取集合的size-->
${list.size}

<#--将用户名大写并转换为html实体-->
${username?upper_case?html}
