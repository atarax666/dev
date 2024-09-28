% Определение версий пакетов
enum PACKAGE = {root, foo_1_1, foo_1_0, left, right, shared_2_0, shared_1_0, target_2_0, target_1_0};

% Массив для хранения версий пакетов
array[PACKAGE] of string: version = [
    "1.0.0",   % root 1.0.0
    "1.1.0",   % foo 1.1.0
    "1.0.0",   % foo 1.0.0
    "1.0.0",   % left 1.0.0
    "1.0.0",   % right 1.0.0
    "2.0.0",   % shared 2.0.0
    "1.0.0",   % shared 1.0.0
    "2.0.0",   % target 2.0.0
    "1.0.0"    % target 1.0.0
];

% Зависимости между пакетами
array[PACKAGE] of set of PACKAGE: dependencies = [
    {foo_1_1, target_2_0},      % root 1.0.0
    {left, right},              % foo 1.1.0
    {},                          % foo 1.0.0
    {shared_1_0},               % left 1.0.0
    {shared_2_0},               % right 1.0.0
    {},                          % shared 2.0.0
    {target_1_0},               % shared 1.0.0
    {},                          % target 2.0.0
    {}                           % target 1.0.0
];

% Вывод зависимостей с стрелками
output [
    "root " ++ show(version[root]) ++ "\n" ++
    "    ├─ foo " ++ show(version[foo_1_1]) ++ "\n" ++
    "    │   ├─ left " ++ show(version[left]) ++ "\n" ++
    "    │   │   └─ shared " ++ show(version[shared_1_0]) ++ "\n" ++
    "    │   │       └─ target " ++ show(version[target_1_0]) ++ "\n" ++
    "    │   └─ right " ++ show(version[right]) ++ "\n" ++
    "    │       └─ shared " ++ show(version[shared_2_0]) ++ "\n" ++
    "    └─ target " ++ show(version[target_2_0]) ++ "\n" ++
    "\n" ++
    "Dependencies:\n" ++
    "root " ++ show(version[root]) ++ " -> foo " ++ show(version[foo_1_1]) ++ "\n" ++
    "foo " ++ show(version[foo_1_1]) ++ " -> left " ++ show(version[left]) ++ "\n" ++
    "foo " ++ show(version[foo_1_1]) ++ " -> right " ++ show(version[right]) ++ "\n" ++
    "left " ++ show(version[left]) ++ " -> shared " ++ show(version[shared_1_0]) ++ "\n" ++
    "right " ++ show(version[right]) ++ " -> shared " ++ show(version[shared_2_0]) ++ "\n" ++
    "shared " ++ show(version[shared_1_0]) ++ " -> target " ++ show(version[target_1_0]) ++ "\n"
];
