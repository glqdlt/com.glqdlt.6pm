package com.glqdlt.pm6.jpapersistence;

import com.glqdlt.pm6.jpapersistence.book.repo.Pm6BookRepo;
import com.glqdlt.pm6.jpapersistence.repo.Pm6BookRepoTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Date 2019-11-14
 *
 * @author glqdlt
 */
@Suite.SuiteClasses({Pm6PersistenceInitTest.class, Pm6BookRepoTest.class, Pm6BookRepo.class})
@RunWith(Suite.class)
public class PersistenceSuite {
}
