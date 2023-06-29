# commons-imaging-gif-test
## Links
* See https://issues.apache.org/jira/browse/IMAGING-355
## Instructions
Run the jar with the image path as parameter:
```bash
git clone git@github.com:andrewmkhoury/commons-imaging-gif-test.git
cd commons-imaging-gif-test
mvn assembly:assembly
java -Xmx1g -jar target/IMAGING-test-0.0.1-SNAPSHOT-jar-with-dependencies.jar commons-imaging-test.gif
```
