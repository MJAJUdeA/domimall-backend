package io.mjaj.domimallbackend.user.v1;

import com.intuit.karate.junit5.Karate;

public class UserRunner {

    @Karate.Test
    Karate testCreate(){
        return Karate.run("create").relativeTo(getClass());
    }
}
