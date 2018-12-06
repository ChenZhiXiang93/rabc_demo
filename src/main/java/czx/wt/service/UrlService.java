package czx.wt.service;

import czx.wt.pojo.Urls;

import java.util.List;

/**
 * @Description: 类作用描述
 * @Author: ChenZhiXiang
 * @CreateDate: 2018/12/5 0005 11:20
 * @Version: 1.0
 */
public interface UrlService {

    List<Urls> getUrlByRid(Integer rid);

    List<Urls> getAllUrl();
}
