import os

def ls(args, vfs):
    path = args[0] if args else vfs.current_dir
    files = vfs.list_dir(path)
    for file in files:
        print(file)

def cd(args, vfs):
    path = args[0] if args else '/'
    vfs.change_dir(path)

def echo(args):
    print(' '.join(args))

def mv(args, vfs):
    src, dest = args
    vfs.move_file(src, dest)

def exit_shell(logger):
    logger.close()
    exit(0)
