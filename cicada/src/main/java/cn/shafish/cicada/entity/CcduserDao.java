package cn.shafish.cicada.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author shafish
 * @since 2019-03-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("ccduser")
public class CcduserDao extends Model<CcduserDao> {

    private static final long serialVersionUID = 1L;

    @TableId(type=IdType.AUTO)
    private Integer id;
    
    /**
     * 用户id
     */
    @TableId(value = "ccdUserId", type = IdType.AUTO)
    private Integer ccdUserId;

    /**
     * 用户名
     */
    @TableField("ccdName")
    private String ccdName;

    /**
     * 密码
     */
    @TableField("ccdPasswd")
    private String ccdPasswd;


    @Override
    protected Serializable pkVal() {
        return this.ccdUserId;
    }

}
