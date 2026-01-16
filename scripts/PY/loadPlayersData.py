from pathlib import Path
import tempfile

# Cherche tous les CSV dans le dossier temporaire Python
tmp_dir = Path(tempfile.gettempdir())
for f in tmp_dir:
    print(f.resolve())
