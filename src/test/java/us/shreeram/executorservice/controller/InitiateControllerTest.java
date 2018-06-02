package us.shreeram.executorservice.controller;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import us.shreeram.executorservice.Executor;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Executor.class)
public class InitiateControllerTest {
    @Autowired
    private InitiateController controller;

    @Test
    public void contexLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

}