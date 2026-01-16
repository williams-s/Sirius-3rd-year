#!/bin/bash

PG_USER="admin"
PG_PASSWORD="Ravus77!"

sudo -u postgres psql <<EOF
DO
\$do\$
BEGIN
   IF NOT EXISTS (
      SELECT FROM pg_catalog.pg_roles WHERE rolname = '${PG_USER}'
   ) THEN
      CREATE ROLE ${PG_USER} WITH LOGIN PASSWORD '${PG_PASSWORD}' SUPERUSER;
   ELSE
      ALTER ROLE ${PG_USER} WITH PASSWORD '${PG_PASSWORD}';
   END IF;
END
\$do\$;
EOF

echo "Utilisateur PostgreSQL '${PG_USER}' créé ou mis à jour avec succès."
