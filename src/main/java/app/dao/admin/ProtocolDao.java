package app.dao.admin;
import app.entity.Protocol;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description TO-DO
 * @Author DDQ
 * @Date 2020/6/23 22:57
 */
@Mapper
@Component
public interface ProtocolDao {
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

    // 协议计数
    int count();
}
