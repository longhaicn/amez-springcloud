package com.union.aimei.common.model.system;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
/**
 * @author liufeihua
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@ApiModel(value = "方案附件表")
public class BaseAttachment implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    @ApiModelProperty("附件保存路径")
    private String filePath;
    @ApiModelProperty("附件名称")
    private String fileName;
    @ApiModelProperty("文件重命名")
    private String fileRename;
    @ApiModelProperty("文件后缀")
    private String fileSuffix;
    @ApiModelProperty("文件大小，单位是字节")
    private Double fileSize;
    @ApiModelProperty("文件连接路径")
    private String fileUrl;
    @ApiModelProperty("文件保存的目标地，1本地保存，2远程服务器保存")
    private Integer fileSaveDes;
    @ApiModelProperty("上传时间")
    private Date createTime;
    @ApiModelProperty("更新时间")
    private Date updateTime;
}