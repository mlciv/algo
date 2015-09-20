#数组

name = ["a","b","c"]

#mixed array
mixarray = [1,2,3,"dasd"]

p mixarray[3]
p mixarray.size

mixarray.each{ |i|
    p i
}


#Hash


table = {"key1"=>1,"key2"=>2}
p table["key1"]

table.each{ |key,value|
    print(key,"=>",value,"\n")
}

require "pp"
p table
pp table


#正则表达式 匹配成功的时候返回匹配成功的位置
p /Ruby/i=~ "RUBY"

