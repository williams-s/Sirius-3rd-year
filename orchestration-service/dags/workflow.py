from datetime import datetime
from airflow import DAG
from airflow.operators.python import PythonOperator
from airflow.providers.mongo.hooks.mongo import MongoHook
from airflow.providers.ssh.operators.ssh import SSHOperator
from pymongo.errors import ServerSelectionTimeoutError


default_args = {
    'owner': 'Williams',
    'start_date': datetime(2025, 12, 4),
    'retries': 1,
}

def check_mongo():
    hook = MongoHook(conn_id='mongo_default')
    try:
        client = hook.get_conn()
        client.admin.command('ping')
        print("MongoDB Online !")
    except ServerSelectionTimeoutError:
        raise ValueError("MongoDB Offline !")

with DAG(
        dag_id='pipeline_data',
        default_args=default_args,
        schedule=None,
        catchup=False,
) as dag:

    check_mongo_task = PythonOperator(
        task_id='check_mongo',
        python_callable=check_mongo
    )

    source_to_bronze_job = SSHOperator(
        task_id='source_to_bronze_job',
        ssh_conn_id='spark_vm',
        command="""
    {% raw %}
    bash /home/usercm/data-pipeline/Players/Players_run.sh
    {% endraw %}
    """,
    )

    check_mongo_task >> source_to_bronze_job


