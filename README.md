# Pricing Service

## 📖 Descripción del proyecto
Servicio REST desarrollado con **Spring Boot** que permite consultar el precio a aplicar para un producto en función de la fecha y marca del producto.

📌 En caso de solapamiento de tarifas para un mismo periodo de tiempo, el precio aplicado será el de **mayor prioridad**.

### Tecnologias usadas

- Java 17
- Spring Boot 3.4.2
- Spring Data JPA
- Base de datos en memoria -> H2
- Mapstruct para el mapeo entre entidades
- JUnit 5 y Mockito para tests
- Maven

### Estructura del proyecto

El proyecto sigue una **arquitectura hexagonal** con la siguiente estructura:

#### *Infrastructure*

- `PriceController`: Recibe las petición HTTP y la pasa al servicio
- `PriceJpaRepository`: Encapsula el acceso a la base de datos.
- `PriceRepositoryImpl`: Implementa la lógica de negocio definida en el repositorio de dominio, usando PriceJpaRepository.
- `PriceJpaEntity`: Representa los datos de la base de datos (tabla "prices").
- `PriceMapper`: Transform entre entidades JPA, modelos de dominio y ResponseDto.
- `GlobalExceptionHandler`: Manejo global de excepciones.
- `DataLoader`: Carga de datos iniciales en la base de datos.

#### *Application* 

- `PriceService`:
    + Contiene la lógica de negocio principal.
    + Se comunica con los repositorios del dominio.

#### *Domain*

- `Price`: Modelo de dominio que representa la información del precio.
- `PriceRepository`: Interfaz del repositorio de dominio (definición de operaciones que deben implementarse en `Infrastructure`).

📌 **Flujo de la operación de obtener el precio aplicable**:

Controller -> Service -> Repository (Domain) -> RepositoryImpl (Infraestructura) -> JPA Repository -> Base de Datos


## 🔧 Configuración y ejecución
### 1️⃣ Clonar el repositorio

```sh
git clone https://github.com/jorgecastalc/pricing-service
cd pricing-service
```

### 2️⃣ Construir el proyecto con Maven

```sh
mvn clean install
```

### 3️⃣ Ejecutar la aplicación

```sh
mvn spring-boot:run
```

## 🛠 Testing

Para ejecutar las pruebas unitarias:

```sh
mvn test
```

### 📚 Datos Iniciales en la Base de Datos - Tabla prices

| BRAND_ID | START_DATE          | END_DATE            | PRICE_LIST | PRODUCT_ID | PRIORITY | PRICE  | CURR     |
|----------|---------------------|---------------------|------------|------------|----------|--------|----------|
| 1        | 2020-06-14 00:00:00 | 2020-12-31 23:59:59 | 1          | 35455      | 0        | 35.50  | EUR      |
| 1        | 2020-06-14 15:00:00 | 2020-06-14 18:30:00 | 2          | 35455      | 1        | 25.45  | EUR      |
| 1        | 2020-06-15 00:00:00 | 2020-06-15 11:00:00 | 3          | 35455      | 1        | 30.50  | EUR      |
| 1        | 2020-06-15 16:00:00 | 2020-12-31 23:59:59 | 4          | 35455      | 1        | 38.95  | EUR      |

Dados estos datos iniciales, los tests de la aplicacion cubren los siguientes casos:

| Test   | Fecha y Hora de Aplicación | Producto | Marca | Tarifa Aplicada Esperada | Precio Esperado |
|--------|----------------------------|----------|-------|--------------------------|-----------------|
| 1️⃣    | 2020-06-14 10:00           | 35455    | 1     | 1                         | 35.50          |
| 2️⃣    | 2020-06-14 16:00           | 35455    | 1     | 2                         | 25.45          |
| 3️⃣    | 2020-06-14 21:00           | 35455    | 1     | 1                         | 35.50          |
| 4️⃣    | 2020-06-15 10:00           | 35455    | 1     | 3                         | 30.50          |
| 5️⃣    | 2020-06-15 12:00           | 35455    | 1     | 1                         | 35.50          |
| 6️⃣    | 2020-06-16 21:00           | 35455    | 1     | 4                         | 38.95          |




