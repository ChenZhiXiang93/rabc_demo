package czx.wt.mapper;

import czx.wt.pojo.Urls;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description: 类作用描述
 * @Author: ChenZhiXiang
 * @CreateDate: 2018/12/5 0005 11:12
 * @Version: 1.0
 */
public interface UrlMapper {

    /**
     * 根据角色id查询url
     * @param rid
     * @return
     */
    List<Urls> getUrlByRid(@Param("rid") Integer rid);

    /**
     * 获取所有需要权限认证的url
     * @return
     */
    List<Urls> getAllUrl();

}
