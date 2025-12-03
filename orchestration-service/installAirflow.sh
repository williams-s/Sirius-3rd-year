sudo apt update
sudo apt install python3-pip python3-venv -y
rm -rf airflow
mkdir airflow && cd airflow
python3 -m venv venv
source venv/bin/activate

export AIRFLOW_VERSION=3.1.3
export PYTHON_VERSION="$(python3 --version | cut -d " " -f 2 | cut -d "." -f 1-2)"
export CONSTRAINT_URL="https://raw.githubusercontent.com/apache/airflow/constraints-${AIRFLOW_VERSION}/constraints-${PYTHON_VERSION}.txt"

pip install "apache-airflow==${AIRFLOW_VERSION}" --constraint "${CONSTRAINT_URL}"
airflow db migrate
nohup airflow standalone > airflow.log 2>&1 &
