package com.healwrap.entity.constants;

/**
 * @author pepedd
 * @ClassName Constants
 * @Description 一些常量
 * @Date 2023/4/11 12:04
 */
public class Constants {
  /**
   * 本地IP
   */
  public static final String LOCAL_IP_REGEX = "^127\\.0\\.0\\.1$|^::1$|^0\\.0\\.0\\.0$";
  /**
   * 本地IP地址
   */
  public static final String LOCAL_ADDRESS = "内网IP";
  /**
   * http请求
   */
  public static final String HTTP = "http://";

  /**
   * https请求
   */
  public static final String HTTPS = "https://";
  /**
   * 数值常量
   */
  public static final Integer INTEGRAL_5 = 5;
  public static final Integer LENGTH_5 = 5;
  public static final Integer LENGTH_10 = 10;
  public static final Integer LENGTH_15 = 15;
  public static final Integer LENGTH_30 = 30;
  public static final Integer LENGTH_200 = 200;
  public static final Integer FILE_SIZE_1M = 1024 * 1024;
  /**
   * 验证码
   */
  public static final String CHECK_CODE_KEY = "check_code_key";
  /**
   * 邮箱验证码
   */
  public static final String CHECK_CODE_KEY_EMAIL = "check_code_key_email";
  /**
   * 未知地址
   */
  public static final String NO_ADDRESS = "未知";
  /**
   * session key
   */
  public static final String SESSIONS_KEY = "session_key";
  /**
   * 频次
   */
  public static final String SESSIONS_KEY_FREQUENCY = "SESSIONS_KEY_FREQUENCY";
  /**
   * 文件夹
   */
  public static final String FILE_FOLDER_FILE = "/file/";
  /**
   * 临时文件夹
   */
  public static final String FILE_FOLDER_TEMP = "/temp/";
  /**
   * 图片
   */
  public static final String FILE_FOLDER_IMAGE = "/image/";
  /**
   * 头像
   */
  public static final String FILE_FOLDER_AVATAR_NAME = "/avatar/";
  /**
   * 附件
   */
  public static final String FILE_FOLDER_ATTACHMENT = "/attachment/";
  /**
   * 头像后缀
   */
  public static final String AVATAR_SUFFIX = ".jpg";
  /**
   * 允许的图片后缀
   */
  public static final String[] IMAGE_SUFFIX = new String[]{".png", ".PNG", ".jpg", ".JPG", ".jpeg", ".JPEG", ".gif", ".GIF", ".bmp", ".BMP"};
  /**
   * 允许的文件后缀
   */
  public static final String[] FILE_SUFFIX = new String[]{".zip", ".ZIP", ".rar", ".RAR"};
  /**
   * 获取图片路径
   */
  public static final String READ_IMAGE_PATH = "/api/files/getImage/";
  public static final String STATUS_SUCCESS = "success";
}
