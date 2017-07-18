package dbutils.entries;


/**
 * 对应一条结果集的JavaBean
 */
public class RowData {
    private int qid;
    private String nick;
    private String quid;

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getQuid() {
        return quid;
    }

    public void setQuid(String quid) {
        this.quid = quid;
    }

    @Override
    public String toString() {
        return "RowData{" +
                "qid=" + qid +
                ", nick='" + nick + '\'' +
                ", quid='" + quid + '\'' +
                '}';
    }
}
