# Pixy

- This is a simple API designed for Spigot, just so that plugin creation for myself was easier.
- It is not meant to be used by anyone else, but if you want to, go ahead.

## How to use
- Maven
```xml

<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io/</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>com.github.staudlol</groupId>
        <artifactId>pixy</artifactId>
        <version>VERSION</version>
        <scope>provided</scope>
    </dependency>
</dependencies>

```

- Gradle
```groovy

repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    compileOnly 'com.github.staudlol:pixy:VERSION'
}

```
