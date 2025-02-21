# Tasks/Notes List App

This is a simple Android application that displays a list of "tasks" or notes that are manually saved
by the user and retrieved through a local database management system

## Features

* Displays a list of task/notes that are manually saved by the user by clicking on the "+" Button
* Uses coroutines for asynchronous operations while making calls to the database.
* Error handling to display state management capabilities if any other external data sources are added
* Built with Jetpack Compose for UI.

## Room Database

This App makes use of Room as the local database management system. It is a relational database that contains the following fields
for each task/note: 
- id: Primary key for the database
- taskName: Name of the task to be added
- taskDefinition: Definition/detailed information of the task to be added
## Screenshots

<img src="https://github.com/ArturoMarmolejo/ToyotaTasksCC/blob/master/app/src/main/res/drawable/homescreen.png" width="300">
<img src="https://github.com/ArturoMarmolejo/ToyotaTasksCC/blob/master/app/src/main/res/drawable/form.png" width="300">

## Architecture

The app follows a simple Model-View-ViewModel (MVVM) and Clean Architecture/Android Architecture principles. With
the following packages:

* **Data:** Represents the data structures used and the database set up
* **DI** Module for dependency injection
* **core** Package for common functionalities and key features such as state management.
* **Presentation:** Displays the list of tasks/notes added by the user through the use of a LazyLayout.

## Libraries

* Kotlin Coroutines
* Jetpack Compose
* Room Database
* Jetpack Compose
* Viewmodel
* Lifecycle
* Jetpack Navigation to navigate between the main screen and the edit form to add a new task/note

## How to run

1. Clone the repository.
2. Open the project in Android Studio.
3. Build and run the app on an emulator or device.

## Future improvements
* Add a Domain Layer to handle business logic.
* Add a delete functionality so the user can delete any database entries
* Add edit functionality for existing notes/tasks
* Add unit testing
* Add instrumentation testing for UI and database