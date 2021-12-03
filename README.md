# Solidaridad Escuela
## CICLOS DE VIDA Y DESARROLLO DE SOFTWARE / 2021-2

[![Deployed to Heroku](https://www.herokucdn.com/deploy/button.png)](https://solidaridad-escuela-grupo-1.herokuapp.com/)

# Integrantes
|     Nombre    |     Rol         |
|--------------|------------- |
|Oscar Ospina	|Product Owner    |
|Juan David Murillo |Scrum Master
|Laura Valentina García|Developer   |
|Juan Sebastian Cadavid |Developer   |
---

### Otros colaboradores:
- Laura Nathalia García

## Descripción del producto

### Descripción General

La _**Plataforma Solidaridad Escuela**_, es una herramienta para generar un entorno de comunicación y ayuda 
dentro de la comunidad de la Escuela Colombiana de Ingeniería Julio Garavito. El sistema permite que los 
estudiantes puedan expresar las necesidades que puedan tener de algún elemento para poder desarrollar sus 
actividades de forma correcta, y que los demás miembros de la comunidad puedan facilitar estos elementos a 
quienes lo necesitan. De igual manera los miembros de la comunidad pueden ofrecer diferentes elementos que sean 
de interés para los estudiantes sin que exista alguna solicitud específica. Adicionalmente el sistema cuenta con
diferentes funcionalidades de reportería y administración que permite llevar un control del funcionamiento de la 
plataforma y del alcance que se está logrando.


### Manual De Usario
  
Páginas iniciales


![](https://github.com/2021-2-PROYCVDS-GRUPO-1/solidaridad-escuela/blob/CVDS-5-V2/modelos/MANUAL%20DE%20USUARIO/logImage.png)

![](https://github.com/2021-2-PROYCVDS-GRUPO-1/solidaridad-escuela/blob/CVDS-5-V2/modelos/MANUAL%20DE%20USUARIO/mainMenu.png)


> #### **CREAR.**

* _Crear Categoría._

_¿Cómo crear una categoría?_

1. Escoger el nombre que tendrá la categoría.  

2. Seleccionar el estado en el que se encuentra la categoría.

3. Añadir la descripción de la categoría.

4. Clicar el botón "Crear Categoría".

![](https://github.com/2021-2-PROYCVDS-GRUPO-1/solidaridad-escuela/blob/CVDS-5-V2/modelos/MANUAL%20DE%20USUARIO/crearCategoria.png)



* _Crear Necesidad._

_¿Cómo crear una necesidad?_

1. Escoger el nombre que tendrá la necesidad.

2. Seleccionar la categoría a la que pertenecerá la necesidad.

3. Añadir la descripción de la necesidad.

4. Seleccionar el tipo de urgencia.

5. Clicar el botón "Crear Necesidad"

![](https://github.com/2021-2-PROYCVDS-GRUPO-1/solidaridad-escuela/blob/CVDS-5-V2/modelos/MANUAL%20DE%20USUARIO/crearNecesidad.png)


* _Crear Oferta._

_¿Cómo crear una oferta?_

1. Escoger el nombre que tendrá la oferta.

2. Seleccionar la categoría a la que pertenecerá la oferta.

3. Añadir la descripción de la oferta.

4. Clicar el botón "Crear Oferta"

![](https://github.com/2021-2-PROYCVDS-GRUPO-1/solidaridad-escuela/blob/CVDS-5-V2/modelos/MANUAL%20DE%20USUARIO/crearOferta.png)


* _Crear Respuesta._

_¿Cómo crear una respuesta?_

1. Escoger el nombre que tendrá la respuesta.

2. Seleccionar la necesidad o la oferta a la que responde.

3. Añadir la descripción de la respuesta.

4. Clicar el botón "Crear Respuesta"

![](https://github.com/2021-2-PROYCVDS-GRUPO-1/solidaridad-escuela/blob/CVDS-5-V2/modelos/MANUAL%20DE%20USUARIO/crearRespuesta.png)

> #### **CONSULTAS.**

* _Consultar categoría._

_¿Qué encontramos y podemos hacer aquí?_

Encontraremos una lista de todas las categorías registradas en la base de datos en el momento junto a 
dos botones: 

![](https://github.com/2021-2-PROYCVDS-GRUPO-1/solidaridad-escuela/blob/CVDS-5-V2/modelos/MANUAL%20DE%20USUARIO/listaCategorias.png)


* Eliminar Categoría: Eliminará la categoría seleccionada.

* Editar Categoría: Redireccionará al apartado de editar categoría. En este es posible cambiar el nombre, el estado 
y la descripción de la categoría. 

![](https://github.com/2021-2-PROYCVDS-GRUPO-1/solidaridad-escuela/blob/CVDS-5-V2/modelos/MANUAL%20DE%20USUARIO/editarCategoria.png)


* _Consultar Ofertas._

_¿Qué encontramos y podemos hacer aquí?_

Encontraremos una lista de todas las ofertas que pertenecen al usuario que se encuentra logeado en la aplicación junto a
dos botones:

![](https://github.com/2021-2-PROYCVDS-GRUPO-1/solidaridad-escuela/blob/CVDS-5-V2/modelos/MANUAL%20DE%20USUARIO/listaOferta.png)


* Eliminar Oferta: Eliminará la oferta seleccionada.

* Editar Oferta: Redireccionará al apartado de editar oferta. En este es posible cambiar únicamente el estado de la
oferta.

![](https://github.com/2021-2-PROYCVDS-GRUPO-1/solidaridad-escuela/blob/CVDS-5-V2/modelos/MANUAL%20DE%20USUARIO/editarOferta.png)


* _Consultar Necesidades._

_¿Qué encontramos y podemos hacer aquí?_

Encontraremos una lista de todas las necesidades que pertenecen al usuario que se encuentra logeado en la aplicación junto a
dos botones:

![](https://github.com/2021-2-PROYCVDS-GRUPO-1/solidaridad-escuela/blob/CVDS-5-V2/modelos/MANUAL%20DE%20USUARIO/listaNecesidad.png)

* Eliminar Necesidad: Eliminará la necesidad seleccionada.

* Editar Necesidad: Redireccionará al apartado de editar necesidad. En este es posible cambiar únicamente el estado de la
necesidad.

![](https://github.com/2021-2-PROYCVDS-GRUPO-1/solidaridad-escuela/blob/CVDS-5-V2/modelos/MANUAL%20DE%20USUARIO/editarNecesidad.png)


* _Reporte de Categorías._

_¿Qué encontramos y podemos hacer aquí?_

Encontraremos una lista de todas las categorías además de una gráfica que muestra información relevante sobre estas. Dicha lista
se podrá exportar en **PDF** o en un archivo de excel.

![](https://github.com/2021-2-PROYCVDS-GRUPO-1/solidaridad-escuela/blob/CVDS-5-V2/modelos/MANUAL%20DE%20USUARIO/reporteCategoria.png)

![](https://github.com/2021-2-PROYCVDS-GRUPO-1/solidaridad-escuela/blob/CVDS-5-V2/modelos/MANUAL%20DE%20USUARIO/graficaCategoria.png)


* _Reporte de Ofertas._

_¿Qué encontramos y podemos hacer aquí?_

Encontraremos una lista de todas las ofertas además de una gráfica que muestra información relevante sobre estas. Dicha lista 
se podrá exportar en **PDF** o en un archivo de excel.  

![](https://github.com/2021-2-PROYCVDS-GRUPO-1/solidaridad-escuela/blob/CVDS-5-V2/modelos/MANUAL%20DE%20USUARIO/ReporteOferta.png)

![](https://github.com/2021-2-PROYCVDS-GRUPO-1/solidaridad-escuela/blob/CVDS-5-V2/modelos/MANUAL%20DE%20USUARIO/graficoOferta.png)

* _Reporte de Necesidades._

_¿Qué encontramos y podemos hacer aquí?_

Encontraremos una lista de todas las necesidades además de una gráfica que muestra información relevante sobre estas. Dicha lista
se podrá exportar en **PDF** o en un archivo de excel.

![](https://github.com/2021-2-PROYCVDS-GRUPO-1/solidaridad-escuela/blob/CVDS-5-V2/modelos/MANUAL%20DE%20USUARIO/reporteNecesidad.png)

![](https://github.com/2021-2-PROYCVDS-GRUPO-1/solidaridad-escuela/blob/CVDS-5-V2/modelos/MANUAL%20DE%20USUARIO/graficoNecesidad.png)


* _Reporte de Respuestas._

_¿Qué encontramos y podemos hacer aquí?_

Encontraremos una lista de todas las respuestas además de una gráfica que muestra información relevante sobre estas. Dicha lista
se podrá exportar en **PDF** o en un archivo de excel.

![](https://github.com/2021-2-PROYCVDS-GRUPO-1/solidaridad-escuela/blob/CVDS-5-V2/modelos/MANUAL%20DE%20USUARIO/reporteRespuesta.png)


## __Arquitectura y Diseño__

### __Modelo E-R__

### __Diagrama de Clase__






### _Tecnologías utilizadas_

#### _Integración continua_
[![CircleCI Badge](https://circleci.com/gh/2021-2-PROYCVDS-GRUPO-1/solidaridad-escuela/tree/master.svg?style=svg)](https://circleci.com/gh/2021-2-PROYCVDS-GRUPO-1/solidaridad-escuela/tree/master)

#### _Despliegue en Heroku_
[![Deployed to Heroku](https://www.herokucdn.com/deploy/button.png)](https://solidaridad-escuela-grupo-1.herokuapp.com/)

## __Descripción del proceso:__

## __Integrantes:__

|     Nombre    |     Git         |
|--------------|------------- |
|Juan David Murillo |[juancho20sp](https://github.com/juancho20sp)|
|Laura Valentina García|[laura-gar](https://github.com/laura-gar) |
|Juan Sebastian Cadavid |[jua1000n](https://github.com/jua1000n)  |
|Laura Nathalia García|[lngar](https://github.com/lngar)   |


### __Metodología Utilizada:__


Planeamos todos los sprints en la primera reunión de equipo que tuvimos, 
discutiendo sobre qué y cómo deberíamos hacer el proyecto.


_¿Cómo ordenamos los sprints?:_

Discutimos entre todo el grupo de trabajo qué tareas deberían hacerse primero, guiándonos tan
solo por lo que decían como tal, haciéndonos preguntas sobre la creación de los elementos necesarios
como lo son las ofertas y las necesidades, lo que después nos llevaría a la siguiente organización:

- Sprint 1:
  - Configuración inicial del proyecto. 
  - Creación de la base de datos. 
  - Inicio de sesión. 
  - Creación de Categorías, Ofertas y Necesidades. 
- Sprint 2:
  - Creación de Respuestas
  - Actualización de Categorías, Ofertas y Necesidades. 
  - Reportes de Necesidades, Ofertas y Respuestas. 
- Sprint 3:
  - Reporte de Categorías
  - Eliminar Categoría
  - Mejoras generales. 

### __Taiga__

Enlace de [Taiga]() 
para ver el seguimiento y manejo que dimos al proyecto.



### __Release-Burndown Chart:__

#### __Sprint1:__
#### __Sprint2:__
#### __Sprint3:__








### _Reporte de análisis estático de código_

#### _Calidad de codigo_

[![Codacy Badge](https://app.codacy.com/project/badge/Grade/f8b62540a056454092310506f21f2296)](https://www.codacy.com/gh/2021-2-PROYCVDS-GRUPO-1/solidaridad-escuela/dashboard?utm_source=github.com&utm_medium=referral&utm_content=2021-2-PROYCVDS-GRUPO-1/solidaridad-escuela&utm_campaign=Badge_Grade)













