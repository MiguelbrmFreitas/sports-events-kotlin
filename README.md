# Upcoming Sports Events
## App features
- List upcoming sport events from a given [API](https://618d3aa7fe09aa001744060a.mockapi.io/api/sports)
- Show scrollable list of sports
- Show the upcoming events for each sport 
- - Click a sport to expand and show the upcoming events in a scrollable grid list
- - Click an expanded sport to collapse it again
- - Display a real-time countdown timer and competitors names for each event
- Add/remove an event from favorites by clicking on it
- - Persist the favorite events in local storage
- Toggle the favorite button on each sport to show only favorite events
- Show error messages when getting an API error or empty list
- Simple support for Light Theme and Dark Theme

## Tech Stack
- Coded in [Kotlin](https://kotlinlang.org)
- Layout with [Jetpack Compose](https://developer.android.com/jetpack/compose?gclid=CjwKCAjwoqGnBhAcEiwAwK-OkUa-37do3KnzC0PtXZR4Nnh24MwS1_xJfXZmn7vAIPST0DcoSErlpRoCYWYQAvD_BwE&gclsrc=aw.ds)
- State and behaviour of the UI with [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) and [MutableState](https://developer.android.com/reference/kotlin/androidx/compose/runtime/MutableState)
- Gradle dependencies with [Android version catalogs](https://developer.android.com/build/migrate-to-catalogs)
- Dependency Injection with [Koin](https://insert-koin.io/)
- Async programming with [Coroutines](https://kotlin.github.io/kotlinx.coroutines/)
- Network calls with [Retrofit](https://github.com/square/retrofit)
- Local database storage with [Room](https://developer.android.com/training/data-storage/room)
- JSON parsing with [Moshi](https://github.com/square/moshi)

## Architecture

The app's architecture is implemented following the pattern MVVM + Clean Architecture, common approach used in Android Development and well supported by the Android API.
It has 3 modules, each is a layer:
- app:
- - Entry point of the app and presentation layer
- - Contains Activity, ViewModel, composables components, DI setup with koin, Application class to start DI, UI models and theme files
- domain:
- - domain layer in pure Kotlin module with business
- - contains Repository interface, domain models and use cases
- data
- - data layer with remote and local data sources
- - contains API models, Retrofit Service, Room setup (entity, DAO and Database), Repository implementation and DI setup with koin.
