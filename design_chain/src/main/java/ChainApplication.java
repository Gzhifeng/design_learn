import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ChainApplication
 * @Authoe ganzhifeng
 * @Date 2019/7/27 0027
 */
@SpringBootApplication
@ComponentScan(basePackages={"com.zhifeng"})
public class ChainApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChainApplication.class, args);
    }

}
