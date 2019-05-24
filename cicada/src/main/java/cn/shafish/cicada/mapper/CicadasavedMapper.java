package cn.shafish.cicada.mapper;

import cn.shafish.cicada.entity.CicadasavedDao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author shafish
 * @since 2019-04-14
 */
public interface CicadasavedMapper extends BaseMapper<CicadasavedDao> {
	CicadasavedDao isSaved(@Param("contentId") Integer contentId,@Param("userId") Integer userId);

	List getContentId(@Param("userId") Integer userId);
}
