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
@TableName("cicadaauths")
public class CicadaauthsDao extends Model<CicadaauthsDao> {

    private static final long serialVersionUID = 1L;

    @TableId(type=IdType.AUTO)
    private Integer id;
    
    /**
     * 用户id
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 登录类型 (手机号/邮箱/用户名) 或第三方应用名称 (微信 , 微博等)
     */
    @TableField("identity_type")
    private String identityType;

    /**
     * 标识 (手机号/邮箱/用户名或第三方应用的唯一标识)
     */
    @TableField("identifier")
    private String identifier;

    /**
     * 密码凭证 (站内的保存密码 , 站外的不保存或保存 token)
     */
    @TableField("credential")
    private String credential;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
