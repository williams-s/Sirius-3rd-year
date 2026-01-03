import json
import paho.mqtt.client as mqtt
import confluent_kafka as kafka

MQTT_BROKER = "localhost"
MQTT_PORT = 1883
MQTT_TOPIC = "test/#"

KAFKA_BOOTSTRAP = "172.29.241.105:9092"
KAFKA_TOPIC = "test"

producer = kafka.Producer({
    "bootstrap.servers": KAFKA_BOOTSTRAP
})

mqtt_topic_to_kafka_topic = {
    "players/health": "players-health",
    "players/position": "players-position",
    "ball/events": "ball-events",
    "match/events": "match-events"
}


def on_connect(client, userdata, flags, rc):
    print("✅ Connected to MQTT")
    client.subscribe("players/health")
    client.subscribe("players/position")
    client.subscribe("ball/events")
    client.subscribe("match/events")


def on_message(client, userdata, msg):
    payload = msg.payload.decode()
    kafka_topic = mqtt_topic_to_kafka_topic[msg.topic]

    message = {
        "payload": payload
    }

    producer.produce(
        kafka_topic,
        value=json.dumps(message),
    )
    producer.poll(0)

mqtt_client = mqtt.Client()
mqtt_client.on_connect = on_connect
mqtt_client.on_message = on_message

mqtt_client.connect(MQTT_BROKER, MQTT_PORT)
mqtt_client.loop_forever()
