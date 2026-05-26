import os
import sys
from pathlib import Path


def generar_arbol(directorio: Path) -> str:
    """
    Genera un árbol de directorios en formato texto tipo Markdown.
    """
    lineas = []

    def recorrer(ruta: Path, prefijo: str = ""):
        elementos = sorted(ruta.iterdir(), key=lambda x: (x.is_file(), x.name.lower()))
        for i, elemento in enumerate(elementos):
            es_ultimo = i == len(elementos) - 1
            conector = "└── " if es_ultimo else "├── "
            lineas.append(f"{prefijo}{conector}{elemento.name}")
            if elemento.is_dir():
                extension = "    " if es_ultimo else "│   "
                recorrer(elemento, prefijo + extension)

    lineas.append(f"{directorio.name}/")
    recorrer(directorio)
    return "\n".join(lineas)


def main():
    directorio_script = Path(__file__).parent.resolve()

    # Argumento 1: carpeta opcional
    if len(sys.argv) > 1:
        ruta_objetivo = Path(sys.argv[1])
        if not ruta_objetivo.is_absolute():
            ruta_objetivo = (directorio_script / ruta_objetivo).resolve()
    else:
        ruta_objetivo = directorio_script

    if not ruta_objetivo.exists() or not ruta_objetivo.is_dir():
        print("La ruta especificada no existe o no es una carpeta válida.")
        return

    # Argumento 2: nombre opcional del archivo markdown
    if len(sys.argv) > 2:
        archivo_md = directorio_script / sys.argv[2]
    else:
        archivo_md = directorio_script / "estructura.md"

    arbol = generar_arbol(ruta_objetivo)

    contenido = f"# Estructura de: {ruta_objetivo.name}\n\n```\n{arbol}\n```text\n"

    with open(archivo_md, "w", encoding="utf-8") as f:
        f.write(contenido)

    print(f"Archivo '{archivo_md.name}' actualizado correctamente.")


if __name__ == "__main__":
    main()
