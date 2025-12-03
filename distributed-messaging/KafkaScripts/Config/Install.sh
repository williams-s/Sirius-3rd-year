#!/bin/bash
cp server.properties /opt
cd /opt
wget https://dlcdn.apache.org/kafka/4.1.0/kafka_2.13-4.1.0.tgz
tar -xvf kafka_2.13-4.1.0.tgz
mv kafka_2.13-4.1.0 kafka
rm kafka_2.13-4.1.0.tgz

cp server.properties /opt/kafka/config
rm server.properties

rm -rf /opt/kafka/data
mkdir -p /opt/kafka/data

UUID=$(/opt/kafka/bin/kafka-storage.sh random-uuid)
echo "Nouvel UUID: $UUID"

/opt/kafka/bin/kafka-storage.sh format -t $UUID -c /opt/kafka/config/server.properties --standalone

echo "Vérification de la création de meta.properties:"
ls -la /opt/kafka/data/meta.properties

echo "Installation et configuration de Kafka terminées!"