pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Real Estate"
include(":app")
include(":app:core")
include(":app:core:data")
include(":app:property:list:data")
include(":app:property:list:domain")
include(":app:property:list:presentation")
include(":app:property:detail:data")
include(":app:property:detail:domain")
include(":app:property:detail:presentation")
include(":app:core:navigation")
include(":app:core:utils")
include(":app:core:utils")
include(":app:core:theme")
include(":app:property:common")
include(":app:core:components")
