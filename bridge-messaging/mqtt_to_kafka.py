import json
import paho.mqtt.client as mqtt
import confluent_kafka as kafka
import os

MQTT_BROKER = os.getenv("MQTT_BROKER", "localhost")
MQTT_PORT = int(os.getenv("MQTT_PORT", 1883))

KAFKA_BOOTSTRAP = os.getenv("KAFKA_BOOTSTRAP")


producer = kafka.Producer({
    "bootstrap.servers": KAFKA_BOOTSTRAP
})

print(f"Connected to Kafka: {KAFKA_BOOTSTRAP}")
print(f"Connected to MQTT: {MQTT_BROKER}:{MQTT_PORT}")

mqtt_topic_to_kafka_topic = {
    "players/health": "players-health",
    "players/position": "players-position",
    "ball/events": "ball-events",
    "match/events": "match-events",
    "match/state": "match-state"
}


def on_connect(client, userdata, flags, rc):
    print(f"Connected to MQTT: {MQTT_BROKER}:{MQTT_PORT}")
    client.subscribe("players/health")
    client.subscribe("players/position")
    client.subscribe("ball/events")
    client.subscribe("match/events")
    client.subscribe("match/state")


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

mqtt_client.connect(MQTT_BROKER, int(MQTT_PORT))
mqtt_client.loop_forever()
