**Run UI Google test (Chrome browser 87 needed) from ui-test module**: 
mvn -Dsurefire.suiteXmlFiles=src/test/resources/ui-test.xml clean test

**Run Age Function Unit test from unit-test module**: 
mvn -Dsurefire.suiteXmlFiles=src/test/resources/unit-test.xml clean test
