package JavaSE.StringTest;

public class StringTest {

    public static void main(String[] args) {
        StringTest test = new StringTest();
        String sql = "SELECT recordid,companyid, companyName,"
                + " breaker_code, breaker_name, chang_time, last_status, "
                + "lower_status FROM DIANNENGZHILIANG.HandleResult_ZT_DLQ"
                + " WHERE ROUND(to_date(to_char(CHANG_TIME,'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'),'HH') ="
                + " ROUND(to_date(to_char(DateAdd(HH,-1,SYSDATE()),'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'),'HH')";
        System.out.println(sql);
        test.fun();

    }

    public void fun() {
        System.out.println(this.getClass().getSimpleName());
    }

}
