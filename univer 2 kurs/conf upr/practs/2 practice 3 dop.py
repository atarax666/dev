import subprocess
import json

def get_dependencies(package_name):
    result = subprocess.run(['pip', 'show', package_name, '--format', 'json'], capture_output=True, text=True)
    if result.returncode != 0:
        raise Exception(f"Error getting dependencies for {package_name}: {result.stderr}")
    package_info = json.loads(result.stdout)
    dependencies = package_info.get('requires', [])
    return [dep.split(' ')[0] for dep in dependencies]

def generate_dot_code(package_name, dependencies):
    dot_code = f"digraph {package_name}_dependencies {{\n"
    dot_code += f"  {package_name} [shape=box];\n"

    for dep in dependencies:
        dot_code += f"  {dep} [shape=ellipse];\n"
        dot_code += f"  {package_name} -> {dep};\n"

    dot_code += "}\n"
    return dot_code

def main():
    package_name = input("Enter the library name (e.g., matplotlib): ")
    dependencies = get_dependencies(package_name)
    dot_code = generate_dot_code(package_name, dependencies)

    with open(f'{package_name}_dependencies.dot', 'w') as file:
        file.write(dot_code)

    print(f"DOT file '{package_name}_dependencies.dot' generated successfully.")
    print("You can visualize it using Graphviz with the following command:")
    print(f"dot -Tpng {package_name}_dependencies.dot -o {package_name}_dependencies.png")

if __name__ == "__main__":
    main()