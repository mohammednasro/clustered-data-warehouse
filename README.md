# Spring Boot Clustered Data Warehouse Service

This Spring Boot application provides an API for for Accept deal details and persist them in the DB via RESTful endpoints and persists them in the database.

## Technologies Used

- Java 17
- Spring Boot
- Maven
- Swagger UI
- MySQL

## Getting Started

### Prerequisites

- Java 17 JDK installed
- Maven installed
- MySQL database installed and running

### Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/mohammednasro/clustered-data-warehouse
    ```

2. Navigate to the project directory:

    ```bash
    cd sclustered-data-warehouse
    ```

3. Build the project:

    ```bash
    mvn clean package
    ```

4. Run the application:

    ```bash
    java -jar target/clustered-data-warehouse.jar
    ```

5. Access the Swagger UI documentation:

    Open a web browser and go to `http://localhost:8080/swagger-ui.html`.


6. For run using Docker Compose

- If you want to use Running Application Using Docker Compose, first, you must install Docker on your machine. 
- We need to follow the following repo path:
    ```bash
  /clustered-data-warehouse
 ```
- Run the following command line to build firstly
 ```bash
 sudo docker compose build
 ```
- Run the following command line to up docker compose
 ```bash
 sudo docker compose up
 ```

- If you need to down thw docker compose you need proceed the following command line:
 ```bash
 sudo docker compose down
 ```

## Usage

### API Endpoints

- `/v1/clustered-data/add`: POST - Create a new clustered data
- `/v1/clustered-data/add/all`: POST - Create a list of clustered datas

### Request and Response Formats

- Request payloads and responses are in JSON format.
- See the Swagger UI documentation for detailed information on request and response formats.

## Configuration

- Database configuration: Modify `application.properties` to configure the database connection settings.

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvements, please create a GitHub issue or submit a pull request.
