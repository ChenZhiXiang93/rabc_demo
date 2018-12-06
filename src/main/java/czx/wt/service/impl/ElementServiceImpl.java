package czx.wt.service.impl;

import czx.wt.mapper.ElementMapper;
import czx.wt.pojo.Elements;
import czx.wt.service.ElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 类作用描述
 * @Author: ChenZhiXiang
 * @CreateDate: 2018/12/5 0005 10:39
 * @Version: 1.0
 */
@Service
public class ElementServiceImpl implements ElementService {

    @Autowired
    private ElementMapper elementMapper;

    @Override
    public List<Elements> getElements(Integer rid) {
        return elementMapper.getElements(rid);
    }
}
