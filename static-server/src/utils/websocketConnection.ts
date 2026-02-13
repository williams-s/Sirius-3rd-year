import {WEBSOCKET_URL} from "../constants/back.ts";
import { Client } from "@stomp/stompjs";
import SockJS from "sockjs-client";

export const ConnectToWebsocket = (): WebSocket => {
    return new WebSocket(WEBSOCKET_URL);
}

export const ConnectToWebSocketSTOMP = (): Client => {
    return new Client({
        webSocketFactory: () => new SockJS(WEBSOCKET_URL),
        reconnectDelay: 5000,
        //debug: str => console.log(str)
    })
}