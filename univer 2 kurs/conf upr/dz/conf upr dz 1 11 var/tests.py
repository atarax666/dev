import unittest
from emulator import execute_command
from filesystem import VirtualFileSystem
from logger import Logger

class TestCommands(unittest.TestCase):
    def setUp(self):
        self.vfs = VirtualFileSystem('test_fs.tar')
        self.logger = Logger('test_log.json')

    def test_ls(self):
        execute_command('ls', self.vfs, self.logger)
        execute_command('ls /some_dir', self.vfs, self.logger)

    def test_cd(self):
        execute_command('cd /some_dir', self.vfs, self.logger)
        execute_command('cd ..', self.vfs, self.logger)

    # Аналогичные тесты для echo, mv и exit

if __name__ == '__main__':
    unittest.main()