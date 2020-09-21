package com.thoughtworks.basic;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ArgsTest {
    @Test
    public void should_return_string_list_when_arg_given_no_value() throws Exception {
        String inputArgs = "-l  -p  -d ";

        Args args = new Args(inputArgs);

        assertEquals("[FlagSchema{flag='l', value=false, type='boolean'}, " +
                        "FlagSchema{flag='p', value=0, type='int'}, " +
                        "FlagSchema{flag='d', value=, type='class java.lang.String'}]"
                ,args.getFlagSchemaList().toString());

    }


}
