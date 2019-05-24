package cn.shafish.cicada.mapper;

import cn.shafish.cicada.entity.CicadauserDao;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author shafish
 * @since 2019-03-25
 */
public interface CicadauserMapper extends BaseMapper<CicadauserDao> {

	CicadauserDao selectByparams(Map<String, Object> params);

}
