#!/bin/bash

sudo apt update
sudo apt-get install postgresql postgresql-contrib -y

sudo cp ./pg_config/postgresql.conf /etc/postgresql/14/main/postgresql.conf
sudo cp ./pg_config/pg_hba.conf /etc/postgresql/14/main/pg_hba.conf

sudo systemctl enable postgresql
sudo systemctl start postgresql
sudo systemctl status postgresql
