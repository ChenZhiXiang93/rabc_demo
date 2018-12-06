package czx.wt.service.impl;

import czx.wt.mapper.UsersMapper;
import czx.wt.pojo.Users;
import czx.wt.service.ElementService;
import czx.wt.service.UrlService;
import czx.wt.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description: 类作用描述
 * @Author: ChenZhiXiang
 * @CreateDate: 2018/12/4 0004 16:19
 * @Version: 1.0
 */
@Service
public class UsersServiceImpl implements UsersService {

    @Resource
    private UsersMapper usersMapper;

    @Autowired
    private MenuServiceImpl menuService;

    @Autowired
    private ElementService elementService;

    @Autowired
    private UrlService urlService;

    @Override
    public Object selUserAndUrls(String username, String password) {
        Users user = usersMapper.selByUser(username,password);
        Map<String,Object> map = new LinkedHashMap<>();
        if(null != user){
            user.setMenus(menuService.showMenu(user.getRid()));
            user.setElements(elementService.getElements(user.getRid()));
            user.setUrls(urlService.getUrlByRid(user.getRid()));
            map.put("allUrl",urlService.getAllUrl());
        }
        map.put("user",user);
        return map;
    }
}
