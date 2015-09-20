#1. create array

num = [1,2,3,4]

## Array.new

a = Array.new
p a
a = Array.new(5)  ## 不指定默认值的时候，默认值为nil
p a 
a = Array.new(5,"123")
p a 

# 元素是字符串且不含空白的时，可以使用%w建立数组 包围数组字符串的括号，可以是()
# {} <> ||||
lang = %w{Ruby Perl Python Scheme Pike PEBOL}
p lang  


# 使用to_a 方法
table = {"key1"=>"value1","key2"=>"value2"}
p table.to_a


#2. 索引的使用方式,可读取或者数次改写
array = [1,2,3,4,5]

p array[0]
p array.at(0)
p array.slice(2)  ## a[2]
p array.slice(0..2)
p array[0..2]   #n-m 的元素
p array[0...2]  #n - (m-1) 的元素
p array[0,3]
p array.slice(0,3)


# 3.以多个所以你建新数组
b = array.values_at(0,2,3)
p b


# 作为集合的数组
# & 为交集， | 为并集

a = [1,2,3]
b = [2,3,4]   ## 除了2,3共有的会被剪掉外，a中没有的4也是剪掉的
c = a-b
p c 

p a+b   ## +包含有重复元素，直接拼接的   
p a|b   ## 算的并集


# 4. 数组的操作

a = [1,2,3]
## 4.1 对前端的操作
p a.unshift(0)  #==> a[0,1,2,3]
p a.first  #=>a[0] = 0
p a.shift  #=> 返回时为a[0],之后变为a[1,2,3]
p a 

## 4.2 对后段的操作
p a.push(4)  ## 和a<< item 效果一样,没有>>运算符
p a.last
p a.pop

p a.concat([5,6,7])

## 4.2 删除元素
b = [1,2,nil,4]
c = b.compact  ## 会生成一个新数组
p c
b.compact!   ## 会删除本身数组的nil 删除了nil返回之后的值，没有删除的为nil返回
p b
p b.compact!

b.delete(1)  ## 删除元素1
p b
b.delete_at(1) ## 删除下标为2的元素
p b

## delete_if reject 是破坏性方法
b = [1,2,3,4,5]
b.delete_if{|item| item>3}
p b
b = [1,2,3,4,5]
a.compact
a.compact
b.reject{|item| item>3}  ## reject是生成的新的数组，reject!是破坏性的
p b

##同样的b.uniq 是新生成的数组，但是b,uniq!是破坏性 加上!的时候就是破坏性

# 以数组的元素进行运算，生成新的数组或者替换原来的元素

b.collect{|item| item+1}
p b 
b.collect!{|item| item+1}
p b

# 数排序
b = [4,23,5,1,2]
p b.sort_by{|i| i}
p b
# 没有sort_by!的方法


##特别的多为数组初始化的问题
a = Array.new(3,[0,0,0])
a[0][1] = 2
p a  ## 会把第位都改了，因为[0,0,0]是一个对象，这里三个元素都是指向的一个对象，可以认为是b = [0,0,0] a = Array.new(3,b)
# 解决方法，放在block里面处理, 但是还是不能用b ，而要使用直接的[0.0,0]
b = [0,0,0]
a = Array.new(3){
    [0,0,0]
}
a[1][2] = 1
p a 
