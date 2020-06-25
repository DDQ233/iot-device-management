package app.dao.admin;
import app.entity.PriClassify;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description TO-DO
 * @Author DDQ
 * @Date 2020/6/23 22:35
 */
@Mapper
@Component
public interface PriClassifyDao {
    // 添加一级分类
    int addPriClassify(PriClassify priClassify);

    // 删除一级分类
    int deletePriClassifyById(String id);

    // 更新一级分类
    int updatePriClassify(PriClassify priClassify);

    // 查询所有一级分类
    List<PriClassify> findAllPriClassify();

    // 查询一级分类
    PriClassify findPriClassify(PriClassify priClassify);

    // 根据 ID 查询一级分类
    PriClassify findPriClassifyById(String id);
}
