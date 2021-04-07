package com.yad.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 
 * @since 2021-04-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UseComputerRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 计算机编号
     */
    private Integer cId;

    /**
     * 用户id
     */
    private Integer uId;

    /**
     * 上机时间
     */
    private Date upTime;

    /**
     * 下机时间
     */
    private Date downTime;

    /**
     * 上网用时
     */
    private Long totalTime;


}
