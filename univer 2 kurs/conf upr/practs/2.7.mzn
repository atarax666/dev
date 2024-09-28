% Определение пакетов и их зависимостей
enum PACKAGE = {root, foo_1_1, foo_1_0, left, right, shared_2_0, shared_1_0, target_2_0, target_1_0};

% Массив для хранения версий пакетов
array[PACKAGE] of int: version = [
    1,   % root 1.0.0
    1,   % foo 1.1.0
    0,   % foo 1.0.0
    0,   % left 1.0.0
    0,   % right 1.0.0
    0,   % shared 2.0.0
    0,   % shared 1.0.0
    2,   % target 2.0.0
    1    % target 1.0.0
];

% Словарь для хранения зависимостей пакетов
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

% Функция для вывода зависимостей
function string: format_dependencies(PACKAGE: pkg) =
    let {
        var string: pkg_name = show(pkg) ++ " " ++ show(version[pkg])
    } in
    if size(dependencies[pkg]) > 0 then
        pkg_name ++ " -> " ++
        join([format_dependencies(dep) | dep in dependencies[pkg]], ", ")
    else
        pkg_name ++ " (no dependencies)"

% Основной вывод
output [
    format_dependencies(root) ++ "\n"
];
