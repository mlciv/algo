#条件判断
#if
if 1==2 then
    1==2
elsif 2==3 then
    2==3
else
    3==4
end

#then 可以省略，最有写end elsif else



#unless 也可以使用else
unless 2==3 then 
    p  "not"
end



#case
a =0
case a
when 0 then
    p 0
when 1,2,3,4,5,6 then
    p 1
when 8 then
    p 2
else
    p "other"
end

##if 和else 也可以写在想要执行的语句后面

puts "a" if 2>1

#也可以判断是什么对象,或者是满足什么正则

array = ["aa",1,nil]

array.each{ |i|
    case i
    when String
        p i
    when Numeric
        p i
    else
        p i
    end

}
