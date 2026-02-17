FROM eclipse-temurin:17-jdk-alpine

RUN apk add --no-cache python3 py3-pip

RUN python3 -m venv /opt/venv
ENV PATH="/opt/venv/bin:$PATH"

COPY requirements.txt /tmp/requirements.txt
RUN pip install --no-cache-dir -r /tmp/requirements.txt

WORKDIR /data
COPY . /data

CMD ["tail", "-f", "/dev/null"]
