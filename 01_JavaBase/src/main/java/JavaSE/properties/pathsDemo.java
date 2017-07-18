package JavaSE.properties;

import java.nio.file.Path;
import java.nio.file.Paths;

public class pathsDemo {
    public static void main(String[] args) {
        Path path = Paths.get(".");
        System.out.println("path-count(direcotry:):" + path.getNameCount());
        System.out.println("path-root(direcotry:):" + path.getRoot());
        System.out.println("absolute-path:" + path.toAbsolutePath());


    }
}