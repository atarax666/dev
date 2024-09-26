import os
import tarfile

class VirtualFileSystem:
    def __init__(self, tar_path):
        self.root = "/virtual_fs"
        self.current_dir = self.root
        self.extract_tar(tar_path)

    def extract_tar(self, tar_path):
        with tarfile.open(tar_path, 'r') as tar:
            tar.extractall(self.root)
    
    def list_dir(self, path):
        full_path = os.path.join(self.current_dir, path)
        return os.listdir(full_path)
    
    def change_dir(self, path):
        full_path = os.path.join(self.current_dir, path)
        if os.path.isdir(full_path):
            self.current_dir = full_path
        else:
            print(f"No such directory: {path}")
    
    def move_file(self, src, dest):
        full_src = os.path.join(self.current_dir, src)
        full_dest = os.path.join(self.current_dir, dest)
        os.rename(full_src, full_dest)
