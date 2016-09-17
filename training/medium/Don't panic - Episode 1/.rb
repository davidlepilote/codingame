STDOUT.sync = true
a=gets.split(" ").map{|x|x.to_i}
e=Array.new(a[0])
a[7].times do
f,p=gets.split(" ").collect{|x|x.to_i}
e[f]=p
end
e[a[7]]=a[4]
loop do
f,p,d=gets.split(" ")
f=f.to_i
p=p.to_i
puts f!=-1&&d=~/l/i&&p<e[f]||d=~/r/i&&p>e[f]?"BLOCK":"WAIT"
end