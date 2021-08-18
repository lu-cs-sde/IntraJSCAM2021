#!/bin/zsh

echo "\u001b[33;1m[INFO] SETTING ENVIRONMENT \u001b[0m"
. ~/.sdkman/bin/sdkman-init.sh
sdk use java 7.0.292-zulu
set -e

echo "\u001b[33;1m[INFO] Compiling Intraj \u001b[0m"
./gradlew build -PclassName=org.extendj.IntraJ
echo "\u001b[33;1m[INFO] Compiling Intraj_DDA \u001b[0m"
./gradlew build -PclassName=org.extendj.IntraJ_DAA
echo "\u001b[33;1m[INFO] Compiling Intraj_CFG \u001b[0m"
./gradlew build -PclassName=org.extendj.IntraJ_CFG
echo "\u001b[33;1m[INFO] Compiling Intraj_CFGDDA \u001b[0m"
./gradlew build -PclassName=org.extendj.IntraJ_CFGDAA
echo "\u001b[33;1m[INFO] Compiling Intraj_BL \u001b[0m"
./gradlew build -PclassName=org.extendj.IntraJ_BL
echo "\u001b[33;1m[INFO] DONE \u001b[0m"

