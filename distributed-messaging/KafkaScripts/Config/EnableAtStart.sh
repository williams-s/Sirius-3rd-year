#!/bin/bash

KAFKA_DIR="/opt/kafka"
USER_NAME="root"

SERVICE_FILE="/etc/systemd/system/kafka.service"

sudo bash -c "cat > $SERVICE_FILE" <<EOL
[Unit]
Description=Apache Kafka Server
After=network.target

[Service]
Type=simple
User=$USER_NAME
ExecStart=$KAFKA_DIR/bin/kafka-server-start.sh $KAFKA_DIR/config/server.properties
ExecStop=$KAFKA_DIR/bin/kafka-server-stop.sh
Restart=on-failure

[Install]
WantedBy=multi-user.target
EOL

sudo systemctl daemon-reload
sudo systemctl enable kafka
sudo systemctl start kafka

sudo systemctl status kafka
echo "Kafka service enabled and started."