import json
import time

class Logger:
    def __init__(self, log_path):
        self.log_path = log_path
        self.log_data = []

    def log(self, command):
        entry = {
            'timestamp': time.time(),
            'command': command
        }
        self.log_data.append(entry)

    def close(self):
        with open(self.log_path, 'w') as logfile:
            json.dump(self.log_data, logfile, indent=4)
