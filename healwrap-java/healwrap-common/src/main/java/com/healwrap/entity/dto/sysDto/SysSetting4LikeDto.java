package com.healwrap.entity.dto.sysDto;

import com.healwrap.entity.annotation.VerifyParams;
import lombok.Data;

/**
 * @author pepedd
 * @ClassName SysSetting4LikeDto
 * @Description 点赞设置
 * @Date 2023/4/12 10:31
 */
@Data
public class SysSetting4LikeDto {
  /**
   * 点赞阈值
   */
  @VerifyParams(required = true)
  private Integer likeDayCountThreshold;
}
