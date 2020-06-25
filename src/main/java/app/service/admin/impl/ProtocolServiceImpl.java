package app.service.admin.impl;

import app.dao.admin.ProtocolDao;
import app.entity.Protocol;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description TO-DO
 * @Author DDQ
 * @Date 2020/6/25 20:25
 */
@Service
public class ProtocolServiceImpl implements ProtocolDao {
    @Resource
    private ProtocolDao protocolDao;

    @Override
    public int addProtocol(Protocol protocol) {
        return protocolDao.addProtocol(protocol);
    }

    @Override
    public int deleteProtocolById(String id) {
        return protocolDao.deleteProtocolById(id);
    }

    @Override
    public int updateProtocol(Protocol protocol) {
        return protocolDao.updateProtocol(protocol);
    }

    @Override
    public List<Protocol> findAllProtocol() {
        return protocolDao.findAllProtocol();
    }

    @Override
    public List<Protocol> findProtocol(Protocol protocol) {
        return protocolDao.findProtocol(protocol);
    }

    @Override
    public Protocol findProtocolById(String id) {
        return protocolDao.findProtocolById(id);
    }
}
