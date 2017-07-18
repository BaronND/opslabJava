package app.entries;

import lombok.Getter;
import lombok.Setter;

/**
 * <h6>Description:<h6>
 * <p>常用的字典</p>
 *
 * @date 2015-06-15.
 */
public class GeneralCode {
    //实体ID
    @Getter @Setter private Integer id;

    //编码ID
    @Getter @Setter private String codeId;

    //编码名称
    @Getter @Setter private String codeName;

    //编码类型
    @Getter @Setter private String codeType;

    //排序ID
    @Getter @Setter private String orderId;

    //创建时间
    @Getter @Setter private String createTime;

    //是否有效
    @Getter @Setter private String valid;

    //备注
    @Getter @Setter private String memo;
}
