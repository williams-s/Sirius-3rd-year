#!/bin/bash

TEAM_ID=$1
MATCH_ID=$2

if [ -z "$TEAM_ID" ]; then
  exit 1
fi

if [ -n "$MATCH_ID" ]; then
  JQ_FILTER=".payload[] | select(.teamId == $TEAM_ID and .matchId == $MATCH_ID)"
else
  JQ_FILTER=".payload[] | select(.teamId == $TEAM_ID)"
fi

/opt/kafka/bin/kafka-console-consumer.sh \
  --bootstrap-server localhost:9092 \
  --topic stats-team-live | \
jq -R "try fromjson catch . | select(type == \"object\") | $JQ_FILTER"