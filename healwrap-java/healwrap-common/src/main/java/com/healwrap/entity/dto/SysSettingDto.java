package com.healwrap.entity.dto;

import com.healwrap.entity.dto.sysDto.*;
import lombok.Data;

/**
 * @author pepedd
 * @ClassName SysSettingDto
 * @Description 系统设置
 * @Date 2023/4/12 10:37
 */
@Data
public class SysSettingDto {
  /**
   * 邮件设置
   */
  private SysSetting4EmailDto emailSetting;
  /**
   * 评论设置
   */
  private SysSetting4CommentDto commentSetting;
  /**
   * 注册设置
   */
  private SysSetting4RegisterDto registerSetting;
  /**
   * 点赞设置
   */
  private SysSetting4LikeDto likeSetting;
  /**
   * 审核设置
   */
  private SysSetting4AuditDto auditSetting;
  /**
   * 帖子设置
   */
  private SysSetting4PostDto postSetting;
}
