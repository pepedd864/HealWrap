package com.healwrap.entity.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * 点赞记录
 */
@Data
public class LikeRecord implements Serializable {


  /**
   * 自增ID
   */
  private Integer opId;

  /**
   * 操作类型0:文章点赞 1:评论点赞
   */
  private Integer opType;

  /**
   * 主体ID
   */
  private String objectId;

  /**
   * 用户ID
   */
  private String userId;

  /**
   * 发布时间
   */
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date createTime;

  /**
   * 主体作者ID
   */
  private String authorUserId;
}
