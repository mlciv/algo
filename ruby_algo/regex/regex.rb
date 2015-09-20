re1 = Regexp.new("abc*def")
re2 =   Regexp.new(Regexp.quote("abc*def"))  # quote 为忽略所有转义字符
p (re1 =~"abc*def")
p (re2 =~"abc*def")
#其他的和正则的正常的使用一样
