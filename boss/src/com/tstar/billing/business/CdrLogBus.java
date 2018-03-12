package com.tstar.billing.business;

import com.tstar.ocs.dao.CdrLogMapper;
import com.tstar.ocs.model.CdrLog;
import com.tstar.util.MyBatisSessionFactory;
import com.tstar.util.UUID;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;
import java.util.List;

public class CdrLogBus {

    public static List<CdrLog> getSortingLogs(int status) {
        SqlSession session = MyBatisSessionFactory.getSession();
        try {
            CdrLogMapper dao = session.getMapper(CdrLogMapper.class);
            return dao.selectByFlag(CdrLog.STATUS_INIT);
        } finally {
            session.close();
        }
    }

    public static CdrLog getLastLog(String sourceId, String fileName) {
        SqlSession session = MyBatisSessionFactory.getSession();
        try {
            CdrLogMapper dao = session.getMapper(CdrLogMapper.class);
            return dao.selectLastLog(sourceId, fileName);
        } finally {
            session.close();
        }
    }

    public static void save(CdrLog log) {
        SqlSession session = MyBatisSessionFactory.getSession();
        try {
            CdrLogMapper dao = session.getMapper(CdrLogMapper.class);
            if (log.getId() == null) {
                log.setId(UUID.get());
                log.setCreateTime(new Date());
                dao.insert(log);
            } else {
                log.setUpdateTime(new Date());
                dao.updateByPrimaryKey(log);
            }
            session.commit();
        } finally {
            session.close();
        }
    }

    public static void main(String[] args) throws Exception {
        ICallable iCallable = new ICallable("hah", "xixi", "cc");
        Thread thread = iCallable.creatCallableThread();
        thread.start();
        iCallable.get();
    }
}
