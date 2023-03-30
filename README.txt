# SupplierRestClient - A PortX Challenge

## Local

#### Dependencies

- [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven 3.8.4](https://maven.apache.org/docs/3.8.4/release-notes.html)

### Steps

- Make sure you're on Java 17
- Make sure that `PaymentRestApi` project is running
- Run

```shell
mvn clean install
```

(Or use your preferred IDE!)

- Enter a number of requests to simulate (equal or greater than one)
- Done!

### ENV vars

You may run it without configuring any env vars out of the box, but you can set up the following ones:

- `PAYMENTS_API_URL` PaymentRestApi url (localhost by default)
- `PAYMENTS_API_PORT` PaymentRestApi port (8081 by default)

# PaymentRestApi

Please refer to [its own repository documentation](https://github.com/daniellovero/portx)