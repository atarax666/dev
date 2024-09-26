import argparse
import tarfile
import os
import json
from commands import ls, cd, echo, mv, exit_shell
from filesystem import VirtualFileSystem
from logger import Logger

def main():
    parser = argparse.ArgumentParser(description="Shell Emulator")
    parser.add_argument("--hostname", required=True, help="Computer name for prompt")
    parser.add_argument("--fs-path", required=True, help="Path to the tar archive of the virtual file system")
    parser.add_argument("--log-path", required=True, help="Path to the log file (JSON format)")
    parser.add_argument("--startup-script", required=False, help="Path to the startup script")

    args = parser.parse_args()

    # Инициализация виртуальной файловой системы
    vfs = VirtualFileSystem(args.fs_path)
    
    # Инициализация логгера
    logger = Logger(args.log_path)
    
    # Выполнение команд из стартового скрипта (если есть)
    if args.startup_script:
        with open(args.startup_script, 'r') as script:
            for line in script:
                execute_command(line.strip(), vfs, logger)
    
    # Основной цикл эмулятора
    while True:
        try:
            command = input(f"{args.hostname}> ")
            execute_command(command, vfs, logger)
        except EOFError:
            break

def execute_command(command, vfs, logger):
    parts = command.split()
    cmd = parts[0]
    args = parts[1:]
    
    if cmd == 'ls':
        ls(args, vfs)
    elif cmd == 'cd':
        cd(args, vfs)
    elif cmd == 'echo':
        echo(args)
    elif cmd == 'mv':
        mv(args, vfs)
    elif cmd == 'exit':
        exit_shell(logger)
    else:
        print(f"Unknown command: {cmd}")
    
    logger.log(command)

if __name__ == "__main__":
    main()
