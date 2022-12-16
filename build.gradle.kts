plugins {
    id("org.jetbrains.kotlin.jvm") version "1.7.21"
    id("org.jetbrains.kotlin.kapt") version "1.7.21"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.7.21"
    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("io.micronaut.application") version "3.6.6"
    id("com.google.cloud.tools.appengine") version "2.4.5"
}

version = "0.1"
group = "com.zamolski"

val kotlinVersion = project.properties.get("kotlinVersion")
repositories {
    mavenCentral()
}

dependencies {
    kapt("io.micronaut:micronaut-http-validation")
    implementation("io.micronaut:micronaut-http-client")
    implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")
    implementation("io.micronaut.views:micronaut-views-thymeleaf")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}")
    implementation("org.slf4j:slf4j-api")
}


application {
    mainClass.set("com.zamolski.gaemicronautthymeleaf.ApplicationKt")
}
java.sourceCompatibility = JavaVersion.VERSION_17

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_17.majorVersion
        }
    }
    compileTestKotlin {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_17.majorVersion
        }
    }
}
graalvmNative.toolchainDetection.set(false)
micronaut {
    runtime("netty")
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("com.zamolski.gaemicronautthymeleaf.*")
    }
}

appengine {
    stage.setArtifact("${buildDir}/libs/${project.name}-${project.version}-all.jar")
    deploy {
        projectId = System.getProperty("GAE_PROJECT_ID") ?: "not-set"
        version = "1"
        promote = false
    }
}
