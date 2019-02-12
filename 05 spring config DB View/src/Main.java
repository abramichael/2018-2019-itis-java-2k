import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.kpfu.itis.group701.db.DB;
import ru.kpfu.itis.group701.models.User;
import ru.kpfu.itis.group701.views.View;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ac =
                new ClassPathXmlApplicationContext("spring-config.xml");
        //View view = ac.getBean(View.class);
        DB db = ac.getBean(DB.class);
        View view = (View) ac.getBean("view");
        System.out.println(view.showUsers(db.getUsers()));

    }
}
