#!/bin/bash

name="wangsai"

hello="hello, $name ,nice to meet u"
hello2="hello ,"$name"  yo hou"

echo $hello
echo $hello2

greeting="hello, $name !"
greeting_1="hello, ${#name} !"

echo ${greeting}
echo ${greeting_1}

array=(1 2 3 4 5)
for i in ${array[*]};
do echo ${i} ;
done

unset ${array[2]}
for i in ${array[@]};
do echo ${i} ;
done

a=10
b=3
sum=`expr ${a} + ${b}`
echo ${sum}

#for 循环语句
echo "===========for1===="
for i in 1 2 3;
do echo $i ;
done

echo "==========for2"
for((i=0;i<5;i++));
do echo ${i};
done;


echo "=========for3"
for i in {0..4};
do echo $i;
done;

echo "===========while1"
index1=0
while(($index1 < 3));
do
    echo ${index1};
    let index1=`expr ${index1} + 1`;
done