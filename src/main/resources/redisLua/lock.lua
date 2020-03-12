local lockKey = KEYS[1]
local lockValue = KEYS[2]
local ttl = ARGV[1]


-- setnx info
local isLock = redis.call('SETNX', lockKey, lockValue)
if isLock == 1
then
local isEx= redis.call('EXPIRE', lockKey, ttl)
return isLock
else
return isLock
end