package com.easybbs.entity.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author pepedd
 * @ClassName AppConfig
 * @Description 应用配置
 * @Date 2023/4/11 18:16
 */
@Data
@Component
public class AppConfig {
  /**
   * 项目名称
   */
  @Value("${easybbs.name:}")
  private String name;
  /**
   * 项目版本
   */
  @Value("${easybbs.version:}")
  private String version;

  @Value("${project.folder:}")
  private String projectFolder;
}
