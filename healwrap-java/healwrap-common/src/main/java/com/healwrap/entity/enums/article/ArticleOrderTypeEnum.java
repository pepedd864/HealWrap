package com.healwrap.entity.enums.article;

/**
 * @author pepedd
 * @ClassName ArticleOrderTypeEnum
 * @Description 文章排序类型
 * @Date 2023/4/24 23:52
 */
public enum ArticleOrderTypeEnum {
  HOT(0, "top_type desc, comment_count desc, good_count desc, read_count desc", "热榜"),
  SEND(1, "post_time asc", "发布"),
  NEW(2, "post_time desc", "最新");
  private final Integer type;
  private final String orderSql;
  private final String desc;

  ArticleOrderTypeEnum(Integer type, String orderSql, String desc) {
    this.type = type;
    this.orderSql = orderSql;
    this.desc = desc;
  }

  public Integer getType() {
    return type;
  }

  public String getOrderSql() {
    return orderSql;
  }

  public String getDesc() {
    return desc;
  }

  public static ArticleOrderTypeEnum getByType(Integer type) {
    for (ArticleOrderTypeEnum articleOrderTypeEnum : ArticleOrderTypeEnum.values()) {
      if (articleOrderTypeEnum.getType().equals(type)) {
        return articleOrderTypeEnum;
      }
    }
    return null;
  }
}
