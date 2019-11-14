package com.glqdlt.pm6.persistence;

import com.glqdlt.pm6.persistence.book.repo.Pm6BookRepoTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Date 2019-11-14
 *
 * @author glqdlt
 */
@Suite.SuiteClasses({Pm6PersistenceInitTest.class, Pm6BookRepoTest.class})
@RunWith(Suite.class)
public class PersistenceSuite {
}
