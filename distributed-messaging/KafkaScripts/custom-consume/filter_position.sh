#!/bin/bash

PLAYER_ID=$1
MATCH_ID=$2

if [ -z "$PLAYER_ID" ]; then
  exit 1
fi

if [ -n "$MATCH_ID" ]; then
  JQ_FILTER=".payload.playersPosition[] | select(.playerId == $PLAYER_ID and .matchId == $MATCH_ID)"
else
  JQ_FILTER=".payload.playersPosition[] | select(.playerId == $PLAYER_ID)"
fi

/opt/kafka/bin/kafka-console-consumer.sh \
  --bootstrap-server localhost:9092 \
  --topic players-position | \
jq -R "try fromjson catch . | select(type == \"object\") | $JQ_FILTER"