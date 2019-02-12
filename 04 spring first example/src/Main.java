import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext ac =
                new ClassPathXmlApplicationContext("spring-config.xml");
        App app = ac.getBean(App.class);
        app.connectToDB();

    }
}
