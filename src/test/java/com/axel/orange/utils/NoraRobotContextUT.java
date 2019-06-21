package com.axel.orange.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.Assert;
import org.junit.Test;

import com.axel.orange.utils.NoraRobotContext;

public class NoraRobotContextUT {

    @Test
    public void testConstructorIsPrivate() throws Exception {
        Constructor<NoraRobotContext> constructor = NoraRobotContext.class.getDeclaredConstructor();
        Assert.assertTrue(Modifier.isPrivate(constructor.getModifiers()));
        constructor.setAccessible(true);
        constructor.newInstance();
    }

}
