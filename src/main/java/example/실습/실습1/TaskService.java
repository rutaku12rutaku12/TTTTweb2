package example.실습.실습1;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
@RequiredArgsConstructor
public class TaskService {

    public final TaskDao taskDao;

    @Scheduled( cron = "0/30 * * * * *")
    public void task1(){
        taskDao.method1(-3);
        System.out.println("TaskService.task1");
    }

    @Scheduled( cron = "0 0/1 * * * *")
    public void task2(){
        taskDao.method2();
        System.out.println("TaskService.task2");
    }

    @Scheduled( cron = "0 0/5 * * * *")
    public void task3(){
        taskDao.method3();
        System.out.println("TaskService.task3");
    }
}
