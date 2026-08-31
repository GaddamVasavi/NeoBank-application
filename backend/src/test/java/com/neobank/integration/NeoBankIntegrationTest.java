package com.neobank.integration;
import com.neobank.account.AccountService; import com.neobank.auth.AuthService; import com.neobank.user.UserService;
import org.junit.jupiter.api.Test; import org.springframework.boot.test.context.SpringBootTest; import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.Assertions.assertTrue;
@SpringBootTest(classes = com.neobank.NeoBankApplication.class)
public class NeoBankIntegrationTest {
    @MockBean private AuthService authService;
    @MockBean private UserService userService;
    @MockBean private AccountService accountService;
    @Test void contextLoads() { assertTrue(true); }
}
