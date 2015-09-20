#print
print ("Hello,Ruby. \n")
## 使用\ 转义
print ("Hello,\"Ruby\"\n")
#单引号中的内容不会转义
#可用逗号分隔表示要打印的多个字符串
#使用puts方法一定有换行
print('Hello,\"Ruby\"',"\n")
print 'hello,world\n',"\n"

#puts
## puts = print (...,"\n")
puts 'Hello,puts'
## coma is foreach puts
puts "hello","world","coma is foreach puts"

#p方法
## like in gdb
puts("100")
puts(100)
p 100
p "100" #=>"100"

## 加上 -Ku 指定为utf-8编码 显示中文
p "中文"

include Math
print("sin(pi) =",sin(3.1415926),"\n")

#变量

x = 10
y = 20
print "x+y=",x+y,"\n"

##if then end

p (2==3)
p (2==2)

if( y>x )
    print ("y is bigger than x\n")
end

## then can be negationd
if x<y then
    print("y is bigger than x\n")
end

#循环
##while end
i=0
while i< y
    i = i+1
end
print i,"\n"

## times方法

10.times{
    i=i+1
}

puts i;

y.times{
    i= i+1
}

puts i

#定义方法

def printhello
    puts "hello"
end

printhello()
