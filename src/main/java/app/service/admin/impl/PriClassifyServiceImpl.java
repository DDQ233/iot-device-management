package app.service.admin.impl;

import app.dao.admin.PriClassifyDao;
import app.entity.PriClassify;
import app.service.admin.PriClassifyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description TO-DO
 * @Author DDQ
 * @Date 2020/6/25 21:44
 */
@Service
public class PriClassifyServiceImpl implements PriClassifyService {
    @Resource(name = "priClassifyDao")
    private PriClassifyDao priClassifyDao;

    @Override
    public int addPriClassify(PriClassify priClassify) {
        return priClassifyDao.addPriClassify(priClassify);
    }

    @Override
    public int deletePriClassifyById(String id) {
        return priClassifyDao.deletePriClassifyById(id);
    }

    @Override
    public int updatePriClassify(PriClassify priClassify) {
        return priClassifyDao.updatePriClassify(priClassify);
    }

    @Override
    public List<PriClassify> findAllPriClassify() {
        return priClassifyDao.findAllPriClassify();
    }

    @Override
    public List<PriClassify> findPriClassify(PriClassify priClassify) {
        return priClassifyDao.findPriClassify(priClassify);
    }

    @Override
    public PriClassify findPriClassifyById(String id) {
        return priClassifyDao.findPriClassifyById(id);
    }
}
