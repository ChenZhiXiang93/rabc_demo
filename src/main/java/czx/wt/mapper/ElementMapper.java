package czx.wt.mapper;

import czx.wt.pojo.Elements;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description: 类作用描述
 * @Author: ChenZhiXiang
 * @CreateDate: 2018/12/5 0005 10:31
 * @Version: 1.0
 */
public interface ElementMapper {

    List<Elements> getElements(@Param("rid") Integer rid);
}
