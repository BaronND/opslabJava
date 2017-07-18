package JsqlParser.selectTest;

import junit.framework.TestCase;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.parser.CCJSqlParserManager;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.select.*;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ps on 15-7-29.
 */
public class SelectTest extends TestCase {

    private SelectBody selectBody;

    public void testSelect() throws JSQLParserException {
        CCJSqlParserManager parserManager = new CCJSqlParserManager();

        String longQuery = "select t.deptip,count(*) from tables t where t.ID > 4 group by t.deptip order by deptid desc ";


        Select select = (Select) parserManager.parse(new StringReader(longQuery));
        System.out.println(select.getWithItemsList());

        System.out.println(select.getSelectBody().toString());

        System.out.println(select.toString());


        PlainSelect selectBody = (PlainSelect) select.getSelectBody();

        System.out.println("group up ->" + selectBody.getGroupByColumnReferences());

        System.out.println("order by ->" + selectBody.getOrderByElements());

        System.out.println("column ->" + selectBody.getSelectItems());

        Expression where = selectBody.getWhere();

        System.out.println("where ->" + selectBody.getWhere());

        System.out.println("table ->" + selectBody.toString());


    }

    public void testWhere() throws JSQLParserException {
        String sql = "select count(a.EMPLOYEE_ID) as employeecount,a.DEPARTMENT_ID as deptnum,avg(SALARY) as salarys from EMPLOYEES as a\n" +
                " where (select count(c.EMPLOYEE_ID) from EMPLOYEES as c where c.DEPARTMENT_ID = a.DEPARTMENT_ID and c.SALARY>(select avg(SALARY) from EMPLOYEES as b where c.DEPARTMENT_ID = b.DEPARTMENT_ID))>1\n" +
                "group by a.DEPARTMENT_ID order by a.DEPARTMENT_ID";
        CCJSqlParserManager parserManager = new CCJSqlParserManager();
        Select select = (Select) parserManager.parse(new StringReader(sql));
        PlainSelect selectBody = (PlainSelect) select.getSelectBody();

        Expression where = selectBody.getWhere();

        System.out.println(where.toString());
    }

    public void testSelectCount() throws JSQLParserException {
        String sql = "select count(a.EMPLOYEE_ID) as employeecount,a.DEPARTMENT_ID as deptnum,avg(SALARY) as salarys from EMPLOYEES as a\n" +
                " where (select count(c.EMPLOYEE_ID) from EMPLOYEES as c where c.DEPARTMENT_ID = a.DEPARTMENT_ID and c.SALARY>(select avg(SALARY) from EMPLOYEES as b where c.DEPARTMENT_ID = b.DEPARTMENT_ID))>1\n" +
                "group by a.DEPARTMENT_ID order by a.DEPARTMENT_ID";
        System.out.println(testSelectCount(sql));


        String sql2 = "select distinct count(a.EMPLOYEE_ID) as employeecount,a.DEPARTMENT_ID as deptnum,avg(SALARY) as salarys from EMPLOYEES as a\n" +
                " where (select count(c.EMPLOYEE_ID) from EMPLOYEES as c where c.DEPARTMENT_ID = a.DEPARTMENT_ID and c.SALARY>(select avg(SALARY) from EMPLOYEES as b where c.DEPARTMENT_ID = b.DEPARTMENT_ID))>1\n" +
                "group by a.DEPARTMENT_ID order by a.DEPARTMENT_ID";
        System.out.println(testSelectCount(sql2));
    }


    public static String testSelectCount(String sql) throws JSQLParserException {

        CCJSqlParserManager parserManager = new CCJSqlParserManager();
        Select select = (Select) parserManager.parse(new StringReader(sql));

        PlainSelect selectBody = (PlainSelect) select.getSelectBody();
        //ȥ��order by�Ӿ�
        selectBody.setOrderByElements(null);


        if (selectBody.getDistinct() != null) {
            //distinct
            //��ѯ���ֶ�
            selectBody.setDistinct(null);
            List<SelectItem> column = selectBody.getSelectItems();
            String col = column.toString();
            col = col.substring(1, col.length() - 1);
            List<SelectItem> list = new ArrayList<SelectItem>();
            list.add(new SelectExpressionItem((new Column("counts(distinct " + col + ")"))));
            selectBody.setSelectItems(list);
        } else {
            //not distinct
            List<SelectItem> list = new ArrayList<SelectItem>();
            list.add(new SelectExpressionItem((new Column("counts(*)"))));
            selectBody.setSelectItems(list);
        }
        return selectBody.toString();
    }

}
