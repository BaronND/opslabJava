package app.entries;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Blog {
    //blogid
    @Getter @Setter private Integer blogid;

    //blog-title
    @Getter @Setter private String title;

    //create time
    @Getter @Setter private String createTime;

    //digest
    @Getter @Setter private String digest;

    //标签
    @Getter @Setter private String label ;

    //bolg content
    @Getter @Setter private String content;

    //图片
    @Getter @Setter private List<String> images;

    //媒体文件
    @Getter @Setter private List<String> media;

    @Override
    public String toString() {
        return "Blog{" +
                "title='" + title + '\'' +
                ", blogid=" + blogid +
                '}';
    }
}
