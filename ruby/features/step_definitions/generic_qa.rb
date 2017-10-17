#coding: utf-8
#include RSpec::Expectations
module GenericQA

  def retorna_tabela_hash(ptable)
    res = ptable.transpose.raw.inject({}) do |hash, column| 
            column.reject!(&:empty?)
            hash[column.shift] = column
            hash    
          end
    res
  end

end