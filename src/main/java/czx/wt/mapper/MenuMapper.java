package czx.wt.mapper;

import czx.wt.pojo.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuMapper {

	List<Menu> selByRid(@Param("rid") int rid, @Param("pid") int pid);
}
