# crypto4j

Crypto4j is a java library for encrypt and decrypt values with Asymmetric and Symmetrical keys.

## Installation

### Maven
```maven
<dependency>
    <groupId>io.github.mrspock182</groupId>
    <artifactId>crypto4j</artifactId>
    <version>1.0.1</version>
</dependency>
```

### Gradle/Grails
```gradle
compile 'io.github.mrspock182:crypto4j:1.0.1'
```

### Gradle Kotlin
```gradle kotlin
implementation("io.github.mrspock182:crypto4j:1.0.1")
```

### Scala SBT
```scala
libraryDependencies += "io.github.mrspock182" % "crypto4j" % "1.0.1"
```

### Groovy Grape
```Groovy Grape
@Grapes( 
@Grab(group='io.github.mrspock182', module='crypto4j', version='1.0.1') 
)
```

### Apache Buildr
```apache buildr
'io.github.mrspock182:crypto4j:jar:1.0.1'
```

### Apache Ivy
```apache ivy
<dependency org="io.github.mrspock182" name="crypto4j" rev="1.0.1" />
```

### Leiningen
```leiningen
[io.github.mrspock182/crypto4j "1.0.1"]
```

### Maven Central Badge
```maven central badge
[![Maven Central](https://img.shields.io/maven-central/v/io.github.mrspock182/crypto4j.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22io.github.mrspock182%22%20AND%20a:%22crypto4j%22)
```

### PURL
```purl
pkg:maven/io.github.mrspock182/crypto4j@1.0.1
```

### Bazel
```bazel
maven_jar(
    name = "crypto4j",
    artifact = "io.github.mrspock182:crypto4j:1.0.1",
    sha1 = "2252948eefb8ad5c547ee741a85e5865d9ef0383",
)
```

Obs: The version 1.0.0 have a problem with Asymmetric keys

## Usage Symmmetrical Key

Your key need 14 bytes to work.

### Encryption

```java
import io.github.mrspock182.Encryption;
import io.github.mrspock182.constant.Cipher;
import io.github.mrspock182.constant.TypeEncryption;
import io.github.mrspock182.constant.Unicode;
import io.github.mrspock182.encryption.EncryptionSymmetrical;

Encryption encryption = new EncryptionSymmetrical(TypeEncryption.AES, Unicode.UTF8,
                "{YOUR_KEY}", Cipher.PKCS5PADDING);
        String encryptSymmetrical = encryption.encrypt("WORD TO ENCRYPT");
        System.out.println(encryptSymmetrical);
```

### Decryption

```java
import io.github.mrspock182.Decryption;
import io.github.mrspock182.constant.Cipher;
import io.github.mrspock182.constant.TypeEncryption;
import io.github.mrspock182.constant.Unicode;
import io.github.mrspock182.decryption.DecryptionSymmetrical;

Decryption decryption = new DecryptionSymmetrical(TypeEncryption.AES, Unicode.UTF8,
                "{YOUR_KEY}", Cipher.PKCS5PADDING);
        String decryptSymmetrical = decryption.toString("TIlt3ujfxpp_bLrOLL3S-A==");
        System.out.println(decryptSymmetrical);
```

## Usage Asymmetric Key

### Generate Public And Private Keys

```java
import io.github.mrspock182.GenerateKey;
import io.github.mrspock182.constant.TypeEncryption;
import io.github.mrspock182.generate.GenerateAsymmetricKey;

GenerateKey generate = new GenerateAsymmetricKey(TypeEncryption.RSA, 
"{FILE_PATH}", {SIZE_KEY});
generateKey.generate();
```

### Encryption

```java
import io.github.mrspock182.Encryption;
import io.github.mrspock182.constant.TypeEncryption;
import io.github.mrspock182.constant.Unicode;
import io.github.mrspock182.encryption.EncryptionAsymmetric;

Encryption encryption = new EncryptionAsymmetric(Unicode.UTF8,
                TypeEncryption.RSA, "{FILE_PATH}/public.key");
String value = encryption.encrypt("WORD TO ENCRYPT");
System.out.println(encryptSymmetrical);
```

### Decryption

```java
import io.github.mrspock182.Decryption;
import io.github.mrspock182.constant.TypeEncryption;
import io.github.mrspock182.constant.Unicode;
import io.github.mrspock182.decryption.DecryptionAsymmetric;

Decryption decryption = new DecryptionAsymmetric(Unicode.UTF8,
            TypeEncryption.RSA, "{FILE_PATH}/private.key");
String value = decryption.toString("VALUE ENCRYPTED");
```

## Contributing
If our library needs to implement something new to solve your problem or wants to collaborate, send your pull request.
If you find any error you can inform us through github issues

Please make sure to update tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)
