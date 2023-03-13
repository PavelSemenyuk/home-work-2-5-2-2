package object;

import java.util.HashMap;
import java.util.Map;

public class Department {
    private Integer id;
    private String name;

    public Department(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    public static final Map<Integer, Department> DEPARTMENT_BY_ID ;
    static {
        DEPARTMENT_BY_ID = new HashMap<>();
        DEPARTMENT_BY_ID.put(1,new Department(1, "Бухгалтерия"));
        DEPARTMENT_BY_ID.put(2,new Department(2,"Отдел кадров"));
        DEPARTMENT_BY_ID.put(3,new Department(3,"Маркетинг"));
    }
}
