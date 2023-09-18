@file:Suppress("UnstableApiUsage")

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://repo.spring.io/release")
        }
        maven {
            url = uri("https://repository.jboss.org/maven2")
        }
        maven { url = uri("https://plugins.gradle.org/m2/")}
        maven { url = uri("https://www.jitpack.io" ) }
        maven {
            url = uri("https://api.mapbox.com/downloads/v2/releases/maven")
            authentication {
                create<BasicAuthentication>("basic")
            }
            credentials {
                username = "mapbox"
                password = "sk.eyJ1IjoiaWNlYm95NjkiLCJhIjoiY2xtZnZ6dXl4MmVmMzNqbzVrdWJldHV4byJ9.X1Rt6yqDV9JRxy_UV7znww"
            }
        }
    }
}

rootProject.name = "My Application"
include(":app")
 