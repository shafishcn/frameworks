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
 * @since 2019-04-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("cicadasubcomment")
public class CicadasubcommentDao extends Model<CicadasubcommentDao> {

    private static final long serialVersionUID = 1L;

    /**
     * 子评论id
     */
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Integer id;

    /**
     * 父评论id
     */
    private Integer commentid;

    /**
     * 子评论用户昵称
     */
    private String username;

    /**
     * 子评论用户id
     */
    private Integer userid;

    /**
     * 子评论内容
     */
    private String subcomment;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
