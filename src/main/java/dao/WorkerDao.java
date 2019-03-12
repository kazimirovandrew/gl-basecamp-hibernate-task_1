package dao;

import entity.Worker;
import org.hibernate.Session;
import util.DaoUtil;

public class WorkerDao {

    private DaoUtil daoUtil;

    public WorkerDao() {
        daoUtil = new DaoUtil();
    }

    public void save(Worker entity) {
        Session session = daoUtil.openCurrentSessionWithTransaction();
        session.save(entity);
        daoUtil.closeCurrentSessionWithTransaction();
    }

    public void update(Worker entity) {
        Session session = daoUtil.openCurrentSessionWithTransaction();
        session.update(entity);
        daoUtil.closeCurrentSessionWithTransaction();
    }

    public Worker findById(int id) {
        Session session = daoUtil.openCurrentSession();
        Worker worker = session.get(Worker.class, id);
        daoUtil.closeCurrentSession();
        return worker;
    }

    public void delete(int id) {
        Session session = daoUtil.openCurrentSessionWithTransaction();
        Worker Worker = session.get(Worker.class, id);
        session.delete(Worker);
        daoUtil.closeCurrentSessionWithTransaction();
    }
}
