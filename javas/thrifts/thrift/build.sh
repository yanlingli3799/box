#!/usr/bin/env bash
path=$(cd "$(dirname "$0")"; pwd)
cd $path

SCRIPT_DIR="${BASH_SOURCE-$0}"
SCRIPT_DIR="$(dirname "${SCRIPT_DIR}")"
SCRIPT_DIR="$(cd "${SCRIPT_DIR}"; pwd)"


## thrift 自动生成代码到【./gen-java】目录下
#thrift -r --gen java UserService.thrift

## 生成代码到【../src/main/java】目录下
thrift -r -out ${SCRIPT_DIR}/../src/main/java --gen java base.thrift
thrift -r -out ${SCRIPT_DIR}/../src/main/java --gen java demo.thrift
#thrift -r -out ${SCRIPT_DIR}/../src/main/java --gen java User.thrift


#mv ./gen-java/com/ann/javas/frameworks/thrifts/beans ../src/main/java/com/ann/javas/frameworks/thrifts
