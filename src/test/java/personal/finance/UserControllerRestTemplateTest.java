package personal.finance;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class UserControllerRestTemplateTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void whenNoUserFoundThenUserNotFoundExceptionThrown() {
        testRestTemplate.put("http://localhost:8080/users/-1", null);
    }

}
