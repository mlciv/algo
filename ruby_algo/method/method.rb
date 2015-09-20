# 方法分为三类
# 1. 实例方法
# 可以重新定义既有对象的方法和运算符

# 2. 类方法
# static 的类方法
#调用类方法的时候可以是. 或者: 是一样的:
# 3. 函数性的方法
# 不会因为接收者不一样而影响执行结果





# 定义方法
# 参数可省略的时候应该设计为右边的可来连续省略
def hello(name="default_value")
    p name
end

hello()
hello("ruby")

def max(a,b)
    if a>b
        return a
    else
        return b
    end
end

#return 控制返回值
#不写return的时候就是最后一个语句的机算值 省略return的实参的时候会返回nil
p max(1,2)
