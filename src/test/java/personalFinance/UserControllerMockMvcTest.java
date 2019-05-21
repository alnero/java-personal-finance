package personalFinance;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import personalFinance.controller.UserController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerMockMvcTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void whenNoUserFoundThenUserNotFoundStatusReturnedByServer() throws Exception {
        mvc.perform(put("/users/-1"))
                .andExpect(status().isNotFound())
                .andExpect(status().reason("User with id=-1 not found"))
                .andDo(print());
    }
}
