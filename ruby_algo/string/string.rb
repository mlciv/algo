#String类的使用

#1. String的创建
a = "str"
b  = 'str'
# 单引号的强制不进行转义 

#2. %Q %q 的使用
#%Q相当于是”“Quoto %q是单引号
a = %Q{1234}
b = %q{hello'world'}
p b

#3. 长度 length size 都是可以的，但是是字节数，不是字数

a = "你好"

p a.size  # 6


#4 判空

p "foo".empty?

# split ,pack , unpack

# 连接字符串 
a = "hello"
b = "world"
p a+b    #a+b 会是新的值
a<<b    # 这里是修改的a的原值
p a


# 大小和相等的判断


# 查找字符串
str = "1212121"
p str.index("12")
p str.rindex("12")

# 检查包含

p str.include?("12")


# 替换字符串 sub 是首次替换一次，gsub是替换全局 

p str.sub("1","2")
p str.gsub("1","2")


# 字符串具有和数组一样的索引访问方法
# 都引入了Enumerable模块，使用collect , each_with_index grep include?

# 连接逆转的方法
a.concat(b)
p a 
p a.delete("e")
p a 
#concat是破坏性的，delete! reverse!是破坏性的

# strip是清除前后空格，trim 用！表示是破坏性的


# 编码转换iconv等等


