package cn.shafish.cicada.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
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
 * @author shafish
 * @since 2019-03-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("cicadauser")
public class CicadauserDao extends Model<CicadauserDao> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户呢称
     */
    private String ccdname;

    /**
     * 密码凭证 (站内的保存密码 , 站外的不保存或保存 token)
     */
    private String ccdpasswd;

    /**
     * 用户头像url
     */
    private String ccdavatar;

    /**
     * 用户标识（手机号/邮箱/用户名）
     */
    private String identifier;

    /**
     * 登录类型 (手机号/邮箱/用户名) 或第三方应用名称 (微信 , 微博等)
     */
    private String identitytype;
    
    /**
     * 性别
     */
    private String gender;
    
    /**
     * 邮箱
     */
    private String email;
    
    /**
     * 地址
     */
    private String location;
    
    /**
     * 一言
     */
    private String mark;
    


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
