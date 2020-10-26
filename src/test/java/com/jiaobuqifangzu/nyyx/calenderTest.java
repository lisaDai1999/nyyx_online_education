package com.jiaobuqifangzu.nyyx;

import com.jiaobuqifangzu.nyyx.domain.User;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

public class calenderTest {

    @Test
    public void test(){
        User user = new User();
        user.setCreate_time(Calendar.getInstance().getTime());
        System.out.println(user.getCreate_time());
        System.out.println(Calendar.getInstance().getTime());
    }
}
