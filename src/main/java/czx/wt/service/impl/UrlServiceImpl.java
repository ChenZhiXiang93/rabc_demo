package czx.wt.service.impl;

import czx.wt.mapper.UrlMapper;
import czx.wt.pojo.Urls;
import czx.wt.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 类作用描述
 * @Author: ChenZhiXiang
 * @CreateDate: 2018/12/5 0005 11:21
 * @Version: 1.0
 */
@Service
public class UrlServiceImpl implements UrlService {

    @Autowired
    private UrlMapper urlMapper;

    @Override
    public List<Urls> getUrlByRid(Integer rid) {
        return urlMapper.getUrlByRid(rid);
    }

    @Override
    public List<Urls> getAllUrl() {
        return urlMapper.getAllUrl();
    }
}
