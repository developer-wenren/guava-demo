package com.one;

import com.google.common.base.Optional;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public  void test() {
        List<String> list = null;
        Optional<List<String>> listOptional = Optional.fromNullable(list);
        System.out.println(listOptional.isPresent());
    }
}
