package com.healwrap.controller;

import com.healwrap.controller.base.ABaseController;
import com.healwrap.entity.annotation.GlobalIntercepter;
import com.healwrap.entity.constants.Constants;
import com.healwrap.entity.enums.ResponseCodeEnum;
import com.healwrap.entity.enums.UserOperFrequencyTypeEnum;
import com.healwrap.entity.vo.ResponseVO;
import com.healwrap.exception.BusinessException;
import com.healwrap.framework.config.AppConfig;
import com.healwrap.framework.config.WebConfig;
import com.healwrap.utils.StringTools;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pepedd
 * @ClassName FileController
 * @Description 文件控制器
 * @Date 2023/5/5 20:48
 */
@RestController
@RequestMapping("/files")
public class FileController extends ABaseController {
  private static final Logger logger = LoggerFactory.getLogger(FileController.class);
  @Resource
  private WebConfig webConfig;
  @Resource
  private AppConfig appConfig;

  /**
   * 上传图片
   *
   * @param file 图片文件
   * @return
   */

  @RequestMapping("/uploadImage")
  @GlobalIntercepter(checkLogin = true, frequencyType = UserOperFrequencyTypeEnum.IMAGE_UPLOAD)
  public ResponseVO uploadImage(MultipartFile file) {
    if (file == null) {
      throw new BusinessException(ResponseCodeEnum.CODE_600);
    }
    String fileName = file.getOriginalFilename();
    assert fileName != null;
    String fileSuffix = StringTools.getFileSuffix(fileName);
    if (!ArrayUtils.contains(Constants.IMAGE_SUFFIX, fileSuffix)) {
      throw new BusinessException(ResponseCodeEnum.CODE_600);
    }
    String path = copyFile(file);
    Map<String, String> fileMap = new HashMap<>();
    fileMap.put("fileName", path);
    return getSuccessResponseVO(fileMap);
  }

  private String copyFile(MultipartFile file) {
    try {
      String fileName = file.getOriginalFilename();
      assert fileName != null;
      String fileSuffix = StringTools.getFileSuffix(fileName);
      String fileRealName = StringTools.getRandomString(Constants.LENGTH_30) + fileSuffix;
      String folderPath = webConfig.getProjectFolder() + Constants.FILE_FOLDER_FILE + Constants.FILE_FOLDER_TEMP;
      File folder = new File(folderPath);
      if (!folder.exists()) {
        folder.mkdirs();
      }
      File uploadFile = new File(folderPath + "/" + fileRealName);
      file.transferTo(uploadFile);
      return Constants.FILE_FOLDER_TEMP + fileRealName;
    } catch (Exception e) {
      logger.error("上传文件失败", e);
      throw new BusinessException("上传文件失败");
    }
  }

  /**
   * 获取图片
   *
   * @param response    响应
   * @param imageFolder 图片文件夹
   * @param imageName   图片名称
   */

  @GetMapping("/getImage/{imageFolder}/{imageName}")
  public void getImage(HttpServletResponse response, @PathVariable("imageFolder") String imageFolder, @PathVariable("imageName") String imageName) {
    readImage(response, imageFolder, imageName);
  }

  /**
   * 获取头像
   *
   * @param response 响应
   * @param userId   用户id
   */
  @GetMapping("/getAvatar/{userId}")
  public void getAvatar(HttpServletResponse response, @PathVariable("userId") String userId) {
    String avatarFolderName = Constants.FILE_FOLDER_FILE + Constants.FILE_FOLDER_AVATAR_NAME;
    String avatarPath = webConfig.getProjectFolder() + avatarFolderName + userId + Constants.AVATAR_SUFFIX;
    File avatarFolder = new File(webConfig.getProjectFolder() + avatarFolderName);
    if (!avatarFolder.exists()) {
      avatarFolder.mkdirs();
    }
    String imageName = userId + Constants.AVATAR_SUFFIX;
    File file = new File(avatarPath);
    if (!file.exists()) {
      imageName = appConfig.getDefaultAvatar();
    }
    readImage(response, Constants.FILE_FOLDER_AVATAR_NAME, imageName);
  }

  private void readImage(HttpServletResponse response, String imageFolder, String imageName) {
    ServletOutputStream sos = null;
    FileInputStream fis = null;
    ByteArrayOutputStream bos = null;
    try {
      if (StringTools.isEmpty(imageFolder) || StringTools.isEmpty(imageName)) {
        throw new BusinessException(ResponseCodeEnum.CODE_600);
      }
      String imageSuffix = StringTools.getFileSuffix(imageName);
      String filePath = webConfig.getProjectFolder() + Constants.FILE_FOLDER_FILE + Constants.FILE_FOLDER_IMAGE + "/" + imageFolder + "/" + imageName;
      if (Constants.FILE_FOLDER_TEMP.replace("/", "").equals(imageFolder) || imageFolder.contains(Constants.FILE_FOLDER_AVATAR_NAME)) {
        filePath = webConfig.getProjectFolder() + Constants.FILE_FOLDER_FILE + imageFolder + "/" + imageName;
      }
      File file = new File(filePath);
      if (!file.exists()) {
        throw new BusinessException(ResponseCodeEnum.CODE_600);
      }
      imageSuffix = imageSuffix.replace(".", "");
      if (!Constants.FILE_FOLDER_AVATAR_NAME.equals(imageFolder)) {
        response.setHeader("Cache-Control", "max-age=2592000");
      }
      response.setContentType("image/" + imageSuffix);
      fis = new FileInputStream(file);
      sos = response.getOutputStream();
      bos = new ByteArrayOutputStream();
      int ch = 0;
      while (-1 != (ch = fis.read())) {
        bos.write(ch);
      }
      sos.write(bos.toByteArray());
    } catch (Exception e) {
      logger.error("读取图片失败", e);
      throw new BusinessException("读取图片失败");
    }
  }
}
