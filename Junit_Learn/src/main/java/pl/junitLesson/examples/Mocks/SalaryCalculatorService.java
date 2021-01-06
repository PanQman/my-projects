package pl.junitLesson.examples.Mocks;

import java.math.BigDecimal;

public class SalaryCalculatorService {

    private TaskManagementSystem taskManagementSystem;

    public BigDecimal calculateSalary(Employee employee) {
        TaskManagementSystem taskManagementSystem = new TaskManagementSystem();
        int finishedTasks = taskManagementSystem.countFinishedTasksForEmployee(employee);

        BigDecimal bonus = BigDecimal.ZERO;
        if (finishedTasks >= 10) {
            bonus = new BigDecimal("500");
        } else if (finishedTasks > 20) {
            bonus = new BigDecimal("1000");
        }

        return employee.getBaseSalary().add(bonus);
    }

    public SalaryCalculatorService(TaskManagementSystem taskManagementSystem) {
        this.taskManagementSystem = taskManagementSystem;
    }
}
