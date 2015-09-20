# 例外的处理方法 begin rescue ensure end

#$! 最后发生的例外
#$@ 最后发生的例外的相关位置
#例外对象的方法 expectio.class ex.message ex.backtrace


begin
    input = open(ARGV[0])
    while line = input.gets
        p line
    end
    input.close
    input = nil
rescue Errno::ENOENT ,Errno::EACCES=> ex  ## 可以指定异常的类别  TODO 注意Exception的继承树
    print("excpetion message:",ex.message,"\n")
    print("exception backstrace:", ex.backtrace,"\n")
    sleep(10)
    retry #retry 会重新执行，一直打不开就会死循环
ensure          ##相当于finally 
    if input
        input.close
        input = nil
    end
end


n = Integer("abc") rescue 0
p n

#当def定义的方法其中就是begin... end ，即begin..end就是方法的本身，则可以取消 begin end

#引发例外raise 到外层或者新的异常来处理

#使用catch 和throw 来控制程序执行，有点goto err的意思

catch(:exit){
  loop {
    if(i==0)
        throw :exit, returnval     ## returnval 为catch被中断时的返回值 TODO 冒号的用法 
    end
  } 
}

