package app.service.admin.impl;

import app.dao.admin.ProtocolDao;
import app.entity.Protocol;

import java.util.List;

/**
 * @Description TO-DO
 * @Author DDQ
 * @Date 2020/6/25 20:25
 */
public class ProtocolServiceImpl implements ProtocolDao {
    @Override
    public int addProtocol(Protocol protocol) {
        return 0;
    }

    @Override
    public int deleteProtocolById(String id) {
        return 0;
    }

    @Override
    public int updateProtocol(Protocol protocol) {
        return 0;
    }

    @Override
    public List<Protocol> findAllProtocol() {
        return null;
    }

    @Override
    public List<Protocol> findProtocol(Protocol protocol) {
        return null;
    }

    @Override
    public Protocol findProtocolById(String id) {
        return null;
    }
}
