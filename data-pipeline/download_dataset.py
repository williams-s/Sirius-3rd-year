import kagglehub
import os
import shutil

download_path = kagglehub.dataset_download("xfkzujqjvx97n/football-datasets")


os.makedirs("./data_raw", exist_ok=True)


for root, dirs, files in os.walk(download_path):
    for file in files:
        src = os.path.join(root, file)
        dst = os.path.join("./data_raw", file)
        print(file)
        shutil.copy2(src, dst)

print("Done")