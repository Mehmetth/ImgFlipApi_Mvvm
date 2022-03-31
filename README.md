
<!-- ABOUT THE PROJECT -->
## ImgFlipApi_MVVM
<p float="left">
  <img src="https://user-images.githubusercontent.com/18207490/161043694-289e2a75-7e53-48d5-9d37-39a7773853eb.png" height="300">
  <img src="https://user-images.githubusercontent.com/18207490/161043707-fcc0b2fe-1950-47fe-a131-abd341d7f1eb.png" height="300">
  <img src="https://user-images.githubusercontent.com/18207490/161043721-6c81b150-6ba3-4da0-bc8c-bdd937e66b30.png" height="300">
  <img src="https://user-images.githubusercontent.com/18207490/161043725-40a14987-6068-4161-a797-cca1a77e9fb5.png" height="300">
</p>

This application is written using the ImgFlip API. The application, MVVM, Coroutines, Hilt, Navigation component features were used.

 * Architecture is written in MVVM. 
 * Asynchronous transactions were made with Coroutines. 
 * StateFlow was used to control the values returned in the Retrofit and to perform operations according to the returned values.
 * Picasso is used to display the pictures.
 * Hilt is used for Dependency Injection.

### Built With

Libraries used in the application.

* [Coroutines](https://developer.android.com/kotlin/coroutines)
* [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
* [Navigation component](https://developer.android.com/guide/navigation/navigation-getting-started)
* [Data Binding](https://developer.android.com/topic/libraries/data-binding)
* [Retrofit](https://square.github.io/retrofit/)
* [StateFlow](https://developer.android.com/kotlin/flow/stateflow-and-sharedflow)
* [Picasso](https://square.github.io/picasso/)

<!-- GETTING STARTED -->
## Getting Started

### Installation

1. Get a free API
2. Enter your API in `build.gradle`
   ```js
   buildConfigField 'String', 'API_BASE_URL', '"https://api.imgflip.com/"'
   ```
