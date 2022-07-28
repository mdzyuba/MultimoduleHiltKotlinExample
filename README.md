# MultimoduleHiltKotlinExample
An example app to experiment with Hilt.

This is a toy project. It is created to experiment with Dagger/Hilt and Gradle.

## Gradle Modules

```
Root project 'MultimoduleHiltKotlinExample'
+--- Project ':app'
|    \--- Project ':app:sampleapp' - the main app module
+--- Project ':libraries'
|    +--- Project ':libraries:common_resources'
|    +--- Project ':libraries:product'
|    +--- Project ':libraries:shipping'
|    \--- Project ':libraries:shop'
+--- Project ':tests'
|    \--- Project ':tests:custom_test_runner'
\--- Project ':tools'
     \--- Project ':tools:lintchecks'
```

## Android Espresso Tests

In the library modules, Android Espresso tests in modules can verify activities specific to modules.
In the main app module, Android Espresso tests can verify navigation across activities in all submodules.

## Hilt
The Hilt is enabled in all modules.

### enableExperimentalClasspathAggregation flag

The flag is enabled in this project.

The project has a copy of the same setup as described in https://github.com/google/dagger/issues/1991 with 2.29.1-alpha.
It is done to reproduce the issue when the flag is off.

// This will return cannot access OkHttpClient
// enableExperimentalClasspathAggregation = false

However, when the flag is on, the lint run fails due to https://github.com/google/dagger/issues/2378. 

## How to Build

./gradlew assemble

Note: 
The "./gradlew build" runs lint. That is blocked for now due to the issue mentioned above.
A workaround is to run assemble first.
 
## How to Run Unit Tests

./gradlew testBasicDebugUnitTest 

or to run tests for all flavors: 

./gradlew test  
 
## How to Run Android Integration Tests

Before running these tests, please start an Android emulator or connect an Android device.

./gradlew connectedBasicDebugAndroidTest


