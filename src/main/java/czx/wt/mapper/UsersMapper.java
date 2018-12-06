package czx.wt.mapper;

import czx.wt.pojo.Users;
import org.apache.ibatis.annotations.Param;

/**
 * @Description: 类作用描述
 * @Author: ChenZhiXiang
 * @CreateDate: 2018/12/4 0004 16:16
 * @Version: 1.0
 */
public interface UsersMapper {

    Users selByUser(@Param("username") String username,@Param("password") String password);
}
