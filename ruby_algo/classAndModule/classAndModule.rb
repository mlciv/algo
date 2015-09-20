# 类与实例
#实例化 使用new方法

ary = Array.new
p ary

#内建的类，很多可以使用字面常数的方式生成对象实例

ary = [1,2,3]
str = "1212"

#检查继承
str = "This is a string"
p str.is_a?(String)
p str.is_a?(Object)
p str.instance_of?(String)

#Object类的方法中包含了is_a,instance_of等方法？TODO 需要整理


#自己定义类的规定

class HelloWorld                                ##定义class 语句 类名一定要大写
    def initialize(myname = "Ruby")             ##initialize 方法，构造方法
        @name = myname                          ##初始化实例变量
        @romember = "xxxx"
        @x = "x"
        @y = "y"
    end

    def hello                                   ## 实例方法,实例变量可以在实例方法中读写,不运行从对象外部直接读取、写入实例变量,内部对象的数据，都需要定义方法来操作
        print(@@des,"++",@name,"\n")
    end

    def HelloWorld.des                          ##类方法，使用类变量 不写访问符的时候默认是public,  然后private是私有，只有类内部使用，pretcted是相同类之间可以调用
        p @@des
    end
    public :hello                               ## 可以用public 补充修饰hello

    public                                      ## 省略参数则接下来的默认是public

    def wohello
        print(@@des,"++",@womember,"\n")
    end

    def self.say_hello
        p "Hello"
    end
    
    attr_accessor:member                        ##attr_accessor 表示的是读写均可
    attr_reader:romember                        ##attr_reader 表示的是只读
    attr_writer:womember                        ##attr_writer 表示的只写

    attr_accessor :x,:y
    protected :x=,:y=

    def swap(other)
        tmpx = @x
        tmpy = @y
        other.x = @x
        other.y = @y
        @x = tmpx
        @y = tmpy
    end

    @@des = "this is HelloWorld Class"          ##定义类变量
    Version = "1.0"
end

class << HelloWorld
    @@des1 = "des1"
    def static_hello
        p @@des1
    end
end

class HelloFoo < HelloWorld
    def helloFoo
        p "helloFoo"
    end
end

foo = HelloFoo.new
foo.helloFoo
foo.is_a?(HelloWorld)
foo.hello

class HelloWorld
    def addHello()
        p "hello again"
    end
end

foo.addHello


HelloWorld.static_hello
HelloWorld.say_hello
p HelloWorld::Version

bob = HelloWorld.new
alice = HelloWorld.new("alice")
bob.hello
alice.hello
HelloWorld.des
bob.member = 123
p bob.member
bob.addHello

bob.member = "123"
p bob.member

p bob.romember
bob.womember = "womember"
bob.wohello

#module


#Mix-in

module MyModule             ##模块不能实例化和继承，可以提供命名空间和Mix-in的方式
                            ## 模块名必须是大写字母开头,语法和类几乎相同
    Version = "1.0.0"
    def commonMethod1
        p "commonMethod1"
    end

    def commonMethod
        p "commonMethod"
    end
    module_function :commonMethod1  ## module_function 可以导出 commonMethod 以模块形式的公开
end

class MyClass1
    include MyModule
    def class1Method
        p "class1"
    end
end

class MyClass2
    include MyModule
    def class2Method
        p "class2"
    end
end

class1 = MyClass1.new
class2 = MyClass2.new
class1.commonMethod
class2.commonMethod
class1.class1Method
class2.class2Method
p  MyModule::Version

