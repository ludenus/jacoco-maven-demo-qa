# jacoco-maven-demo-qa
test project for jacoco-maven-demo

```
mvn clean verify
```

```
java -jar ./src/test/resources/jacoco/lib/jacococli.jar report target/jacoco-merged.exec --classfiles ../jacoco-maven-demo/target/classes/ --sourcefiles ../jacoco-maven-demo/src/main/java/ --html /tmp/jacoco-report && xdg-open /tmp/jacoco-report/index.html
```