#include

module M
    def meth
        puts "meth"
    end
end

class C
    include M
end

#Comparable模块

#Enumerable模块提供的方法

#都可以呗导入和重写

#方法查找顺序

#1. 于继承关系相同，本身有同名的方法时，以类本身的为主
#2. 一个类里面读入不只一个模块时，以最后读入的优先
#3. 当读入有多层现象时，查找顺序仍是线状的
#4. 读入相同的模块两次以上时，第二次会被忽略， Kernel 是一个实现了不属于任何对象
#功能的模块名称  p方法raise方法都是Kernel
module M1
end
module M2
end

module M3
    include M2
end

class A
    include M1
    include M3
end

p A.ancestors
