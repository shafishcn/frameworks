package cn.shafish.cicada.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author shafish
 * @since 2019-04-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("cicadacomment")
public class CicadacommentDao extends Model<CicadacommentDao> {

    private static final long serialVersionUID = 1L;

    /**
     * 评论id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 文章id
     */
    @TableField("contentId")
    private Integer contentId;

    /**
     * 文章类型
     */
    private String contenttype;

    /**
     * 评论内容
     */
    private String comment;

    /**
     * 评论用户id
     */
    private Integer fromuserid;

    /**
     * 评论目标用户id
     */
    private Integer touserid;
    
    /**
     * 用户昵称
     */
    private String username;

    /**
     * 用户头像
     */
    private String useravatar;
    
    /**
     * 评论时间
     */
    private LocalDateTime time;
    
    /**
     * 子评论json
     */
    private String subcomment;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
