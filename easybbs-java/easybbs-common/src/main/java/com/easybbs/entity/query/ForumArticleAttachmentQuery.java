package com.easybbs.entity.query;


import lombok.Data;

/**
 *
 * 文件信息参数
 *
 */
@Data
public class ForumArticleAttachmentQuery extends BaseParam {


	/**
	 * 文件ID
	 */
	private String fileId;

	private String fileIdFuzzy;

	/**
	 * 文章ID
	 */
	private String articleId;

	private String articleIdFuzzy;

	/**
	 * 用户id
	 */
	private String userId;

	private String userIdFuzzy;

	/**
	 * 文件大小
	 */
	private Long fileSize;

	/**
	 * 文件名称
	 */
	private String fileName;

	private String fileNameFuzzy;

	/**
	 * 下载次数
	 */
	private Integer downloadCount;

	/**
	 * 文件路径
	 */
	private String filePath;

	private String filePathFuzzy;

	/**
	 * 文件类型
	 */
	private Integer fileType;

	/**
	 * 下载所需积分
	 */
	private Integer integral;

}
