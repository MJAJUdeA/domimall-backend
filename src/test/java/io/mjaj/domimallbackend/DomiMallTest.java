package io.mjaj.domimallbackend;

import com.intuit.karate.junit5.Karate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class DomiMallTest {

    @Karate.Test
    Karate testAll(){
        return Karate.run().relativeTo(getClass());
    }
}
