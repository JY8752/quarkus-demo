# kotlin-demo Project

## install
```
//quarkus
curl -Ls https://sh.jbang.dev | bash -s - trust add https://repo1.maven.org/maven2/io/quarkus/quarkus-cli/
curl -Ls https://sh.jbang.dev | bash -s - app install --fresh --force quarkus@quarkusio

//graalvm
brew install --cask graalvm/tap/graalvm-ce-java17

//パスを通す
# graal
export PATH=/Library/Java/JavaVirtualMachines/graalvm-ce-java17-22.2.0/Contents/Home/bin:"$PATH"

//警告が出たら以下のコマンド必要
 sudo xattr -r -d com.apple.quarantine /Library/Java/JavaVirtualMachines/graalvm-ce-java17-22.2.0/
 
[~/study/quarkus/kotlin-demo3] % gu --version
GraalVM Updater 22.2.0

//java
/usr/libexec/java_home -v "17" 
/Library/Java/JavaVirtualMachines/graalvm-ce-java17-22.2.0/Contents/Home

//jenvに追加する
jenv add `/usr/libexec/java_home -v "17"` 

//graalのjavaに切り替える
jenv global graalvm64-17.0.4

//native-imageのインストール
gu install native-image
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

## native
```
//ビルド(2分半くらい)
./gradlew build --native

//実行(めっちゃ早い)
./build/kotlin-demo3-1.0.0-SNAPSHOT-runner
```