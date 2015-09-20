#变量命名的规范，已命名来表示变量的范围
#1.局部变量
#_起始用小写字母或者"_"表局部变量,表意需要连接的时候用"_",类名或者模块名才使用首
#字母大写的方式
#2. 全局变量
# 起始以“$"开头的
#3.实例变量
#变量名以"@"起始的变量
#4.类变量
#变量名以"@@"起始的变量
#5.虚拟变量
#true,false,self等

#常数
#用全大写表示

class HelloWorld
    def initialize(myname="")
        @name = myname
    end
    
    def printName()
        p @name
    end

    def HelloWorld.des
        @@des
    end

    @@des = "HelloWorld Class"
end

bob = HelloWorld.new("Bob")
bob.printName()
p HelloWorld.des;
