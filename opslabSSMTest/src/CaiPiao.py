#! /usr/bin/python
# encoding=UTF-8

import re,time
import requests
from bs4 import BeautifulSoup

headers = {
    'Accept': 'image/gif, image/jpeg, image/pjpeg, image/pjpeg,*/*',
    'Referer': 'http://www.baidu.com',
    'Accept-Language': 'zh-cn',
    'User-Agent': 'Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1;.NET CLR 2.0.50727)',
    'Content-Type': 'application/x-www-form-urlencoded',
    'Accept-Encoding': 'gzip, deflate'
}

insert = "insert into t_real_result(data,num,red1,red2,red3,red4,red5,red6,blue) " \
         "values('{}','{}','{}','{}','{}','{}','{}','{}','{}');\n"
with open("real_result.sql","w") as f:
    for i in range(1, 42, 1):
        url = 'http://www.chinafcw.com.cn/ulWinInfo.do?method=list&menuType=1&currentPage=' + str(i)
        print url
        response = requests.get(url, headers=headers)

        soup = BeautifulSoup(response.content)

        for tr in soup.find_all('tr', "ncolor"):
            text = tr.get_text().replace("\n{2,}", "")
            text = re.sub("\s", ":", tr.get_text())
            arr = text.split(":")
            if len(arr) > 4:
                date = arr[1]
                num = arr[2]
                reds = arr[3].split("|")
                blue = arr[4]

                f.writelines(insert.format(
                    date, num, reds[0], reds[1], reds[2], reds[3], reds[4], reds[5], blue))

        time.sleep(2)

print "it's ok!"
