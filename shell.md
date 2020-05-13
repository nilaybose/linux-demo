### /etc/passwd file

```shell script
#!/bin/bash
# seven fields from /etc/passwd stored in $f1,f2...,$f7
# 
while IFS=: read -r f1 f2 f3 f4 f5 f6 f7
do 
 echo "User $f1 use $f7 shell and stores files in $f6 directory."
done <  /etc/passwd
```

### Back up
```shell script
#!/bin/sh
cd /var/backups || exit 0
for FILE in passwd group shadow gshadow; do
test -f /etc/$FILE
|| continue
cmp -s $FILE.bak /etc/$FILE
&& continue
cp -p /etc/$FILE $FILE.bak && chmod 600 $FILE.bak
done
```