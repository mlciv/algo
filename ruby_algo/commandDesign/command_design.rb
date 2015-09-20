ARGV.each{|arg|
    p arg
}

if(ARGV.size ==2) then
num1 = ARGV[0].to_i
num2 = ARGV[1].to_i
p num1+num2
end
if(ARGV.size ==1) then
#Read from file
filename = ARGV[0]
file = open(filename)
#一次读完
#text = file.read
#逐行读入
while text = file.gets do
    p text
end
file.close
end


