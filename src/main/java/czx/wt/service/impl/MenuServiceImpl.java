package czx.wt.service.impl;


import czx.wt.mapper.MenuMapper;
import czx.wt.pojo.Menu;
import czx.wt.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
	@Resource
	
	private MenuMapper menuMapper;
	@Override
	public List<Menu> showMenu(int rid) {

		return menuMapper.selByRid(rid, 0);
	}

}
