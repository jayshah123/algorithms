
for (( i=1 ; i<=255; i++ ))
do
	echo "trying $i"
	ping -c 1 "172.26.0.$i" | grep 'ttl'
done
