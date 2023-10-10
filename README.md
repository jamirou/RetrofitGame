# Apigames - Aplicación Android con Jetpack Compose y Kotlin

## Descripción del Proyecto
Apigames es una aplicación Android que utiliza Jetpack Compose y Kotlin para mostrar información sobre videojuegos utilizando una API externa. La aplicación se centra en las siguientes características clave:

- Uso de la API de juegos externa.
- Integración de Retrofit para conectarse a los servidores y extraer datos en formato JSON.
- Inyección de dependencias utilizando Dagger Hilt.
- Arquitectura limpia (Clean Architecture).
- Uso de Coil para la carga eficiente de imágenes desde el servidor.
- Utilización de la navegación con Jetpack Compose.

<img src="https://github.com/jamirou/Personal_Schedule/assets/48457084/09cd01ba-a680-49ce-9959-2b015beacb49" height="550" /> <img src="https://github.com/jamirou/CronosApp/assets/48457084/637b9616-c8a7-4c1d-a9e5-42baaa5b6ae4" height = "550"/>


  

## Estructura del Proyecto
La aplicación sigue una estructura de paquetes organizada de la siguiente manera:

- **data**: Contiene la interfaz `ApiGame` para las consultas a la API y los repositorios de datos.
- **di**: Aquí se encuentra el módulo `AppModule` para la inyección de dependencias.
- **model**: Contiene los modelos de datos utilizados en la aplicación.
- **navigation**: Gestiona la navegación en la aplicación.
- **ui**: Contiene las vistas de la aplicación.
  
## Arquitectura de la Aplicación

La aplicación sigue una arquitectura basada en MVVM (Model-View-ViewModel) y se organiza en capas para mantener un código limpio y modular. A continuación, se describen las principales partes de la arquitectura:

### Componentes de Compose

El paquete `com.jamirodev.retrofitgameapp.components` contiene componentes de Jetpack Compose utilizados en toda la aplicación. Algunos de estos componentes incluyen:

- `MainTopBar`: Un componente para la barra de navegación superior que muestra el título y los botones de navegación.
- `CardGame`: Un componente para mostrar información de juegos en forma de tarjetas.
- `MainImage`: Un componente para cargar y mostrar imágenes de juegos.
- `MetaWebsite`: Un componente para mostrar la puntuación Metascore y un botón para abrir el sitio web del juego.
- `ReviewCard`: Un componente para mostrar la puntuación Metascore de un juego en una tarjeta.

### Repositorio de Juegos

El paquete `com.jamirodev.retrofitgameapp.repository` contiene la clase `GamesRepository`, que actúa como intermediario entre la API y la capa de ViewModel. Se encarga de realizar consultas a la API de juegos y proporcionar los datos necesarios a la ViewModel.

### Estado de la Aplicación

El paquete `com.jamirodev.retrofitgameapp.state` define la clase `GameState`, que almacena el estado actual de la aplicación. Esta clase se utiliza para representar la información detallada de un juego.

### Utilidades

En el paquete `com.jamirodev.retrofitgameapp.util`, se encuentra la clase `Constants` que almacena constantes utilizadas en toda la aplicación, como URLs de la API y colores.

### ViewModel

La ViewModel principal de la aplicación se encuentra en el paquete `com.jamirodev.retrofitgameapp.viewModel`. La clase `GamesViewModel` se encarga de gestionar la lógica de la aplicación y proporciona datos a las vistas. Utiliza `MutableStateFlow` para almacenar y emitir la lista de juegos y el estado actual de un juego.

### Vistas

Las vistas de la aplicación se encuentran en los paquetes `com.jamirodev.retrofitgameapp.views`. Aquí se definen las pantallas principales de la aplicación:

- `HomeView`: Muestra una lista de juegos en tarjetas y permite la navegación a la pantalla de detalles.
- `DetailView`: Muestra información detallada de un juego, incluyendo su imagen, puntuación Metascore y descripción.
- `SearchGameView`: Permite la búsqueda de juegos, aunque no se muestra en el código proporcionado.

### Navegación

La navegación en la aplicación se gestiona mediante el uso de `NavController` y se define en el paquete `com.jamirodev.retrofitgameapp.navigation`. El `NavManager` se encarga de configurar las rutas y transiciones entre pantallas.

Esta arquitectura permite una separación clara de las responsabilidades y facilita la expansión y mantenimiento de la aplicación. Cada componente desempeña un papel específico en la aplicación, lo que facilita la comprensión y el desarrollo continuo.


## Inyección de Dependencias
La inyección de dependencias se realiza utilizando Dagger Hilt. El módulo `AppModule` proporciona una instancia de Retrofit configurada con la URL base de la API y una interfaz `ApiGame`.

```kotlin
@Singleton
@Provides
fun providesRetrofit(): Retrofit {
    // Configuración de Retrofit
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

@Singleton
@Provides
fun providesApiGames(retrofit: Retrofit): ApiGame {
    return retrofit.create(ApiGame::class.java)
}
```
