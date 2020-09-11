# Bitriser

## What is Bitriser
Bitriser is an experimental Android application that uses [Bitrise API](https://devcenter.bitrise.io/api/api-index/) as a backend.

It's main purpose is to test the newest and greatest frameworks and libraries available for Android developement in Kotlin in order to get familiar with the newest trends so that once they are production ready, we are ready too.

This application is using `Jetpack Compose` for all of it's UI elements and the current focus is to achieve most of the well-known Android and Material UX using it, explicitly.

Furthermore, Gradle's `Kotlin DSL` is used, instead of traditional `Groovy DSL`.

Other libraries:
 - `Koin` for dependency injection
 - `Retrofit2` in pair with `OkHttp3` and coroutines for networking
 - `Moshi` for JSON encoding and decoding
 - `Timber` for logging

**Note:** we are just getting to know Jetpack Compose and you can probably find something used in quite the opposite way than it is supposed to be used, but don't worry, the more we experiment, the more skilled we get!
