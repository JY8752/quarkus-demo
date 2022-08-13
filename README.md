# kotlin-demo Project

## install
```
//quarkus
curl -Ls https://sh.jbang.dev | bash -s - trust add https://repo1.maven.org/maven2/io/quarkus/quarkus-cli/
curl -Ls https://sh.jbang.dev | bash -s - app install --fresh --force quarkus@quarkusio
```

## setup
```
//create app
quarkus create app com.example:quarkus-demo \
--extension=kotlin,resteasy-reactive-jackson --gradle-kotlin-dsl
```

## flyway
```
./gradlew flywayMigrate
```