package com.du.dao;

import com.du.config.pojo.Department;
import com.du.config.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    //模拟数据库的数据
    private static Map<Integer, Employee> employees = null;

    @Autowired
    private DepartmenrDao departmenrDao;

    static {
        employees = new HashMap<Integer,Employee>();

        employees.put(1001,new Employee(1001,"AM","12324@qq.com",0,new Department(101,"教学部")));
        employees.put(1002,new Employee(1002,"WE","12124@qq.com",1,new Department(103,"教研部")));
        employees.put(1003,new Employee(1003,"QW","15324@qq.com",1,new Department(101,"教学部")));
        employees.put(1004,new Employee(1004,"ZX","17324@qq.com",0,new Department(103,"教研部")));
        employees.put(1005,new Employee(1005,"FG","12624@qq.com",1,new Department(103,"教研部")));

    }

    //增删改查
    //主键自增
    private static Integer initId = 1006;
    //增加一个员工
    public void save(Employee employee){
        if (employee.getId()==null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmenrDao.gerDepartmentById((employee.getDepartment().getId())));

        employees.put(employee.getId(),employee);
    }
    //查询全部员工
    public Collection<Employee> getAll(){
        return employees.values();
    }
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }
    public void delete(Integer id){
        employees.remove(id);
    }


}
