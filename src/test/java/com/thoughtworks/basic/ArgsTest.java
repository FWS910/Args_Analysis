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
    @Test
    public void should_throw_value_no_legal_when_args_given_error_value() throws Exception {
        String inputArgs = "-l -true";

        try {
            Args args = new Args(inputArgs);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            assertEquals("不能识别的命令标识符",exception.getMessage());
        }
    }

    @Test
    public void should_throw_value_no_legal_when_args_given_flages_no_space_split() throws Exception {
        String inputArgs = "-l-d";

        try {
            Args args = new Args(inputArgs);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            assertEquals("参数之间不用空格分割视为非法",exception.getMessage());
        }
    }

    @Test
    public void should_throw_value_no_legal_when_args_given_repeat_flags() throws Exception {
        String inputArgs = "-l -l";

        try {
            Args args = new Args(inputArgs);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            assertEquals("不允许输入重复flag",exception.getMessage());
        }
    }

}
