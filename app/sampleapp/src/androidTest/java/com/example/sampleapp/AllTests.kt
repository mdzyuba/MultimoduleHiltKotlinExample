package com.example.sampleapp

import com.example.sampleapp.clones.MainActivityV1Test
import org.junit.runner.RunWith
import org.junit.runners.Suite


/**
 * This is an example of a test suite.
 * Note: adding tests from modules to the test suite in the main module does not work.
 * cannot find symbol: OrderActivityTest.class.
 */
@RunWith(Suite::class)
@Suite.SuiteClasses(
    MainActivityTest::class,
    MainActivityV1Test::class,
)
class AllTests