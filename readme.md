
# Delivery Fee Calculator Application

## Description
This is a simple Kotlin application using Ktor to calculate delivery fees based on specified parameters.
There's multiple ways to run the application. Docker(recommended) or Gradle/Java.

## Table of contents
- [Description](#Description)
- [Gradle](#Gradle)
  - [Dependencies](#dependencies)
  - [Running the application](#running-the-application)
- [Docker](#docker)
  - [Dependencies](#dependencies-1)
  - [Running the application](#running-the-application-1)
- [API endpoint](#api-endpoint)
  - [Example payload](#example-payload)

## Gradle:
### Dependencies:
**JDK**
```bash
# Ubuntu/Debian
sudo apt update
sudo apt install default-jdk

# Fedora
sudo dnf install java-latest-openjdk
```

**Kotlin Compiler**
```bash
# Install SDKMAN (Software Development Kit Manager)
curl -s "https://get.sdkman.io" | bash

# Reload shell
source "$HOME/.sdkman/bin/sdkman-init.sh"

# Install Kotlin
sdk install kotlin
```

**Gradle**
```bash
sdk install gradle
```

### Running the application
To run the application using Gradle, follow these steps:
- Open a terminal window in the root directory of the project.
- Run the following command to build and run the application:

```bash
./gradlew run
```

This will start the application, and you can access it by navigating to http://0.0.0.0:8042/api/delivery-fee in your web browser.

## Docker:
### Dependencies:
**Docker**: install docker through https://www.docker.com/.

### Running the application
To run the application using Docker, follow these steps:
- Open a terminal window in the root directory of the project.
- Build the Docker image by running the following command:

```bash 
docker build -t deliveryfeecalculator .
```

Once the image is built, you can run the Docker container with the following command:

```bash
docker run -p 8042:8042 deliveryfeecalculator
```

This will start the application inside a Docker container, and you can access it by navigating to http://0.0.0.0:8042/api/delivery-fee in your web browser.

## API Endpoint:
The main API endpoint for calculating the delivery fee is:

###POST /api/delivery-fee:
Calculate the delivery fee by sending a JSON payload containing "cart_value," (in cents) "delivery_distance," (in meters) "number_of_items," and "time." (UTC ISO format)

### Example Payload:
```json
{
"cart_value": 100,
"delivery_distance": 1000,
"number_of_items": 4,
"time": "2024-01-15T13:00:00Z"
}
```
Feel free to customize the payload based on your testing requirements.

Please ensure you have Java or Docker installed on your system before running the application. 
If you encounter any issues, check the project documentation for additional information.
