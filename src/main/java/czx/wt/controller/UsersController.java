package czx.wt.controller;

import czx.wt.service.MenuService;
import czx.wt.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class UsersController {
	@Resource
	private UsersService usersServiceImpl;

	@Resource
	private MenuService menuService;

	@PostMapping("/login")
	public Object login(String username, String password, HttpServletRequest request){
		Map<String,Object> map = (Map<String, Object>) usersServiceImpl.selUserAndUrls(username,password);
		HttpSession session = request.getSession();
		if(map.get("user")!=null){
			session.setAttribute("user", map.get("user"));
			session.setAttribute("allUrl",map.get("allUrl"));
			return "main";
		}
		return "login";
	}

	@RequestMapping("/menu")
	public Object login(@RequestParam("rid") Integer rid){

		return menuService.showMenu(rid);
	}
}
