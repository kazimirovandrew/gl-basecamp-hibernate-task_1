import dao.DepartmentDao;
import dao.WorkerDao;
import entity.Availability;
import entity.Department;
import entity.Worker;

public class App {

    public static void main(String[] args) {

        DepartmentDao departmentDao = new DepartmentDao();

        Department dep1 = new Department("1_dep", true);
        departmentDao.save(dep1);

        Department dep2 = new Department("2_dep", true);
        departmentDao.save(dep2);

        dep1.setStatus(false);
        departmentDao.update(dep1);

        dep1 = departmentDao.findById(1);
        System.out.println("1_dep status: " + dep1.isStatus());

        departmentDao.delete(dep2.getId());

        Department dep3 = new Department("3_dep", true);
        departmentDao.save(dep3);


        WorkerDao workerDao = new WorkerDao();

        Worker worker1 = new Worker(22, Availability.PART_TIME, "ABC", dep1);
        workerDao.save(worker1);

        Worker worker2 = new Worker(30, Availability.FULL_TIME, "ZzZ", dep3);
        workerDao.save(worker2);

        Worker worker3 = new Worker(25, Availability.PART_TIME, "qwerty", dep1);
        workerDao.save(worker3);

        worker1.setAvailability(Availability.FULL_TIME);
        worker1.setDepartment(dep3);
        workerDao.update(worker1);

        worker1 = workerDao.findById(1);
        System.out.println("worker1 availability: " + worker1.getAvailability());

        departmentDao.delete(dep1.getId());
    }
}
