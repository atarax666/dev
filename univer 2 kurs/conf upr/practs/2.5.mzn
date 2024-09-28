% Пакеты и их возможные версии
array[1..5] of string: menu_versions = ["1.0.0", "1.1.0", "1.3.0", "1.4.0", "1.5.0"];
array[1..3] of string: dropdown_versions = ["2.0.0", "2.2.0", "2.3.0"];
array[1..2] of string: icons_versions = ["1.0.0", "2.0.0"];

% Переменные для версий
var 1..5: menu_version;
var 1..3: dropdown_version;
var 1..2: icons_version;

% Зависимости
constraint menu_version >= dropdown_version; % menu зависит от dropdown
constraint dropdown_version = icons_version; % dropdown зависит от icons

% Решение
solve satisfy;

% Вывод зависимостей с отображением версий как на скриншоте
output [
  "root\n",
  "    └─ menu\n",
  "        " ++ menu_versions[5] ++ "\n" ++
  "        " ++ menu_versions[4] ++ "\n" ++
  "        " ++ menu_versions[3] ++ "\n" ++
  "        " ++ menu_versions[2] ++ "\n" ++
  "        " ++ menu_versions[1] ++ "\n\n",
  "        └─ dropdown\n",
  "            " ++ dropdown_versions[3] ++ "\n" ++
  "            " ++ dropdown_versions[2] ++ "\n" ++
  "            " ++ dropdown_versions[1] ++ "\n\n",
  "            └─ icons\n",
  "                " ++ icons_versions[2] ++ "\n" ++
  "                " ++ icons_versions[1] ++ "\n"
];
