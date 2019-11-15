#path=`cd $(dirname $0);pwd -P`
#echo "the current path is:$path"
#for i in `ls`
  #do
#    echo $i
  #done
#
#filename=`basename $0`
#echo "file name is:$filename"
#
project_path=$(cd `dirname $0`; pwd)
project_name="${project_path##*/}"
echo $project_path

for name in $(ls $1)
do 
  #echo $project_path$name
  cat "$project_path/$name" | grep class | awk '{print $3}' 
  cat "$project_path/$name" | grep "http"
  echo =================================

done
