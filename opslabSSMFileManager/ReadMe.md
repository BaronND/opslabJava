## ImageManagerWeb
一个通用的上传管理系统.
核心数据表
t_ops_uploadgroup 上传用户组配置
t_ops_uploadgroup_client 上传用户组的ip配置（为实现）
t_ops_uploadgroup_handlers 上传后对上传后的文件做另外的处理
t_ops_uploadinfo 上传日志

上传时需要先在t_ops_uploadgroup中配置用户组，如果需要也可以在t_ops_uploadgroup_handlers中配置处理组
随后可以使用如下方式上传
### 前端实例
```jsp
<html>
<head>
    <title>Upload File Request Page</title>
</head>
<body>
<form method="POST" action="/image/upload" enctype="multipart/form-data">
    ImageGroup id : <input type="text" name="gid"/><br>
    Business System bid: <input type="text" name="bid"/><br>
    File to upload: <input type="file" name="file"/><br>
    <input type="submit" value="Upload"> Press here to upload the file!
</form>
</body>
</html>
```
### 上传的http
```http
POST http://localhost:8080/image/upload HTTP/1.1
Host: localhost:8080
Connection: keep-alive
Content-Length: 15021
Cache-Control: max-age=0
Origin: http://localhost:8080
Upgrade-Insecure-Requests: 1
User-Agent: Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2969.0 Safari/537.36
Content-Type: multipart/form-data; boundary=----WebKitFormBoundaryPZSjJBRITl4W03PC
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8
Referer: http://localhost:8080/upload.jsp
Accept-Encoding: gzip, deflate, br
Accept-Language: zh-CN,zh;q=0.8
Cookie: Webstorm-46fc939c=46679107-a00d-453e-b60b-d6e1d9069f4a; Idea-81111fc3=a1d6af1c-7532-4e91-8e7c-7b9c286332ff; JSESSIONID=625AD37FFD31D2FD95AF81A68DF45605

------WebKitFormBoundaryPZSjJBRITl4W03PC
Content-Disposition: form-data; name="gid"

1111
------WebKitFormBoundaryPZSjJBRITl4W03PC
Content-Disposition: form-data; name="bid"

2222
------WebKitFormBoundaryPZSjJBRITl4W03PC
Content-Disposition: form-data; name="file"; filename="2.jpg"
Content-Type: image/jpeg

file-content
------WebKitFormBoundaryPZSjJBRITl4W03PC--
```
