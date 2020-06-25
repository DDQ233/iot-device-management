package app.service.admin;

import app.entity.Protocol;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description TO-DO
 * @Author DDQ
 * @Date 2020/6/25 20:24
 */
@Service
public interface ProtocolService {
    // 添加设备接入协议
    int addProtocol(Protocol protocol);

    // 删除设备接入协议
    int deleteProtocolById(String id);

    // 更新设备接入协议
    int updateProtocol(Protocol protocol);

    // 查询所有设备接入协议
    List<Protocol> findAllProtocol();

    // 查询设备接入协议
    List<Protocol> findProtocol(Protocol protocol);

    // 根据 ID 查询设备接入协议
    Protocol findProtocolById(String id);
}
