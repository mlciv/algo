# Hash 的使用
#

person= Hash.new  ## Hash.new(2)  2为默认初始值
person['jiessie'] = "xxx"
person["bar"] ="foo"
p person

p person.keys
p person.values
p person.to_a

h = Hash.new{ |hash,key|
    hash[key] = key.upcase
}
h["a"]= "b"
p h["x"]  # 默认是大写的X
p h["y"]


# 查询hash里是否有某个值或者value

h.has_key?("key")
h.key?("key")
h.include?("key")
h.member?("key")
h.value?("value")

# length size为大小

h = {"R"=>"ruby"}
#不包含的时候执行block中的内容
p h.delete("P"){|key| "no #{ key}."}

# h.delete_if 没有的时候会返回原来的hash  reject!返回nil

h = {"k1"=>"v1"}
g = h   #指向统一对象
h.clear
p g

# 嵌套的两个键的hash
table = {"A"=>{"k1"=>"v1"}}

