package com.healwrap.entity.enums.attachment;

/**
 * @author pepedd
 * @ClassName ArticleAttachmentTypeEnum
 * @Description TODO
 * @Date 2023/5/10 10:45
 */
public enum ArticleAttachmentTypeEnum {
  NO_ATTACHMENT(0, "没有附件"),
  HAVE_ATTACHMENT(1, "有附件");
  private final Integer type;
  private final String desc;

  ArticleAttachmentTypeEnum(Integer type, String desc) {
    this.type = type;
    this.desc = desc;
  }

  public static ArticleAttachmentTypeEnum getByType(Integer type) {
    for (ArticleAttachmentTypeEnum item : ArticleAttachmentTypeEnum.values()) {
      if (item.getType().equals(type)) {
        return item;
      }
    }
    return null;
  }

  public Integer getType() {
    return type;
  }

  public String getDesc() {
    return desc;
  }
}