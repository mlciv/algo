
5.times{|n|
    p n
}

#区块调用
#

#Enumerable
# collect方法
#
# sort方法

array = [1,4,5,62,2]
sorted= array.sort{|a,b|
    a<=>b
}

array = ["12","123","1234","12345"]
sorted = array.sort{|a,b|
    a.length <=>b.length
}
p sorted

array.sort_by{|item|
    item.length
}
p array

class Book
    attr_accessor:title, :author,:gener
    def initialize(title,author,genre=nil)
        @title = title
        @author = author
        @genre = genre
    end
end

class BookList
    def initialize()
        @booklist = Array.new
    end
    def add(book)
        @booklist.push(book)
    end

    def length()
        @booklist.length()
    end

    def []=(n,book)
        @booklist[n] =book
    end

    def delete(book)
        @booklist.delete(book)
    end
end


