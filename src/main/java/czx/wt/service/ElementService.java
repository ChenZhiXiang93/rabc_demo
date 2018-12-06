package czx.wt.service;

import czx.wt.pojo.Elements;

import java.util.List;

/**
 * @Description: 类作用描述
 * @Author: ChenZhiXiang
 * @CreateDate: 2018/12/5 0005 10:38
 * @Version: 1.0
 */
public interface ElementService {

    List<Elements> getElements(Integer rid);
}
