package io.mjaj.domimallbackend.commerce.v1;


import com.intuit.karate.junit5.Karate;


public class CommerceRunner {


    @Karate.Test
    Karate testCreate(){
        return Karate.run("create").relativeTo(getClass());
    }

    @Karate.Test
    Karate testFindById(){
        return Karate.run("findById").relativeTo(getClass());
    }
}
