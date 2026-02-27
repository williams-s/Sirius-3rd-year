import json
import time

import paho.mqtt.client as mqtt
import confluent_kafka as kafka
import os

MQTT_BROKER = os.getenv("MQTT_BROKER", "172.31.249.162")
MQTT_PORT = int(os.getenv("MQTT_PORT", 1883))

KAFKA_BOOTSTRAP = os.getenv("KAFKA_BOOTSTRAP", "172.31.125.112:9092")


producer = kafka.Producer({
    "bootstrap.servers": KAFKA_BOOTSTRAP,
    "acks": "all",
    "enable.idempotence": True,
    "retries": 3
})

#print(f"Connected to Kafka: {KAFKA_BOOTSTRAP}")
#print(f"Connected to MQTT: {MQTT_BROKER}:{MQTT_PORT}")

mqtt_topic_to_kafka_topic = {
    "players/health": "players-health",
    "players/position": "players-position",
    "ball/events": "ball-events",
    "match/events": "match-events",
    "match/state": "match-state",
    "match/sheet": "match-sheet"
}


def on_connect(client, userdata, flags, rc):
    print(f"Connected to MQTT: {MQTT_BROKER}:{MQTT_PORT}")
    client.subscribe("players/health")
    client.subscribe("players/position")
    client.subscribe("ball/events")
    client.subscribe("match/events")
    client.subscribe("match/state")
    client.subscribe("match/sheet")


previous_match_id = set()

def on_message(client, userdata, msg):
    raw_payload = msg.payload.decode()
    kafka_topic = mqtt_topic_to_kafka_topic[msg.topic]

    try:
        parsed_payload = json.loads(raw_payload)
    except json.JSONDecodeError:
        print("Invalid JSON from MQTT")
        return

    match_id = parsed_payload["matchId"]

    if match_id not in previous_match_id:
        previous_match_id.add(match_id)
        print(f"Le match d'id :{match_id} a commencé")

    message = {
        "payload": parsed_payload
    }

    producer.produce(
        kafka_topic,
        key=str(match_id),
        value=json.dumps(message),
        timestamp=int(time.time() * 1000)
    )
    producer.poll(0)

mqtt_client = mqtt.Client()
mqtt_client.on_connect = on_connect
mqtt_client.on_message = on_message

mqtt_client.connect(MQTT_BROKER, int(MQTT_PORT))
mqtt_client.loop_forever()
