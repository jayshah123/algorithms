
import sys

n = int(sys.stdin.readline())
for i in range(0,n):
	dict = {}
	flag = 1
	for u in sys.stdin.readline().strip():
		if u==' ':
			continue
		if dict.has_key(u):
			dict[u] = dict[u]+1
		else:
			dict[u] = 1
	t = int(sys.stdin.readline())
	for j in range(0,t):
		for r in sys.stdin.readline().strip():
			if r==' ':
				continue
			if dict.has_key(r):
				dict[r] = dict[r]-1
				if dict[r]<0:
					flag = -1
					break
			else:
				flag = -1
				break


	if flag>0:  
		print("YES")
	else:  
		print("NO")