#!/bin/bash

TOPIC=""
SERVER="localhost:9092"

parse_arg() {
    local ARG1="$1"
    local ARG2="$2"
    case "$ARG1" in
        --topic)
            TOPIC="${ARG2}"
            ;;
        --server)
            SERVER="$ARG2"
            ;;
        *)
            ;;
    esac
}

[ ! -z "$1" ] && parse_arg "$1" "$2"
[ ! -z "$3" ] && parse_arg "$3" "$4"

if [ -z "$TOPIC" ] || [ -z "$SERVER" ]; then
    echo "Missing argument --topic or --server if no --server then its set to localhost:9092"
    exit 1
fi
echo "Consuming from topic: $TOPIC on server: $SERVER"
/opt/kafka/bin/kafka-console-consumer.sh --topic "$TOPIC" --from-beginning --bootstrap-server "$SERVER"
