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
 * @since 2019-03-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("cicadamember")
public class CicadamemberDao extends Model<CicadamemberDao> {

    private static final long serialVersionUID = 1L;

    @TableId(type=IdType.AUTO)
    private Integer id;
    
    /**
     * 用户昵称
     */
    @TableField("ccdname")
    private String ccdname;

    /**
     * 用户头像url
     */
    @TableField("ccdavatar")
    private String ccdavatar;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
