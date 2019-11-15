package com.glqdlt.pm6.webcms.web;

import com.glqdlt.pm6.webcms.web.controller.restful.SomeRestControllerTest;
import com.glqdlt.pm6.webcms.web.controller.restful.book.BookRestControllerTest;
import com.glqdlt.pm6.webcms.web.controller.restful.metadata.MetaDataRestControllerTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Date 2019-11-10
 *
 * @author glqdlt
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({BookRestControllerTest.class, SomeRestControllerTest.class, MetaDataRestControllerTest.class})
public class RestControllerTestSuite {
}
