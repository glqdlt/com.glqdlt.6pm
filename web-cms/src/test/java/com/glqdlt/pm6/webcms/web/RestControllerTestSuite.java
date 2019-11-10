package com.glqdlt.pm6.webcms.web;

import com.glqdlt.pm6.webcms.web.restful.SomeRestControllerTest;
import com.glqdlt.pm6.webcms.web.restful.book.BookRestControllerTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Date 2019-11-10
 *
 * @author glqdlt
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({BookRestControllerTest.class, SomeRestControllerTest.class})
public class RestControllerTestSuite {
}
