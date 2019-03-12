package dao;

import entity.Department;
import org.hibernate.Session;
import util.DaoUtil;

public class DepartmentDao {

    private DaoUtil daoUtil;

    public DepartmentDao() {
        daoUtil = new DaoUtil();
    }

    public void save(Department entity) {
        Session session = daoUtil.openCurrentSessionWithTransaction();
        session.save(entity);
        daoUtil.closeCurrentSessionWithTransaction();
    }

    public void update(Department entity) {
        Session session = daoUtil.openCurrentSessionWithTransaction();
        session.update(entity);
        daoUtil.closeCurrentSessionWithTransaction();
    }

    public Department findById(int id) {
        Session session = daoUtil.openCurrentSession();
        Department department = session.get(Department.class, id);
        daoUtil.closeCurrentSession();
        return department;
    }

    public void delete(int id) {
        Session session = daoUtil.openCurrentSessionWithTransaction();
        Department department = session.get(Department.class, id);
        session.delete(department);
        daoUtil.closeCurrentSessionWithTransaction();
    }
}
