plugins {
    java
    kotlin("jvm") version "1.9.22"
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("xyz.jpenilla.run-paper") version "2.2.2"
}

group = "com.undefined"
version = "1.0"

repositories {
    mavenCentral()
    maven {
        name = "spigotmc-repo"
        url = uri("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    }
    maven {
        name = "undefinedapiRepo"
        url = uri("https://repo.undefinedcreation.com/repo")
    }
    maven("https://repo.extendedclip.com/content/repositories/placeholderapi/")
    maven("https://repo.codemc.io/repository/maven-snapshots/")
}


dependencies {
    compileOnly("org.spigotmc:spigot-api:1.20.4-R0.1-SNAPSHOT")
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("com.undefined:api:0.5.39:mapped")
    implementation("net.wesjd:anvilgui:1.9.2-SNAPSHOT")
    compileOnly("me.clip:placeholderapi:2.11.5")
}

tasks {
    shadowJar {
        archiveFileName.set("UndefinedCombat-shadow.jar")
    }

    compileKotlin {
        kotlinOptions.jvmTarget = "21"
    }
    runServer {
        minecraftVersion("1.20.4")
    }
}

kotlin{
    jvmToolchain(21)
}

