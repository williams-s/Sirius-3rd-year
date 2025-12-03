import sys
import subprocess

firewallIp = "usercm@172.31.249.162"


def matchNameWithAddress(machine):
    finaladdress = firewallIp
    match machine:
        case "talend":
            finaladdress += " -p 130"
        case "mongo":
            finaladdress += " -p 131"
        case "spark":
            finaladdress += " -p 132"
        case "postgres":
            finaladdress += " -p 133"
        case "airflow":
            finaladdress += " -p 134"
        case "kafka":
            finaladdress += " -p 150"
        case "bridge":
            finaladdress += " -p 155"
        case "mqtt":
            finaladdress += " -p 160"
        case "idp":
            finaladdress += " -p 165"
        case "cicd":
            finaladdress += " -p 200"
        case _:
            return None
    return finaladdress

def main():
    machine = sys.argv[1] if len(sys.argv) > 1 else ""
    hostname = matchNameWithAddress(machine)
    if hostname is None:
        print(f"Machine {machine} not found")
        exit(1)
    subprocess.run(f"ssh {hostname}", shell=True)

if __name__ == "__main__":
    main()