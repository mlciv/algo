# 循环有两种方法
# 1.循环语句  for while unitl
sum =0

## 开始数值 .. 结束数值
for i in 1..5
    sum = sum +i
end
puts sum

##一般的用法是从一个可迭代的数组容器中遍历
nums = [1,2,3,4,5]
p nums
sum = 0
for a in nums do 
    sum = sum+a
end
puts sum

##while
i =1
while i<3
    i = i+1
    p i
end

until i >5 do
    i = i+1
end
p i

# 2.循环方法  times, each, loop

## uptto downto step(to step) 都是可以的


tmp=0;
10.times do
    tmp = tmp+1
end
#do end也可以写为block
20.times { |i|
    tmp =tmp +1
}
# |i| 表示是循环到第几次了,只能从0开始,i在循环外也可以被访问到
puts i


p nums
## each
nums.each{ |i|
    p i
}

nums.each do |i|
    p i
end

## loop 没有结束条件的循环

## break 跳出循环
## next 调到下一次循环 continue
## redo 以相同的条件重新进行这次循环



