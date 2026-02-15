sudo mkdir -p ./ssl
sudo openssl req -x509 -nodes -days 365 -newkey rsa:2048 \
  -keyout ./ssl/privkey.pem \
  -out ./ssl/cert.pem \
  -subj "/CN=172.31.249.162/O=Club Manager/OU=Williams et Younes"