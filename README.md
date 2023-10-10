# Publisher Subscriber Pattern Demonstration Using Redis

---

## Instructions To Run The Project

### Step 01:

From the parent directory `redis-publisher-subscriber` type the below commands to navigate to the `docker-compose`
directory and start the redis server.

```bash
cd ./docker-compose
docker compose up
```

### Step 02:

Start the `publisher-service` and `subscriber-service` application.

### Step 03:

Now execute the below CURL to publish an event.

```bash
curl --location --request POST 'localhost:8080/publish' \
--header 'Content-Type: application/json' \
--data-raw '{
    "orderId": "oder-1",
    "userId": "12345",
    "productName": "Some product",
    "price": 200,
    "quantity": 1
}'
```

Once an event is published, `subscriber-service` will listen to that. And consume the event. You can check the log of
`subscriber-service` for that.