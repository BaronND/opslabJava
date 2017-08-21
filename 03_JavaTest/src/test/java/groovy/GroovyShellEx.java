package groovy;

/**
 * 利用GroovyShell执行Groovy脚本
 */
import groovy.lang.Binding;
import groovy.lang.GroovyShell;
public class GroovyShellEx {
    public static void main(String[] args) {
        Binding bind = new Binding();
        bind.setVariable("name", "iamzhongyong");
        bind.setVariable("age", "25");
        GroovyShell shell = new GroovyShell(bind);
        String groovyScript = "str = name+age;return str";
        Object obj = shell.evaluate(groovyScript);
        System.out.println(obj);
    }
}
