package cn.shafish.cicada.mapper;

import cn.shafish.cicada.entity.CicadacontentDao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author shafish
 * @since 2019-03-09
 */
public interface CicadacontentMapper extends BaseMapper<CicadacontentDao> {
	List<CicadacontentDao> selectAll();
	List<CicadacontentDao> selectByUserId(@Param("id") Integer id);
	IPage<CicadacontentDao> selectContentByPage(Page page);//, @Param("state") Integer state
	Integer addView(@Param("id") Integer id,@Param("readtimes") Integer view);
	List getSavedContent(@Param("Ids") List<Integer> ids);
}
