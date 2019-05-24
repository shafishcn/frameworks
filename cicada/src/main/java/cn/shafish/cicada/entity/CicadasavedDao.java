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
 * @since 2019-04-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("cicadasaved")
public class CicadasavedDao extends Model<CicadasavedDao> {

    private static final long serialVersionUID = 1L;

    /**
     * 收藏表id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 收藏列表所属用户
     */
    @TableField("userId")
    private Integer userId;

    /**
     * 收藏内容
     */
    @TableField("contentId")
    private Integer contentId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
