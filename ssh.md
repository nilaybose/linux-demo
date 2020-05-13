### Generation of keys

- ssh-keygen
- copy to remote machine for pass-word less ssh
```shell script
cat .ssh/id_rsa.pub | ssh <user>@hostname "cat >> .ssh/authorized_keys"
ssh <user>@hostname "cat .ssh/authorized_keys"
```

Let us create a new user named vivek using the useradd command on Ubuntu:
```shell script
$ sudo useradd -s /bin/bash -d /home/vivek/ -m -G sudo vivek
$ sudo passwd vivek
```

Where,

- -s /bin/bash – Set /bin/bash as login shell of the new account
- -d /home/vivek/ – Set /home/vivek/ as home directory of the new Ubuntu account
- -m – Create the user’s home directory
- -G sudo – Make sure vivek user can sudo i.e. give admin access to the new account


### add user to groups
- sudo usermod -a -G group username

### delete user
- sudo deluser username group