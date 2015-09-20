module Numeric_exerise
    def fahrenheit(celsius)
        x = celsius*9/5+32
        return x
    end
    
    def celsius(fahrenheit)
        y = (fahrenheit-32)*5/9
    end
    
    def dice()
        return rand(6)+1
    end

    def prime?(num)
        sqrt = Math.sqrt(num)
        p sqrt
        flag = true
        2.upto(sqrt){ |i|
            if num % i==0
                flag = false
                break
            end
        }
        return flag
    end
    module_function :fahrenheit, :celsius, :dice, :prime?
end

 p Numeric_exerise::fahrenheit(0)
 p Numeric_exerise.fahrenheit(0)
 p Numeric_exerise::celsius(32)
 p Numeric_exerise::dice
 p Numeric_exerise::prime?(32)


