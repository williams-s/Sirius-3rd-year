docker config create nginx_conf ./reverse-proxy/nginx.conf
docker config create nginx_snippets_oauth2 ./reverse-proxy/snippets/oauth2_headers.conf
docker config create mosquitto_conf ./mqtt-broker/mosquitto/config/mosquitto.conf
docker secret create nginx_cert ./reverse-proxy/ssl/cert.pem
docker secret create nginx_key ./reverse-proxy/ssl/privkey.pem