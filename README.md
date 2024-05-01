# Upcoming Sports Events
## App features
- List upcoming sport events from a given [API](https://618d3aa7fe09aa001744060a.mockapi.io/api/sports)
- Show scrollable list of sports
- Show the upcoming events for each sport 
  - Click a sport to expand and show the upcoming events in a scrollable grid list
  - Click an expanded sport to collapse it again
  - Display a real-time countdown timer (format dd:HH:mm:ss) and competitors names for each event
- Add/remove an event from favorites by clicking on it
 - Persist the favorite events in local storage
- Toggle the favorite button on each sport to show only favorite events
- Show error messages when getting an API error or empty list
- Simple support for Light Theme and Dark Theme

[Video with demonstration](https://github.com/MiguelbrmFreitas/sports-events-kotlin/assets/6539610/58709b97-8f43-4748-ac97-92653ed889ff)

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

![sports_events_architecture](https://github.com/MiguelbrmFreitas/sports-events-kotlin/assets/6539610/2d0fc8a1-0ba8-458d-99b2-982595fcc297)

The app's architecture is implemented following the pattern MVVM + Clean Architecture, common approach used in Android Development and well supported by the Android API.
It has 3 modules, each is a layer:
- app:
  - Entry point of the app and presentation layer
  - Contains Activity, ViewModel, composables components, DI setup with koin, Application class to start DI, UI models and theme files
- domain:
  - Domain layer in pure Kotlin module with business logic
  - Contains Repository interface, domain models and use cases
- data
  - Data layer with remote and local data sources
  - Contains API models, Retrofit Service, Room setup (entity, DAO and Database), Repository implementation and DI setup with koin.
 
## Known issues and what could improve
- Show a scrollbar to give better feedback when scrolling (there's no built-in way to do it in Jetpack Compose and requires some manual work)
- When expanding the events for a sport in the end of the list, the scroll doesn't update and the user needs to scroll a little bit more to see the events
- Paddings, dimensions and colors are directly assigned within the composables. Should have a better work with themes and styles to avoid hard-coding.
- Better icon for toggling on/off showing only favorite events. It's the same as the icon to fav an event and should be something different and more intuitive.

