package com.healwrap.entity.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.healwrap.entity.enums.UserIntegralOperTypeEnum;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * 用户积分记录表
 */
@Data
public class UserIntegralRecord implements Serializable {


  /**
   * 记录ID
   */
  private Integer recordId;

  /**
   * 用户ID
   */
  private String userId;

  /**
   * 操作类型
   */
  private Integer operType;

  /**
   * 积分
   */
  private Integer integral;

  /**
   * 创建时间
   */
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date createTime;
  private String operTypeName;

  public String getOperTypeName() {
    UserIntegralOperTypeEnum operTypeEnum = UserIntegralOperTypeEnum.getByOperType(operType);
    return operTypeEnum == null ? "" : operTypeEnum.getDesc();
  }
}
