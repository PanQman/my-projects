package pl.junitLesson.examples.Mocks;

import java.util.Random;

public class TaskManagementSystem {

    public int countFinishedTasksForEmployee(Employee employee) {
        return new Random().nextInt(30);
    }
}
