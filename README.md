¿De qué trata el sistema?
Es una aplicación de escritorio para administrar integralmente un centro educativo de formación profesional. Cubre cuatro grandes áreas:
Alumnos
Registro, modificación, asignación a cursos, bajas, estados (activo/egresado/desertor), pagos y deudores.
Empleados (docentes/personal)
Registro y modificación de empleados, asignación de cargos y títulos, gestión de licencias, asignación a cursos como profesores.
Cursos
Creación, modificación y eliminación de cursos; definición de horarios, lugares, períodos lectivos, planes de estudio y tipos de cursado.
Configuración y tablas maestras
Gestión de barrios, calles, localidades, nacionalidades, sexos, tipos de documento, títulos, cargos, gremios, planes, períodos, entre otros.

Funcionalidades adicionales

Listados e informes: alumnos por curso, egresados, desertores, deudores, ciclo lectivo.
Gestión de usuarios: login, crear/modificar/eliminar usuarios y contraseñas con control de acceso.
Configuración de la escuela: nombre, dirección, director, logo e imagen de fondo.
Validación de CUIL y lectura de DNI por formulario especial.

-Librerías necesarias

Agregar estas 4 librerías en NetBeans (clic derecho en Libraries → Add JAR/Folder):
 `mysql-connector-java-9.7.0.jar` | https://dev.mysql.com/downloads/connector/j/ |
 `jcalendar-1.4.jar` | https://mvnrepository.com/artifact/com.toedter/jcalendar/1.4 |
 `AbsoluteLayout.jar` | Carpeta de instalación de NetBeans: `platform/modules/ext/` |
 `slf4j-api-1.7.36.jar` | https://repo1.maven.org/maven2/org/slf4j/slf4j-api/1.7.36/slf4j-api-1.7.36.jar |

-Base de datos

-Crear la base de datos

Importar el archivo `DatosCFP.sql` con el siguiente comando:

mysql -u root -p < DatosCFP.sql


-Tablas agregadas

**Barrio** — usada en las pantallas de configuración de domicilio
**Calles** — usada en las pantallas de configuración de domicilio


-Cambios en la base de datos

-Columnas renombradas

El código Java usaba nombres distintos a los del diagrama. Se renombraron las siguientes columnas:

**Tabla `persona`:**
- `cuil` → `CUIL`
- `idLugar` → `lugarNacimiento`

**Tabla `domicilio`:**
- `Lugar_idLugar` → `idLugar`
- `Edificio_idEdificio` → `idEdificio`

**Tabla `empleado`:**
- `Persona_idPersona` → `idPersona`
- `EstadoEmpleado_idEstadoEmpleado` → `idEstadoEmpleado`
- `Gremio_idGremio` → `idGremio`

**Tabla `usuario`:**
- `Empleado_idEmpleado` → `idEmpleado`

**Tabla `alumno`:**
- `Persona_idPersona` → `idPersona`

**Credenciales de acceso:**
- Usuario: `admin`
- Contraseña: `admin`


-Cómo ejecutar

1. Abrir el proyecto en NetBeans 8.2
2. Verificar que las librerías estén agregadas en Libraries
3. Tener Laragon corriendo con MySQL activo
4. Haber importado `DatosCFP.sql`
5. Ingresar con usuario `admin` y contraseña `admin`
