package com.sdut.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 文件
 *
 * @TableName file
 */
@TableName(value = "file")
@Data
public class File implements Serializable {
    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 文件名
     */
    private String fileName;

    /**
     * 文件原名
     */
    private String fileOriginName;
    
    /**
     * 文件路径
     */
    private String filePath;

    /**
     * 文件大小（MB）
     */
    private BigDecimal fileSize;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}