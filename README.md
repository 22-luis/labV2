# Labs-Moviles
Lab07
#1 Garantiza que la IU coincida con el estado de los datos: LiveData sigue el patrón de diseño observador.
LiveData notifica a los objetos Observer cuando cambian los datos subyacentes. Puedes consolidar tu código
para actualizar la IU en esos objetos Observer. De esa manera, no necesitas actualizar la IU cada vez que
cambian los datos de la app porque el observador lo hace por ti.● Sin fugas de memoria: Los observadores están vinculados a objetos Lifecycle y borran lo que crean cuando se
destruye el ciclo de vida asociado.
● Actividades detenidas para evitar las fallas: Si el ciclo de vida del observador está inactivo, como en el caso
de una actividad de la pila de actividades, no recibe ningún evento de LiveData.
● No más control manual del ciclo de vida: Los componentes de IU solo observan los datos relevantes y no
detienen ni reanudan la observación. LiveData se ocupa automáticamente de todo esto, ya que está al tanto
de los cambios de estado del ciclo de vida relevantes mientras lleva a cabo la observación.
● Datos siempre actualizados: Si un ciclo de vida queda inactivo, recibe los datos más recientes después de
quedar activo de nuevo. Por ejemplo, una actividad que estuvo en segundo plano recibe los datos más
recientes inmediatamente después de volver al primer plano.
● Cambios de configuración apropiados: Una actividad o un fragmento que se vuelve a crear debido a un
cambio de configuración, como la rotación del dispositivo, recibe de inmediato los datos disponibles más
recientes.

#2 Singleton

#3 dataBinding{
   enabled true
}


#4 DataBinding es una función de Android que permite vincular los elementos de la interfaz de usuario (UI)
de una aplicación directamente a los datos de la aplicación, lo que significa que no es necesario realizar
actualizaciones manuales para que la interfaz refleje los cambios en los datos. DataBinding utiliza una sintaxis
especial en XML para crear una conexión entre la UI y los datos, lo que facilita la implementación de patrones de
arquitectura de software como el patrón MVVM (Model-View-ViewModel).
En lugar de tener que actualizar manualmente los elementos de la UI en el código, DataBinding permite que la UI
se actualice automáticamente a medida que los datos cambian en la aplicación. Esto significa que es posible
centrarse en la lógica de la aplicación en lugar de preocuparse por la sincronización de los datos y la UI.
Además, DataBinding proporciona una mayor eficiencia y rendimiento, ya que reduce la necesidad de hacer
referencia a los elementos de la interfaz de usuario en el código y también disminuye la cantidad de código
repetitivo necesario para mantener la sincronización de los datos y la UI.
