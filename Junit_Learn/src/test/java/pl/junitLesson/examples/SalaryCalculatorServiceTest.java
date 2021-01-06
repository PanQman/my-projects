package pl.junitLesson.examples;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import pl.junitLesson.examples.Mocks.Employee;
import pl.junitLesson.examples.Mocks.SalaryCalculatorService;
import pl.junitLesson.examples.Mocks.TaskManagementSystem;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class SalaryCalculatorServiceTest {

    @Mock TaskManagementSystem taskManagementSystem;
    private SalaryCalculatorService salaryCalculatorService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        salaryCalculatorService = new SalaryCalculatorService(taskManagementSystem);
    }

    @Test
    public void shouldHaveNoBonus() {
        Employee employee = new Employee("Tomek", BigDecimal.valueOf(2000));
        when(taskManagementSystem.countFinishedTasksForEmployee(employee)).thenReturn(9);

        BigDecimal salary = salaryCalculatorService.calculateSalary(employee);

        assertThat(salary).isEqualTo(BigDecimal.valueOf(2000));
    }

    @Test
    public void shouldHave1000Bonus() {
        Employee employee = new Employee("Tomek", BigDecimal.valueOf(2000));
        when(taskManagementSystem.countFinishedTasksForEmployee(employee)).thenReturn(20);

        BigDecimal salary = salaryCalculatorService.calculateSalary(employee);

        assertThat(salary).isEqualTo(BigDecimal.valueOf(3000));
    }

    public BigDecimal calculateSalary(Employee employee) {
        int finishedTasks = taskManagementSystem.countFinishedTasksForEmployee(employee);

        BigDecimal bonus = BigDecimal.ZERO;
        if (finishedTasks >= 20) {
            bonus = new BigDecimal("1000");
        } else if (finishedTasks >= 10) {
            bonus = new BigDecimal("500");
        }

        return employee.getBaseSalary().add(bonus);
    }

    @ValueSource(ints = {10, 19})
    @ParameterizedTest
    public void shouldHave500Bonus(int finishedTasks) {
        Employee employee = Mockito.mock(Employee.class);
        when(employee.getBaseSalary()).thenReturn(BigDecimal.valueOf(2000));
        when(taskManagementSystem.countFinishedTasksForEmployee(employee)).thenReturn(finishedTasks);

        BigDecimal salary = salaryCalculatorService.calculateSalary(employee);

        assertThat(salary).isEqualTo(BigDecimal.valueOf(2500));
    }
}
