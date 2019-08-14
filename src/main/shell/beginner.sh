#!/bin/bash
# 学习shell编程


echo "=====================定义变量=================="
#定义变量
str1="string1"
#使用变量
echo ${str1}
echo $str1
for num in 1 2 3
do
    echo ${num}
done

# 变量重新赋值
str1="hello world"
echo ${str1}

echo "=====================引号=================="
# 单引号
#单引号里的任何字符都会原样输出，单引号字符串中的变量是无效的
#单引号字串中不能出现单引号,对单引号使用转义符后也不行
echo '${str1}'
# 双引号
#双引号里可以有变量
#双引号里可以出现转义字符
echo "${str1}"


echo "=====================字符串=================="
# 变量在双引号里面嵌套使用
name="wang sai"
# 直接嵌套
echo "hello,${name}."
# 字符串拼接
echo "hello,"${name}"."

# 获取字符串长度
echo ${#name}

echo "=====================删除变量=================="
value="wow"
echo ${value}
unset value
echo ${value}

echo "=====================条件语句=================="


if 2
then
    echo "yes"
else
    echo "no"
fi
