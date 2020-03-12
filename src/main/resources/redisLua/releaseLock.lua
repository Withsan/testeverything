local lockKey = KEYS[1]
local preFlag = ARGV[1]


-- 获取当前锁的值
local lockFlag = redis.call('GET', lockKey)
--是当前锁则删除，否则返回该锁的拥有者
if lockFlag == preFlag
then
local isDEL= redis.call('DEL', lockKey)
return isDEL
else
return false
end