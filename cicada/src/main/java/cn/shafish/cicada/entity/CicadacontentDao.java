package cn.shafish.cicada.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
@TableName("cicadacontent")
public class CicadacontentDao extends Model<CicadacontentDao> {

    private static final long serialVersionUID = 1L;

    /**
     * 内容id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 内容作者
     */
    private Integer userid;

    /**
     * 内容
     */
    private String contents;

    /**
     * 内容创建时间
     */
    private LocalDateTime createtime;

    /**
     * 内容收藏次数
     */
    private Integer start;

    /**
     * 内容标题
     */
    private String title;

    /**
     * 内容阅读次数
     */
    private Integer readtimes;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
